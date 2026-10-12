package webservices;

import entities.Module;
import metiers.ModuleBusiness;


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
    public Response createUe(Module module) {
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
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModulebyMat(@QueryParam("Mat") String Mat) {
        return Response.ok(helper.getModuleByMatricule(Mat)).build();
    }
    @Path("/delte/{deletemat}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delteByMat(@PathParam("deletemat") String deltemat) {
        if (helper.deleteModule(deltemat)) {
            return Response.status(201).entity("supprimer avec succee").build();
        } else {
            return Response.status(400).entity("erreur lor de supression").build();
        }
    }
}
