function deleteAction(comment_id) {
    //  alert("dddd");
    // alert(movieId);
    // var r=confirm("确定要删除吗？");
    if(window.confirm("确定删除？")){
<<<<<<< HEAD
        $(window).attr('location','/movie/movies/delete/'+ comment_id);
    }else{
        $(window).attr('location','/movie/movies/getAllMovies');
=======
        $(window).attr('location','/movie/comment/delete/'+ comment_id);
    }else{
        $(window).attr('location','/movie/comment/getAllComments');
>>>>>>> 5433d29737e5397230f9fa0566e937dae61b70b1
    }
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