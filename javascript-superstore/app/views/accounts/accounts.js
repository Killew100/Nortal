(function() {
	"use strict";

	angular.module('app.accounts', ['ui.router'])

	/* Route
	/*------------------------------------------------*/

	.config(['$stateProvider', function($stateProvider) {
		// Parent state
		$stateProvider.state('default.accounts', {
			url: '/accounts',
			views: {
				"main@default": {
					templateUrl: './views/accounts/accounts.html',
					controller: ViewCtrl,
					controllerAs: 'vm'
				}
			},
			data: {
				title: 'Superstor | Accounts',
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
            $.getJSON('https://reqres.in/api/users?per_page=100', function(data) {
            	vm.total = data["total"]
                vm.rows = data["data"];
                vm.page = 0;
                $scope.$apply();
            });
			vm.add = add;
		};

		// Controller on destroy
		this.$onDestroy = function() {
			// Unbind rootscope listeners
		};


		// Functions

		/**
		 *	Function that adds to a table
		 */
		function add() {
			vm.rows.push({
				id: vm.id,
				first_name: vm.first_name,
                last_name: vm.last_name,
                avatar: vm.avatar
			});
			vm.id = undefined;
			vm.first_name = undefined;
			vm.last_name = undefined;
			vm.avatar = undefined;
		}
	}

})();
