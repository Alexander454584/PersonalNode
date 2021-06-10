<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="Author" content="Briastorm Network IT Corporation">
<title>ZHCash P2P Blockchain Network</title>
<meta name="description" content="ZeroLab">
<meta name="keywords" content="zerohour, zhcash, crypto, blockchain">
<meta name="author" content="Briastorm">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css">
<link href="${pageContext.request.contextPath}/css/css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>
<style>
    .content {
        width: 500px;
        height: 300px;
        border: 2px black;
        float: left;
        text-align: left;
        text-emphasis-style: circle;
        margin-left: 30px;
        margin-top: 30px;
    }

    .content2 {
        width: 500px;
        height: 800px;
        border: 2px black;
        float: right;
        margin-right: 600px;
        margin-top: 30px;
    }

    .body {
        background: #424040;
    }

    .button {
        display: inline-block;
        font-size: 20px;
        color: #110e0e;
        background-color: #ffffff;
        border: none;
        border-radius: 15px;
        box-shadow: 0 3px #999;
    }


</style>
<body class="body">
<meta http-equiv="Refresh" content="60;URL=${pageContext.request.contextPath}/info" />
<div class="content">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <font style="font-size: 20px">Баланс: ${l1}<br>
        Баланс в работе: ${l3}<br>
        Высота блока: ${l4}<br>
        Версия программного обеспечения: ${l2}<br>
        Майнинг: <font color=${color1} ">${l5}</font><br>
                Состояние: <font color= ${color2}">${l6}</font><br>${l10}
        Ваш вес: ${l7}<br>
        Вес сети: ${l8}</font><br><br>
    <form method="get" action="${pageContext.request.contextPath}/list">
        <button class="button" type="submit">Отобразить адреса</button>
        <br><br>
        <p style="font-size: 20px">${l9} </p>
    </form>
</body>
</html>