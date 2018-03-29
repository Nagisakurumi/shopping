window.onload = function(){

    var ol = $("#imageslist")[0].parentNode.parentNode.children[1];
    ol.style.height = "420px";
    ol.style.overflowY = "auto";

    $.ajax({
        type:"GET",
        url: testUrl + "/product/getdetail",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:{"proId" : GetQueryString("proId")},
        success : function (map) {
            if(map.success == true){
                var images = "";
                for (let index = 0; index < map.productImages; index++) {
                    images += "<li data-thumb='images/s1.jpg'> " +
                                "	<div class='thumb-image detail_images'> " +
                                "<img src='" + map.productImages[i].imgUrl + "' data-imagezoom='true' class='img-responsive' alt=""> "
                                "</div>" +
                                "</li>";              
                }
                $("#imageslist").html(images);

                $("#reviews").html(map.product.visitCount + " reviews");
                $("#price").html("$" + map.product.originalPrice);
                $("#offprice").html("$" + map.product.favourablePrice);
                $("#time").html("Shelf time " + map.product.addtime);
                $("#productname").html(map.product.name);
                $("#off").html((1 - parseFloat(map.product.favourablePrice) / parseFloat(map.product.originalPrice))
                    + "OFF");
                var stars = parseInt((parseFloat(map.product.star1) + parseFloat(map.product.star2) +
                parseFloat(map.product.star3) + parseFloat(map.product.star4)) / 4);
                var starList = $("#starList")[0].children;
                for (let index = 0; index < 4; index++) {
                    if(index < stars)
                    {
                        starList[index].style.visibility = "visible";
                    }   
                    else{
                        starList[index].style.visibility = "hidden";
                    }                 
                }
            }else{
                alert("获取数据异常!");
            }
        },
        error :function(e){
            alert("异常");
        }
    });
}