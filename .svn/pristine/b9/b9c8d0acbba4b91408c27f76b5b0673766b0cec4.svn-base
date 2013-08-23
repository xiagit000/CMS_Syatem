/**
 * function for validate login data.
 * @return true if validate.
 */
function validate(){
	var v_u = $("#username").attr("value");
	if(v_u == '' || v_u.length == 0){
		$("#error").show();
		$("#loginMessage").html("用户名不能为空！");
		return false;
	}
	var v_p = $("#password").attr("value");
	if(v_p == '' || v_p.length == 0){
		$("#error").show();
		$("#loginMessage").html("密码不能为空！");
		return false;
	}
	return true;
}

/**
 * AJAX function for login into.
 * @return null.
 */
function login(url,target){
	if(validate()){
		var v_u = $("#username").attr("value");
		var v_p = $("#password").attr("value");
		var v_v = $("#verifyCode").attr("value");
		$.post(url, {
			username: v_u,
			password: v_p,
			verifyCode:v_v
		}, function(message){
			switch(message){
			case "100":message = "无此用户！";
			break;
			case "200":message = "密码错误！";
			break;
			case "300":message = "未通过验证！";
			break;
			case "400":message = "登录成功！";
			window.location.href = target;
			break;
			case "500":message = "验证码错误！";
			break;
			default:message = "";
			break;
			}
			$("#loginMessage").html(message);
		});
	}
}

function exchange(url) {
	document.getElementById("pic").src = url+"?random="+Math.random();
}