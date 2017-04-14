"use strict";

var appDependencies = [
	'ui.mask',
	'ui.bootstrap',
	'ngAnimate',
	'ngTouch',
	'ngResource',
	'ngSanitize',
	'blockUI',
	'toastr',
	'ui.router',
	'pascalprecht.translate',
	'idf.br-filters',
	'ui.utils.masks',
	'restangular'

];

var sgcApp = angular.module("app", appDependencies);

sgcApp.config(function($translateProvider, $translatePartialLoaderProvider, $stateProvider, $urlRouterProvider, $locationProvider,
					   $httpProvider, blockUIConfig, RestangularProvider, toastrConfig) {

	//###################### INICIO DA CONFIGURACAO DO BLOQUEIO DA INTERFACE ######################
	blockUIConfig.message = 'Carregando ...';
	blockUIConfig.delay = 100;
	//###################### FIM DA CONFIGURACAO DO BLOQUEIO DA INTERFACE ######################


	//###################### INICIO DA CONFIGURACAO DAS MENSAGENS ######################
	angular.extend(toastrConfig, {
		allowHtml: false,
		closeButton: true,
		closeHtml: '<button>&times;</button>',
		extendedTimeOut: 1000,
		iconClasses: {
			error: 'toast-error',
			info: 'toast-info',
			success: 'toast-success',
			warning: 'toast-warning'
		},
		messageClass: 'toast-message',
		onHidden: null,
		onShown: null,
		onTap: null,
		progressBar: true,
		tapToDismiss: false,
		timeOut: 10000,
		titleClass: 'toast-title',
		toastClass: 'toast',
		preventDuplicates: false,
		preventOpenDuplicates: true,
		maxOpened: 0
	});
	//###################### FIM DA DA CONFIGURACAO DAS MENSAGENS ######################

	//###################### INICIO DA DEFINICAO DO PADRAO DE ANGULAR-TRANSLATE ######################
	$translatePartialLoaderProvider.addPart('portal');
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate: 'i18n/{lang}/{part}.json'
	});
	// portal.json precisa estar no diretorio i18n/pt_BR/portal.json
	$translateProvider.preferredLanguage('pt_BR');
	// habilita o escaping do HTML
	$translateProvider.useSanitizeValueStrategy('escape');
	//###################### FINAL DA DEFINICAO DO PADRAO DE ANGULAR-TRANSLATE #######################

	//###################### INICIO DA DEFINICAO DO PADRAO DAS ROTAS ACESSAVEIS ######################
	$urlRouterProvider.otherwise("/inicial");
	$stateProvider
		.state('inicial', {
			url: "/inicial",
			templateUrl: "/sgc/pages/contaCorrente.html",
			controller: 'ContaCorrenteController'
		});
	//################## INICIO DA CONFIGURAÇÃO DE URL BASE, INTERCEPTOR DE REQUESTS VIA RESTANGULAR ##################
	RestangularProvider.setBaseUrl('/sgc');
	//################## FIM DA CONFIGURAÇÃO DE URL BASE, INTERCEPTOR DE REQUESTS VIA RESTANGULAR ##################

});
