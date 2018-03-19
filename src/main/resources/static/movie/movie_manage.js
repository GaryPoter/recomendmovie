function deleteAction(movieId) {
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/movies/delete/'+movieId);
    }else{
        $(window).attr('location','/movie/movies/getAllMovies');
    }
}
