import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class Asserts {

	@Test
	public void test() {
		
		Assert.assertTrue(true); //Verifica se a expressão é verdadeira
	    Assert.assertFalse(false); // verifica se for falsa
	    
	    Assert.assertEquals(1, 1); // Se um parametro for igual ao segundo
	    Assert.assertEquals(0.51, 0.51, 0.01); // Para double se coloca a margem de erro.O numero de zeros depois do ponto indica até quantas casas decimais será considerada
	    
	    Assert.assertEquals("bola", "bola");
	    Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
	    Assert.assertTrue("bola".startsWith("bo"));
	    
	    Usuario u1 = new Usuario("Usuário 1");
	    Usuario u2 = new Usuario("Usuário 1");
	    Usuario u3 = null;
	    
	    Assert.assertEquals(u1, u2); // Neste caso dará erro pois são 2 objetos diferentes instaciados
	    
	    Assert.assertTrue(u3 == null);
	    
	}
	
}
