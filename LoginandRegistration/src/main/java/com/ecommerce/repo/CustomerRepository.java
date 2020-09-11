package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ecommerce.dto.CustomerDTO;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer>
{
    CustomerDTO findById(int id);
    boolean existsCustomerDTOByEmail(String email);
   // CustomerDTO findCustomerDTOByEmailAndPassword(String email,String password);
	List<CustomerDTO> findByUserType(String customer);
	CustomerDTO findCustomerDTOByEmail(String email);
	CustomerDTO findCustomerDTOByEmailAndPasswordAndUserType(String email, String password, String userType);
  
}
