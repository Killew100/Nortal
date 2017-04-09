(function() {
	"use strict";

	// Declare component
	angular.module('app').component('navigation', {
		templateUrl: 'components/navigation/navigation.html',
		controller: ComponentCtrl,
		controllerAs: 'vm'
	});

	// Inject
	ComponentCtrl.$inject = ['$scope'];

	// Controller for navigation component
	function ComponentCtrl($scope) {
		var vm;

		this.$onInit = function() {
			vm = this;
		};
	}

})();