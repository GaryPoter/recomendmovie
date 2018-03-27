
function updateMovieAction() {
    var movie_name=$("#movie_name").val();
    var download_url=$("#download_url").val();
    var image_url = $("#image_url").val();
    var director=$("#director").val();
    var star=$("#star").val();
    var area =$("#area").val();
    var duration=$("#duration").val();
    var type=$("#type").val();
    var url=window.location .href;
    var aa=url.lastIndexOf("/");
    var id=url.substring(aa+1);
    var time=$("#time").val();
    var mabstract=$("#mabstract").text();
    if(movie_name != '') {
        $.ajax({
            async:false,
            type:'POST',
            dataType:'json',
            data:{id:id,movie_name:movie_name,download_url:download_url,image_url:image_url,director:director,star:star,area:area,duration:duration,type:type,time:time,mabstract:mabstract},
            url:'/movie/movies/update',
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response) {

                if (0 == response["code"]) {
                    alert("修改成功!");

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