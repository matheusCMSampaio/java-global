package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.Calendario;
import br.com.medvirtua.java_global.model.repository.CalendarioRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CalendarioResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid Calendario calendario){
        try {
            Calendario resposta = CalendarioRepository.save(calendario);
            return Response.status(Response.Status.CREATED).entity(resposta).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salver: "+ e.getMessage()).build();
        }
    }
}
