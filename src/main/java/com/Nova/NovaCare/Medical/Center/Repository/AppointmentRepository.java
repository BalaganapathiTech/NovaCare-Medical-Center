package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.List;

@Tag(name = "Appointment History - Rest API Controllers", description = "Appointment API")
@RepositoryRestResource(collectionResourceRel = "appointment", path = "appointment")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> findByPatientId(@Param("id") int id);

	public List<Appointment> findByDoctorId(@Param("id") int id);

}
