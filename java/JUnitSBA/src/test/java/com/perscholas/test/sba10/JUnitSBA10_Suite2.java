package com.perscholas.test.sba10;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@ExcludeCategory(Daily.class)
@SuiteClasses({SchoolTests.class,
		StudentTests.class,
		InstructorTests.class})

public class JUnitSBA10_Suite2 {

}
