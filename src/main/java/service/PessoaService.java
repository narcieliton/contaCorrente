package service;

import bean.PessoaBean;

public interface PessoaService {

   PessoaBean consultarCpf(String cpf);
   void salvar(PessoaBean pessoaBean);
}
