package br.am.nimai.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.am.nimai.test.AdminTest;
import br.am.nimai.test.BuzzTest;
import br.am.nimai.test.LoginTest;
import br.am.nimai.test.PIMTest;
import br.am.nimai.test.RecruitmentTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	AdminTest.class,
	PIMTest.class,
//	BuzzTest.class,
//	RecruitmentTest.class
})
public class SuiteGeral {
	
}
