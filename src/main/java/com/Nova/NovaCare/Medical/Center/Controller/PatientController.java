package com.Nova.NovaCare.Medical.Center.Controller;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import com.Nova.NovaCare.Medical.Center.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("patient")
public class PatientController {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	PrescriptionRepository prescriptionRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	MedicalHistoryRepository historyRepository;

	@GetMapping({ "{patientId}" })
	public String welcome(@PathVariable("patientId") int patientId, Model model) {
		String name = patientRepository.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		return "index";
	}

	@GetMapping({ "doctordetails" })
	public String getDoctorDetails(Model model) {
		List<Doctor> doctors = doctorRepository.findAll();
		model.addAttribute("doctors", doctors);
		return "doctor_details";
	}
	@GetMapping({ "bookappointment/{patientId}" })
	public String getPatientAppointmentBook(@PathVariable("patientId") int patientId, Model model) {
		Appointment appointment = new Appointment();
		appointment.setPatientId(patientId);

		Patient patient = patientRepository.findById(patientId).get();

		List<Doctor> doctors = doctorRepository.findAll();

		model.addAttribute("appointmentForm", appointment);
		model.addAttribute("doctors", doctors);
		model.addAttribute("patient", patient);
		return "appointment_book";
	}

	@PostMapping("/bookappointment/save")
	public String postAppointmentBook(@ModelAttribute Appointment appointment, Model model) {
		appointmentRepository.save(appointment);
		int id = appointment.getPatientId();
		return "redirect:/patient/" + id;
	}

	@GetMapping({"checkappointment/{patientId}" })
	public String getAppointmentCheck(@PathVariable("patientId") int patientId, Model model) {

		List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
		model.addAttribute("appointments", appointments);
		String name = patientRepository.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		return "appointment_check";
	}
	@GetMapping({ "checkprescription/{patientId}" })
	public String getPrescriptionCheck(@PathVariable("patientId") int patientId, Model model) {
		List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
		model.addAttribute("prescriptions", prescriptions);

		String name = patientRepository.findById(patientId).get().getPatient_name();
		model.addAttribute("id", patientId);
		model.addAttribute("name", name);
		return "prescription_check";
	}
	@GetMapping({ "medicalhistory/{patientId}" })
	public String getMedicalHistory(@PathVariable("patientId") int patientId, Model model) {
		model.addAttribute("patient", patientRepository.findById(patientId).get());

		List<Medical_History> medHistory = historyRepository.findByPatientId(patientId);
		model.addAttribute("history", medHistory);

		return "Medical_history";
	}
}