function deleteAction(comment_id) {
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/comment/delete/'+ comment_id);
    }else {
        $(window).attr('location', '/movie/comment/getAllComments');
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
        $(window).attr('location','/movie/comment/batchDelete/'+chestr);
    }
}
