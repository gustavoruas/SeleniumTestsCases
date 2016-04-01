package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalculoDecTer.class, CalculoRecisaoTests.class,
		CalculoSalBruto.class })
public class AllTests {

}
