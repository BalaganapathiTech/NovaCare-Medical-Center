//package com.Nova.NovaCare.Medical.Center.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//
//@Entity
//@Table
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Consultation {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int consultation_id;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;
//
//    @Column(name = "consultation_date")
//    private Date consultationDate;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;
//
//    @Column(name = "consultation_date", insertable = false, updatable = false)
//    private LocalDate consultationDate;  // Store LocalDateTime
//
//    @Column(length = 500)
//    private String notes;
//
//    // Getters and setters
//    public LocalDateTime getConsultationDateTime() {
//        return consultationDate;
//    }
//
////    public void setConsultationDate(Date consultationDate) {
////        this.consultationDate = consultationDate;
////        this.consultationDate = consultationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // Convert to LocalDateTime
////    }
////
////    public void setConsultationDateTime(LocalDateTime consultationDateTime) {
////        this.consultation_date = consultationDateTime;
////    }
//
//    public Date getConsultationDate() {
//        return consultationDate;
//    }
//
//    public void setConsultationDate(LocalDateTime localDateTime) {
//        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//        this.consultationDate = date;
//    }
//}


package com.Nova.NovaCare.Medical.Center.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "consultations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private Long consultationId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "consultation_date", insertable = false, updatable = false)
    private LocalDate consultationDate;

    @Column(name = "consultation_time", nullable = false)
    private LocalTime consultationTime;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "notes")
    private String notes;

    @Column(name = "consultation_type")
    private String consultationType;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDate updatedAt;
}
