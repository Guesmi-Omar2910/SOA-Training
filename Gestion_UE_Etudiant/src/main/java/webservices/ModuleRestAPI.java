package webservices;
import entities.UniteEnseignement;
import metiers.ModuleBusiness;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("md")
public class ModuleRestAPI {
    ModuleBusiness helper = new ModuleBusiness();
    @Path("/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUEs() {
        return Response.status(200).entity(helper.getAllModules()).build();
    }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(ModuleBusiness module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();

        } else {
            return Response.status(400).entity("error").build();
        }
    }
    @Path("/{inputCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUeByCode(@PathParam("inputCode") String mat) {
        // return Response.status(200).entity(helper.getUEByCode(code)).build();
        return Response.ok(helper.getModuleByMatricule(mat)).build();//alternative

    }
}
