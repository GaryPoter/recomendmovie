// <<<<<<< HEAD
// function inserCommentAction() {
//     var user_id=$("#uId").val();
//     var movie_id=$("#mId").val();
//     var comment = $("#comment").val();
//     var score=$("#score").val();
//     var myDate = new Date();
//     var comment_time=myDate.toLocaleString( );
//     if(score=='')
//         score=0;
//     if(user_id!=null){
//         if(comment!=''){
//             $.ajax({
//                 async:false,
//                 type:'POST',
//                 dataType:'json',
//                 data:{user_id:user_id, movie_id:movie_id ,comment:comment, comment_time:comment_time,score:score},
//                 url:'/movie/comment/insert',
//                 error:function(XMLHttpRequest, textStatus, errorThrown) {
//                     console.log(XMLHttpRequest);
//                     console.log(textStatus);
//                     console.log(errorThrown);
//                 },
//                 success: function(response) {
//
//                     if (0 == response["code"]) {
//                         alert("添加成功!");
//                         $(window).attr('location','/movie/movies/movieDetails/'+movie_id+'/'+1);
//                         console.log("重定向");
//                     }
// =======
function addCommentAction() {
    var user_id=$("#uid").val();
    var movie_id=$("#mid").val();
    var comment = $("#comment").val();

    // var comment_time=$("#comment_time").val();
    // var date = new Date(comment_time[0],parseInt(comment_time[1])-1,comment_time[2]);
    // var comment_time="1999-09-09";
    // var score=$("#score").val();
    var score = $("#ratingScore").val();
    if(user_id != null) {
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

                    $(window).attr('location', '/movie/movies/movieDetails/' + movie_id + "/1");
                    console.log("重定向");
                } else if (2 == response["code"]) {

                    alert("您还未登录，无法评论！");
                    $(window).attr('location', '/movie/user/login');
                } else {
                    alert("添加失败！");
                }
            }
            });
        }else{
        alert("您还未登录，无法评论！");
        $(window).attr('location', '/movie/user/login');
        }
}

$(function () {
    // $("td").each(function (index) {
    //     $(this).click = function () {
    //         alert(index + 1);
    //     };
    //     // $(this).on("click", function () {
    //     //     $(this).text(index);
    //     //     alert("this");
    //     // });
    // });
    tds = document.getElementsByTagName("td");
    for(var i = 0;i < tds.length;i ++){
        tds[i].onmouseover=score;
    }
    var index;
    function score(){

        for(var i = 0;i < tds.length;i ++){
            if(tds[i]==this)
            {
                index=i;
            }
        }
        //选中的设置成黄色 没选中的设置成灰色
        for(var i = 0;i <= index; i ++) {
            tds[i].style.color = "#FFD700";
        }
        for(var i = index + 1;i < tds.length;i ++){
            tds[i].style.color="gray";
        }
        $("#ratingScore").val(index);
    }
    // document.getElementById("td").onclick=function(){
    //     var rating = index + 1;
    //     $("#ratingScore").val(rating);
    //     alert(rating)
    // }
});

// $(function(){
//     $('td').each(function(index){
//         $(this).on('click',function(){
//             alert(index);
//         })
//     })
// });

