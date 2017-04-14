'use strict';

sgcApp.factory('ContaCorrenteRepository', ['Restangular', 'AbstractRepository', function (restangular, AbstractRepository) {

        function ContaCorrenteRepository() {

            AbstractRepository.call(this, restangular, 'rest/conta');

            this.efetuarTransacao = function (bean) {
                return restangular.all('rest/transacao/efetuarTransacao').post(bean);
            };

            this.consultarContaPorId = function (id) {
                return restangular.one(this.route + '/consultarContaPorId').post(id);
            }

        }

        AbstractRepository.extend(ContaCorrenteRepository);

        return new ContaCorrenteRepository();
    }]);