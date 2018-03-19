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

function getAddList(userId){
    $.ajax({
        type:"GET",
        url: "http://127.0.0.1:8082/shop/address/getaddresslist",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{"userId": userId},
        success : function (map) {
            alert(map["success"]);
        },
        error :function(e){

        }
    });
}

$(document).ready(
    function () {
        alert("dd");
        getAddList(1);
    }
);