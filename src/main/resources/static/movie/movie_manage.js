function deleteAction(movieId) {
    //  alert("dddd");
    // alert(movieId);
    // var r=confirm("确定要删除吗？");
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/movies/delete/'+movieId);
    }else{
        $(window).attr('location','/movie/movies/getAllMovies');
    }
}

function searchMovieAction() {
    var searchContent = $("#searchContent").val();
    $.ajax({
        async:false,
        type:'GET',
        dataType:'json',
        data:{searchContent:searchContent},
        url:'/movie/movies/search/'+searchContent,
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}
// $("#delete").on("click",function () {
//     alert("dddd");
//     var movieId=movieId.val();
//     var r=confirm("确定要删除吗？");
//      if(r==true){
//          $(window).attr('location','/movie/movies/delete/'+movieId);
//     }else{
//         $(window).attr('location','/movie/movies/getAllMovies');
//     }
// });