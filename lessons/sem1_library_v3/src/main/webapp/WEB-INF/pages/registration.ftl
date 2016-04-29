<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LLIB | Регистрация</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/resources/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <!-- Header -->
<#include "header.ftl">
    <!-- Left column -->
<#include "left_column.ftl">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Регистрация
                <small>начните читать прямо сейчас!</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Horizontal Form -->
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">Введите данные для регистрации</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" enctype="multipart/form-data" action="/registration" method="POST">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Имя на сайте:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="nickname"
                                       placeholder="Придумайте свой никнейм">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Email:</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="email"
                                       placeholder="Введите адрес своего электронного почтового ящика">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Имя:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="first_name"
                                       placeholder="Введите свое имя">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Второе имя:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="last_name"
                                       placeholder="Введите свое второе имя (необязательно)">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Фамилия:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="surname"
                                       placeholder="Введите свою фамилию">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Пароль:</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password"
                                       placeholder="Введите пароль">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Подтверждение пароля:</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password_confirmation"
                                       placeholder="Введите пароль еще раз">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Аватар:</label>
                            <div class="col-sm-10">
                                <input type="file" name="avatar">
                            </div>

                        </div>
                    </div><!-- /.box-body -->
                    <div class="box-footer">
                        <button class="btn btn-default">Отмена</button>
                        <button type="submit" class="btn btn-primary pull-right">Регистрация</button>
                    </div><!-- /.box-footer -->
                </form>
            </div><!-- /.box -->


        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- Footer -->
<#include "footer.ftl">


    <!-- Control Sidebar -->
<#include "control_sidebar.ftl">
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg "></div>
</div><!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/resources/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/dist/js/demo.js"></script>

</body>
</html>
