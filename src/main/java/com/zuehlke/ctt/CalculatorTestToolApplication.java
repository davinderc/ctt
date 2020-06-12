package com.zuehlke.ctt;

import org.aspectj.weaver.ast.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class CalculatorTestToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorTestToolApplication.class, args);
	}

	@Bean
	public ApplicationRunner init(TestCaseRepository testCaseRepository, TestSuiteRepository testSuiteRepository) {
		return args -> {
			for(int testSuiteIndex = 0; testSuiteIndex < 10; testSuiteIndex++)
			{
				TestSuite testSuite = new TestSuite( "SUITE");

				for(int testCaseIndex = 0; testCaseIndex < 5; testCaseIndex++) {
					var operand1 = (long)(10*Math.random());
					var operand2 = (long)(10*Math.random());
					var operand3 = (long)(10*Math.random());
					var expectedResult = operand1 + operand2 + operand3;

					TestCase testCase = new TestCase("CASE", Arrays.asList(operand1, operand2, operand3), expectedResult);
					testCase.setTestSuite(testSuite);
					testSuite.getTestCases().add(testCase);
				}
				testSuiteRepository.save(testSuite);
			}
		};
	}

}
