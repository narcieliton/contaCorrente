'use strict';

sgcApp.controller('AppController', ['$scope', '$timeout', '$translate','toastr',
	function AppController($scope, $timeout, $translate,toastr ) {

		//###################### INICIO FUNCOES GENERICAS PARA MENSAGENS ######################
		$scope.controllerBodyElement = document.querySelector('body');

		//###################### INICIO FUNCOES GENERICAS PARA MENSAGENS ######################
		/**
		 * Metodo para mostrar mensagens para o usuario
		 *
		 * type: success|info|warning|error
		 * message: texto do toastr
		 * title: titulo do toastr
		 */
		$scope.showMessage = function (type, message, title) {

			$timeout(function () {
				if (toastr[type] !== undefined) {
					toastr[type](message, title);
				}
			}, 400);
		};
		/**
		 * Metodo para mostrar mensagem de obrigatoriedade de campos
		 */
		$scope.showMessageObrigatoriedade = function() {
			$scope.limparMensagemTela();
			var message = $translate.instant('VALIDACAO.MENSAGEM_M002');
			if (message && message !== ""){
				$scope.showMessage('error', message);
			} else {
				console.log("texto da mensagem de campos obrigatorios nao configurada");
			}
		};

		/**
		 * Metodo para mostrar mensagem de campos invalidos
		 */
		$scope.showMessageErrorCampoInvalido = function(campo) {
			$scope.limparMensagemTela();
			var message = campo;
			message += " ".concat($translate.instant('VALIDACAO.MENSAGEM_M004'))
				.concat($translate.instant('VALIDACAO.MENSAGEM_M004_PROCEDIMENTO')).concat(campo)
				.concat($translate.instant('VALIDACAO.MENSAGEM_M004_CAMPOS'));
			if (message && message !== ""){
				$scope.showMessage('error', message);
			} else {
				console.log("texto da mensagem de campos invalidos nao configurada");
			}
		};

		/**
		 * Metodo para mostrar mensagem de campos invalidos
		 */
		$scope.showMessageError = function(dataError) {
			$scope.limparMensagemTela();
			var message = (dataError) ? dataError : $translate.instant('MSG.MENSAGEM_ERROR');
			if (message && message !== ""){
				$scope.showMessage('error', message);
			} else {
				console.log("texto da mensagem de erros genericos nao configurada");
			}
		};

		/**
		 * Metodo para mostrar mensagem de sucesso das operacoes
		 */
		$scope.showMessageSucess = function (){
			$scope.limparMensagemTela();
			var message = $translate.instant('MSG.MENSAGEM_M001');
			if (message && message !== ""){
				$scope.showMessage('success', message);
			} else {
				console.log("texto da mensagem de sucesso nao configurada");
			}
		};

		/**
		 * Metodo para mostrar mensagem de alerta
		 */
		$scope.showMessageAlert = function(dataAlert){
			console.log(dataAlert);
			$scope.limparMensagemTela();
			var message = angular.copy(dataAlert);
			if (message && message !== ""){
				$scope.showMessage('warning', message);
			} else {
				console.log("texto da mensagem de alerta nao configurado");
			}
		};
		/**
		 * Metodo para mostrar mensagem de exception tratada
		 */
		$scope.showMessageTreatedExcept = function (exception) {
			toastr.error($translate.instant(exception.message) + (exception.msgComplemento ? exception.msgComplemento : ''), null);
		};

		/**
		 * Metodo para mostrar mensagem de exception nao tratada unhandled
		 */
		$scope.showMessageUnhandledExcept = function (exception) {
			var messageException = null;
			if (exception.ex && exception.ex.message) {
				messageException = exception.ex.message;
			} else if (exception.ex && !exception.ex.message && exception.ex.localizedMessage) {
				messageException = exception.ex.localizedMessage;
			}
			toastr.error($translate.instant(messageException ? messageException : 'MSG.MENSAGEM_ERROR'), $translate.instant('MSG.TITULO_EXCECAO_NAO_TRATADA'));
		};

		/**
		 * Metodo para remover growl quando presente na tela
		 */
		$scope.limparMensagemTela = function () {
			toastr.clear();
		};
		//###################### FIM FUNCOES GENERICAS PARA MENSAGENS ######################

	}]);