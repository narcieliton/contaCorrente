'use strict';

sgcApp.service('ContaCorrenteService', ['ContaCorrenteRepository', function (repository) {
        return {
            efetuarTransacao: function (bean) {
                return repository.efetuarTransacao(bean);
            },
            consultarContaPorId: function (id) {
                return repository.consultarContaPorId(id);
            }
        }
    }]);