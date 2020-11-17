function reloj() {

	// Obtiene la fecha actual
	var fObj = new Date() ;
	// Obtiene la hora
	var horas = fObj.getHours() ;
	// Obtiene los minutos
	var minutos = fObj.getMinutes() ;
	// Obtiene los segundos
	var segundos = fObj.getSeconds() ;
	// Si es menor o igual a 9 le concatena un 0
	if (horas <= 9) horas = "0" + horas;
	// Si es menor o igual a 9 le concatena un 0
	if (minutos <= 9) minutos = "0" + minutos;
	// Si es menor o igual a 9 le concatena un 0
	if (segundos <= 9) segundos = "0" + segundos;
	// Asigna la hora actual a la caja de texto reloj
	document.forma.reloj.value = horas+":"+minutos+":"+segundos;
	
	// Cada segundo invoca a si mismo
	setTimeout("reloj()",1000);
	}

function f_mostrarFecha(){
	var obDat = new Date();
	var lib = obDat.getDate() + "/";
	lib += (obDat.getMonth() + 1) + "/";
	lib += obDat.getFullYear();

	document.forma.fecha.value = lib;
}

function f_abrirpopup(page, titulo ,ancho ,alto){
	window.open(page ,titulo ,'scrollbars=no ,width='+ancho+', height='+alto+'');
}

