package com.ecommerce.rest.services;

import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;


import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.service.CustomerService;


@CrossOrigin
@Path("/e_commerce")
public class RestAPI {
	
	@Autowired
	private CustomerService customerService;
	

	
	 
	 
	@Path("/registerUser")
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerDTO register(CustomerDTO customer) // throws Exception
	{
		return customerService.registerUser(customer);
	}

	@Path("/userLogin")
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerDTO loginUser(CustomerDTO customer) // throws Exception
	{
		return customerService.loginUser(customer);
	}

	@Path("/allusers")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CustomerDTO> allusers() {

		return customerService.users();
	}

	@Path("/updateUser")
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerDTO updatecust(CustomerDTO customer) {
		return customerService.updateCustomer(customer);
	}

	@Path("/userType/{user_type}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CustomerDTO> getUsers(@PathParam("user_type") String userType) {
		return customerService.customers(userType);
	}

	@Path("/userbyID/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerDTO customID(@PathParam("id") int id) {
		return customerService.custom(id);
	}

	@Path("/userDelete/{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerDTO deleteCustomer(@PathParam("id") int id) {
		return customerService.deleteuser(id);
	}

	
}
