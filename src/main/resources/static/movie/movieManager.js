$("#name").on("click", function () {
    alert($(this).text());
    $(this).text("程佳倩");
    $(this).html("<a href='http://www.baidu.com '>baidu</a>");


})

$("#getVal").on("click", function () {
    var val = $("#textarea").val();
    var val2 = $("#textarea").text();
    alert(val + " : " + val2);
})