package br.com.gustavodias94.javaee.dto.converters;

import br.com.gustavodias94.javaee.dto.PessoaDTO;
import br.com.gustavodias94.javaee.models.Pessoa;

public class PessoaDtoToPessoaConverter implements SuperConverter<PessoaDTO, Pessoa> {
    @Override
    public Pessoa apply(PessoaDTO dto) {
        final Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setTelefone(dto.getTelefone());
        return pessoa;
    }
}
