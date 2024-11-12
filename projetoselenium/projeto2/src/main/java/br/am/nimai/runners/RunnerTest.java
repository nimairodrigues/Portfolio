package br.am.nimai.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Para indicar ao JUnit onde estão as features
		features = "src/main/resources/features/",
		
		//Para indicar ao JUnit onde estão os steps
		glue = "br.am.nimai.steps",
		
		//Para executar testes que contenham as tags x, aqui eu não utilizei
		tags = "",
		
		//pretty é pra deixar mais 'bonito' a visualização do resultado no console
		//summary gera um resumo dos testes
		//html e json são para criar um arquivo de relatório sobre os testes na pasta de target/
		plugin = {"pretty", "summary", "html:target/report-html", "json:target/report.json"},
		
		//torna o resultado no console mais colorido se true, quando for executado através do cmd
		monochrome = false,
		
		//quando executar o teste e não ter algum step, ele vai mostrar o step já com o camelcase no console, pronto para ctrl c e ctrl v
		snippets = SnippetType.CAMELCASE,
		
		//realiza uma verificação se todos os steps estão implementados, sem precisar executar os testes
		//true para realizar a verificação, false para não realiza-la
		dryRun = false
		)
public class RunnerTest {

}
