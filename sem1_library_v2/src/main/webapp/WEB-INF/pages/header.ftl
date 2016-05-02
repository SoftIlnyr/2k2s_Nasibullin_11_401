<header class="main-header">
    <!-- Logo -->
    <a href="/test" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>L</b>LIB</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Legistis</b>LIBRO</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <#if user?exists>
                        <img src="/resources/uploads/user_images/${user.avatar}" class="user-image" alt="User Image">
                        <span class="hidden-xs">${user.nickname}</span>
                    <#else >
                        <img src="/resources/uploads/user_images/default.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">Анонимный пользователь</span>
                    </#if>

                    </a>
                    <ul class="dropdown-menu">
                    <#if user?exists>
                        <!-- User image -->
                        <li class="user-header">
                            <img src="/resources/uploads/user_images/${user.avatar}" class="img-circle"
                                 alt="User Image">
                            <p>
                            ${user.firstName} ${user.surname}
                            </p>
                            <small>${user.role}</small>
                        </li>
                    <#else >
                        <li class="user-header">
                            <img src="/resources/uploads/user_images/default.jpg" class="img-circle"
                                 alt="User Image">
                            <p>
                                Анонимный пользователь
                            </p>
                        </li>
                    </#if>

                        <!-- Menu Footer-->
                    <#if user?exists>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/users/${user.id}" class="btn btn-default btn-flat">Профиль</a>
                            </div>
                            <div class="pull-right">
                                <a href="/logout" class="btn btn-default btn-flat">Выход</a>
                            </div>
                        </li>
                    <#else >
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/login" class="btn btn-default btn-flat">Вход</a>
                            </div>
                            <div class="pull-right">
                                <a href="/registration" class="btn btn-default btn-flat">Регистрация</a>
                            </div>
                        </li>
                    </#if>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li>
                    <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                </li>
            </ul>
        </div>
    </nav>
</header>
