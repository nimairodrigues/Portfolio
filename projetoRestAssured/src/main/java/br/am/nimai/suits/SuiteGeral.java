package br.am.nimai.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.am.nimai.rest.ProductsTest;
import br.am.nimai.rest.UsersTest;

@RunWith(Suite.class)
@SuiteClasses({
	ProductsTest.class,
	UsersTest.class
})
public class SuiteGeral {
	
	
}
