<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>ZHCash P2P Blockchain Network</title>

    <link rel="shortcut icon" href="https://zhcash.com/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
</head>

<body id="home">
<div id="large-header" class="large-header" style="height: 1158px">
    <canvas id="demo-canvas" width="1833" height="1158"></canvas>
</div>
<div id="Content" class="wrapper">
    <div class="top-wrapper">
        <div class="ZH-header-block">
            <div class="wrapper">
                <h1>ZHC Personal Node</h1>
            </div>
        </div>
    </div>
    <div class="bottom-wrapper">
        <div class="intro">
            <div class="intro-text">
                <h2 class="section-heading">Настройка</h2>
                <div class="ZH-bnt-block-small">
                    <a href="complexDownload" download="wallet.dat" onclick="this.href='wallet.dat';">
                        <button class="button_1623083733844 btn-zh-small">Резервная копия кошелька</button>
                    </a>
                </div>
                <form action="upload" method="post" enctype="multipart/form-data">

                    <hr>
                    <h3>Загрузка кошелька</h3>
                    <div class="ZH-bnt-block-small">
                        <input class="button_1623083733844 btn-zh-small" type="file" name="file" />
                    </div>
                    <div >
                        ${requestScope["message"]}
                    </div>
                    <!-- <br> -->
                    <div class="ZH-bnt-block-small">
                        <input class="button_1623083733844 btn-zh-small" type="submit" value="Загрузить" />
                    </div>
                    <hr>
                    <h3>Загрузка обновлений</h3>
                    <div class="ZH-bnt-block-small">
                        <input class="button_1623083733844 btn-zh-small" type="file" name="file" />
                    </div>
                    <div class="ZH-bnt-block-small">
                        <input class="button_1623083733844 btn-zh-small" type="submit" value="Обновление ПО" />
                    </div>
                    <div >
                        ${requestScope["message1"]}
                    </div>
                </form>
                    <form action="copy" method="post">
                        <hr>
                        <div class="ZH-bnt-block-small">
                        <input class="button_1623083733844 btn-zh-small" type="submit" value="Очистка кэша" />
                        </div>
                        <div >
                        ${requestScope["message2"]}
                        </div>
                        <hr>
                    </form>

                    <div class="ZH-bnt-block-small">
                        <a href="/index.html" class="button_1623083733844 btn-zh-small">На главную</a>
                    </div>
            </div>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<!-- TweenMax (60 Kb) — это основная библиотека анимации. Есть ещё TweenLite (21 Kb), включающий только базовые возможности. -->
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<!-- это набор эффектов анимации, контролирующих её характер, например, плавное замедление или «эластичное» подрагивание. -->
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<!-- анимация -->
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
<!-- анимация -->
</body>

</html>