function MVVM() {
	this.cadena='';

	this.setCadena = function(cadenaNueva) {
		this.cadena = cadenaNueva;
	};

	this.getCadena = function() {
		return this.cadena;
	};
};


var VistaM = function(vm) {

	crearFormulario = function(contenedorPadre) {
		console.log("Empieza a crear la pagina.");
		var $formulario = $('<form></form>');
		$formulario.append('<article id="formCrear">');

		$formulario.append('<label>Texto de entrada: </label>');
		$formulario.append('<input type="text" id="tString" name="tString"/>');
		$formulario
				.append('<input type="button" id="bBoton" name="bBoton" value="Enviar" /></br>');
		$formulario.append('<label>Texto recibido directamente: </label>');
		$formulario
				.append('<input type="text" id="tDevuelto" name="tDevuelto" disabled/></br>');
		$formulario.append('<label>Texto recibido del modelo: </label>');
		$formulario
				.append('<input type="text" id="tMVVM" name="tMVVM" disabled/>');

		$formulario.append('</article>');
		$formulario.appendTo(contenedorPadre);

		$('#bBoton').click(VistaM.ejecuta);
	};

	vm.inicio = function() {
		console.log("Inicio");
		crearFormulario('#pagina');
		console.log("Creada la pagina pintada.");
	};

	
	getMVVM = function(){
		return new MVVM();
	};
	
	vm.ejecuta = function() {
		console.log("Entra a ejecutar el texto.");
		var texto = $('#tString').val();
		console.log("Leida la cadena: " + texto);
		$('#tDevuelto').val(texto);
		console.log("Ahora pasa a enviarselo al objeto modelo.");
		
		// PARTE CON EL OBJETO
		var modelovista = getMVVM();
		modelovista.setCadena(texto);
		console.log("Modelovista: "+modelovista.cadena);
		$('#tMVVM').val(modelovista.getCadena()); // Finalmente voy a mostrar el valor que hay almacenado en el MVVM
	};
	
	

	return vm;
}(VistaM || {});