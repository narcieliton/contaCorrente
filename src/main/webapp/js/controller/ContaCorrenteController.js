'use strict';

sgcApp.controller("ContaCorrenteController", ['$scope', 'blockUI', '$filter', '$rootScope', '$translate', 'PessoaService','ContaCorrenteService',
    function ContaCorrenteController($scope, blockUI, $filter, $rootScope, $translate, pessoaService, contaCorrenteService) {

        $scope.$watch('formCadastro', function (theForm) {
            if (theForm) {
                $scope.formCadastro.$submitted = false;
                $scope.formCadastro.$setPristine();
            }
        });

        $scope.consultar = function (cpf){
            $scope.limparMensagemTela();
            if($scope.formCadastro.cpf.$viewValue){
                if (!$scope.bean.cliente.cpf) {
                    $scope.showMessageErrorCampoInvalido("cpf");
                    $scope.formCadastro.cpf.$viewValue ="";
                    $scope.formCadastro.cpf.$modelValue = "";
                    goFocus("cpf");
                    return;
                }
                pessoaService.consultarCpf(cpf).then(function(response) {
                    onConsultar(response);
                }, function errorCallback(response){
                    console.log(angular.toJson(response));
                    $scope.showMessageError($translate.instant('MSG.DESCULPE_SERVICO_NAO_PODE_SER_REALIZADO_TENTE_NOVAMENTE'));
                });
            }
        };

        var onConsultar = function (result) {
            $scope.limparMensagemTela();
            if(result){
                $scope.bean.cliente = result.plain();
                if($scope.bean.cliente.nome){
                    $scope.contaCorrenteBean = $scope.bean.cliente.contaCorrenteBean;
                    $scope.etapa = '3';
                }
                else {
                    $scope.etapa = '2';
                }
            }
            else {
                $scope.showMessageError($translate.instant('MSG.DESCULPE_SERVICO_NAO_PODE_SER_REALIZADO_TENTE_NOVAMENTE'));
            }
        };

        $scope.salvar = function (){
            $scope.limparMensagemTela();
            if(validarCampos()) {
                pessoaService.salvar($scope.bean.cliente).then(function (response) {
                    onSalvar(response);
                }, function errorCallback(response) {
                    console.log(angular.toJson(response));
                    $scope.showMessageError($translate.instant('MSG.DESCULPE_SERVICO_NAO_PODE_SER_REALIZADO_TENTE_NOVAMENTE'));
                });
            }
        };

        var onSalvar = function (result) {
            $scope.limparMensagemTela();
            if(result){

            }
            else {
                $scope.showMessageSucess();
                $scope.consultar($scope.bean.cliente.cpf);
                $scope.etapa = '3';
            }
        };

        function validarCampos() {
            var valido = false;

            if(!$scope.bean.cliente.cpf){
                $scope.showMessageObrigatoriedade();
                goFocus('cpf');
                valido = false;
                return;
            }
            else if(!$scope.bean.cliente.nome){
                $scope.showMessageObrigatoriedade();
                goFocus('nome');
                valido = false;
                return;
            }
            else if(!$scope.bean.cliente.dataNascimento){
                $scope.showMessageObrigatoriedade();
                goFocus('dataNascimento');
                valido = false;
                return;
            }
            else if(!$scope.bean.cliente.email){
                $scope.showMessageObrigatoriedade();
                goFocus('email');
                valido = false;
                return;
            }
            else if(!$scope.bean.cliente.telefone){
                $scope.showMessageObrigatoriedade();
                goFocus('telefone');
                valido = false;
                return;
            }
            else if(!$scope.bean.cliente.endereco){
                $scope.showMessageObrigatoriedade();
                goFocus('endereco');
                valido = false;
                return;
            }
            else{
                valido = true;
                $scope.formCadastro.$submitted = true;
            }
            return valido;
        }

        $scope.efetuarTransacao = function (){
            $scope.limparMensagemTela();
            if($scope.contaCorrenteBean.valor){
                contaCorrenteService.efetuarTransacao($scope.contaCorrenteBean).then(function (response) {
                    onEfetuarTransacao(response);
                }, function errorCallback(response) {
                    $scope.showMessageError($translate.instant('MSG.SALDO_INSUFICIENTE'));
                });
            }
            else if($scope.bean.beanDestinatarioTransferencia.cpf) {
                if($scope.contaCorrenteDestinatarioTransferenciaBean.valor){
                    $scope.contaCorrenteBean.idDestinatarioTransferencia = $scope.contaCorrenteDestinatarioTransferenciaBean.id;
                    $scope.contaCorrenteBean.valor = $scope.contaCorrenteDestinatarioTransferenciaBean.valor;
                    contaCorrenteService.efetuarTransacao($scope.contaCorrenteBean).then(function (response) {
                        onEfetuarTransacaoTransferencia(response);
                    }, function errorCallback(response) {
                        $scope.showMessageError($translate.instant('MSG.SALDO_INSUFICIENTE'));
                    });
                }
            }
        };

        var onEfetuarTransacao = function (result) {
            $scope.limparMensagemTela();
            if(result){

            }
            else {
                $scope.consultar($scope.bean.cliente.cpf);
            }
        };
        var onEfetuarTransacaoTransferencia = function (result) {
            $scope.limparMensagemTela();
            if(result){

            }
            else {
                $scope.consultar($scope.bean.cliente.cpf);
                $scope.bean.beanDestinatarioTransferencia = {};
            }
        };


        $scope.consultarDestinatarioTransferencia  = function (cpf){
            $scope.limparMensagemTela();
            if (!cpf) {
                $scope.showMessageErrorCampoInvalido("cpfDestinatarioTransferencia");
                goFocus("cpfDestinatarioTransferencia");
                return;
            }
            else if(cpf !== $scope.bean.cliente.cpf) {
                pessoaService.consultarCpf(cpf).then(function (response) {
                    onConsultarDestinatarioTransferencia(response);
                }, function errorCallback(response) {
                    console.log(angular.toJson(response));
                    $scope.showMessageError($translate.instant('MSG.DESCULPE_SERVICO_NAO_PODE_SER_REALIZADO_TENTE_NOVAMENTE'));
                });
            }else {
                $scope.showMessageAlert($translate.instant('MSG.CLIENTE_NAO_PODE_SER_O_MESMO_DA_TRANSFERENCIA'));
                goFocus('cpfDestinatarioTransferencia');
            }
        };

        var onConsultarDestinatarioTransferencia = function (result) {
            $scope.limparMensagemTela();
            if(result){
                $scope.bean.beanDestinatarioTransferencia = result.plain();
                if ($scope.bean.beanDestinatarioTransferencia.nome != null) {
                    $scope.contaCorrenteDestinatarioTransferenciaBean = $scope.bean.beanDestinatarioTransferencia.contaCorrenteBean;
                }
                else {
                    $scope.showMessageAlert($translate.instant('MSG.CLIENTE_NAO_ENCONTRADO_VERIFICAR_CPF'));
                }
            }
        };

        $scope.sair = function(){
            $scope.limpar();
            $scope.etapa = '1';
            $scope.formCadastro.$submitted = false;
            $scope.formCadastro.$setPristine();
        };

        $scope.cadastrar = function () {
            $scope.etapa = '2';
        };

        $scope.listaTipoTransacao = [
            {id: 1, descricao: "Depósito"},
            {id: 2, descricao: "Saque"},
            {id: 3, descricao: "Transferência"}
        ];

        $scope.limpar = function () {

            $scope.bean = {};
            $scope.bean.cliente = {
                cpf: null,
                nome: null,
                email: null,
                telefone: null,
                endereco: null,
                dataNascimento: null,
                idPessoa: null,
                idConta: null
            };
            $scope.bean.beanDestinatarioTransferencia = {};

            $scope.contaCorrenteBean = {};
            $scope.contaCorrenteDestinatarioTransferenciaBean = {};

            $scope.etapa = '1';
        };

        function iniciar() {
            $scope.limpar();
            $scope.etapa = '1';
        }
        iniciar();
    }]);
