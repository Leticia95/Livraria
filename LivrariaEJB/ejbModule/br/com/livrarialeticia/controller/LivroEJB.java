package br.com.livrarialeticia.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.livrarialeticia.model.Livro;

/**
 * Session Bean implementation class LivroEJB
 */
@Stateless
@LocalBean
@PersistenceContext(unitName = "LivrariaEJB")
public class LivroEJB implements LivroEJBRemote, LivroEJBLocal {
	private EntityManager gerenciador;

    public LivroEJB() {
    
    }
    
    public List<Livro> localizaLivros()
    {
    	TypedQuery<Livro> consulta = gerenciador.createNamedQuery("Livro.localiza", Livro.class);   	
        return consulta.getResultList();
    }
    
    public Livro localizaLivroPorID(Long id)
    {
    	return gerenciador.find(Livro.class, id);
    }
    
    public Livro criaLivro(Livro livro)
    {
    	gerenciador.persist(livro);
    	return (livro);
    }
    
    public void apagaLivro(Livro livro)
    {
    	gerenciador.persist(livro);
    }
    
    public Livro atualizaLivro(Livro livro)
    {
    	return gerenciador.merge(livro);
    }
    
}
