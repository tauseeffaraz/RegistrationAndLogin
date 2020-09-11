package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.dto.AddressDTO;
@Repository
public interface AddressRepository extends JpaRepository<AddressDTO, Integer>
{
	AddressDTO findByAddressId(int id);
	//boolean idExist(int id);
	boolean existsAddressDTOByAddressId(int id);
	
}
