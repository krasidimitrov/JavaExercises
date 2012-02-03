$(document).ready(function () {

    var jVal = {

        'sendIt':function () {
            if (!jVal.errors) {
                alert("SENT");
                $('#regForm').submit();
            }
        },

        'firstName':function () {

            $('#mainDiv').append('<div id="firstNameInfo" class="info"></div>');

            var firstNameInfo = $('#firstNameInfo');
            var ele = $('#firstName');
            var pos = ele.offset();

            firstNameInfo.css({
                'position':'absolute',
                'color':'red',
                'background-color':'#ddd',
                'left':'300px',
                'top':pos.top - ele.height()
            });

            if (ele.val().length < 5) {
                jVal.errors = true;
                firstNameInfo.removeClass('correct').addClass('error').html('&larr; at least 5 characters').show();
                ele.removeClass('normal').addClass('wrong');
            } else {
                firstNameInfo.removeClass('error').addClass('correct').html('&radic;').show();
                ele.removeClass('wrong').addClass('normal');
            }
        },


        'lastName':function () {

            $('#mainDiv').append('<div id="lastNameInfo" class="info"></div>');

            var lastNameInfo = $('#lastNameInfo');
            var ele = $('#lastName');
            var pos = ele.offset();

            lastNameInfo.css({
                'position':'absolute',
                'color':'red',
                'background-color':'#ddd',
                'left':'300px',
                'top':pos.top - ele.height()
            });

            if (ele.val().length < 5) {
                jVal.errors = true;
                lastNameInfo.removeClass('correct').addClass('error').html('&larr; at least 5 characters').show();
                ele.removeClass('normal').addClass('wrong');
            } else {
                lastNameInfo.removeClass('error').addClass('correct').html('&radic;').show();
                ele.removeClass('wrong').addClass('normal');
            }
        }



    };


    $('#send').click(function () {
        var obj = $.browser.webkit ? $('body') : $('html');
        obj.animate({ scrollTop:$('#regForm').offset().top }, 750, function () {
            jVal.errors = false;
            jVal.firstName();
            jVal.lastName();
            jVal.sendIt();
        });
        return false;
    });

});


