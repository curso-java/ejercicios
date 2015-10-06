var n = 0;

// Controladores individuales de los hijos
var H = function(hijo) {
	var cadena = "";

	H.crearHijo = function() {

	};
};

// Función que hace de controlador de controladores
var P = function(padre) {

	var lista = []; // Lista general de hijos (a posteriori)

	crearFormulario = function(contenedorPadre) { // Esta función genera el
		// menú inicial.
		console.log("Empieza a crear la pagina.");
		var $formulario = $('<form></form>');
		$formulario.append('<article id="formCrear">');

		$formulario.append('<label>Botones principales: </label><br/>');
		$formulario
				.append('<input type="button" id="bCrear" name="bCrear" value="Crear" />');
		$formulario
				.append('<input type="button" id="bCerrar" name="bCerrar" value="Cerrar" /></br>');
		$formulario.append('</article>');
		$formulario.appendTo(contenedorPadre);

		$('#bCrear').click(P.Crear);
		$('#bCerrar').click(P.CerrarTodos);
	};

	actualizarHijos = function(contenedorHijo) {
		var i = 0;
		for (i = 0; i < lista.lenght; i++) {
			hijoAdd = lista.pop();
		}
		;
	};

	actualizaVistaHijos = function() {

	};

	padre.inicio = function() { // Arranca el formulario padre
		console.log("Inicio");
		crearFormulario('#padre');
		console.log("Creada la pagina pintada.");
	};

	padre.Crear = function() {
		console.log("Creado el hijo " + lista.length);

		// Crea un hijo y un botón a pelo y los añade en el div del hijo.
		$hijo = $('<span class = "hijo"></span>');
		$botonCerrar = $('<input type="button" id="bCerrar" name="bCerrar" value="Cerrar" />');
		$hijo.append($botonCerrar);
		if (n % 5 == 1 && n != 1) {
			$hijo.append("<br>");
		}
		;

		$botonCerrar.click(P.bCerrarHijo);

		lista.push($hijo);
		actualizaVistaHijos();

		$('#hijos').append($hijo); // Mete el hijo creado al contenedor de
		// hijos.
		n++;
	};

	padre.CerrarTodos = function() { // Función para una segunda versión con
		// hijos.
		console.log("Entro a eliminar el hijo");
		console.log("Hay: " + lista.length + " hijos inicialmente.");
		lista.splice(0, lista.length);
		console.log("Han quedado: " + lista.length);

		$('#hijos').html(''); // Dejo vacio el div
	};

	getHijo = function() { // Función auxiliar para obtener hijos.
		return new hijo();
	};

	padre.bCerrarHijo = function() { // Controlador del botón de cada hijo.
		$(this).parent().remove();
	};

	return padre;
}(P || {});

$(document).ready(function() {
	P.inicio();
});