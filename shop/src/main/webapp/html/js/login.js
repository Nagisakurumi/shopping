var veridx = 0;


var uid = "";

function changeVerImage(img){
    $.ajax({
        type:"GET",
        url: testUrl + "/user/getverid",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{},
        success : function (map) {
            if(map.success == true){
                uid = map.data;
                img.src = "http://127.0.0.1:8081/shop/user/getvercode?uid=" + uid + "idx=" + veridx;
                veridx ++;
            }else{
                alert("请求验证码异常");
            }
        },
        error :function(e){
            alert("异常");
        }
    });
    
}



function login(){
    $.ajax({
        type:"GET",
        url: testUrl + "/user/verifycode",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{"key": uid, "value" : $("#vercode").val()},
        success : function (map) {
            if(map.success == true){
                var username = $("#username").val();
                var userpassword = $("#password").val();
                
                $.ajax({
                    type:"POST",
                    url: testUrl + "/user/login",
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    data:JSON.stringify({"username": username, "password":userpassword}),
                    success : function (map) {
                        window.location.href = "../index.html";
                    },
                    error :function(e){
                        alert("异常");
                    }
                });
            }else{
                alert("验证码错误");
            }
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

    changeVerImage($("#verimg")[0])
}

