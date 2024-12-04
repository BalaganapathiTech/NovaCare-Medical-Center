package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

@Tag(name = "Record: Doctor - Rest API Controllers", description = "Doctor Record API")
@RepositoryRestResource(collectionResourceRel = "doctor", path = "doctor")
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	public Doctor findByEmail(@Param("email") String email);

}
