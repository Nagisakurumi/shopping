function login(){
    alert("开始登陆!");
    var username = $("#username").val();
    var userpassword = $("#userpassword").val();



    $.ajax({
        type:"POST",
        url: "http://www.wxxand.xyx/shop/user/login",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{"username": username, "password":userpassword},
        success : function (map) {
            alert("登陆成功!");
            window.location.href = "../index.html";
        },
        error :function(e){
            alert("异常");
        }
    });
}


//搜索
function search(param) {
    alert("跳转到搜索界面!");
    var search = $("#search").val();
    window.location.href = "../products.html?key=" + keyword;
}
//页面加载的时候
window.onload = function(){
    $("#search").keyup(function(event){
        var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
        if (eCode == 13){
            alert('您按了回车键');
            search();
            //自己写判断函数
        }
    })
}

