package com.estudo.email.repositories;

import com.estudo.email.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {


}
