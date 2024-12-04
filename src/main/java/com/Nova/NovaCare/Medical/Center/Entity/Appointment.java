package com.Nova.NovaCare.Medical.Center.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "appointment")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Appointment.PatientId", query = "from appointment where patientId =:id")
@NamedQuery(name = "Appointment.DoctorId", query = "from appointment where doctorId =:id")
@NamedQuery(name = "Appointment.DateSlot", query = "from appointment where doctorId =:id and visitDate =:vdate")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_id;
	@Column(name = "appointment_doctor_id")
	private int doctorId;
	@Column(name = "appointment_patient_id")
	private int patientId;
	@PastOrPresent
	@Column(name = "visit_date")
	private LocalDate visitDate;
	private int slot;
	private boolean booked;
}
