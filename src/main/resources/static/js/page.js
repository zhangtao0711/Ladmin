/**zt页码信息*/
$(function(){
	//分页按钮上的事件注册
	//在容器pageId对应的对象上注册click事件，当点击容器中的子元素(例如pre,..)时执行
	//事件处理函数doJumpToPage
	$("#pageId").on("click",".prev,.pre,.next,.last",doJumpToPage);
})
//基于分页按钮事件，执行新的页码记录查询
function doJumpToPage(){
	//1.获取点击对象的class属性值(pre,first,next,last)
	var cls=$(this).prop("class");
	console.log("class",cls);
	//2.基于点击对象的不同修改当前页码值
	var current=$("#pageId").data("currentid");//基于key取值
	var pageCount=$("#pageId").data("pageCount");//基于key取值
	console.log(current);
	console.log(pageCount);
	if(cls=="prev"){//首页
		current=1;
	}else if(cls=="pre"&&current>1){//上一页并且不是第一页，应该执行当前页码减一操作
		current--;
	}else if(cls=="next"&&current<pageCount){
		current++;
	}else if(cls=="last"){
		current=pageCount;
	}else{
		return;
	}
	
	//3.基于新的页码值去执行新的查询
	//3.1存储新的页码值
	$("#pageId").data("currentid",current);
	console.log(current);
	//3.2执行新的查询
	doLoadData();
	//doGetObjects();
}
//初始化分页信息
function doSetPagination(pageObject){
	//console.log("pageObject",pageObject);
	//初始化总记录数
	$(".rowCount").html("总记录数("+pageObject.rowCount+")");
	//初始化总页数
	$(".pageCount").html("总页数("+pageObject.pageCount+")");
	//初始化当前页 
	$(".current").html("当前页("+pageObject.pageCurrent+")");
	//存储当前页码值和总页数
	//data函数为jquery中的一个数据绑定函数，可以将一些key/value对存储到指定的对象上
	//data函数语法data(key[,value]);
	$("#pageId").data("currentid",pageObject.pageCurrent);
	$("#pageId").data("pageCount",pageObject.pageCount);
}