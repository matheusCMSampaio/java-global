package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.Medidas;
import br.com.medvirtua.java_global.model.repository.MedidasRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Path("medidas")
public class MedidasResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid Medidas medidas){
        try {
            Medidas resposta = MedidasRepository.save(medidas);
            return Response.status(Response.Status.CREATED).entity(resposta).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salver: "+ e.getMessage()).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        try {
            ArrayList<Medidas> resposta = MedidasRepository.findAll();
            if (resposta.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.status(Response.Status.OK).entity(resposta).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar registros: " + e.getMessage())
                    .build();
        }
    }
    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id){
        if(MedidasRepository.delete(id)){
            return Response.noContent().build();
        }else {
            return Response.status(404).build();
        }
    }
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response update(@Valid Medidas medidas){
        Medidas resposta = MedidasRepository.update(medidas);
        Response.ResponseBuilder response = null;
        if(resposta != null){
            response = Response.status(Response.Status.OK).entity(resposta);
        } else {
            response = Response.status(Response.Status.BAD_REQUEST);
        }
        return response.build();
    }
}
