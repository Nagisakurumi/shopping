function login(){
    var username = $("#username").val();
    var userpassword = $("#userpassword").val();
    $.ajax({
        type:"POST",
        url: "http://localhost:8082/shop/user/login",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{"username": username, "password":userpassword},
        success : function (map) {
            alert(map["success"]);
        },
        error :function(e){

        }
    });
}