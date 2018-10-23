package br.com.gustavodias94.javaee.resources;

import br.com.gustavodias94.javaee.models.Pessoa;
import br.com.gustavodias94.javaee.services.PessoaService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> listarPessoas(){
        return pessoaService.getPessoas();
    }

    @POST
    @Path("/cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    /*
    * @Produces - formato que será retornado ao cliente. Verbo HTTP @GET.
    * @Consumes - formato que será recebido no corpo da requisicao. Verbos HTTP: @POST, @PUT, @PATCH.
    * */

}

