package br.am.nimai.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class UsersTest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
	}
	
	@Test
	public void ct_68_solicitarListaDeUsuarios() {
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.body("id", hasSize(10))
			.body("username", hasSize(10))
			.body("name", hasSize(10))
		;
	}
	
	@Test
	public void ct_69_solicitarUsuario1() {
		given()
		.when()
			.get("/users/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("username", notNullValue())
			.body("name", notNullValue())
		;
	}
	
	@Test
	public void ct_70_solicitarUsuario0() {
		given()
		.when()
			.get("/users/0")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /users/0"))
		;
	}
	
	@Test
	public void ct_71_solicitarUsuarioB() {
		given()
		.when()
			.get("/users/b")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /users/b"))
		;
	}
	
	@Test
	public void ct_72_solicitarUsuario9999() {
		given()
		.when()
			.get("/users/9999")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /users/9999"))
		;
	}
	
	@Test
	public void ct_73_solicitarUsuario1B() {
		given()
		.when()
			.get("/users/1b")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /users/1b"))
		;
	}
	
	@Test
	public void ct_74_solicitarUsuarioSimbolo() {
		given()
		.when()
			.get("/users/#")
		.then()
			.statusCode(404)
			.body("msg", is("error"))
			.body("message", is("Cannot DELETE /users/#"))
		;
	}
}
