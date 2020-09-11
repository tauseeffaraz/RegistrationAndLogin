package com.ecommerce.validation;

import java.util.regex.Pattern;

import com.ecommerce.dto.CustomerDTO;


public class CustomerValidation
{

	public static boolean validate(CustomerDTO customer)
	{

		if (validateName(customer.getName()) && validateEmail(customer.getEmail()) && validatePassword(customer.getPassword())
				&& validateMoblie(customer.getMobile())) {
			return true;
		} else {
			return false;
		}
		
		
	}
	public static boolean loginValidate(CustomerDTO user) {

		if (validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {

			return true;
		} else {
			return false;
		}
	}

	private static boolean validateMoblie(String mobile) {
		String pattern = "(0/91)?[6-9][0-9]{9}";
		return Pattern.matches(pattern, mobile);
	}

	private static boolean validatePassword(String password) {

		String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{8,15})";

		return Pattern.matches(pattern, password);
	}

	private static boolean validateEmail(String email) {

		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		return Pattern.matches(pattern, email);
	}

	private static boolean validateName(String name) 
	{
		String pattern = "[a-zA-Z][a-zA-Z\\s]{1,25}";

	return Pattern.matches(pattern, name);
	}
	

}
