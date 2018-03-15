function deleteAction(comment_id) {
    if(window.confirm("确定删除？")){
        $(window).attr('location','/movie/comment/delete/'+ comment_id);
    }else {
        $(window).attr('location', '/movie/comment/getAllComments');
    }

}
