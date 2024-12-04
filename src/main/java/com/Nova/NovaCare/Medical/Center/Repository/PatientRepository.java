package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

@Tag(name = "Record: Patient - Rest API Controllers", description = "Patient Record API")
@RepositoryRestResource(collectionResourceRel = "patient", path="patient")
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Patient findByEmail(@Param("email") String email);
}