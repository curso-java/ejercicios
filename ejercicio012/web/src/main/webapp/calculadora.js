/**
 * 
 */
function suma(a, b) {
	var c = a + b;
	return c;
}

var MODULE = (function (my) {
	var privateVariable = 1;

	function privateMethod() {
		// ...
	}

	my.moduleProperty = 1;
	my.moduleMethod = function () {
		return privateVariable;
	};

	return my;
}(MODULE || {}));

var MODULE = (function (my) {
	my.anotherMethod = function () {
		// added method...
	};

	return my;
}(MODULE || {}));