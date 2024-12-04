package com.Nova.NovaCare.Medical.Center.Repository;

import com.Nova.NovaCare.Medical.Center.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

}
