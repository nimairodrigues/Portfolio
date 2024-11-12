package br.am.nimai.page;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class CadastroPage extends BasePage {
	
	public void escreverEmail(String email) {
		
		esperarVisibilidadeDeElemento("//*[@class='card__register']//*[@type='email']");
		
		escreverPorXpath("//*[@class='card__register']//*[@type='email']", email);
	}
	
	public void escreverNome(String nome) {
		
		esperarVisibilidadeDeElemento("//*[@class='card__register']//*[@type='name']");
		
		escreverPorXpath("//*[@class='card__register']//*[@type='name']", nome);
	}
	
	public void escreverSenha(String senha) {
		
		esperarVisibilidadeDeElemento("//*[@class='card__register']//*[@for='password']/../input");
		
		escreverPorXpath("//*[@class='card__register']//*[@for='password']/../input", senha);
	}
	
	public void escreverConfirmarSenha(String senha) {
		
		esperarVisibilidadeDeElemento("//*[@class='card__register']//*[@for='passwordConfirmation']/../input");
		
		escreverPorXpath("//*[@class='card__register']//*[@for='passwordConfirmation']/../input", senha);
	}
	
	public void clicarAdicionarBalance() {
		//Aqui há um bug em que a aplicação não está resetando os campos do card de registrar conta
		//Deveria ser aberto um report aqui, mas para fins didáticos eu dei um jeito.
		//Quando eu preciso criar 2 contas (no caso pra realizar transferencia de uma conta para outra) e na tela de cadastro,
		//no 2° cadastro, os campos continuam preenchidos e o botão de adicionar balance também continua marcado
		//O Método verifica se ele está desmarcado, se não tiver, ele vai e marca.
		WebElement elementoAdicionarBalanco = DriverFactory.getDriver().findElement(By.xpath("//*[@id='toggleAddBalance']/.."));
		if(elementoAdicionarBalanco.getAttribute("class").toString().contains("kIwoPV")) {
			clicarPorId("toggleAddBalance");
			esperarVisibilidadeDeElemento("//*[@class='styles__Container-sc-1pngcbh-0 hsmFIT']");
		}
	}
	
	public void clicarCadastrar() {
		esperarVisibilidadeDeElemento("//*[@class='card__register']//*[@type='submit']");
		
		clicarPorXpath("//*[@class='card__register']//*[@type='submit']");
	}
	
	public void clicarFecharConfirm() {
		esperarVisibilidadeDeElemento("//*[@id='btnCloseModal']");
		
		clicarPorXpath("//*[@id='btnCloseModal']");
	}
	
	public boolean existeMensagemContaCriadaComSucesso() {
		esperarVisibilidadeDeElemento("//*[@id='modalText']");
		
		//realizar a busca do texto e retornar se existe ou não
		//entre conta e foi aparece um código aleatório, por isso utilizei essa forma de verificação
		//poderia verificar se o modal de sucesso aparece também na tela (seria mais fácil até), mas eu quis diferenciar
		List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath("//*[contains(text(), 'A conta' and 'foi criada com sucesso')]"));
		return elements.size() > 0;
		
	}
	
	//para cadastrar um usuário digitando todos os dados necessários
	public String cadastrarUsuario(String email, String nome, String senha, String confirmSenha) {
		escreverEmail(email);
		escreverNome(nome);
		escreverSenha(senha);
		escreverConfirmarSenha(confirmSenha);
		clicarAdicionarBalance();
		clicarCadastrar();
		
		//Foi necessário para capturar o código da conta criada, que aparece no final do cadastro de uma conta
		//Esse código vai ser necessário na hora de transferir o dinheiro, pois precisa do número da conta e do dígito
		//Foi utilizado o regex para capturar esse código
		String textoConfirmCadastro = pegarTextXpath("//*[@id='modalText']");
		
		//o regex que foi utilizado para pegar o valor entr 'conta' e 'foi'
		String regex = "(?<=conta\\s)(.*?)(?=\\sfoi)";
		
		//armazenar o regex dentro de um pattern
		Pattern pattern = Pattern.compile(regex);
		
		//depois capturar o texto usando o pattern.matcher e armazena-lo no matcher
		Matcher matcher = pattern.matcher(textoConfirmCadastro);
		
		clicarFecharConfirm();
		
		//aqui ele precisa verificar se o matcher existe ou não
		if(matcher.find()) {
			//vai retornar os valores necessários (conta e dígito)
			return matcher.group();
		} else {
			return "Erro ao encontrar o matcher.find()";
		}
	}
	
	public String pegarTextoWarningEmail() {
		//vai pegar o texto do elemento e retornar
		return pegarTextXpath("//*[@class='card__register']//*[@for='email']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningNome() {
		//vai pegar o texto do elemento e retornar
		return pegarTextXpath("//*[@class='card__register']//*[@for='name']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningSenha() {
		//vai pegar o texto do elemento e retornar
		return pegarTextXpath("//*[@class='card__register']//*[@for='password']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningSenhaConfirm() {
		//vai pegar o texto do elemento e retornar
		return pegarTextXpath("//*[@class='card__register']//*[@for='passwordConfirmation']/..//*[@class='input__warging']");
	}
	
	
}
