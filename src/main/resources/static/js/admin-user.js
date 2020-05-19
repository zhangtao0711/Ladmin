/**
 *zt
 *会员删除
 */
$(function () {
	//初始化数据
	loadData();
});

function loadData(){
	var url="/user/doFindUsers";
	var startTime="";
	var endTime="";
	var name="";
	var page=1;
	var size=2;
	var params="&username="+name+"&startTime="+startTime+"&endTime="+endTime+"&pageCurrent="+page;
	$.get(url+"?"+params,function(result){
		console.log(result);
		if(result!=null){
			console.log(result.data.records);
			doSetTableBodyRows(result.data.records)
		}
		   
	   })
}

function loadErrors(message){
	console.log(message);
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
	   console.log(data);
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
    "<td>"+row.userid+"</td>"+
	   "<td>"+row.username+"</td>"+
    "<td>"+row.usersex+"</td>"+
    "<td>"+row.userphone+"</td>"+
    "<td>"+row.useremail+"</td>"+
    "<td>"+row.useraddress+"</td>"+
    "<td>"+row.userjoinDate+"</td>"+
    "<td class='td-status'>"+
    "<span class='layui-btn layui-btn-danger layui-btn-mini'>已删除</span></td>"+
    "<td class='td-manage'>"+
    "<a title='恢复' onclick='member_del(this,"+row.userid+")' href=''>"+
      "<i class='layui-icon'>&#xe618;</i> </a>"+
   
    "<a title='删除' onclick='member_del(this,"+row.userid+")' href='javascript:;'>"+
      "<i class='layui-icon'>&#xe640;</i></a></td>"
    return tds;
}



