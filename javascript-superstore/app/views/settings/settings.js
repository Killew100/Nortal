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

        };

        // Controller on destroy
        this.$onDestroy = function() {
            // Unbind rootscope listeners
        };

    }

})();