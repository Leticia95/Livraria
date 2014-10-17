package br.com.livrarialeticia.controller;

import java.util.List;

import javax.ejb.Local;

import br.com.livrarialeticia.model.Livro;

@Local
public interface LivroEJBLocal 
{
	public List<Livro> localizaLivros();
	public Livro localizaLivroPorID(Long id);
	public Livro criaLivro(Livro livro);
	public void apagaLivro(Livro livro);
	public Livro atualizaLivro(Livro livro);
}
