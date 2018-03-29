var baseUrl = 'http://www.wxxandxyx.cn:8081/shop';
var proListSize = 2;
var proListIndex = 1;


var testUrl = "http://localhost:8081/shop"


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}