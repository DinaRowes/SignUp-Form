package com.google.Selenium;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryRunner {

	@Test
	@Factory
	public Object []RunTests()
	{
		return new Object[] {new factoryValidSignUp(),new factoryInvalidSignup()};
	}
	
}
