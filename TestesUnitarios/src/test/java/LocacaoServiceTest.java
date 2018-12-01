

import java.util.Date;

import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	
	@Test
	public void teste() {
		//cenario
				LocacaoService service = new LocacaoService();
				Usuario usuario = new Usuario("Usuário 1");
				Filme filme = new Filme("Filme 1", 2, 5.0);
				
				//acao
				Locacao locacao = service.alugarFilme(usuario, filme);
				
				//verificação
				System.out.println(locacao.getValor() == 5);
				System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
				System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	
}
