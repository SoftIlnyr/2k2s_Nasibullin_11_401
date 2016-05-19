findPresences = function (request, response) {
    var id = parseInt($('#book').val().split(" ")[0]);
    console.log(id);

    $.ajax({
        type: "POST",
        url: "/talons/order/libraries",
        data: JSON.stringify(id),
        dataType: "json",
        async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false,
        success: function (libraries) {
            console.log("Success");
            console.log(libraries);
            $('#libraries').html("");
            $('#selected').html("");
            for (var i = 0; i < libraries.length; i++) {
                $('#libraries').append("<option>" + libraries[i].id + " - " + libraries[i].name + "</option>");
            }
        },
        error: function (result) {
            // alert(" Ошибка");
            console.log("Error")
        }
    });
};

validateNickname = function (request, response) {
    var data = $('#nickname').val();
    console.log("Enter");
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        url: "/registration/nickname_validation",
        data: JSON.stringify({"data": data}),
        dataType: "json",
        success: function (flag) {
            if (flag === true) {
                $('#nickname_group').removeClass("has-danger").addClass("has-success");
                $('#userinfo').addClass('hidden');
            } else {
                $('#nickname_group').removeClass("has-success").addClass("has-danger");
                $('#userinfo').removeClass('hidden');
            }
        },
        error: function (result) {
            console.log(" Error");
        }
    });
};

validateEmail = function (request, response) {
    var data = $('#email').val();
    console.log("Enter");
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        url: "/registration/email_validation",
        data: JSON.stringify({"data": data}),
        dataType: "json",
        success: function (flag) {
            if (flag === true) {
                $('#email_group').removeClass("has-danger").addClass("has-success");
                $('#emailinfo').addClass('hidden');

            } else {
                $('#email_group').removeClass("has-success").addClass("has-danger");
                $('#emailinfo').removeClass('hidden');

            }
        },
        error: function (result) {
            console.log(" Error");
        }
    });
};