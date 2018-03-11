$('#loginBtn').on('click', function () {
    var email = $('input#email').val();
    // var name = $('input#email').val();
	
    var password = $('input#password').val();
    // var paswd = $('input#password').val();
	if(valid_email(email) && valid_password(password)){
		$.ajax({
			async: false,
			type: 'POST',
			dataType: 'json',
			data:{email:email, password:password},
			url: '/movie/user/loginAction',
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log(XMLHttpRequest);
				console.log(textStatus);
				console.log(errorThrown);
			},
			success: function(response){
				if(0 == response["code"]){
					// document.getElementById("moviePage").click();
					// $('#moviePage').click();
                    // $(location).attr('href', 'index.html');
					alert("登录成功!");
                    // window.location.href = "http://www.baidu.com";
                    // $(location).prop('href', 'http://www.jb51.net');
					$.cookie("email", email, { expires: 7 })
                    $(window).attr('location','/movie/home');
                    console.log("重定向");
                }else {
					$('#email').select().focus();
				}
			}
		});
	}else{
		alert("输入的邮箱或者密码格式错误");
	}
});

$(function () {
	var email = $.cookie("email")
	if(email != null){
		$("input#email").val(email)
	}
});