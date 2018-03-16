function login(){
    var username = $("#username").val();
    var userpassword = $("#userpassword").val();
    $.ajax({
       type:"POST",
        url:"127.0.0.1:8081/shop/user/login",
        data:{"username": username, "password":userpassword},
        success : function (map) {
            alert(map["success"]);
        }
    });
}