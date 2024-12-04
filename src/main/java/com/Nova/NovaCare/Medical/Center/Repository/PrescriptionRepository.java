package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.List;

@Tag(name = "Prescription History - Rest API Controllers", description = "Prescription API")
@RepositoryRestResource(collectionResourceRel = "prescription", path = "prescription")
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	public List<Prescription> findByPatientId(@Param("id") int id);

	public List<Prescription> findByDoctorId(@Param("id") int id);
}
