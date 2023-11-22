package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.Registro;
import br.com.medvirtua.java_global.model.repository.RegistroRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

import java.util.ArrayList;

@Path("registro")
public class RegistroResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid Registro registro){
        try {
            Registro resposta = RegistroRepository.save(registro);
            return Response.status(Response.Status.CREATED).entity(resposta).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salvar o registro: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        try {
            ArrayList<Registro> resposta = RegistroRepository.findAll();
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
}