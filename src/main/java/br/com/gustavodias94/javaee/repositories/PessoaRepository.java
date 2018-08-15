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

    private EntityManager em;

    public PessoaRepository(){
    }

    @Inject
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
        getOne(pessoa.getId());

        if (pessoa.getId() == null){
            em.persist(pessoa);
            return pessoa;
        } else {
            return em.merge(pessoa);
        }
    }

    public void delete(Pessoa pessoa){
        em.joinTransaction();
        em.remove(pessoa);
    }

}
