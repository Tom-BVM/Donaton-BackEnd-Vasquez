package com.donaton.MicroS_Logistica.Repository;

import com.donaton.MicroS_Logistica.Model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
}
