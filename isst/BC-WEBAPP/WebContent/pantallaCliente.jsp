<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<title>BarrioCovid</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="img/logo.PNG" type="image/PNG">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
<body>


<!--menu superior -->
<div class="w3-top">
  <div class="w3-bar w3-red w3-large ">
    <img src="https://i.pinimg.com/564x/0c/3b/3a/0c3b3adb1a7530892e55ef36d3be6cb8.jpg" class="w3-circle w3-bar-item w3-right" alt="usericon" style="width:100%;max-width:58px">

    <input type="text" class="w3-bar-item w3-input w3-right" placeholder="Buscar tienda">

  </div>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <img src="img/logo.PNG" width = 100%>
  </div>

  <div class="w3-bar-block">
    <div class="w3-panel w3-border w3-border-white ">
      <h1>Pedidos</h1>
      <button onclick="myFunction('Demo1')" class="w3-button w3-block w3-red w3-left-align">Pedido 1</button>
      <div id="Demo1" class="w3-hide w3-container">
        <p>Producto</p>
      </div>
      <button onclick="myFunction('Demo2')" class="w3-button w3-block w3-red w3-left-align">Pedido 2</button>
      <div id="Demo2" class="w3-hide w3-container">
        <p>Producto</p>
      </div>
    </div>
  </div>

  <div class="w3-panel w3-border w3-border-white">
    <div class="w3-bar-block">
      <h1>Recogidas</h1>
      <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-red w3-left-align">Recogida 1</button>
      <div id="Demo3" class="w3-hide w3-container">
        <p>Info recogida</p>
      </div>
      <button onclick="myFunction('Demo4')" class="w3-button w3-block w3-red w3-left-align">Recogida 2</button>
      <div id="Demo4" class="w3-hide w3-container">
        <p>Info recogida</p>
      </div>
    </div>
  </div>

</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span>Company Name</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">


 <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-xxxlarge"><b>BarrioCovid</b></h1>
  </div>



  <!-- Tiendas -->
  <div class="w3-container" id="designers" style="margin-top:40px">
    <h1 class="w3-xxlarge w3-text-red"><b>Tiendas</b></h1>
  </div>

  <!-- Lista Tiendas -->


<c:forEach items="${comercios}" var="comercioi">

  <div class="w3-row-padding w3-grayscale">
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="https://zaragozaguia.com/wp-content/uploads/2020/01/Homenaje-a-las-tiendas-chinas-de-barrio-de-Zaragoza-2.jpg" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="pantallaCliente2.jsp">${comercioi.shop_name} </a></h3>
          <p class="w3-opacity">Dirección</p>
          <p>INFO TIENDA</p>
        </div>
      </div>
    </div>
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="https://zaragozaguia.com/wp-content/uploads/2020/01/Homenaje-a-las-tiendas-chinas-de-barrio-de-Zaragoza-2.jpg" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="pantallaCliente2.html">TIENDA 2 </a></h3>
          <p class="w3-opacity">Dirección</p>
          <p>INFO TIENDA</p>
        </div>
      </div>
    </div>
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="https://zaragozaguia.com/wp-content/uploads/2020/01/Homenaje-a-las-tiendas-chinas-de-barrio-de-Zaragoza-2.jpg" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="pantallaCliente2.html">TIENDA 3 </a></h3>
          <p class="w3-opacity">Dirección</p>
          <p>INFO TIENDA</p>
        </div>
      </div>
    </div>
  </div>
</c:forEach>



<!-- End page content -->
</div>


<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}

function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className =
            x.previousElementSibling.className.replace("w3-red", "w3-red");
  } else {
    x.className = x.className.replace(" w3-show", "");
    x.previousElementSibling.className =
            x.previousElementSibling.className.replace("w3-red", "w3-red");
  }
}

</script>

</body>
</html>
