function addCommentAction() {
    alert("ffff");
    var user_id=$("#user_id").val();
    var movie_id=$("#movie_id").val();
    var comment = $("#comment").val();
    var comment_time=$("#comment_time").val();
    var date = new Date(comment_time[0],parseInt(comment_time[1])-1,comment_time[2]);
    var score=$("#score").val();
    if(user_id != ''&&movie_id !='') {
        $.ajax({
            async:false,
            type:'POST',
            dataType:'json',
            data:{user_id:user_id, movie_id:movie_id ,comment:comment, comment_time:date,score:score},
            url:'/movie/comment/insert',
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response) {

                if (0 == response["code"]) {
                    alert("添加成功!");

                    $(window).attr('location','/movie/comment/getAllComments');
                    console.log("重定向");
                }else {
                    $('#user_id').select().focus();
                }

            }
        });
    }else{
        alert("未输入电影或者评论！");
    }
}