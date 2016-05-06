findPresences = function (request, response) {
    var id = $('#book').val().split(" ")[0];
    console.log(id);

    $.ajax({
        type: "POST",
        contentType: "applecation/json",
        url: "/talons/order/libraries",
        data: JSON.stringify(id),
        dataType: "json",
        async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData:false,
        success: function (libraries) {
            console.log("Success");
            console.log(libraries);
            $('#libraries').html("");
            $('#selected').html("");
            for (var i = 0; i < libraries.length; i++) {
                $('#libraries').append("<option>" +libraries[i].id + " - " +  libraries[i].name + "</option>");
            }
        },
        error: function (result) {
            alert(" Ошибка");
            console.log(libraries)
        }
    });
};