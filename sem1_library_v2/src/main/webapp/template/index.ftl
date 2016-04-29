<#ftl encoding="Windows-1251"/>
<!doctype html>
<html>
<head>
    <meta charset="Windows-1251">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>Cooker</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="../css/style.css?v=2">
    <link rel="stylesheet" href="../css/jcarousel.css">

    <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
    <script src="../js/libs/modernizr-1.7.min.js"></script>

</head>

<body class="home">

<!-- LOGIN POP UPS -->
<div id="popup-overlay"></div>
<div class="popup" id="popup-login">
    <h2>Вход</h2>
    <hr class="separator">
    <form method="post" action="/index/process" class="form clearfix">
        <fieldset>
            <label for="login-username">Логин:</label>
            <input type="text" name="login" id="login-username" class="input text">
            <label for="login-password">Пароль:</label>
            <input type="password" name="password" id="login-password" class="input text">
        </fieldset>

    <hr class="separator">
    <button type="submit" class="button submit">Войти</button>
    <div class="links"><a href="#">Forgotten password </a> | <a href="#" class="register-btn"> New account</a></div>
    <a class="close" href="#"></a>
    </form>
</div>



<div class="popup" id="popup-register">
    <h2>Регистрация</h2>
    <hr class="separator">
    <form method="post" action="/index" class="form clearfix">
        <fieldset>
            <label for="login-username">Логин:</label>
            <input type="text" name="login" id="login-username" class="input text">
            <label for="login-email">Телефон:</label>
            <input type="text" name="phone" id="login-email" class="input text" >
            <label for="login-password">Пароль:</label>
            <input type="password" name="password" id="login-password" class="input text">
            <label for="login-confirm-password">Повторите пароль:</label>
            <input type="password" name="repassword" id="login-confirm-password" class="input text">
        </fieldset>

        <hr class="separator">

        <div class="checks">
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I have read and agree to the <a href="#">Terms &amp; Conditions</a></label>
            </div>
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I agree to recieve promotional mails</label>
            </div>
        </div>

        <button title="submit" class="button submit">Зарегистрироваться</button>
    </form>
    <a class="close" href="#"></a>
