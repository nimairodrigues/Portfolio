package br.am.nimai.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class ProductsTest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://fakestoreapi.com";
	}
	
	@Test
	public void ct_01_solicitarTodosOsProdutos() {
		given()
			.contentType("application/json")
		.when()
			.get("/products")
		.then()
			.statusCode(200)
			.body("id", hasSize(20))
			.body("title", hasSize(20))
			.body("price", hasSize(20))
			.body("category", hasSize(20))
		;
	}
	
	@Test
	public void ct_02_solicitarProduto1() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("title", startsWith("Fjallraven"))
			.body("price", notNullValue())
			.body("category", is("men's clothing"))
		;
	}
	
	@Test
	public void ct_03_solicitarProdutoB() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/b")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void ct_04_solicitarProdutoJogoDaVelha() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/#")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void ct_05_solicitarProduto1b() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/1b")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void ct_06_solicitarProduto0() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/0")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/0"))
		;
	}
	
	@Test
	public void ct_07_solicitarProduto1Negativo() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/-1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/-1"))
		;
	}
	
	@Test
	public void ct_08_solicitarProduto9999999999() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/9999999999")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/9999999999"))
		;
	}
	
	@Test
	public void ct_09_solicitarProduto20() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/20")
		.then()
			.statusCode(200)
			.body("id", is(20))
			.body("title", startsWith("DANVOUY"))
			.body("price", notNullValue())
			.body("category", is("women's clothing"))
		;
	}
	
	@Test
	public void ct_10_solicitarProduto21() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/21")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Product doesn\'t exist"))
		;
	}
	
	@Test
	public void ct_11_solicitarTodasAsCategorias() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories")
		.then()
			.statusCode(200)
			.body("$", containsInAnyOrder("electronics", "jewelery", "men's clothing", "women's clothing", "sports"))
		;
	}
	
	@Test
	public void ct_12_solicitarTodasAsCategorias1() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/1")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/1"))
		;
	}
	
	@Test
	public void ct_13_solicitarTodasAsCategoriasB() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/b")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/b"))
		;
	}
	
	@Test
	public void ct_14_solicitarTodasAsCategoriasJogoDaVelha() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/categories/#")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/categories/#"))
		;
	}
	
	@Test
	public void ct_15_solicitarProdutoDaCategoryElectronics() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/electronics")
		.then()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void ct_16_solicitarProdutoDaCategoryJewelery() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/jewelery")
		.then()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void ct_17_solicitarProdutoDaCategoryMensClothing() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/Men's clothing")
		.then()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void ct_18_solicitarProdutoDaCategoryWomensClothing() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/women's clothing")
		.then()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
	}
	
	@Test
	public void ct_19_solicitarProdutoDaCategorySports() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/sports")
		.then()
			.statusCode(200)
			.body("id", notNullValue())
			.body("title", notNullValue())
			.body("price", notNullValue())
			.body("category", notNullValue())
		;
		Assert.fail("Erro quanto as variáveis, ao colocar qualquer tipo de variàvel para verificação ela conta como se existisse e valesse como []");
	}
	
	@Test
	public void ct_20_solicitarProdutoDaCategoryGames() {
		given()
			.contentType("application/json")
		.when()
			.get("/products/category/games")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot GET /products/category/games"))
		;
	}
	
	@Test
	public void ct_21_criarNovoProduto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(201)
			.body("id", is(21))
			.body("title", is("product fake"))
			.body("price", is(11.2f))
			.body("category", is("electronic"))
		;
	}
	
	@Test
	public void ct_22_criarNovoProdutoComCategoryInexistente() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Category doesnt exist"))
		;
	}
	
	@Test
	public void ct_23_criarNovoProdutoComCategoryVazia() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Category cannot be empty"))
		;
	}
	
	@Test
	public void ct_24_criarNovoProdutoComPriceVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": \"\", \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price cannot be empty"))
		;
	}
	
	@Test
	public void ct_25_criarNovoProdutoComPriceNegativo() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": -11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"games\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void ct_26_criarNovoProdutoComTituloVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Title cannot be empty"))
		;
	}
	
	@Test
	public void ct_27_criarNovoProdutoComTituloAcimaDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Apple MacBook Pro 13-inch M1 Chip with 8-Core CPU and 8-Core GPU, 16GB RAM, 512GB SSD - Space Gray\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Maximum number of characters reached"))
		;
	}
	
	@Test
	public void ct_28_criarNovoProdutoComTituloAbaixoDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"mac\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Minimum number of characters not reached."))
		;
	}
	
	@Test
	public void ct_29_criarNovoProdutoComTituloContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 25, \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void ct_30_criarNovoProdutoComTituloContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 10.5, \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"macbook.jpg\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void ct_31_criarNovoProdutoComImageContendoArquivoComExtensaoIncompativel() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.mp4\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}

	@Test
	public void ct_32_criarNovoProdutoComImageContendoArquivoSemExtensao() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_33_criarNovoProdutoComImageVazia() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"\", \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Image cannot be empty"))
		;
	}
	
	@Test
	public void ct_34_criarNovoProdutoComImageContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": 1, \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_35_criarNovoProdutoComImageContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product gamer fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": 2.5, \"category\": \"electronic\"}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_36_criarNovoProdutoComCategoryContendoNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": 2.5}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void ct_37_criarNovoProdutoComCategoryContendoNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"product fake\", \"price\": 11.2, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": 1}")
		.when()
			.post("/products")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void ct_38_atualizarProdutoAlterandoPrice() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 100.5, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("title", Matchers.startsWith("Fjallraven"))
			.body("price", is(100.5f))
			.body("image", is("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"))
			.body("category", is("Men’s clothing"))
		;
	}
	
	@Test
	public void ct_39_atualizarProdutoAlterandoPriceParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price cannot be empty"))
		;
	}
	
	@Test
	public void ct_40_atualizarProdutoAlterandoPriceParaNegativo() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": -109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void ct_41_atualizarProdutoAlterandoPriceParaZero() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 0, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void ct_42_atualizarProdutoAlterandoPriceValorDentroDeString() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"109.95\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void ct_43_atualizarProdutoAlterandoPriceParaTexto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"texto\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid price"))
		;
	}
	
	@Test
	public void ct_44_atualizarProdutoAlterandoPriceParaValorAlto() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": \"9999999999999\", \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Price is too high."))
		;
	}
	
	@Test
	public void ct_45_atualizarProdutoAlterandoTituloParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Title cannot be empty"))
		;
	}
	
	@Test
	public void ct_46_atualizarProdutoAlterandoTituloParaAcimaDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Apple MacBook Pro 13-inch M1 Chip with 8-Core CPU and 8-Core GPU, 16GB RAM, 512GB SSD - Space Gray\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Maximum number of characters reached."))
		;
	}
	
	@Test
	public void ct_47_atualizarProdutoAlterandoTituloParaAbaixoDoLimite() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"mac\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Minimum number of characters not reached."))
		;
	}
	
	@Test
	public void ct_48_atualizarProdutoAlterandoTituloParaNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 1, \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void ct_49_atualizarProdutoAlterandoTituloParaNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": 2.5, \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid title"))
		;
	}
	
	@Test
	public void ct_50_atualizarProdutoAlterandoImageParaSemExtensao() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_51_atualizarProdutoAlterandoImageParaExtensaoIncompativel() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.xyz\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_52_atualizarProdutoAlterandoImageParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": \"\", \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Image cannot be empty"))
		;
	}
	
	@Test
	public void ct_53_atualizarProdutoAlterandoImageParaNumeroInteiro() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": 1, \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_54_atualizarProdutoAlterandoImageParaNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst\", \"price\": 109.95, \"description\": "
					+ "\"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday\", "
					+ "\"image\": 1.5, \"category\": \"Men’s clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Invalid image"))
		;
	}
	
	@Test
	public void ct_55_atualizarProdutoAlterandoCategoryParaJewelery() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Jewelery\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("id", Matchers.notNullValue())
			.body("title", is("Product fake"))
			.body("price", is(109.95f))
			.body("category", is("Jewelery"))
		;
	}
	
	@Test
	public void ct_56_atualizarProdutoAlterandoCategoryParaElectronic() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Electronic\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("id", Matchers.notNullValue())
			.body("title", is("Product fake"))
			.body("price", is(109.95f))
			.body("category", is("Electronic"))
		;
	}
	
	@Test
	public void ct_57_atualizarProdutoAlterandoCategoryParaMensClothing() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Men's clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("id", Matchers.notNullValue())
			.body("title", is("Product fake"))
			.body("price", is(109.95f))
			.body("category", is("Men's clothing"))
		;
	}
	
	@Test
	public void ct_58_atualizarProdutoAlterandoCategoryParaWomensClothing() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Women's clothing\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("id", Matchers.notNullValue())
			.body("title", is("Product fake"))
			.body("price", is(109.95f))
			.body("category", is("Women's clothing"))
		;
	}
	
	@Test
	public void ct_59_atualizarProdutoAlterandoCategoryParaVazio() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(400)
			.body("msg", is("error"))
			.body("message", is("Category cannot be empty"))
		;
	}
	
	@Test
	public void ct_60_atualizarProdutoAlterandoCategoryParaSports() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Sports\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("id", Matchers.notNullValue())
			.body("title", is("Product fake"))
			.body("price", is(109.95f))
			.body("category", is("Sports"))
		;
	}
	
	@Test
	public void ct_61_atualizarProdutoAlterandoCategoryParaGames() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": \"Games\"}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void ct_62_atualizarProdutoAlterandoCategoryParaNumeroDecimal() {
		given()
			.contentType("application/json")
			.body("{ \"title\": \"Product fake\", \"price\": 109.95, \"description\": \"lorem ipsum set\", \"image\": \"productFake.jpg\", \"category\": 1.5}")
		.when()
			.put("/products/1")
		.then()
			.statusCode(200)
			.body("msg", is("error"))
			.body("message", is("Invalid category"))
		;
	}
	
	@Test
	public void ct_63_deletarProduto1() {
		given()
			.contentType("application/json")
		.when()
			.delete("/products/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("price", is(109.95f))
			.body("title", startsWith("Fjallraven"))
			.body("category", is("men's clothing"))
		;
	}
	
	@Test
	public void ct_64_deletarProduto0() {
		given()
			.contentType("application/json")
		.when()
			.delete("/products/0")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /product/0"))
		;
	}
	
	@Test
	public void ct_65_deletarProduto999() {
		given()
			.contentType("application/json")
		.when()
			.delete("/products/999")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /product/999"))
		;
	}
	
	@Test
	public void ct_66_deletarProdutoA() {
		given()
			.contentType("application/json")
		.when()
			.delete("/products/a")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
	
	@Test
	public void ct_67_deletarProdutoSimbolo() {
		given()
			.contentType("application/json")
		.when()
			.delete("/products/#")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("cart id should be provided"))
		;
	}
}
