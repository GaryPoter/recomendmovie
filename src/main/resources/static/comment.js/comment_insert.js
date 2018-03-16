function addCommentAction() {
    var user_id=$("#user_id").val();
    var movie_id=$("#movie_id").val();
    var comment = $("#commentContent").val();
    // var comment_time=$("#comment_time").val();
    // var date = new Date(comment_time[0],parseInt(comment_time[1])-1,comment_time[2]);
    // var comment_time="1999-09-09";
    var score=9.0;
    if(user_id != ''&&movie_id !='') {
        $.ajax({
            async:false,
            type:'POST',
            dataType:'json',
            data:{user_id:user_id, movie_id:movie_id ,comment:comment, score:score},
            url:'/movie/comment/insert',
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response) {

                if (0 == response["code"]) {
                    alert("添加成功!");

                    $(window).attr('location','/movie/movies/movieDetails/' + movie_id);
                    console.log("重定向");
                }else if(2 == response["code"]){

                    alert("您还未登录，无法评论！");
                    $(window).attr('location','/movie/user/login');
                }else {
                    $('#user_id').select().focus();
                }

            }
        });
    }else{
        alert("未输入电影评论！");
    }
}