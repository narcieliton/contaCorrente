package rest.resources;

import bean.PessoaBean;
import service.PessoaService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoa")
@RequestScoped
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @GET
    @Path("/consultarCpf/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarCpf(@PathParam("cpf") String cpf) {

     PessoaBean bean = pessoaService.consultarCpf(cpf);

        return Response.ok(bean).build();
    }

    @POST
    @Path("/salvar")
    @Produces(MediaType.APPLICATION_JSON)
    public void consultarParticipantePorCpf(PessoaBean pessoaBean)  {
        pessoaService.salvar(pessoaBean);

    }


}