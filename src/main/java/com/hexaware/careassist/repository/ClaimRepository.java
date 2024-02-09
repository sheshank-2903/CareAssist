package com.hexaware.careassist.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.careassist.entities.Claims;

@Repository
public interface ClaimRepository extends JpaRepository<Claims, Long> {
	
		@Modifying
		@Query("update Claims c set c.claimStatus= :newStatus where c.claimId= :claimId")
		public void updateClaimStatus(@Param("newStatus") String newStatus, @Param("claimId") Long claimId);

		@Query("select c from Claims c where c.patient.patientId= :patientId")
		public List<Claims> findBypatientId(@Param("patientId") long patientId);
		
		@Query(value="select c from Claims c where c.claimStatus= :claimStatus && c.patientId=:patientId",nativeQuery=true)
		public List<Claims> getClaimByStatus(@Param("claimStatus") String claimStatus,@Param("patientId") Long patientId);

		@Query("select c from Claims c where c.plans.planId= :planId")
		public List<Claims> findByplanId(@Param("planId") long planId);

		
//		@Modifying
//		@Query("delete from Claims c where claimId= :deleteId")
//		public void updateClaimStatus(@Param("newStatus") String newStatus, @Param("claimId") Long claimId);
}
