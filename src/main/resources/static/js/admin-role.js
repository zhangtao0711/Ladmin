/**
 *creatBy  刘小刘
 */
$(function () {
	//初始化数据
	loadData();
});

function loadData(){
	var url="/role/list";
	var beginTime="";
	var endTime="";
	var name="";
	var page=0;
	var size=5;
	var params="page="+page+"&size="+size+"&beginTime="+beginTime+"&endTime="+endTime+"&name="+name;
	$.get(url+"?"+params,function(result){
		if(result.success){
			doSetTableBodyRows(result.data.list)
		}
		   
	   })
}

function loadErrors(message){
	   //获取body对象并清空
	   var tBody=$("#tbodyId");
	   tBody.empty();
	   //创建tr对象
	   var tr=$("<tr></tr>");
	   //创建td对象
	   //var len=$("table thead").find("tr").find("th").length;
	   var len=$("table th").length;
	   var td=$("<td></td>");
	   td.prop("colspan",len);
	   td.append(message);
	   tr.append(td);
	   //将tr追加到tbody
	   tBody.append(tr);
}
function doSetTableBodyRows(data){
<<<<<<< HEAD
	   console.log(data);
=======
	   
>>>>>>> 2eaf973f4968e64b6c2b45a070e523d4650c4760
	  //获取tbody对象,并清空
	   var tBody=$("#dataTbody");
	   tBody.empty();
	   //2.迭代数据,并追加到tBody
	
	   for(var i=0;i<data.length;i++){
		  //2.1构建tr对象
		  var tr=$("<tr></tr>");
		
		  //2.2构建tds对象
		  var tds=doCreateTds(data[i],i);
		  //2.3将tds对象追加到tr中
		  tr.append(tds);
		  //2.4将tr追加到tbody中
		  tBody.append(tr);
	   }
}
function doCreateTds(row,i){
	
	   var tds=
		   "<td> <div class='layui-unselect layui-form-checkbox' lay-skin='primary' data-id='2'><i class='layui-icon'>&#xe605;</i></div>   </td>"+
    "<td>"+(parseInt(i)+1)+"</td>"+
	   "<td>"+row.roleName+"</td>"+
    "<td>"+row.roleKey+"</td>"+
    "<td>"+row.remark+"</td>"+
    "<td>"+row.status+"</td>"+
    "  <td class='td-manage'>  <a onclick = 'member_stop(this,"+row.roleId+" ) '  href='javascript:;' title='启用'> <i class='layui-icon'>&#xe601;</i></a>"+
    " <a title='编辑'    onclick ='x_admin_show(\"编辑\",\"role-add.html?roleId="+row.roleId+"\") '  href='javascript:;'> <i class='layui-icon'>&#xe642;</i></a>"+
            " <a title='删除'  onclick = 'member_del(this,"+row.roleId+") ' href='javascript:;'> <i class='layui-icon'>&#xe640;</i></a></td>";
    return tds;
}



