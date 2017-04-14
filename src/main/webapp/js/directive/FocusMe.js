/** Diretiva para focar em um campo atraves de um atributo	 **/
avaliacaoApp.directive('focusMe', function($timeout) {
	return {
		link: function(scope, element, attrs) {
			scope.$watch(attrs.focusMe, function(value) {
				if(value === true) { 
					element[0].focus();
					scope[attrs.focusMe] = false;
				}
			});
		}
	};
});
