package com.erp.repository.master;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erp.domain.master.AddressMaster;

public interface AddressMasterRepository extends JpaRepository<AddressMaster, Long>{

	@Modifying
	@Query("update AddressMaster am set am.isActive = false,am.modifiedDate = NOW() where am.id =:id")
	public int setInActive(@Param("id") Long id);
	
	@Query( "from AddressMaster am where isActive=true" )
	List<AddressMaster> listAll();
	
	@Query( "from AddressMaster am where isActive=true" )
	public List<AddressMaster> listByRange(Pageable pageable);
}
