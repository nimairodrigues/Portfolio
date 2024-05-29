package br.am.nimai.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class ProductsTest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://fakestoreapi.com";
	}
	
	
	@Test
	public void solicitarTodosOsProdutos() {
		given()
			.log().all()
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
			.log().all()
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
	public void test() {
		given()
			.log().all()
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
			.log().all()
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
}
