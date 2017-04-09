(function() {
	"use strict";

	angular.module('app.settings', ['ui.router'])

	/* Route
	/*------------------------------------------------*/

	.config(['$stateProvider', function($stateProvider) {
		// Parent state
		$stateProvider.state('default.settings', {
			url: '/settings',
			views: {
				"main@default": {
					templateUrl: './views/settings/settings.html',
					controller: ViewCtrl,
					controllerAs: 'vm'
				}
			},
			data: {
				title: 'Superstor | settings',
				scrollable: true
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

			vm.page = 0;
			vm.rows = [
				{name: 'Milk', price: 1.99, date: '01.01.2017 12:55', store: 'Downtown store'},
				{name: 'White bread', price: 2, date: '01.01.2017 12:55', store: 'Ülemiste store'},
				{name: 'Bread', price: 3, date: '01.01.2017 12:55', store: 'Lasnamäe store'},
				{name: 'Beer', price: 4, date: '01.01.2017 12:55', store: 'Nõmme store'},
				{name: 'Wine', price: 3.25, date: '01.01.2017 12:55', store: 'Mustamäe store'},
				{name: 'Water', price: 1.99, date: '01.01.2017 12:55', store: 'Downtown store'},
				{name: 'White bread', price: 2, date: '01.01.2017 12:55', store: 'Ülemiste store'},
				{name: 'Bread', price: 5, date: '01.01.2017 12:55', store: 'Lasnamäe store'},
				{name: 'Flour', price: 1.8, date: '01.01.2017 12:55', store: 'Lasnamäe store'},
				{name: 'Minced meat', price: 3.25, date: '01.01.2017 12:55', store: 'Mustamäe store'},
				{name: 'Kefir', price: 1.99, date: '01.01.2017 12:55', store: 'Nõmme store'},
				{name: 'Onion', price: 2, date: '01.01.2017 12:55', store: 'Ülemiste store'},
				{name: 'Rice', price: 2.3, date: '01.01.2017 12:55', store: 'Lasnamäe store'},
				{name: 'Buckwheat', price: 1.65, date: '01.01.2017 12:55', store: 'Nõmme store'},
				{name: 'Groats', price: 2.25, date: '01.01.2017 12:55', store: 'Mustamäe store'}
			];
		};

		// Controller on destroy
		this.$onDestroy = function() {
			// Unbind rootscope listeners
		};
	}

})();