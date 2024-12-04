package com.Nova.NovaCare.Medical.Center.Controller;

import com.Nova.NovaCare.Medical.Center.Entity.Consultation;
import com.Nova.NovaCare.Medical.Center.Services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/index")
    public String indexPage(Model model) {
        int patientId =34 ; // Replace with dynamic patient ID, such as from session or database
        model.addAttribute("patientId", patientId);
        return "index";
    }

    @GetMapping("/consultations/{patientId}")
    public String bookConsultation(@PathVariable int patientId) {
        return "bookConsultationPage";
    }
    @PostMapping("/book")
    public String bookConsultation(@RequestParam int patientId,
                                   @RequestParam int doctorId,
                                   @RequestParam String date,
                                   @RequestParam String notes,
                                   Model model) {
        LocalDateTime consultationDate = LocalDateTime.parse(date);

        Consultation consultation = consultationService.bookConsultation(patientId, doctorId, consultationDate, notes);
        model.addAttribute("consultation", consultation);

        return "consultationDetails";
    }
}
