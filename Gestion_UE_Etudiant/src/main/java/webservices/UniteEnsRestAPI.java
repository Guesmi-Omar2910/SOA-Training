package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestAPI {
    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @Path("/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUEs() {
        return Response.status(200).entity(helper.getListeUE()).build();
    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(UniteEnseignement unite) {
        if (helper.addUniteEnseignement(unite)) {
            return Response.status(201).entity("ok").build();

        } else {
            return Response.status(400).entity("error").build();
        }
    }

    @Path("/{inputCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUeByCode(@PathParam("inputCode") int code) {
        // return Response.status(200).entity(helper.getUEByCode(code)).build();
        return Response.ok(helper.getUEByCode(code)).build();//alternative

    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUeBySemaistre(@QueryParam("semestre") int semestre) {
        return Response.ok(helper.getUEBySemestre(semestre)).build();
    }

    @Path("/delte/{deletecode}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response delteBykey(@PathParam("deletecode") int deltecode) {
        if (helper.deleteUniteEnseignement(deltecode)) {
            return Response.status(201).entity("supprimer avec succee").build();
        } else {
            return Response.status(400).entity("erreur lor de supression").build();
        }
    }



}
