//管理员登录界面的js
function loginAction(){
    var mName=$("#mName").val();
    var mPassword=$("#mPassword").val();
    if(mName!=''&&mPassword!=''){
        $.ajax({
            async:false,
            type:'POST',
            dataType:'json',
            data:{mName:mName,mPassword:mPassword},
            url:'/movie/movies/loginAction',
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response){
                if(0 == response["code"]){
                    alert("登录成功!");
                    $.cookie("mName", mName, { expires: 7 });
                    $(window).attr('location','/movie/manager');
                    console.log("重定向");
                }else {
                    alert("输入的用户名或密码有误");
                    $('#mName').select().focus();
                }
            }

        });

    }else{
        alert("输入的用户名或密码为空");
    }
}