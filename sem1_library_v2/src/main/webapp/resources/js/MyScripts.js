findPresences = function (request, response) {
    $.ajax({
        type: "POST",
        contentType: "applecation/json",
        url: "/talons/order/libraries",
        data: JSON.stringify($("#book").val()),
        dataType: "json",
        success: function (response_data) {
            console.log("Success");
            for (var i = 0; i < response_data.libs.length; i++) {
                $('#libraries').append("<option>" + response_data.libs[i] + "</option>");
            }
        }
    });
};