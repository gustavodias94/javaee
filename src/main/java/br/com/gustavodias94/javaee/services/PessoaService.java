package br.com.gustavodias94.javaee.services;

import br.com.gustavodias94.javaee.models.Pessoa;
import br.com.gustavodias94.javaee.repositories.PessoaRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class PessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    public List getPessoas() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        try {
            pessoa = pessoaRepository.save(pessoa);
        } catch (Exception ignored){}
        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        try {
            pessoa = pessoaRepository.save(pessoa);
        } catch (Exception ignored){}
        return pessoa;
    }
}
