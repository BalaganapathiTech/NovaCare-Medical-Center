package com.Nova.NovaCare.Medical.Center.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "prescription")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Prescription.PatientId", query = "from prescription where patientId =:id")
@NamedQuery(name = "Prescription.DoctorId", query = "from prescription where doctorId =:id")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescription_id;

	@Column(name = "prescription_doctor_id")
	private int doctorId;

	@Column(name = "prescription_patient_id")
	private int patientId;

	@PastOrPresent
	@Column(name = "issued_date_time")
	private LocalDateTime issuedDateTime;
	
	private String findings;
	
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
	private String medicines;
	
}
