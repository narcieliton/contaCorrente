package serviceImpl;

import bean.ContaCorrenteBean;
import entity.ContaCorrente;
import entity.Transacao;
import negocio.ContaCorrenteBO;
import service.ContaCorrenteService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    @Inject
    ContaCorrenteBO contaCorrenteBO;
    

    public ContaCorrenteBean consultar(Long id) {
        ContaCorrente conta = contaCorrenteBO.consultarPorId(id);
        
        ContaCorrenteBean contaCorrenteBean = new ContaCorrenteBean();

        contaCorrenteBean.setId(conta.getId());
        contaCorrenteBean.setSaldo(conta.getSaldoConta());
        contaCorrenteBean.setLimite(conta.getLimiteConta());            
        
        return contaCorrenteBean;
    }
}
