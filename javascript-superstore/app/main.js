(function() {
	"use strict";

	angular.module('app', [
		'ui.router',
		'ui.bootstrap',
		'ngAnimate',
		'app.accounts',
		'app.history',
		'app.settings'
	])

	/* Router config
	/*------------------------------------------------*/
	.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider) {

		// Default / fallback route - called when no other route found
		$urlRouterProvider.otherwise('/accounts');

		// Assign template layouts to state groups
		$stateProvider.state('default', {
			abstract: true,
			templateUrl: 'layouts/default.html'
		});
	}])

	/* State changes
	/*------------------------------------------------*/
	.run(['$rootScope', '$http', '$location', '$window', function($rootScope, $http, $location, $window) {

		$http.get('/please-dont-fail.js').then(function() {
			// Meant to throw an error
		});

		/**
		 *	State change start - to jump with back button
		 */
		$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
			if (toState.name === 'default.settings') {
				$location.path('/settings').replace();
			}
		});

		/**
		 *	Do after successful state change
		 */
		$rootScope.$on('$stateChangeSuccess', function(event, current, previous) {
			// Window title
			window.document.title = current.data.title;
			$rootScope.scrollable = current.data.scrollable;
		});
	}]);


})();
