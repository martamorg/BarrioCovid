$(document).ready(function(){
$.ajax({
url: '/BC-SERVICE/rest/Clientes',
type: 'get',
dataType: 'JSON',
success: function(response){
var len = response.length;
for(var i=0; i<len; i++){
var email = response[i].email;
var location = response[i].location;
var password = response[i].password;
var type = response[i].type;
var tr_str = "<tr>" +
"<td align='center'>" + email + "</td>" +
"<td align='center'>" + location + "</td>" +
"<td align='center'>" + password + "</td>" +
"<td align='center'>" + type + "</td>" +
"</tr>";
$("#userTable tbody").append(tr_str);
}
}
});
});


$(document).ready(function(){
	$.ajax({
	url: '/BC-SERVICE/rest/Comercios',
	type: 'get',
	dataType: 'JSON',
	success: function(response){
	var len = response.length;
	for(var i=0; i<len; i++){
	var email = response[i].email;
	var location = response[i].location;
	var password = response[i].password;
	var tr_str = "<tr>" +
	"<td align='center'>" + email + "</td>" +
	"<td align='center'>" + location + "</td>" +
	"<td align='center'>" + password + "</td>" +
	"</tr>";
	$("#shopTable tbody").append(tr_str);
	}
	}
	});
	});

$(document).ready(function(){
	$.ajax({
	url: '/BC-SERVICE/rest/Pedidos',
	type: 'get',
	dataType: 'JSON',
	success: function(response){
	var len = response.length;
	for(var i=0; i<len; i++){
	var idPedido = response[i].idPedido;
	var horario = response[i].horario;
	var idCliente = response[i].idCliente;
	var idComercio = response[i].idComercio;
	var idRepartidor = response[i].idRepartidor;
	var listaProductos = response[i].listaProductos;

	var tr_str = "<tr>" +
	"<td align='center'>" + idPedido + "</td>" +
	"<td align='center'>" + horario + "</td>" +
	"<td align='center'>" + idCliente + "</td>" +
	"<td align='center'>" + idComercio + "</td>" +
	"<td align='center'>" + idRepartidor + "</td>" +
	"<td align='center'>" + listaProductos + "</td>" +

	"</tr>";
	$("#pedidoTable tbody").append(tr_str);
	}
	}
	});
	});
