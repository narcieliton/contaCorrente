package rest.resources;

import bean.ContaCorrenteBean;
import service.ContaCorrenteService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conta")
@RequestScoped
public class ContaCorrenteResource {

    @Inject
    private ContaCorrenteService ContaCorrenteService;

    @POST
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(Long id)  {
        ContaCorrenteBean bean = ContaCorrenteService.consultar(id);
        return Response.ok(bean).build();
    }

}