(function() {
	"use strict";

	angular.module('app.history', ['ui.router'])

	/* Route
	/*------------------------------------------------*/

	.config(['$stateProvider', function($stateProvider) {
		// Parent state
		$stateProvider.state('default.history', {
			url: '/history',
			views: {
				"main@default": {
					templateUrl: './views/history/history.html',
					controller: ViewCtrl,
					controllerAs: 'vm'
				}
			},
			data: {
				title: 'Superstore | history'
			}
		});

	}]);

	// Inject
	ViewCtrl.$inject = ['$scope'];

	// Controller for navigation component
	function ViewCtrl($scope) {
		var vm;

		// Controller on init
		this.$onInit = function() {
			vm = this;

		};

		// Controller on destroy
		this.$onDestroy = function() {
			// Unbind rootscope listeners
		};

	}

})();