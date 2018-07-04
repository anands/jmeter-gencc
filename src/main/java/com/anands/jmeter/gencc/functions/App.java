package com.anands.jmeter.gencc.functions;

// Base template credits: http://www.testautomationguru.com/jmeter-extending-jmeter-creating-custom-functions/

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;

public class App extends AbstractFunction {

	private static final List<String> desc = new LinkedList<String>();
	private static final String FunctionName = "__GenerateCC";

	public App() {
	}

	private enum CC_ENUM {
		VISA("VISA"), MASTERCARD("MASTERCARD"), AMEX("AMEX"), DISCOVER("DISCOVER"), DINERS("DINERS"), ENROUTE(
				"ENROUTE"), JCB("JCB"), VOYAGER("VOYAGER");

		private final String CC_ENUM;

		private CC_ENUM(String CC_ENUM) {
			this.CC_ENUM = CC_ENUM;
		}
	}

	static {
		desc.add("CC Type (default: VISA)");
		desc.add("Name of variable in which to store the result (optional)");
	}

	private Object[] values;

	public List<String> getArgumentDesc() {
		return desc;
	}

	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {

		JMeterVariables vars = getVariables();

		String str1 = ((CompoundVariable) values[0]).execute().trim(); // parameter 1

		String result;

		try {
			switch (CC_ENUM.valueOf(str1)) {
			case VISA:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.VISA_PREFIX_LIST, 16, 1)[0];
				break;
			case MASTERCARD:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.MASTERCARD_PREFIX_LIST, 16, 1)[0];
				break;
			case AMEX:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.AMEX_PREFIX_LIST, 15, 1)[0];
				break;
			case DINERS:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.DINERS_PREFIX_LIST, 15, 1)[0];
				break;
			case DISCOVER:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.DISCOVER_PREFIX_LIST, 16, 1)[0];
				break;
			case ENROUTE:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.ENROUTE_PREFIX_LIST, 15, 1)[0];
				break;
			case JCB:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.JCB_PREFIX_LIST, 16, 1)[0];
				break;
			case VOYAGER:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.VOYAGER_PREFIX_LIST, 15, 1)[0];
				break;
			default:
				result = RandomCreditCardNumberGenerator
						.credit_card_number(RandomCreditCardNumberGenerator.VISA_PREFIX_LIST, 16, 1)[0];
				break;
			}
		} catch (IllegalArgumentException e) {
			result = RandomCreditCardNumberGenerator
					.credit_card_number(RandomCreditCardNumberGenerator.VISA_PREFIX_LIST, 16, 1)[0];
		}

		// user might want the result in a variable
		if (null != vars && values.length > 3) {
			String userVariable = ((CompoundVariable) values[1]).execute().trim();
			vars.put(userVariable, result); // store the result in the user defined variable
		}

		return result;
	}

	@Override
	public String getReferenceKey() {
		return FunctionName;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
		values = parameters.toArray();
	}
}