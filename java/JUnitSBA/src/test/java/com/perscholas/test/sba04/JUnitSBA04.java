package com.perscholas.test.sba04;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.perscholas.test.sba01.JUnitSBA01;
import com.perscholas.test.sba02.JUnitSBA02;
import com.perscholas.test.sba03.JUnitSBA03;

@RunWith(Suite.class)
@SuiteClasses({JUnitSBA01.class,
		JUnitSBA02.class,
		JUnitSBA03.class})
public class JUnitSBA04 {
	
}