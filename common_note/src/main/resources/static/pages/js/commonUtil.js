function ajax(url,type,contentType,param){
	$.ajax({
		　　url:url,                   　　  //地址
		　　type:type,　　　　　　 //请求方式 还可以是get type不可写成Type 不让会导致数据发送不过去,使用post无法接受
		　　contentType:contentType,　　　//返回格式 ,还可以是json
		　　async:false,　 　　 //同步异步 ,一般为异步flase
		　　data:JSON.stringify(param),　　 //参数值
		　　beforesend:function(){　//　请求前的处理

		　　},

		　　success:function(res){　
			　//请求成功时的处理
				return res;
		　　},
		　　complete:function(){　　//请求完成时的处理

		　　},
		　　error:function(){　　　　//请求出错误时的处理

		　　}
		});
	return null;
}