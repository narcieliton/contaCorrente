package service;

import bean.ContaCorrenteBean;

import javax.ws.rs.core.Response;

public interface TransacaoService {
   Response efetuarTransacao(ContaCorrenteBean bean) throws Exception;
}
