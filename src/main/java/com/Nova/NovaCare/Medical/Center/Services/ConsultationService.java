package com.Nova.NovaCare.Medical.Center.Services;

import com.Nova.NovaCare.Medical.Center.Entity.Consultation;
import com.Nova.NovaCare.Medical.Center.Repository.ConsultationRepository;
import com.Nova.NovaCare.Medical.Center.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.Nova.NovaCare.Medical.Center.Entity.Doctor;
import com.Nova.NovaCare.Medical.Center.Entity.Patient;
import com.Nova.NovaCare.Medical.Center.Repository.PatientRepository;


@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    LocalDateTime localDateTime = LocalDateTime.now();  // Get current date and time
    LocalDate localDate = localDateTime.toLocalDate();

    public Consultation bookConsultation(int patientId, int doctorId, LocalDateTime consultationDate, String notes) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Consultation consultation = new Consultation();
        consultation.setPatient(patient);
        consultation.setDoctor(doctor);
        consultation.setConsultationDate(localDate);  // Use localDate here, not localDateTime
        consultation.setNotes(notes);
        return consultationRepository.save(consultation);
    }
}
