package com.intuit.jmeter.gencc;

import com.anands.jmeter.gencc.functions.RandomCreditCardNumberGenerator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
	
	public void testLength() {
		final String[] ccList = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.AMEX_PREFIX_LIST, 15, 5);
		assertEquals(ccList.length, 5);
	}

	
	public void testAMEX() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.AMEX_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testVISA() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.VISA_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testMASTERCARD() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.MASTERCARD_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testDISCOVER() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.DISCOVER_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testENROUTE() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.ENROUTE_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testJCB() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.JCB_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testVOYAGER() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.VOYAGER_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
	
	public void testDINERS() {
		final String cc = RandomCreditCardNumberGenerator.credit_card_number(RandomCreditCardNumberGenerator.DINERS_PREFIX_LIST, 15, 1)[0];
		assertTrue(RandomCreditCardNumberGenerator.isValidCreditCardNumber(cc));
	}
}
