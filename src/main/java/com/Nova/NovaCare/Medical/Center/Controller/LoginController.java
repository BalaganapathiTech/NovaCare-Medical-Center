package com.Nova.NovaCare.Medical.Center.Controller;

import com.Nova.NovaCare.Medical.Center.Entity.*;
import com.Nova.NovaCare.Medical.Center.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class LoginController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping({"/"})
    public String loggedIn(@AuthenticationPrincipal User user, Model model) {
        String username = user.getUsername();

        String url = "";
        if (doctorRepository.findByEmail(username) != null) {
            Doctor doc = doctorRepository.findByEmail(username);
            long docId = doc.getDoctor_id();
            url = "redirect:/doctor/" + docId;
        } else if (patientRepository.findByEmail(username) != null) {
            Patient pat = patientRepository.findByEmail(username);
            int patId = pat.getPatient_id();
            url = "redirect:/patient/" + patId;
        }
        return url;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "redirect:/dashboard";
    }
}
