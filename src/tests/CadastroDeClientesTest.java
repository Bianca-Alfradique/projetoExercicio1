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

		// acessar a página web do exercicio 03 que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio03");

		// preencher o nome do funcionário
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");

		// Preencher o RG do funcionário
		driver.findElement(By.xpath("//*[@id=\"RG\"]")).sendKeys("1234567890");

		// Preencher o CPF do funcionário
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys("098.123.876-00");

		// Preencher a data de nascimento
		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys("10/10/1980");

		// Clicar no botão para realizar a inscrição
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// Capturar a mensagem gerada pelo sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Verificar se a mensagem é igual a: “Processo realizado com sucesso”
		assertEquals(mensagem, "Processo realizado com sucesso");

		try {
			// o selenium irá fazer um print da tela e armazenar em memória
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

	// Função de teste para validação de campos obrigatórios
	@Test
	public void testValidacaoDeCamposObrigatorios() {

		// Executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// abrir o google chorme
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a página de cadastro de clientes
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio03");

		// clicar no botão de realizar inscrição
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar as mensagens de erro exibidas pelo sistema
		String erroNomeDoCliente = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div/span")).getText();
		String erroNoRg = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div/span")).getText();
		String erroNoCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[3]/div/span")).getText();
		String erroNoNascimento = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[4]/div/span")).getText();
		
		//comparando se o resultado esperado é igual ao resultado obtido
		assertEquals(erroNomeDoCliente, "Campo obrigatório");
		assertEquals(erroNoRg, "Campo obrigatório");
		assertEquals(erroNoCpf, "Campo obrigatório");
		assertEquals(erroNoNascimento, "Campo obrigatório");
		
		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_test\\Validação de Campos Obrigátorios.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//fechar o navegador
		driver.close();
		driver.quit();
		
	}

}
