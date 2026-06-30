package com.donaton.MicroS_Necesidades.Repository;

import com.donaton.MicroS_Necesidades.Model.Necesidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecesidadRepository extends JpaRepository<Necesidad, Long> {
}
