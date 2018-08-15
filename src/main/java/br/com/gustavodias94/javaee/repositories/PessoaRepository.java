package br.com.gustavodias94.javaee.repositories;

import br.com.gustavodias94.javaee.models.Pessoa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
@RequestScoped
public class PessoaRepository {

    @Inject
    private EntityManager em;

    public PessoaRepository(){
    }

    public PessoaRepository(EntityManager em) {
        this.em = em;
    }

    public Pessoa getOne (Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> findAll(){
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public Pessoa save(Pessoa pessoa) {
        em.joinTransaction();
        em.persist(pessoa);
        return pessoa;
    }

    public void delete(Pessoa pessoa){
        em.joinTransaction();
        em.remove(pessoa);
    }

}
