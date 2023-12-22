package br.am.nimai.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class BuzzPage extends BasePage {
	
	public void escreverPost(String texto) {
		escrever(By.xpath("//*[@class='oxd-buzz-post-input']"), texto);
	}
	
	public void escreverPostLongo() {
		escrever(By.xpath("//*[@class='oxd-buzz-post-input']"), textoLongo());
	}
	
	public String pegarPopupSucessoSaved() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Saved']")).getText();
	}
	
	public String pegarPopupSucessoUpdated() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Updated']")).getText();
	}
	
	public String pegarPopupSucessoDelete() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Deleted']")).getText();
	}

	public void clicarPost() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String aleatorizarNumeros(int qtdNum) {
		return randomNum(qtdNum);
	}

	public void clicarApagarPost() {
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Delete Post']"));
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Delete Post']"));
	}
	
	public void clicarAlterarPost() {
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
	}
	
	public void clicarLikePost() {
		if(isLikeado()) {
			System.out.println("2 caso");
			clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"));
			System.out.println("cliquei");
			esperarInvisibilidadeDeElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
			System.out.println("esperei");
		} else {
			System.out.println("1 caso");
			clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"));
			esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz']//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
		}
	}
	
	public void clicarLikePost2() {
			clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"));
	}

	public void escreverEditPost() {
		esperarPresencaPorElemento(By.xpath("//*[@class='orangehrm-buzz-post-modal-header-text']/div/textarea"));
		escrever(By.xpath("//*[@class='orangehrm-buzz-post-modal-header-text']/div/textarea"), " " + randomNum(50));
	}
	
	public void clicarPostEdit() {
		clicar(By.xpath("//*[@class='oxd-dialog-container-default--inner']//button[@type='submit']"));
	}
	
	public void encontrarPostDeUmUsuario(String string) {
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div//*[@class='oxd-text oxd-text--p orangehrm-buzz-post-emp-name']"));
		boolean achei = false;
		
		for(WebElement doidos: findElements) {
			System.out.println(doidos.getText());
		}
		
		for(int i = 0; i < findElements.size(); i++) {
			if(findElements.get(i).getText().contains(string)) {
				i++;
				clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']"));
				esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
				clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
				achei = true;
				break;
			}
		}
		
		if(achei) {
			System.out.println("Achei um post desse cara na tela");
		} else {
			System.out.println("Nao achei nenhum post desse cara na tela");
		}
		
	}
	
	public String pegarUsuarioLogado() {
		return obterTexto(By.xpath("//*[@class='oxd-userdropdown-name']"));
	}
	
	public void test() {
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div"));
	}
	
	public boolean isLikeado() {
		String string = DriverFactory.getDriver()
				.findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"))
				.getAttribute("class");
		return string.contains("orangehrm-like-animation");
	}
	
	public int pegarQtdLikes() {
		String text = DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-stats']/div[1]//*[@class='oxd-text oxd-text--p orangehrm-buzz-stats-active']")).getText();
		String valor = text.replaceAll("(?:[^0-9]+)", "");
		int resultado = Integer.parseInt(valor);
		return resultado;
	}
	
	public void clicarCompartilharPost() {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-post-actions']//*[@class='oxd-icon bi-share-fill']"));
	}
	
	public void clicarShare() {
		clicar(By.xpath("//*[@class='oxd-dialog-container-default--inner']//button[@class='oxd-button oxd-button--medium oxd-button--main']"));
	}
	
	public void clicarBotaoComentar() {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-post-actions']//*[@class='oxd-icon bi-chat-text-fill']"));
	}
	
	public void escreverNosComents(String comentario) {
		escrever(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//input"), comentario);
	}
	
	public void enviarComent() {
		DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//input"))
		.sendKeys(Keys.ENTER);
	}
	
	public void comentarEmAlgumPost(String comentario) {
		clicarBotaoComentar();
		escreverNosComents(comentario);
		enviarComent();
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}
	
	public void apagarMeuComentario(String comentario) {
		clicarApagarComent(comentario);
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		clicarPorTexto(" Yes, Delete ");
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}
	
	public void clicarLikeComent(String comentario) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../..//*[text()='Like']"));
		esperarPresencaPorElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../*[@class='orangehrm-post-comment-stats']/p"));
	}
	
	public String pegarLikesComent(String comentario) {
		return obterTexto(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../*[@class='orangehrm-post-comment-stats']/p"));
	}
	
	public void clicarEditComent(String comentarioQueSeraEditado) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentarioQueSeraEditado+"']/../..//*[text()='Edit']"));
	}
	
	public void escreverEditComent(String comentarioNovo) {
		apagarElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"));
		escrever(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"), comentarioNovo);
		DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"))
		.sendKeys(Keys.ENTER);
	}
	
	public void clicarApagarComent(String comentario) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../..//*[text()='Delete']"));
		
	}
	
	
	
	
	
	public String textoLongo() {
		String textoGrande = "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "Começo\r\n"
				+ "A ARPANET funcionava através de um sistema conhecido como chaveamento de pacotes, que é um sistema de transmissão de dados em rede de computadores no qual as informações são divididas em pequenos pacotes, que por sua vez contém trecho dos dados, o endereço do destinatário e informações que permitiam a remontagem da mensagem original. O ataque inimigo nunca aconteceu, mas o que o Departamento de Defesa dos Estados Unidos não sabia era que dava início ao maior fenômeno midiático do século XX', único meio de comunicação que em apenas 4 anos conseguiria atingir cerca de 50 milhões de pessoas.\r\n"
				+ "\r\n"
				+ "Em 29 de Outubro de 1969 ocorreu a transmissão do que pode ser considerado o primeiro E-mail da história.[2] O texto desse primeiro e-mail seria \"LOGIN\", conforme desejava o Professor Leonard Kleinrock da Universidade da Califórnia em Los Angeles (UCLA), mas o computador no Stanford Research Institute, que recebia a mensagem, parou de funcionar após receber a letra \"O\".\r\n"
				+ "\r\n"
				+ "Já na década de 1970, a tensão entre URSS e EUA diminui. As duas potências entram definitivamente naquilo em que a história se encarregou de chamar de Coexistência Pacífica. Não havendo mais a iminência de um ataque imediato, o governo dos EUA permitiu que pesquisadores que desenvolvessem, nas suas respectivas universidades, estudos na área de defesa pudessem também entrar na ARPANET. Com isso, a ARPANET começou a ter dificuldades em administrar todo este sistema, devido ao grande e crescente número de localidades universitárias contidas nela.\r\n"
				+ "\r\n"
				+ "Dividiu-se então este sistema em dois grupos, a MILNET, que possuía as localidades militares e a nova ARPANET, que possuía as localidades não militares. O desenvolvimento da rede, nesse ambiente mais livre, pôde então acontecer. Não só os pesquisadores como também os alunos e os amigos dos alunos, tiveram acesso aos estudos já empreendidos e somaram esforços para aperfeiçoá-los. Houve uma época nos Estados Unidos em que sequer se cogitava a possibilidade de comprar computadores prontos, já que a diversão estava em montá-los.\r\n"
				+ "\r\n"
				+ "A mesma lógica se deu com a Internet. Jovens da contracultura, ideologicamente engajados em uma utopia de difusão da informação, contribuíram decisivamente para a formação da Internet como hoje é conhecida. A tal ponto que o sociólogo espanhol e estudioso da rede Manuel Castells afirmou no livro A Galáxia da Internet (2003) que A Internet é, acima de tudo, uma criação cultural.\r\n"
				+ "\r\n"
				+ "Um sistema técnico denominado Protocolo de Internet (Internet Protocol) permitia que o tráfego de informações fosse encaminhado de uma rede para outra. Todas as redes conectadas pelo endereço IP na Internet comunicam-se para que todas possam trocar mensagens. Através da National Science Foundation, o governo norte-americano investiu na criação de backbones (que significa espinha dorsal, em português), que são poderosos computadores conectados por linhas que tem a capacidade de dar vazão a grandes fluxos de dados, como canais de fibra óptica, elos de satélite e elos de transmissão por rádio. Além desses backbones, existem os criados por empresas particulares. A elas são conectadas redes menores, de forma mais ou menos anárquica. É basicamente isto que consiste a Internet, que não tem um dono específico.\r\n"
				+ "\r\n"
				+ "O cientista Tim Berners-Lee, do CERN, criou a World Wide Web em 1992.\r\n"
				+ "\r\n"
				+ "A empresa norte-americana Netscape criou o protocolo HTTPS (HyperText Transfer Protocol Secure), possibilitando o envio de dados criptografados para transações comercias pela internet.\r\n"
				+ "\r\n"
				+ "Por fim, vale destacar que já em 1992, o então senador Al Gore, já falava na Superhighway of Information. Essa \"superestrada da informação\" tinha como unidade básica de funcionamento a troca, compartilhamento e fluxo contínuo de informações pelos quatro cantos do mundo através de uma rede mundial, a Internet. O que se pode notar é que o interesse mundial aliado ao interesse comercial, que evidentemente observava o potencial financeiro e rentável daquela \"novidade\", proporcionou o boom (explosão) e a popularização da Internet na década de 1990. Até 2003, cerca de mais de 600 milhões de pessoas estavam conectadas à rede. Segundo a Internet World Estatistics, em junho de 2007 este número se aproxima de 1 bilhão e 234 milhões de usuários.\r\n"
				+ "\r\n"
				+ "";
		return textoGrande;
	}

	

}
