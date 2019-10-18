package com.perscholas.exercisetests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProductTests.class,
		ShoppingCartTests.class,
		PaymentTests.class})
public class ProductionSuiteOne {
	
}
