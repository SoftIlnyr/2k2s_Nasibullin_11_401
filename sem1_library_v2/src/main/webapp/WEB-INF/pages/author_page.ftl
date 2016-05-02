<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LLIB | ${author.name} ${author.surname}</title>
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


<#include "header.ftl">
<#include "left_column.ftl">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
            ${author.name} ${author.surname}
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#info" data-toggle="tab">Информация</a></li>
                            <li><a href="#settings" data-toggle="tab">Редактировать</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="info">

                                <!-- Post -->
                                <div class="post">
                                    <div class='row margin-bottom'>
                                        <div class='col-sm-4'>

                                            <img class='img-responsive img-bordered-sm'
                                                 src='/resources/uploads/author_images/${author.photo}' alt='Photo'>
                                        </div><!-- /.col -->
                                        <div class="col-sm-8">
                                            <h1>${author.name} ${author.surname}</h1>
                                            <p style="white-space: pre-line">${author.info}</p>
                                        </div>

                                    </div><!-- /.row -->

                                </div><!-- /.post -->

                            </div><!-- /.tab-pane -->

                            <div class="tab-pane" id="settings">

                                <form class="form-horizontal" enctype="multipart/form-data" action="/authors/${author.id}"
                                      method="POST">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Имя:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="name"
                                                       value="${author.name}"
                                                       placeholder="Имя">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Фамилия:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="surname"
                                                       value="${author.surname}"
                                                       placeholder="Фамилия">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Информация:</label>
                                            <div class="col-sm-10">
                                <textarea class="form-control" rows="10" name="info" placeholder="Информация"
                                          style="white-space: pre-line"> ${author.info}
                                </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Изображение:</label>
                                            <div class="col-sm-10">
                                                <input type="file" name="image">
                                            </div>

                                        </div>
                                    </div><!-- /.box-body -->
                                    <div class="box-footer">
                                        <button class="btn btn-default"><a href="/authors/${author.id}/delete">Удалить</a></button>
                                        <button type="submit" class="btn btn-info pull-right">Редактировать</button>
                                    </div><!-- /.box-footer -->
                                </form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->

                    </div><!-- /.nav-tabs-custom -->
                </div><!-- /.col -->
            <#list books as book>
                <div class="col-md-6">
                    <!-- About Me Box -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <a href="/books/${book.id}"><h3 class="text-muted text-center">${book.title}</h3></a>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class='col-sm-4'>
                                <a href="/books/${book.id}">
                                <img class='img-responsive img-bordered-sm'
                                     src='/resources/uploads/book_images/${book.image}' alt='Photo'></a>
                            </div>
                            <div class="col-sm-8">
                                <p style="white-space: pre-line">${book.info}</p>
                            </div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </#list>
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->


<#include "footer.ftl">
    <!-- Control Sidebar -->
<#include "control_sidebar.ftl">
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
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
