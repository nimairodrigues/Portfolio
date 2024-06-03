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
			.body("id", Matchers.greaterThan(0))
		;
	}
	
}
