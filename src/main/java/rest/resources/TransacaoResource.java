package rest.resources;

import bean.ContaCorrenteBean;
import service.TransacaoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transacao")
@RequestScoped
public class TransacaoResource {

    @Inject
    private TransacaoService transacaoService;

    @POST
    @Path("/efetuarTransacao")
    @Produces(MediaType.APPLICATION_JSON)
    public Response efetuarTransacao(ContaCorrenteBean bean) throws Exception {
        try {
            return Response.ok(transacaoService.efetuarTransacao(bean)).build();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
