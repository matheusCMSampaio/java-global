package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.Doenca;
import br.com.medvirtua.java_global.model.entity.RegistroCliente;
import br.com.medvirtua.java_global.model.repository.DoencaRepository;
import br.com.medvirtua.java_global.model.repository.RegistroClienteRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class DoencaResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid Doenca doenca){
        try {
            Doenca resposta = DoencaRepository.save(doenca);
            return Response.status(Response.Status.CREATED).entity(resposta).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salver: "+ e.getMessage()).build();
        }
    }
}
