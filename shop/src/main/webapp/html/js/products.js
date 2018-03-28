//页面加载的时候
window.onload = function () {
    getProList(proListSize, proListIndex, "addtime", true);
    //价格从低到高
    $("#lowPrice").click(function () {
        getProList(proListSize, proListIndex, "favourable_price", true);
    });
    //价格从高到低
    $("#highPrice").click(function () {
        getProList(proListSize, proListIndex, "favourable_price", false);
    });
    //最近商品
    $("#latest").click(function () {

        getProList(proListSize, proListIndex, "addtime", false);
    });
}
function getProList(pageSize, pageIndex, order, isAsc) {
    var prourl = baseUrl + '/product/queryProList';
    $.ajax({
        type: "GET",
        url: baseUrl+"/product/queryProList",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data: {"pageSize": pageSize, "pageIndex": pageIndex, "order": order, "isAsc": isAsc},
        success: function (map) {
            var html = "";
            console.log(map.data);
            $.each(map.data, function (index, obj) {

                    html += " <div class=\"col-md-3 product-grids\">\n" +
                    "                <div class=\"agile-products\">\n" +
                    "                <div class=\"new-tag\"><h6>New</h6></div>\n" +
                    "                <a href='single.html?'" + obj.psn + "><img src='" + obj.showimage + "' class=\"img-responsive\" alt=\"img\"></a>\n" +
                    "                <div class=\"agile-product-text\">              \n" +
                    "                <h5><a href=\"single.html\">Refrigerator</a></h5> \n" +
                    "                <h6><del>$" + obj.favourablePrice + "</del> $" + obj.originalPrice + "</h6> \n" +
                    "                <form action=\"#\" method=\"post\">\n" +
                    "                <input type=\"hidden\" name=\"cmd\" value=\"_cart\" />\n" +
                    "                <input type=\"hidden\" name=\"add\" value=\"1\" /> \n" +
                    "                <input type=\"hidden\" name=\"w3ls_item\" value=\"Refrigerator\" /> \n" +
                    "                <input type=\"hidden\" name=\"amount\" value=\"300.00\" /> \n" +
                    "                <button type=\"submit\" class=\"w3ls-cart pw3ls-cart\"><i class=\"fa fa-cart-plus\" aria-hidden=\"true\"></i> Add to cart</button>\n" +
                    "                </form>\n" +
                    "                </div>\n" +
                    "                </div>\n" +
                    "                </div> ";

            });
            html +="<div class=\"clearfix\"></div>";
            $("#productsList").empty();
            $("#productsList").prepend(html);
        },
        error: function (e) {
            alert("异常");
        }
    });
};