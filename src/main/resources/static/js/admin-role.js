/**
 * creatBy 刘小刘
 */
$(function() {
	// 初始化数据
	var cuur = 1;
	loadData(cuur);

	$("#pre").click(function() {
		cuur--;
		if (cuur <= 1) {
			cuur = 1;
		}
		loadData(cuur);
	});

	$("#next").click(function() {
		var total = $("#total").html();
		var totalPage = Math.ceil(total / 5);
		cuur++;
		if (cuur >= totalPage) {
			cuur = totalPage;
		}
		loadData(cuur);
	});

	$("#search").click(function() {
		loadData(cuur);
	})

});

/** 加载数据 */
function loadData(cuur) {

	var url = "/role/list";
	/*var beginTime = $("#start").val();
	var endTime = $("#end").val();*/
	var name = $("#earchRoleName").val();
	var size = 5;
	var params = "page=" + cuur + "&size=" + size 	 + "&name=" + name;
	$.get(url + "?" + params, function(result) {
		if (result.success) {
			doSetTableBodyRows(result.data.list)
			$("#total").html(result.data.total)
		} else {
			loadErrors(result.message)
		}
	})
	
	
	
	
}

/* 加载数据失败显示错误信息 */
function loadErrors(message) {
	// 获取body对象并清空
	var tBody = $("#tbodyId");
	tBody.empty();
	// 创建tr对象
	var tr = $("<tr></tr>");
	// 创建td对象
	// var len=$("table thead").find("tr").find("th").length;
	var len = $("table th").length;
	var td = $("<td></td>");
	td.prop("colspan", len);
	td.append(message);
	tr.append(td);
	// 将tr追加到tbody
	tBody.append(tr);
}

// 加载表格数据追加到tbody
function doSetTableBodyRows(data) {

	// 获取tbody对象,并清空
	var tBody = $("#dataTbody");
	tBody.empty();
	// 2.迭代数据,并追加到tBody
	for (var i = 0; i < data.length; i++) {
		// 2.1构建tr对象
		var tr = $("<tr></tr>");

		// 2.2构建tds对象
		var tds = doCreateTds(data[i], i);
		// 2.3将tds对象追加到tr中
		tr.append(tds);
		// 2.4将tr追加到tbody中
		tBody.append(tr);
	}
}
function doCreateTds(row, i) {
	 var tds=
		//   "<td> <div class='layui-unselect header layui-form-checkbox' lay-skin='primary' data-id='"+row.roleId+"'><i class='layui-icon'>&#xe605;</i></div>   </td>"+
  "<td>"+(parseInt(i)+1)+"</td>"+
	   "<td>"+row.roleName+"</td>"+
  "<td>"+row.roleKey+"</td>"+
  "<td>"+row.remark+"</td>";
	if (row.status == 0) {
		tds += "<td  class='td-status'><span class='layui-btn layui-btn-normal layui-btn-mini'>已启用</span></td>";
	} else {
		tds += "<td class='td-status'><span class='layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled'>已停用</span></td>";
	}

	tds += "  <td class='td-manage'>  <a onclick = 'member_stop(this,"
			+ row.roleId
			+ " ) '  href='javascript:;' title='启用'> <i class='layui-icon'>&#xe601;</i></a>"
			+ " <a title='编辑'    onclick ='x_admin_show(\"编辑\",\"role-add.html?roleId="
			+ row.roleId
			+ "\") '  href='javascript:;'> <i class='layui-icon'>&#xe642;</i></a>"
			+ " <a title='删除'  onclick = 'member_del(this,"
			+ row.roleId
			+ ") ' href='javascript:;'> <i class='layui-icon'>&#xe640;</i></a></td>";
	return tds;
}

/* 用户-停用 */
function member_stop(obj, id) {
	layer.confirm('确认操作吗？', function(index) {
		var status = 0;
		if ($(obj).attr('title') == '已启用') {
			status = 1;
		}
		updateStatus(obj, id, status);

	});
}

/* 更新用户状态 */
function updateStatus(obj, id, status) {
	var url = "/role/updateStatus";
	var params = "roleId=" + id + "&status=" + status;
	$.get(url + "?" + params, function(result) {
		if (result.success) {
			if ($(obj).attr('title') == '已启用') {
				// 发异步把用户状态进行更改
				$(obj).attr('title', '已停用')
				$(obj).find('i').html('&#xe62f;');
				$(obj).parents("tr").find(".td-status").find('span').addClass(
						'layui-btn-disabled').html('已停用');
				layer.msg('已停用!', {
					icon : 5,
					time : 1000
				});
			} else {
				$(obj).attr('title', '已启用')
				$(obj).find('i').html('&#xe601;');

				$(obj).parents("tr").find(".td-status").find('span')
						.removeClass('layui-btn-disabled').html('已启用');
				layer.msg('已启用!', {
					icon : 5,
					time : 1000
				});
			}
		}
	})
}

/* 用户-删除 */
function member_del(obj, id) {
	
	layer.confirm('确认要删除吗？', function(index) {
		var params = "roleId=" + id ;
		$.get("/role/delete",params, function(result) {
			if (result.success) {
				// 发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				})
			}
		});
	})
}

/* 多选删除 */
function delAll(argument) {

	var data = tableCheck.getData();
	debugger;
	if(data.length==0){
		layer.msg('没有要删除的数据!', {
			icon : 1,
			time : 1000
		})
		return;
		
	}

	layer.confirm('确认要删除吗？' + data, function(index) {
		var params = "roleIds=" + data ;
		$.get("/role/deleteByIds", params,function(result) {
			if (result.success) {
				// 捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			}
		});

	});
}
