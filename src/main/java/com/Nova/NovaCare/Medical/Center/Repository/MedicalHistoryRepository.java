package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.List;

@Tag(name = "Medical History - Rest API Controllers", description = "Medical History API")
@RepositoryRestResource(collectionResourceRel = "medical_history", path = "medical_history")
public interface MedicalHistoryRepository extends JpaRepository<Medical_History, Integer> {
	public List<Medical_History> findByPatientId(@Param("id") int id);

}