package br.am.nimai.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.am.nimai.test.ExplorerTest;
import br.am.nimai.test.LoginTest;
import br.am.nimai.test.ProfileTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	ExplorerTest.class,
	ProfileTest.class
})
public class SuiteGeral {

}
