<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title></title>
      
    <style>
    body {
      font-family: Arial;
      font-size: 17px;
      padding: 8px;
      background-color: #ff5757!important;
    }
    * {
      box-sizing: border-box;
    }
    .row {
      display: -ms-flexbox; /* IE10 */
      display: flex;
      -ms-flex-wrap: wrap; /* IE10 */
      flex-wrap: wrap;
      margin: 0 -16px;
    }
    .col-25 {
      -ms-flex: 25%; /* IE10 */
      flex: 25%;
    }
    .col-50 {
      -ms-flex: 50%; /* IE10 */
      flex: 50%;
    }
    .col-75 {
      -ms-flex: 75%; /* IE10 */
      flex: 75%;
    }
    .col-25,
    .col-50,
    .col-75 {
      padding: 0 16px;
    }
    .container {
      background-color: #f2f2f2;
      padding: 5px 20px 15px 20px;
      border: 1px solid lightgrey;
      border-radius: 3px;
      width: 60%;
      margin: auto;
      margin-top: 5%;
    }
    input[type=text] {
      width: 100%;
      margin-bottom: 20px;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }
    label {
      margin-bottom: 10px;
      display: block;
    }
    .icon-container {
      margin-bottom: 20px;
      padding: 7px 0;
      font-size: 24px;
    }
    .btn {
      background-color: #04AA6D;
      color: white;
      padding: 12px;
      margin: 10px 0;
      border: none;
      width: 100%;
      border-radius: 3px;
      cursor: pointer;
      font-size: 17px;
    }
    .btn:hover {
      background-color: #45a049;
    }
    a {
      color: #2196F3;
    }
    hr {
      border: 1px solid lightgrey;
    }
    span.price {
      float: right;
      color: grey;
    }
    /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
    @media (max-width: 800px) {
      .row {
        flex-direction: column-reverse;
      }
      .col-25 {
        margin-bottom: 20px;
      }
    }
    </style>
  </head>
  <body>
    <div class="container">
    <h1>Elige tu horario de recogida</h1>
  <form action="AsignaHorario" method="get">
  
   
   
   	 <c:if test="${cliente.type == false}">
  	    <c:forEach items="${horariosDisp}" var="horarioDispi">   	 
   			<p><input type="radio" name="hora" value="${horarioDispi}" > ${horarioDispi} </p> 
   		</c:forEach>       		        
     </c:if>
     
     <c:if test="${cliente.type == true}">
     
	    <c:choose>
		    <c:when test="${horariosRec.size() == 0}">
				<h2>Lo sentimos, no hay horarios de recogida disponibles.</h2>
		    </c:when>    
		    <c:otherwise>
		   	    <c:forEach items="${horariosRec}" var="horarioReci"> 
		   		          <p><input type="radio" name="hora" value="${horarioReci}"> ${horarioReci} </p> 
		  		</c:forEach> 
		    </c:otherwise>
		</c:choose>
   
  		   		        
     </c:if>
  
    
   
   <input type="hidden" name="idComercio" value="${comercio.email}" />          	
   
   <input type="hidden" name="idCliente" value="${cliente.email}" />    
   
   <input type="hidden" name="listaProds" value="${listaProds}" />          	
         	
   
   <input type="submit" value="Finalizar" class="btn">
   
   
  </form>
    </div>
  </body>

  
  
</html>
 