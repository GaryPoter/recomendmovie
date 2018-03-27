// $("input#addMovie").on('click',function(){
//     var movie_name=$("#movie_name").val();
//     var movie_resouse_url=$("#movie_resouse_url").val();
//     var image_id = $("#image_id").val();
//     var director=$("#director").val();
//     var starring=$("#starring").val();
//     var area =$("#area").val();
//     var duration=$("#duration").val();
//     var typeId=$("#typeId optiion:selected").text();
//     if(movie_name != ''&&movie_resouse_url != '') {
//         $.ajax({
//             async:false,
//             type:'POST',
//             dataType:'json',
//             data:{movie_name:movie_name,movie_resouse_url:movie_resouse_url,image_id:image_id,director:director,starring:starring,area:area,duration:duration,typeId:typeId},
//             url:'/movie/movies/insert',
//             error:function(XMLHttpRequest, textStatus, errorThrown) {
//                 console.log(XMLHttpRequest);
//                 console.log(textStatus);
//                 console.log(errorThrown);
//             },
//             success: function(response) {
//
//                 if (0 == response["code"]) {
//                     alert("添加成功!");
//
//                     $(window).attr('location','/movie/movies/getAllMovies');
//                     console.log("重定向");
//                 }else {
//                     $('#movie_name').select().focus();
//                 }
//
//             }
//         });
//     }else{
//         alert("未输入电影名字或电影链接！");
//     }
// });

function addMovieAction() {
    var movie_name=$("#movie_name").val();
    var download_url=$("#download_url").val();
    var image_url = $("#image_url").val();
    var director=$("#director").val();
    var star=$("#star").val();
    var area =$("#area").val();
    var duration=$("#duration").val();
    var type=$("#type").val();
    var time=$("#time").val();
    var mabstract=$("#mabstract").val();
    if(movie_name != '') {
        $.ajax({
            async:false,
            type:'POST',
            dataType:'json',
            data:{movie_name:movie_name,download_url:download_url,image_url:image_url,director:director,star:star,area:area,duration:duration,type:type,time:time,mabstract:mabstract},
            url:'/movie/movies/insert',
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response) {

                if (0 == response["code"]) {
                    alert("添加成功!");

                    $(window).attr('location','/movie/movies/getAllMovies');
                    console.log("重定向");
                }else {
                    $('#movie_name').select().focus();
                }

            }
        });
    }else{
        alert("未输入电影名字！");
    }
}