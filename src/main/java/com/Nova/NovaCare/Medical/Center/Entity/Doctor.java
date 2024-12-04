package com.Nova.NovaCare.Medical.Center.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonIgnoreProperties()
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;

	@NotEmpty
	@Size(min = 2, max = 24, message = "Doctor name")
	private String doctor_name;

	@NotEmpty
	@Past
	private LocalDate dob;

	@NotEmpty
	private String specialization;

	@NotEmpty
	private String sex;

	@NotEmpty
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String mobile_no;

	@NotEmpty
	@Size(min = 15, max = 100, message = "Door No, Street, Area, City, State")
	private String address;

	@NotEmpty
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;

	@NotEmpty
	private String login_password;
}
