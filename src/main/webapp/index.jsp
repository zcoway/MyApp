<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        /* spinner */
        .spinner-circle{ float:left; display: none;}
        .circle{
            background-color:#CCC;
            float:left;
            height:15px;
            margin-left:8px;
            width:15px;
            -webkit-animation-name: bounce_circle;
            -webkit-border-radius:10px;
            -webkit-animation-duration: 1.5s;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-direction: linear;
            opacity:0.3;
        }
        .spinner-circle .circle_1{ -webkit-animation-delay: .3s;}
        .spinner-circle .circle_2{ -webkit-animation-delay: .7s;}
        .spinner-circle .circle_3{ -webkit-animation-delay: .9s;}
        @-webkit-keyframes bounce_circle{
            0%{opacity:0.3;}
            50%{opacity:1;background-color:#111}
            100%{opacity:0.3;}
        }

        /* button */
        .button { 
            position: relative; 
            overflow: visible; 
            display: inline-block; 
            padding: 0.5em 1em; 
            border: 1px solid #d4d4d4; 
            margin: 0;
            text-decoration: none; 
            text-shadow: 1px 1px 0 #fff; 
            font:11px/normal sans-serif; 
            color: #333; 
            white-space: nowrap; 
            cursor: pointer; 
            outline: none; 
            background-color: #ececec;
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#f4f4f4), to(#ececec));
            background-image: -moz-linear-gradient(#f4f4f4, #ececec);
            background-image: -o-linear-gradient(#f4f4f4, #ececec);
            background-image: linear-gradient(#f4f4f4, #ececec);
            -webkit-background-clip: padding;
            -moz-background-clip: padding;
            -o-background-clip: padding-box; 
            /*background-clip: padding-box;*/ /* commented out due to Opera 11.10 bug */
            -webkit-border-radius: 0.2em; 
            -moz-border-radius: 0.2em; 
            border-radius: 0.2em; 
            /* IE hacks */
            zoom: 1; 
            *display: inline; 
        }

        .button:hover,
        .button:focus,
        .button:active {
            border-color: #3072b3;
            border-bottom-color: #2a65a0;
            text-decoration: none; 
            text-shadow: -1px -1px 0 rgba(0,0,0,0.3); 
            color: #fff; 
            background-color: #3072b3;
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#599bdc), to(#3072b3));
            background-image: -moz-linear-gradient(#599bdc, #3072b3);
            background-image: -o-linear-gradient(#599bdc, #3072b3);
            background-image: linear-gradient(#599bdc, #3072b3);
        }

        .button:active,
        .button.active {
            border-color: #2a65a0;
            border-bottom-color: #3884CF;
            color: #fff; 
            background-color: #3072b3;
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#3072b3), to(#599bdc));
            background-image: -moz-linear-gradient(#3072b3, #599bdc);
            background-image: -o-linear-gradient(#3072b3, #599bdc);
            background-image: linear-gradient(#3072b3, #599bdc);
        }

        body{ margin: 0; font: 16px/1.65 'sans-serif';}
        form { width: 350px; margin: 200px auto 0;}
        label { width: 100px; float: left; text-align: right; margin-right: 5px; line-height: 3em;}
        input[type=text], input[type=password] { border: 1px solid #CCC; height: 3em; padding: 0 10px; font-size: 16px;}
        input[type=submit]{ font-size: 16px;}

    </style>
</head>
<body>

    <form action="MyApp/j_spring_security_check" method="post" id="loginForm">
        <p>
            <label for="name">Username:</label>
            <input id="name" type="text" name="j_username">
        </p>
        <p>
            <label for="password">Password:</label>
            <input id="password" type="password" name="j_password">
        </p>
        <p id="action">
            <input type="submit" value="Login" class="button">
        </p>
        <p id="feedback">
        </p>
        <div id="spinner" class="spinner-circle">
            <div class="circle_1 circle"></div>
            <div class="circle_2 circle"></div>
            <div class="circle_3 circle"></div>
        </div>
    </form>

    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/jQuery.md5.js"></script>
    <script>
        'use strict';

        var $form = $('#loginForm'),
            $pass = $('#password'),
            $spinner = $('#spinner'),
            $action = $('#action'),
            $feedback = $('#feedback');

        $('#name').focus();

        $form.submit(function(){
            $pass.val($.md5($pass.val()));

            $.ajax({
                url: $form.attr('action'),
                data: $form.serialize(),
                type: 'POST',
                success: function(d){
                    $action.hide();
                    $spinner.show();

                    if(d['status'] !== 'success'){
                        $feedback.text('error');
                        $action.show();
                        $spinner.hide();
                        return;
                    }
                    location.href = '/C/' + (d.data.userType === 1 ? 'express' : 'buyer') + '/';
                }
            });
            return false;
        });

    </script>

</body>
</html>


