'use strict';

sgcApp.factory('PessoaRepository', ['Restangular', 'AbstractRepository', function (restangular, AbstractRepository) {

        function PessoaRepository() {

            AbstractRepository.call(this, restangular, 'rest/pessoa');
            this.consultarCpf = function (cpf) {
                return restangular.one(this.route + '/consultarCpf').customGET(cpf);
            };

            this.salvar = function (formBean) {
                return restangular.all(this.route + '/salvar').post(formBean);
            };

        }

        AbstractRepository.extend(PessoaRepository);

        return new PessoaRepository();
    }]);