<%@ page import="com.example.food.entity.Food" %><%
    request.setCharacterEncoding("utf-8");
    Food food = (Food) request.getAttribute("food");
%>
<!DOCTYPE html>
<head>
    <jsp:include page="/admin/include/header.jsp">
        <jsp:param name="title" value="<%= food.getName()%>"/>
        <jsp:param name="description" value="Food detail"/>
        <jsp:param name="keywords" value="admin, page...."/>
    </jsp:include>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Admin Page</span>
</div>
<jsp:include page="/admin/include/left-menu.jsp"/>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> Food form</b></h5>
    </header>

    <div class="w3-padding w3-margin-bottom">
        <div class="w3-margin">
            <label>Id</label>
            <p><%= food.getId()%></p>
        </div>
        <div class="w3-margin">
            <label>Name</label>
            <p><%= food.getName()%></p>
        </div>
        <div class="w3-margin">
            <label>Idname</label>
            <p><%= food.getIdname()%></p>
        </div>
        <div class="w3-margin">
            <label>Description</label>
            <p><%= food.getDescription()%></p>
        </div>
        <div class="w3-margin">
            <label>Thumbnail</label>
            <img src="<%= food.getThumbnail()%>" alt="<%= food.getName()%>" width="200px">
        </div>
        <div class="w3-margin">
            <label>Price</label>
            <p><%= food.getPrice()%></p>
        </div>
        <div class="w3-margin">
            <label>Selldate</label>
            <p><%= food.getSelldate()%></p>
        </div>
        <div class="w3-margin">
            <label>Editdate</label>
            <p><%= food.getEditdate()%></p>
        </div>
        <div class="w3-margin">
            <label>Status</label>
            <p><%= food.getStatus()%></p>
        </div>
    </div>
    <hr>
    <!-- Footer -->
    <jsp:include page="/admin/include/footer.jsp"/>
    <!-- End page content -->
</div>

<jsp:include page="/admin/include/script.jsp"/>

</body>
</html>