<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><style>
    html,body,h1,h2,h3,h4,h5 {font-family: "RobotoDraft", "Roboto", sans-serif;}
    .w3-bar-block .w3-bar-item{padding:16px}
</style>
<body>

    <!-- 왼쪽 메뉴 -->
    <nav class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card-2" style="z-index:3;width:320px;" id="mySidebar">

        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-border-bottom w3-large">
            Dynamic-mybatis<br/>
            ${Auth.userName}님 어서오세요.
        </a>
        <a href="javascript:void(0)" onclick="w3_close()" title="Close Sidemenu" class="w3-bar-item w3-button w3-hide-large w3-large">Close <i class="fa fa-remove"></i></a>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align" onclick="document.getElementById('id01').style.display='block'">New Message <i class="w3-padding fa fa-pencil"></i></a>
        <a id="myBtn" onclick="myFunc('Demo1')" href="javascript:void(0)" class="w3-bar-item w3-button"><i class="fa fa-inbox w3-margin-right"></i>메시지함 (${messages.size()})<i class="fa fa-caret-down w3-margin-left"></i></a>
        <!-- side 메뉴 리스트 -->
        <div id="Demo1" class="w3-hide w3-animate-left">
            <c:forEach var="message" items="${messages}" varStatus="status">
                <a href="javascript:void(0)"  id="firstTab" class="w3-bar-item w3-button w3-border-bottom test w3-hover-light-grey" onclick="openMail('message${status.index}');w3_close();">
                    <div class="w3-container">
                        <img class="w3-round w3-margin-right" src="/resources/kakao/muzi.jpg" style="width:15%;">
                        <span class="w3-opacity w3-large">${message.sender}</span>
                        <h6>제목: ${message.title}</h6>
                        <p>${message.summary}</p>
                    </div>
                </a>
            </c:forEach>
        </div>
    </nav>

    <!--  새로운 메시지 보내기 -->
    <div id="id01" class="w3-modal" style="z-index:4">
        <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-padding w3-red">
            <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-red w3-right w3-xxlarge"><i class="fa fa-remove"></i></span>
            <h2>메시지 보내기</h2>
        </div>
        <div class="w3-panel">
            <label>보내는사람</label>
            <input type="hidden" id="sender"      name="sender" value="${Auth.id}">
            <input class="w3-input w3-border w3-margin-bottom" type="text"  readonly ="readonly" value="${Auth.userName}">
            <label>받는사람</label>
            <select id="receiver" name="receiver" class="w3-input w3-border w3-margin-bottom">
            <c:forEach var="member" items="${members}">
                <option value="${member.id}">${member.userName}</option>
            </c:forEach>
            </select>
            <label>제목</label>
            <input class="w3-input w3-border w3-margin-bottom" type="text" id="title" name="title">
            <input class="w3-input w3-border w3-margin-bottom" style="height:150px" placeholder="What's on your mind?" id="message" name="message">
            <div class="w3-section">
                <a class="w3-button w3-red" onclick="document.getElementById('id01').style.display='none'">취소  <i class="fa fa-remove"></i></a>
                <a class="w3-button w3-light-grey w3-right" onclick="pushMessage();">보내기<i class="fa fa-paper-plane"></i></a>
            </div>
        </div>
    </div>
</div>

<!-- Overlay effect when opening the side navigation on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="Close Sidemenu" id="myOverlay"></div>

<!-- Page content -->
<div class="w3-main" style="margin-left:320px;">
    <i class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top" onclick="w3_open()"></i>
    <a href="javascript:void(0)" class="w3-hide-large w3-red w3-button w3-right w3-margin-top w3-margin-right" onclick="document.getElementById('id01').style.display='block'"><i class="fa fa-pencil"></i></a>

    <c:forEach var="message" items="${messages}" varStatus="status">
        <div id="message${status.index}" class="w3-container person">
            <br>
            <img class="w3-round  w3-animate-top" src="/resources/kakao/muzi.jpg" style="width:20%;">
            <h5 class="w3-opacity">제목: ${message.title}</h5>
            <h4><i class="fa fa-clock-o"></i> 보낸이 ${message.sender}, ${message.regDate}</h4>
            <hr>
            <p>${message.message}</p>
        </div>
    </c:forEach>



</div>

    <script src="/resources/js/jquery.js"></script>
    <script>
    var openInbox = document.getElementById("myBtn");
    openInbox.click();

    function w3_open() {
        document.getElementById("mySidebar").style.display = "block";
        document.getElementById("myOverlay").style.display = "block";
    }
    function w3_close() {
        document.getElementById("mySidebar").style.display = "none";
        document.getElementById("myOverlay").style.display = "none";
    }

    function myFunc(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
            x.previousElementSibling.className += " w3-red";
        } else {
            x.className = x.className.replace(" w3-show", "");
            x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-red", "");
        }
    }

    openMail("Borge")
    function openMail(personName) {
        var i;
        var x = document.getElementsByClassName("person");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x = document.getElementsByClassName("test");
        for (i = 0; i < x.length; i++) {
            x[i].className = x[i].className.replace(" w3-light-grey", "");
        }
        document.getElementById(personName).style.display = "block";
        event.currentTarget.className += " w3-light-grey";
    }

    function pushMessage() {

        var sender   = $('#sender').val();
        var receiver = $('#receiver').val();
        var title    = $('#title').val();
        var message  = $('#message').val();

        if(!message) {
            alert('메시지가 작성되지 않았습니다. 김덕주 사랑해라는 메시지로 대신 합니다.');
        }

        if(message) {
            message = $.trim(message);
        }

        $.ajax({
            url : '/board/message'
            , type : 'POST'
            , data : {sender:sender, receiver:receiver, message:message, title:title}
            , async : false
            //, dataType : 'json'
            , success : function(data) {
                location.reload();
            }
            ,error:function(request, status, error){
                return false;
            }
        });
    }
</script>

<script>
    var openTab = document.getElementById("firstTab");
    openTab.click();
</script>

</body>
</html>
