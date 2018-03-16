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

$("#selectAll").select(function () {
    $(".selectRow").each(function () {
        $(this).select(true);
    })
});