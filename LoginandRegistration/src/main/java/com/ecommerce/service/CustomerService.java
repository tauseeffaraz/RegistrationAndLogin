package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.constant.ExceptionConstant;
import com.ecommerce.constant.MessageConstant;
import com.ecommerce.dto.AddressDTO;
import com.ecommerce.dto.CustomerDTO;

import com.ecommerce.repo.CustomerRepository;

import com.ecommerce.validation.CustomerValidation;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	private static final Logger logs=LoggerFactory.getLogger( CustomerService.class);
    
	public CustomerDTO registerUser(CustomerDTO customer)
	{
		try
		{
			boolean validResponse=CustomerValidation.validate(customer);
			if(validResponse)
			{
				boolean emailExist=customerRepo.existsCustomerDTOByEmail(customer.getEmail());
				if(!emailExist)
				{
					customerRepo.save(customer);
					customer.setMessage(MessageConstant.USER_REGISTER_SUCCESSFULLY);
					
					  customer.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
					  }
				
			else
			{
				customer.setMessage(MessageConstant.YOUR_EMAIL_IS_ALREADY_REGISTER);
				customer.setStatusCode(-20);
			}
		}
			else
			{
				customer.setMessage(MessageConstant.PASSWORD_OR_EMAIL_STANDARD_IS_INCORRECT);
				customer.setStatusCode(-29);
			}
					 
			
			
			  }catch (Exception e) {  
				  logs.error("Exception in Register User!");
				  customer.setMessage(MessageConstant.EXCEPTION_REGISTER_USER);
			  }
			 
		return customer;
	}
	public CustomerDTO loginUser(CustomerDTO customer)
	{
		boolean validRequest=CustomerValidation.loginValidate(customer);
		CustomerDTO customerdto=new CustomerDTO();
	
		if(validRequest)
		{
			try
			{
		CustomerDTO	customerDTO=customerRepo.findCustomerDTOByEmailAndPasswordAndUserType(customer.getEmail(),customer.getPassword(),customer.getUserType());
			customerdto.setId(customerDTO.getId());
			customerdto.setName(customerDTO.getName());
			customerdto.setEmail(customerDTO.getEmail());
			customerdto.setAddressess(customerDTO.getAddressess());
			customerdto.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
			customerdto.setMessage(MessageConstant.LOGIN_SUCCESSFULLY);
			
			  }catch (Exception e) { logs.error("Excepion in login User");
			  customerdto.setMessage(MessageConstant.EMAIL_NOT);
			  
			  }	
		}
		else
		{
			customerdto.setMessage(MessageConstant.INVALID_REQUEST);
			customerdto.setStatusCode(-30);
		}
		return customerdto;
	}
	public List<CustomerDTO> users()
	{
		List<CustomerDTO> response=new ArrayList<CustomerDTO>();
		CustomerDTO customer=new CustomerDTO();
		response=customerRepo.findAll();
		customer.setMessage(MessageConstant.USER_RETRIVED);
		response.add(customer);
		customer.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
		response.add(customer);
		return response;
	
	}
	public CustomerDTO updateCustomer(CustomerDTO product)
	{ 
		CustomerDTO response=new CustomerDTO();
		CustomerDTO productDto=customerRepo.findById(product.getId());
		productDto.setName(product.getName());
		productDto.setMobile(product.getMobile());
		productDto.setEmail(product.getEmail());
		productDto.setOtp(product.getOtp());
		productDto.setGender(product.getGender());
		productDto.setUserType(product.getUserType());
		productDto.setPassword(product.getPassword());
		List<AddressDTO> productImages = productDto.getAddressess();
		for(AddressDTO image: productImages) {
			for(AddressDTO productImage: product.getAddressess()) {

				if(image.getAddressId() == productImage.getAddressId()) {
					image.setHouseDetails(productImage.getHouseDetails());
					image.setCity(productImage.getCity());
					image.setState(productImage.getState());
					image.setCountry(productImage.getCountry());
					image.setZipCode(productImage.getZipCode());
					break;
				}
			}

		}
		productDto.setAddressess(productImages);

		CustomerDTO productdto=customerRepo.save(productDto);
		if(productdto!=null)
		{
			response.setMessage(MessageConstant.USER_UPDATE_SUCCESSFULLY);
			response.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
		}
		else
		{
			response.setMessage(MessageConstant.USER_UPDATE_FAILED);
			response.setStatusCode(-30);
		}

		return response;
	}
	public List<CustomerDTO> customers(String customer)
	{
		CustomerDTO customerDTO=new CustomerDTO();
		List<CustomerDTO> customerDto=customerRepo.findByUserType(customer);
		
				customerDTO.setMessage(MessageConstant.USER_RETRIVED_USERTYPE);
			customerDTO.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
			customerDto.add(customerDTO);		
		
		
		
		return customerDto;
		
		
	}
   public CustomerDTO custom(int id)
   {
	   CustomerDTO customer=new CustomerDTO();
	   try
	   {
		   customer=customerRepo.findById(id);
		   customer.setMessage(MessageConstant.USER_ID);
		   customer.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
	   }
	   catch(Exception e)
	   {
		   logs.error("Excpetion in getting user by id");
		   customer.setMessage(MessageConstant.EXCEPTIION_USERID);
	   }
	   return customer;
   }
   public CustomerDTO deleteuser(int id)
   {
	   CustomerDTO customer=new CustomerDTO();
	   customerRepo.deleteById(id);
	   customer.setMessage(MessageConstant.USER_REMOVED_SUCCESSFULLY);
	   customer.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
	   return customer;
   }
   public CustomerDTO changePassword(CustomerDTO custumer)
   {
	   CustomerDTO requset=new CustomerDTO();

	   CustomerDTO custumerDTO=new CustomerDTO();
	 
		  custumerDTO =customerRepo.findCustomerDTOByEmail(custumer.getEmail());
		 /* if(custumerDTO.getEmail().equals(custumer.getEmail()))
		  {*/
			  custumerDTO.setPassword(custumer.getPassword());
			  // CustomerDTO response=
					   customerRepo.save(custumerDTO);
			   requset.setMessage("password changed Successfully");
			   requset.setStatusCode(ExceptionConstant.SUCCESS_STATUS);
				/*
				 * } else { requset.setMessage("password cannot changed");
				 * requset.setStatusCode(-78); }
				 */
	
	  return requset; 
	  
   }

}
