function changCodeImage(){
	var path = document.getElementById("path").value;
	document.getElementById('imageCode').src=path+"/getImageCode?code="+Math.random();
}
function login(){
	var number = document.getElementById("number").value();
	if(number == null || number == ""){
		alert("登陆账号不能为空");
		return;
	}
	var password = document.getElementById("password").value();
	if(password == null || password == ""){
		alert("登陆密码不能为空");
		return;
	}
	var imageCode = document.getElementById("imageCode").value();
	if(imageCode == null || imageCode ==""){
		alert("验证不能为空");
		return;
	}
	document.getElementById("loginForm").submit();
}