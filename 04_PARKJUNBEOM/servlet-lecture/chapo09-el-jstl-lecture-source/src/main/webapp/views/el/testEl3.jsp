<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>파라미터 값 받아서 출력하기</h1>

    상품명: ${ param.name}
    가격: ${ param.price}
    제품번호 ${ param.no}
    제품번호 : ${ paramValues.no[0]}, ${ paramValues.no[1]}
<%-- EL 내에서 연산자 사용 가능 --%>
    옵션 : ${ empty param.option? "옵셔없음" : param.option}
</body>
</html>
