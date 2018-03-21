$(".update").each(function () {
    $(this).click(function () {
        $(window).attr('location','/movie/user/updateUserPage?id=' + $(this).attr("data"));
    });
});


$(".delete").each(function () {
    $(this).click(function () {
        var id = $(this).attr("data");
        $.ajax({
            async: false,
            type: 'POST',
            dataType: 'json',
            data:{id:id},
            url: '/movie/user/delete',
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response){
                if(0 == response["code"]){
                    alert("删除成功!");
                    $(window).attr('location','/movie/user/userManage/?pageNum=1');
                    console.log("重定向");
                }else {
                    alert("删除失败");
                }
            }
        })
    });
});

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
        $.ajax({
            async: false,
            type: 'POST',
            dataType: 'json',
            data:{chestr:chestr},
            url: '/movie/user/batchDelete',
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
            },
            success: function(response){
                if(0 == response["code"]){
                    alert("删除成功!");
                    $(window).attr('location','/movie/user/userManage/?pageNum=1');
                    console.log("重定向");
                }else {
                    alert("删除失败");
                }
            }
        });
    }
}