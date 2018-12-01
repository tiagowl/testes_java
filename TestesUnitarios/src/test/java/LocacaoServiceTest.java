

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.sun.org.apache.xpath.internal.operations.NotEquals;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector(); // Para mostrar todos os erros,não somente o primeiro erro que aparece. Colocar error.checkThat... em vez de Assert.assertThat
	
	@Test
	public void testeLocacao() {
		//cenario
				LocacaoService service = new LocacaoService();
				Usuario usuario = new Usuario("Usuário 1");
				Filme filme = new Filme("Filme 1", 2, 5.0);
				
				//acao
				Locacao locacao = service.alugarFilme(usuario, filme);
				
				//verificação
				Assert.assertThat(locacao.getValor(), is(5.0)); //verifique que...
				Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
				Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	
}
