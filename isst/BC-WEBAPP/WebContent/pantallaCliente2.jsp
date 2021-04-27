<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html>
<html lang="en">
<title>BarrioCovid</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="img/logo.png" type="image/PNG">
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

	<form action="FormLogout">
    <button type="submit" class="w3-bar-item w3-input w3-right">Logout</button>
    </form>
  </div>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <a class="imagen" href="pantallaCliente.jsp">
      <img src="img/logo.png" width = 100%>
    </a>
  </div>

  <div class="w3-bar-block">
    <div class="w3-panel w3-border w3-border-white ">
      <h1>Pedidos</h1>
      
      <c:forEach items="${pedidos}" var="pedidoi">
	  <c:if test="${pedidoi.idCliente.equals(cliente.email)}">
      
      <button onclick="myFunction('${pedidoi.idPedido}')" class="w3-button w3-block w3-red w3-left-align">Pedido id: ${pedidoi.idPedido}</button>
      <div id="${pedidoi.idPedido}" class="w3-hide w3-container">
        <p>Pedido: ${pedidoi.listaProductos}</p>
        <p>Recogida: ${pedidoi.horario}</p>
        
        
        <c:forEach items="${comercios}" var="comercioi">
	        <c:if test="${pedidoi.idComercio.equals(comercioi.email)}">
	        	<p>Comprado en: ${comercioi.shop_name}</p>
	        	<p>Ubicación: ${comercioi.location}</p>	
	        	<p>Teléfono del comercio: ${comercioi.phone}</p>	        	
	        	        	
	        </c:if>
	    </c:forEach>      
	    
	    <c:if test= "${cliente.type == true}">         
		    <c:forEach items="${clientes}" var="clientej">	        
		        <c:if test="${pedidoi.idRepartidor.equals(clientej.email)}">
		        	<p>Mi repartidor: ${clientej.client_name}</p>
		        	<p>email de contacto: ${clientej.email}</p>        	
		        </c:if>
			</c:forEach>
		</c:if>
        	
      </div>
      
      </c:if>
	  </c:forEach>
      
    </div>
  </div>
  



	  <c:if test="${cliente.type == false}">


  <div class="w3-panel w3-border w3-border-white">
    <div class="w3-bar-block">
      <h1>Recogidas</h1>
      
      <c:forEach items="${pedidos}" var="pedidoi">
	  <c:if test="${pedidoi.idRepartidor.equals(cliente.email)}">
      
      <button onclick="myFunction('${pedidoi.idPedido}')" class="w3-button w3-block w3-red w3-left-align">Recogida id: ${pedidoi.idPedido}</button>
      <div id="${pedidoi.idPedido}" class="w3-hide w3-container">
        <p>Info recogida</p>
        <p>Horario recogida: ${pedidoi.horario}</p>
        
        <c:forEach items="${comercios}" var="comercioi">
	        <c:if test="${pedidoi.idComercio.equals(comercioi.email)}">
	        	<p>Comprado en: ${comercioi.shop_name}</p>
	        	<p>Ubicación comercio: ${comercioi.location}</p>
	        	<p>Teléfono del comercio: ${comercioi.phone}</p>	        		        		        	
	        </c:if>
	    </c:forEach>
	    
	    <c:forEach items="${clientes}" var="clientej">	        
		      <c:if test="${pedidoi.idCliente.equals(clientej.email)}">
		        <p>Repartir a: ${clientej.client_name}</p>
		        <p>Email de contacto: ${clientej.email}</p>     
		        <p>Dirección de entrega: ${clientej.location}</p>        			           	
		      </c:if>
		</c:forEach>
        
      </div>
      
      </c:if>  
      </c:forEach>  
      
    </div>
  </div> 
  
  
	  </c:if>


</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span></span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">


 <!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-xxxlarge"><b> ${comercio.shop_name} </b></h1>
    
  </div>



  <!-- Tiendas -->
  <div class="w3-container" id="designers" style="margin-top:40px">
    <h1 class="w3-xxlarge w3-text-red"><b>Productos</b></h1>
  </div>

  <!-- Lista Tiendas -->
  <div class="w3-row-padding w3-grayscale">
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="img\manzana.png" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="#">PRODUCTO 1 </a></h3>
          <h3>
            <p>INFO PRODUCTO</p>
            <button href="" class= "boton2">Añadir al carrito</button>
          </h3>
          
        </div>
      </div>
    </div>
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="img\melon.jpg" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="#">PRODUCTO 2 </a></h3>
          <h3>
            <p>INFO PRODUCTO</p>
            <button href="" class= "boton2">Añadir al carrito</button>
          </h3>
        </div>
      </div>
    </div>
    <div class="w3-row m4 w3-margin-bottom">
      <div class="w3-light-grey w3-container">
        <div class="w3-quarter">
          <img src="img\banana.jpg" alt="Tienda 1" style="width:100%">
        </div>
        <div class="w3-container w3-threequarter">
          <h3><a href="#">PRODUCTO 3 </a></h3>
          <h3>
            <p>INFO PRODUCTO</p>
            <button href="" class= "boton2">Añadir al carrito</button>
          </h3>
        </div>
      </div>
    </div>
  </div>



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
