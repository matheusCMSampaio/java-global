package br.com.medvirtua.java_global.controller;

import br.com.medvirtua.java_global.model.entity.RegistroCliente;
import br.com.medvirtua.java_global.model.repository.RegistroClienteRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

}
