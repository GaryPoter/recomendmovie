function deleteAction(comment_id) {
    //  alert("dddd");
    // alert(movieId);
    // var r=confirm("确定要删除吗？");
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/movies/delete/'+ comment_id);
    }else {
        $(window).attr('location', '/movie/movies/getAllMovies');
        $(window).attr('location', '/movie/comment/delete/' + comment_id);
    }
    // }else{
    //     $(window).attr('location','/movie/comment/getAllComments');
    // }
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