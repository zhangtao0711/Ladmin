/**
 * creatBy 刘小刘
 */

$(function() {

	// 加载权限列表
	loadPermission();

	var roleId = GetRequest().roleId;
	// roleId 有值为修改
	if (roleId != "fundefined" && roleId != '' && roleId != null) {
		$("#roleId").val(roleId);
		// 根据角色id加载角色
		loadDataByRoleId(roleId);
		// 获取选中的权限

	}
	
	
	$("#roleName").blur(function(){
		checkRoleName();
	})
	$("#roleKey").blur(function(){
		checkRoleKey();
	})

})

function checkRoleName(){
	var url = "/role/checkRoleName/"+$("#roleName").val();
	$.get(url, function(result) {
		if(result.data>0){
			layer.alert("名称已存在", {
				icon : 6
			})
			return false;
		}else{
			return true;
		}
	})
}
function checkRoleKey(){
	var url = "/role/checkRoleKey/"+$("#roleKey").val();
	$.get(url, function(result) {
		if(result.data>0){
			layer.alert("key已存在", {
				icon : 6
			})
			return false;
		}else{
			return true;
		}
	})
}

/* 加载权限列表 */
function loadPermission() {
	
	var url = "/permission/getPermissions";
	$.get(url, function(result) {
		if (result.data.length > 0) {
			initPermission(result.data, "permissionType")
		}
	})
}

/* 保存方法 */
function saveRole() {
	debugger;
	if(checkRoleName()&&checkRoleKey()){
		var url = "/role/save";
		var data = $("#roleForm").serialize()
		$.post(url, data, function(result) {
			if (result.success) {
				// 发异步
				layer.alert("保存成功", {
					icon : 6
				}, function() {
					// 获得frame索引
					var index = parent.layer.getFrameIndex(window.name);
					// 关闭当前frame
					parent.layer.close(index);
				});
			}
		})
	}

}

//
function initPermission(list, field) {
	// 分组
	var obj = {};
	for (var i = 0; i < list.length; i++) {
		for (item in list[i]) {
			if (item == field) {
				obj[list[i][item]] = {
					list : obj[list[i][field]] ? obj[list[i][field]].list : [],
					type : list[i].type
				};
			}
		}
		obj[list[i][field]].list.push(list[i])
	}

	doSetTableBodyRows(obj)

}

function doSetTableBodyRows(obj) {

	// 获取tbody对象,并清空
	var tBody = $("#permissionTbody");
	tBody.empty();
	// 2.迭代数据,并追加到tBody
	for (item in obj) {
		// 2.1构建tr对象
		var tr = $("<tr></tr>");
		// 2.2构建tds对象
		var tds = doCreateTds(item, obj[item].list);
		// 2.3将tds对象追加到tr中
		tr.append(tds);
		// 2.4将tr追加到tbody中
		tBody.append(tr);
	}

}
function doCreateTds(type, list) {
	var tds = `<td> <input type="checkbox" name="like1[write]" lay-skin="primary" title="${type}"> </td>`
	tds += ` <td> <div class="layui-input-block">`

	for (var i = 0; i < list.length; i++) {
		var per = list[i];
		var input = `  <input name="permissionId"  lay-skin="primary" type="checkbox" title="${per.permissionName}"  value="${ per.id }"> `;
		tds += input;
	}
	tds += `</div>`;

	return tds;
}

/** 根据id查询信息回显 */
function loadDataByRoleId(roleId) {
	var url = "/role/edit/" + roleId;
	$.get(url, function(result) {
		if (result.success) {
			$("#roleName").val(result.data.sysRole.roleName);
			$("#roleKey").val(result.data.sysRole.roleKey);
			$("#remark").val(result.data.sysRole.remark);
			var listSysPer = result.data.listRolePermission;

			var groupCheckbox = $("input[name='permissionId']");
			for (i = 0; i < groupCheckbox.length; i++) {
				var val = groupCheckbox[i].value;
				    for(j=0;j<listSysPer.length;j++){
				    	if(val==listSysPer[j].permissionId){
				    		groupCheckbox[i].checked=true;
				    	}
				    }
			}
		}

	})
}

/**
 * [获取URL中的参数名及参数值的集合]
 * 示例URL:http://htmlJsTest/getrequest.html?uid=admin&rid=1&fid=2&name=小明
 * 
 * @param {[string]}
 *            urlStr [当该参数不为空的时候，则解析该url中的参数集合]
 * @return {[string]} [参数集合]
 */
function GetRequest() {
	var urlStr = window.location.href;
	if (typeof urlStr == "undefined") {
		var url = decodeURI(location.search); // 获取url中"?"符后的字符串
	} else {
		var url = "?" + urlStr.split("?")[1];
	}
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}