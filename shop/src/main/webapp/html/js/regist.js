function regist() {
    alert("开始注册!");
    var emial = $("#emial").val();
    var username = $("#username").val();
    var userpassword = $("#password").val();
    var userpassword2 = $("#password2").val();
    var phone = $("#phone").val();

    var myreg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; 
    if (myreg.test(email.value) == false){
        alert("不是正确的emial地址");
        return false;
    }
    myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
    if (!myreg.test(phone)) {  
        alert("不是正确的手机号码");
        return false;  
    }

    if(userpassword != userpassword2){
        alert("2次输入的密码不一致!");
        return false;
    }
    $.ajax({
        type:"POST",
        url: testUrl + "/user/regist",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify({"username": username, "password":userpassword, "email" : email.value,"phone":phone}),
        success : function (map) {
            alert("注册成功!");
            window.location.href = "../login.html";
        },
        error :function(e){
            alert("异常");
        }
    });
}