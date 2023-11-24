package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.RegistroCliente;
import br.com.medvirtua.java_global.model.entity.RegistroEspecialista;
import br.com.medvirtua.java_global.model.repository.RegistroClienteRepository;
import br.com.medvirtua.java_global.model.repository.RegistroEspecialistaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("registroCliente")
public class RegistroClienteResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid RegistroCliente registroCliente){
        try {
            RegistroCliente resposta = RegistroClienteRepository.save(registroCliente);
            return Response.status(Response.Status.CREATED).entity(resposta).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salver: "+ e.getMessage()).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{nome}")
    public Response findByName(@PathParam("nome") String nome){
        try {
            ArrayList<RegistroCliente> resposta = RegistroClienteRepository.findByName(nome);
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
        if(RegistroClienteRepository.delete(id)){
            return Response.noContent().build();
        }else {
            return Response.status(404).build();
        }
    }
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response update(@Valid RegistroCliente registroCliente){
        RegistroCliente resposta = RegistroClienteRepository.update(registroCliente);
        Response.ResponseBuilder response = null;
        if(resposta != null){
            response = Response.status(Response.Status.OK).entity(resposta);
        } else {
            response = Response.status(Response.Status.BAD_REQUEST);
        }
        return response.build();
    }

}
