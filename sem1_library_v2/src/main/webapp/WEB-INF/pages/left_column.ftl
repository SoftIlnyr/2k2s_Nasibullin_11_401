<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">НАВИГАЦИЯ</li>
            <li><a href="#"><i class="fa fa-bookmark-o"></i> <span>Главная</span></a></li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>Книги</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/books/"><i class="fa fa-circle-o"></i> Главная</a></li>
                    <li><a href="/auhors/"><i class="fa fa-circle-o"></i> Авторы</a></li>
                    <li><a href="/talons/order"><i class="fa fa-circle-o"></i> Получить книгу</a></li>
                </ul>
            </li>
        <@security.authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')">

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-table"></i> <span>Таблицы</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/tables/books"><i class="fa fa-circle-o"></i> Книги</a></li>
                    <li><a href="/tables/authors"><i class="fa fa-circle-o"></i> Писатели</a></li>
                    <li><a href="/tables/libraries"><i class="fa fa-circle-o"></i> Библиотеки</a></li>
                    <li><a href="/tables/users"><i class="fa fa-circle-o"></i> Пользователи</a></li>
                    <li><a href="/tables/talons"><i class="fa fa-circle-o"></i> Записи</a></li>
                    <li><a href="/tables/presences"><i class="fa fa-circle-o"></i> Книги в наличии</a></li>
                </ul>
            </li>
        </@security.authorize>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- =============================================== -->