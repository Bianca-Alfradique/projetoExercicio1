package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeClientesTest {

	@Test
	public void testCadastroDeClienteComSucesso() {

		// Executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador (google chrome)
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a p�gina web do exercicio 03 que ser� testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio03");

		// preencher o nome do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");

		// Preencher o RG do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"RG\"]")).sendKeys("1234567890");

		// Preencher o CPF do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys("098.123.876-00");

		// Preencher a data de nascimento
		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys("10/10/1980");

		// Clicar no bot�o para realizar a inscri��o
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// Capturar a mensagem gerada pelo sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Verificar se a mensagem � igual a: �Processo realizado com sucesso�
		assertEquals(mensagem, "Processo realizado com sucesso");

		try {
			// o selenium ir� fazer um print da tela e armazenar em mem�ria
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_test\\Cadastro de Clientes com sucesso.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechar o navegador
		driver.close();
		driver.quit();
	}

	// Fun��o de teste para valida��o de campos obrigat�rios
	@Test
	public void testValidacaoDeCamposObrigatorios() {

		// Executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrir o google chorme
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a p�gina de cadastro de clientes
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio03");

		// clicar no bot�o de realizar inscri��o
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar as mensagens de erro exibidas pelo sistema
		String erroNomeDoCliente = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div/span")).getText();
		String erroNoRg = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div/span")).getText();
		String erroNoCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[3]/div/span")).getText();
		String erroNoNascimento = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[4]/div/span")).getText();
		
		//comparando se o resultado esperado � igual ao resultado obtido
		assertEquals(erroNomeDoCliente, "Campo obrigat�rio");
		assertEquals(erroNoRg, "Campo obrigat�rio");
		assertEquals(erroNoCpf, "Campo obrigat�rio");
		assertEquals(erroNoNascimento, "Campo obrigat�rio");
		
		try {
			// o selenium ir� fazer um print da tela e armazenar em mem�ria
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_test\\Valida��o de Campos Obrig�torios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//fechar o navegador
		driver.close();
		driver.quit();
		
	}

}
