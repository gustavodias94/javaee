package br.com.gustavodias94.javaee.dto.converters;

import br.com.gustavodias94.javaee.dto.PessoaDTO;
import br.com.gustavodias94.javaee.models.Pessoa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PessoaDtoToPessoaConverter implements SuperConverter<PessoaDTO, Pessoa> {
    @Override
    public Pessoa apply(PessoaDTO dto) {
        return new Pessoa(null, dto.getNome(),dto.getTelefone());
    }
}
