package br.am.nimai.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ProductsTest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://fakestoreapi.com";
	}
	
	
	@Test
	public void solicitarTodosOsProdutos() {
		given()
			.contentType("application/json")
		.when()
			.get("/products")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", hasSize(20))
			.body("title", hasSize(20))
			.body("price", hasSize(20))
			.body("category", hasSize(20))
		;
	}
	
	@Test
	public void solicitarProduto1() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", is(1))
			.body("title", startsWith("Fjallraven"))
			.body("price", notNullValue())
			.body("category", is("men's clothing"))
		;
	}
	
	@Test
	public void solicitarProdutoB() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/b")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void solicitarProdutoJogoDaVelha() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/#")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void solicitarProduto1b() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/1b")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void solicitarProduto0() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/0")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/0"))
		;
	}
	
	@Test
	public void solicitarProduto1Negativo() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/-1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/-1"))
		;
	}
	
	@Test
	public void solicitarProduto9999999999() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/9999999999")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/9999999999"))
		;
	}
	
	@Test
	public void solicitarProduto20() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/20")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", is(20))
			.body("title", startsWith("DANVOUY"))
			.body("price", notNullValue())
			.body("category", is("women's clothing"))
		;
	}
	
	@Test
	public void solicitarProduto21() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/21")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Product doesn\'t exist"))
		;
	}
	
	@Test
	public void solicitarTodasAsCategorias() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories")
		.then()
			.log().all()
			.statusCode(200)
			.body("$", containsInAnyOrder("electronics", "jewelery", "men's clothing", "women's clothing", "sports"))
		;
	}
	
	@Test
	public void solicitarTodasAsCategorias1() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/1")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/1"))
		;
	}
	
	@Test
	public void solicitarTodasAsCategoriasB() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/b")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/b"))
		;
	}
	
	@Test
	public void solicitarTodasAsCategoriasJogoDaVelha() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/#")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/#"))
		;
	}
	
	@Test
	public void solicitarProdutoDaCategoryElectronics() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/electronics")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void solicitarProdutoDaCategoryJewelery() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/jewelery")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void solicitarProdutoDaCategoryMensClothing() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/Men's clothing")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void solicitarProdutoDaCategoryWomensClothing() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/women's clothing")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void solicitarProdutoDaCategorySports() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/sports")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
		Assert.fail("Erro quanto as variáveis, ao colocar qualquer tipo de variàvel para verificação ela conta como se existisse e valesse como []");
	}
	
	@Test
	public void solicitarProdutoDaCategoryGames() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/games")
		.then()
			.log().all()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/category/games"))
		;
	}
	
	@Test
	public void criarNovoProduto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(201)
			.body("id", is(21))
			.body("title", is("product fake"))
			.body("price", is(11.2f))
			.body("category", is("electronic"))
		;
	}
	
	@Test
	public void criarNovoProdutoComCategoryInexistente() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Category doesnt exist"))
		;
	}
	
	@Test
	public void criarNovoProdutoComCategoryVazia() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Category cannot be empty"))
		;
	}
	
	@Test
	public void criarNovoProdutoComPriceVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": , \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price cannot be empty"))
		;
	}
	
	@Test
	public void criarNovoProdutoComPriceNegativo() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": -11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void criarNovoProdutoComTituloVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Title cannot be empty"))
		;
	}
	
	@Test
	public void criarNovoProdutoComTituloAcimaDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Apple MacBook Pro 13-inch M1 Chip with 8-Core CPU and 8-Core GPU, 16GB RAM, 512GB SSD - Space Gray\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Maximum number of characters reached"))
		;
	}
	
	@Test
	public void criarNovoProdutoComTituloAbaixoDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"mac\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Minimum number of characters reached"))
		;
	}
	
	@Test
	public void criarNovoProdutoComTituloContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 25, \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void criarNovoProdutoComTituloContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 10.5, \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void criarNovoProdutoComImageContendoArquivoComExtensaoIncompativel() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.mp4\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}

	@Test
	public void criarNovoProdutoComImageContendoArquivoSemExtensao() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void criarNovoProdutoComImageVazia() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Image cannot be empty"))
		;
	}
	
	@Test
	public void criarNovoProdutoComImageContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": 1, \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void criarNovoProdutoComImageContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": 2.5, \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void criarNovoProdutoComCategoryContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": 2.5}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void criarNovoProdutoComCategoryContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": 1}")
		.when()
			.post("/products")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPrice() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 100.5, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("title", Matchers.startsWith("Fjallraven"))
			.body("price", is(100.5f))
			.body("image", is("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"))
			.body("category", is("Men’s clothing"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price cannot be empty"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceParaNegativo() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": -109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceParaZero() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 0, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceValorDentroDeString() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"109.95\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceParaTexto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"texto\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoPriceParaValorAlto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"9999999999999\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price is too high."))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoTituloParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Title cannot be empty"))
		;
	}
	
	@Test
	public void atualizarProdutoAlterandoTituloParaAcimaDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.log().all()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Title cannot be empty"))
		;
	}
}