</div>
<!-- END LOGIN POP UPS -->
<div class='wrapper'>
    <header>
        <div class="top-nav">
            <nav>
                <ul>
                    <li><a href="#" id="login-btn">Вход</a></li>
                    <li><a href="#" class="register-btn">Регистрация</a></li>
                    <li><a href="/default">Мой профиль</a></li>
                </ul>
            </nav>

            <form class="search-form" method="post">
                <input type="text" class="search" placeholder="Search for product">
                <input type="submit" class="search-submit" value="">
            </form>

        </div>
        <a href="/index" class="logo"><img src="/images/logo.png" alt="your logo" /></a>
        <nav class="main-menu">
            <ul>
                <li id="lava-elm"></li>
                <li class="current"><form action="/listing" >
                    <button type="submit" value="KOMBO" name="type">Наборы</button>
                </form></li>
                <li>
                <form action="/listing" >
                    <button type="submit" value="PIZZA" name="type">Пицца</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ROLL" name="type">Роллы</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DRINK" name="type">Напитки</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DESERT" name="type">Десерты</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="WOK" name="type">Вок</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ANOTHER" name="type">Дополнительно</button>
                </form></li>
            </ul>
        </nav>
        <div class="header-slider-canvas">
            <div class="parts part-1"></div>
            <div class="parts part-2"></div>
            <div class="parts part-3"></div>
        </div>

        <ul id="mycarousel" class="jcarousel-skin-header-slider">
        <#list productsSlider as p>
            <li><img src= "${p.getPhoto()}" width="680px"  height="464" alt="" /><div class="description"><span class='price'>${p.getPrice()}</span><span class='name'>${p.getName()}</span><a href="#" class="shop">shop now</a></div></li>
        </#list>
        </ul>
    </header>
    <div class="content clearfix">
        <div id="meals-of-the-day">
            <h3 class="title-separator"><span class="title">Блюда дня</span><span class="sep"></span></h3>
            <ul>
                <#list productsOfDay  as prodOfDay>
                    <li class="meal">
                        <div class="img-holder"><img src=${prodOfDay.getPhoto()} alt=""></div>
                        <div class="desc-holder">
                            <h1><a href="#">${prodOfDay.getName()}</a></h1>
                            <p>${prodOfDay.getDescription()}</p>
                            <span class="price">${prodOfDay.getPrice()}</span>
                            <a href="check-out.html" class="add-to-cart-button">add to cart</a>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
        <h3 class="title-separator"><span class="title">Особые блюда</span><span class="sep"></span></h3>


        <div id="featured-meals">
            <ul>
                <#list productsFeatured as prodFeatured>
                    <li class="meal">
                        <div class="img-holder"><img src=${prodFeatured.getPhoto()} alt=""></div>
                        <h1><a href="#">${prodFeatured.getName()}</a></h1>
                        <p>${prodFeatured.getDescription()}</p>
                        <span class="price">${prodFeatured.getPrice()}</span>
                        <a href="check-out.html" class="add-to-cart-button">add to cart</a>
                    </li>
                </#list>
            </ul>
        </div>

        <div class="cart-box">
            <div class="top">Корзина</div>
            <div class="body">
                <ul>
                    <li class="info">
                        <span class="products"><strong>5</strong> товаров</span>
                        <a href="#">Посмотреть корзину</a>
                    </li>
                    <li class="price">
                        <span class="label">Доставка</span>
                        <span class="value">$0.00</span>
                    </li>
                    <li class="price">
                        <span class="label">Всего</span>
                        <span class="value">$0.00</span>
                    </li>
                </ul>
                <a class="submit-button" href="check-out.html">Check out</a>
                <div class="graphic"></div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="footer-holder">
        <a href="" class="logo">Cooker Logo</a>
        <div class="newsletter">
            <div class="quote">
                <h6>Newsletter</h6>
                <p>Sign-up for our newsletter and be always aware of the new offers and services:</p>
                <form method="post">
                    <input type="text" placeholder="Email"><input type="submit" value="Submit" class="submit-button">
                </form>
            </div>
        </div>
        <div class="links first">
            <h6>follow us on...</h6>
            <ul>
                <li class="facebook"><a href="#">Facebook</a></li>
                <li class="twitter"><a href="#">Twitter</a></li>
                <li class="rss"><a href="#">Rss feed</a></li>
            </ul>
        </div>
        <div class="links">
            <h6>useful links</h6>
            <ul>
                <li><a href="#">Specials</a></li>
                <li><a href="#">New orders</a></li>
                <li><a href="#">Terms and conditions of use</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#">Sitemap</a></li>
            </ul>
        </div>
        <div class="links">
            <h6>categories</h6>
            <ul>
                <li><a href="#">Fruits and vegetables</a></li>
                <li><a href="#">Seafood</a></li>
                <li><a href="#">Meat</a></li>
                <li><a href="#">Entrees</a></li>
                <li><a href="#">Pizza and pasta</a></li>
                <li><a href="#">Desserts</a></li>
            </ul>
        </div>
        <div class="credits clearfix">
            Copyright &copy; 2011 Cooker. All rights reserved
        </div>
    </div>
</footer>
</body>


<script type="text/javascript" src="/js/libs/jquery-1.7.1.min.js"></script>
<script src="/js/libs/jquery.easing.1.3.js"></script>
<script src="/js/script.js"></script>
<script src="/js/libs/jquery.jcarousel.min.js"></script>

<script type="text/javascript">
    // FRONT SLIDER STARTER

    jQuery(document).ready(function() {
        jQuery('#mycarousel').jcarousel({
            auto: 3,
            wrap: 'last',
            scroll: 1,
            animation: 'slow',
            initCallback: mycarousel_initCallback,
        });
    });
</script>

</html>