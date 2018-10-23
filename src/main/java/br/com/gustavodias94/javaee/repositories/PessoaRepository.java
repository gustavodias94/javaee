package br.com.gustavodias94.javaee.repositories;

import br.com.gustavodias94.javaee.models.Pessoa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PessoaRepository {

    @PersistenceContext(name = "dsv")
    private EntityManager em;


    public Pessoa getOne (Long id) {
        return em.find(Pessoa.class, id);
    }

    public List findAll(){
        return em.createNamedQuery(Pessoa.FIND_ALL).getResultList();
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
