(function() {
	"use strict";

	var config = {};

	// Javascripts
	config.js = [
		"node_modules/jquery/dist/jquery.js",
		"node_modules/angular/angular.js",
		"node_modules/angular-bootstrap/ui-bootstrap.js",
		"node_modules/angular-bootstrap/ui-bootstrap-tpls.js",
		"node_modules/angular-animate/angular-animate.js",
		"node_modules/angular-ui-router/release/angular-ui-router.js",
		"app/main.js",
		"app/views/**/*.js",
		"app/components/**/*.js"
	];

	module.exports = config;

})();