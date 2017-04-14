'use strict';

sgcApp.service('PessoaService', ['PessoaRepository', function (repository) {
    return {
        consultarCpf: function (cpf) {
            return repository.consultarCpf(cpf);
        },
        salvar: function (pessoa) {
            return repository.salvar(pessoa);
        }
    }
    }]);