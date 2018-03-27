// function update() {
//     $.ajax({
//
//     });
// }

// $("#updateUser").click(function () {
function updateUser() {

   var id = $("#id").val();
   var username = $("#username").val();
   var email = $("#email").val();
   var password = $("#password").val();
   var repassword = $("#repassword").val();
   if(password != repassword){
       alert("密码不一致！");
   }else  if(!valid_email(email)){
       alert("邮箱格式错误！");
   }else {
       $.ajax({
           async:false,
           type:'POST',
           dataType:'json',
           data:{id:id, username:username, email:email, password:password},
           url:'/movie/user/update',
           error:function (XMLHttpRequest, textStatus, errorThrown) {
               console.log(XMLHttpRequest);
               console.log(textStatus);
               console.log(errorThrown);
           },
           success: function (response) {
               if(0 == response["code"]){
                   alert("修改成功");

                   $(window).attr('location', '/movie/user/userManage');
                   console.log("重定向");
               }else {
                   $('#username').select().focus();
               }
           }
       });

    }
}


