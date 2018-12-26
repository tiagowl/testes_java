package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

	@Parameter
	public List<Filme> filmes;
	@Parameter(value=1)
	public Double valorLocacao;
	public LocacaoService service;
	
	@Before
	public void setup(){
		service = new LocacaoService();
	}
	
	private static Filme filme1 = new Filme("Filme 1", 2, 4.0 );
	private static Filme filme2 = new Filme("Filme 2", 2, 4.0 );
	private static Filme filme3 = new Filme("Filme 3", 2, 4.0 );
	private static Filme filme4 = new Filme("Filme 4", 2, 4.0 );
	private static Filme filme5 = new Filme("Filme 5", 2, 4.0 );
	private static Filme filme6 = new Filme("Filme 6", 2, 4.0 );
	
	@Parameters(name="Teste {index} = {0} - {1}")
	public static Collection<Object[]> getParametros(){
		return Arrays.asList(new Object[][]{
			{Arrays.asList(filme1,filme2,filme3),11.0, "3 filmes: 25%"},
			{Arrays.asList(filme1,filme2,filme3,filme4),13.0,"4 filmes: 50%"},
			{Arrays.asList(filme1,filme2,filme3,filme4,filme5),14.0,"5 filmes: 75%"},
			{Arrays.asList(filme1,filme2,filme3,filme4,filme5,filme6),14.0,"6 filmes: 100%"}
		});
	}
	
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDesconto() throws FilmeSemEstoqueException, LocadoraException{
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		//verificacao
		assertThat(resultado.getValor(), is(valorLocacao));
	}
	
}
