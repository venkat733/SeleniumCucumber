package com.Parabank;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookCLass {
	@Before
	public static void setUp() {
		HelperClass.setUpDriver();
	}
	@After
	public static void tearDown(Scenario scenario) {
		HelperClass.tearDown();
	}


}
