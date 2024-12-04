package com.Nova.NovaCare.Medical.Center.Configuration;
import com.Nova.NovaCare.Medical.Center.Entity.*;
import com.Nova.NovaCare.Medical.Center.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		List<Doctor> docs = doctorRepository.findAll();
		List<Patient> pats = patientRepository.findAll();

		List<UserDetails> doctors = new ArrayList<>();
		List<UserDetails> patients = new ArrayList<>();

		for (Doctor doc : docs) {
			doctors.add(User.withUsername(doc.getEmail())
					.password(encoder.encode(doc.getLogin_password()))
					.roles("USER")
					.build());
		}

		for (Patient pat : pats) {
			patients.add(User.withUsername(pat.getEmail())
					.password(encoder.encode(pat.getLogin_password()))
					.roles("USER")
					.build());
		}

		Collection<UserDetails> allUsers = new ArrayList<>();
		allUsers.addAll(doctors);
		allUsers.addAll(patients);
		return new InMemoryUserDetailsManager(allUsers);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/")
						.permitAll())
				.logout(logout -> logout.permitAll())
				.authorizeHttpRequests(auth -> auth
						.anyRequest().authenticated())
				.build();
	}
}