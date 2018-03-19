// function update() {
//     $.ajax({
//
//     });
// }

$("#updateUser").click(function () {
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
       $.post("/movie/user/update",{id:id, username:username, email:email, password:password});
   }
});