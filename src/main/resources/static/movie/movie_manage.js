function deleteAction(movieId) {
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/movies/delete/'+movieId);
    }else{
        $(window).attr('location','/movie/movies/getAllMovies');
    }
}

function batchDelete() {
    var elements = document.getElementsByName("hxy");
    var chestr="";
    for(var i = 0; i <elements.length; i++){
        if(elements[i].checked==true){
            chestr+=elements[i].value+",";
        }
    }
    if(chestr==""){
        alert("请先选择需要删除的电影");
    }
    else{
        $(window).attr('location','/movie/movies/batchDelete/'+chestr);
    }
}

