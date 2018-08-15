package br.com.gustavodias94.javaee.resources;

import br.com.gustavodias94.javaee.dto.converters.PessoaDtoToPessoaConverter;
import br.com.gustavodias94.javaee.models.Pessoa;
import br.com.gustavodias94.javaee.services.PessoaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @Inject
    PessoaDtoToPessoaConverter pessoaDtoToPessoaConverter;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> listarPessoas(){
        return pessoaService.getPessoas();
    }

    @POST
    @Path("/cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

}

