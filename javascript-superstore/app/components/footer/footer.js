(function() {
	"use strict";

	// Declare component
	angular.module('app').component('footer', {
		templateUrl: 'components/footer/footer.html',
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

			var date = new Date();
			vm.year = date.getFullYear();
		};
	}

})();
