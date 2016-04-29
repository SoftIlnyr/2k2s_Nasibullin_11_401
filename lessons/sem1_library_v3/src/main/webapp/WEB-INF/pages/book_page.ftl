<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LLIB | ${book.title}</title>
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
            ${book.title}
                <small> <a href="/authors/${book.author.id}">${book.author.name} ${book.author.surname}</a></small>
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

                                <div class="post">
                                    <div class='row margin-bottom'>
                                        <div class='col-sm-4'>
                                            <img class='img-responsive img-bordered-sm'
                                                 src='/resources/uploads/book_images/${book.image}' alt='Photo'>
                                        </div><!-- /.col -->
                                        <div class="col-sm-8">
                                            <h1>${book.title}</h1>
                                            <h3>${book.author.name} ${book.author.surname}</h3>
                                            <p style="white-space: pre-line">${book.info}</p>

                                            <div class="box">
                                                <div class="box-header">
                                                    <h3 class="box-title">Наличие в библиотеках</h3>
                                                </div><!-- /.box-header -->
                                                <div class="box-body">
                                                    <table id="example1" class="table table-bordered table-striped">
                                                        <thead>
                                                        <tr>
                                                            <th>Библиотека</th>
                                                            <th>Адрес</th>
                                                            <th>Количество</th>
                                                            <th>Заказать</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#list presences as p>
                                                        <tr>
                                                            <td>${p.library.name}</td>
                                                            <td>${p.library.address}</td>
                                                            <td>${p.amount}</td>
                                                            <td><a href="/books/${book.id}/${p.library.id}" id><i class="fa fa-book"></i> </a> </td>
                                                        </tr>
                                                        </#list>
                                                        </tbody>
                                                        <tfoot>
                                                        <tr>
                                                            <th>Библиотека</th>
                                                            <th>Адрес</th>
                                                            <th>Количество</th>
                                                            <th>Заказать</th>
                                                        </tr>
                                                        </tfoot>
                                                    </table>
                                                </div><!-- /.box-body -->
                                            </div><!-- /.box -->


                                        </div>


                                    </div><!-- /.row -->

                                    <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                </div><!-- /.post -->
                            </div><!-- /.tab-pane -->
                            <div class="tab-pane" id="timeline">
                                <!-- The timeline -->
                                <ul class="timeline timeline-inverse">
                                    <!-- timeline time label -->
                                    <li class="time-label">
                        <span class="bg-red">
                          10 Feb. 2014
                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-envelope bg-blue"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>
                                            <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email
                                            </h3>
                                            <div class="timeline-body">
                                                Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
                                                weebly ning heekya handango imeem plugg dopplr jibjab, movity
                                                jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
                                                quora plaxo ideeli hulu weebly balihoo...
                                            </div>
                                            <div class="timeline-footer">
                                                <a class="btn btn-primary btn-xs">Read more</a>
                                                <a class="btn btn-danger btn-xs">Delete</a>
                                            </div>
                                        </div>
                                    </li>
                                    <!-- END timeline item -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-user bg-aqua"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>
                                            <h3 class="timeline-header no-border"><a href="#">Sarah Young</a> accepted
                                                your friend request</h3>
                                        </div>
                                    </li>
                                    <!-- END timeline item -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-comments bg-yellow"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>
                                            <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post
                                            </h3>
                                            <div class="timeline-body">
                                                Take me to your leader!
                                                Switzerland is small and neutral!
                                                We are more like Germany, ambitious and misunderstood!
                                            </div>
                                            <div class="timeline-footer">
                                                <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                                            </div>
                                        </div>
                                    </li>
                                    <!-- END timeline item -->
                                    <!-- timeline time label -->
                                    <li class="time-label">
                        <span class="bg-green">
                          3 Jan. 2014
                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-camera bg-purple"></i>
                                        <div class="timeline-item">
                                            <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                                            <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos
                                            </h3>
                                            <div class="timeline-body">
                                                <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                <img src="http://placehold.it/150x100" alt="..." class="margin">
                                            </div>
                                        </div>
                                    </li>
                                    <!-- END timeline item -->
                                    <li>
                                        <i class="fa fa-clock-o bg-gray"></i>
                                    </li>
                                </ul>
                            </div><!-- /.tab-pane -->

                            <div class="tab-pane" id="settings">

                                <form class="form-horizontal" enctype="multipart/form-data" action="/books/${book.id}"

                                      method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <div class="box-body">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Название:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="title"
                                                       value="${book.title}"
                                                       placeholder="Название">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Издание:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="edition"
                                                       value="${book.edition}"
                                                       placeholder="Издание">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Год выпуска:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="issue"
                                                       value="${book.issue}"
                                                       placeholder="Год выпуска">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Язык:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="language"
                                                       value="${book.language}"
                                                       placeholder="Язык">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Автор:</label>
                                            <div class="col-sm-10">
                                                <select class="form-control select2" style="width: 100%;" name="author">
                                                    <option selected="selected">${book.author.id}
                                                        - ${book.author.name} ${book.author.surname}</option>
                                                <#list authors as author>
                                                    <option>${author.id} - ${author.name} ${author.surname}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Информация:</label>
                                            <div class="col-sm-10">
                                <textarea class="form-control" rows="10" name="info" placeholder="Информация" style="white-space: pre-line">${book.info}
                                </textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile"
                                                   class="col-sm-2 control-label">Обложка:</label>
                                            <div class="col-sm-10">
                                                <input type="file" name="image">
                                            </div>
                                        </div>
                                    </div><!-- /.box-body -->
                                    <div class="box-footer">
                                        <button class="btn btn-default"><a href="/books/${book.id}/delete">Удалить</a></button>
                                        <button type="submit" class="btn btn-info pull-right">Редактировать</button>
                                    </div><!-- /.box-footer -->
                                </form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- /.nav-tabs-custom -->
                </div><!-- /.col -->
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
<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/resources/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $("#example1").DataTable();
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": true
        });
    });
</script>
</body>
</html>
