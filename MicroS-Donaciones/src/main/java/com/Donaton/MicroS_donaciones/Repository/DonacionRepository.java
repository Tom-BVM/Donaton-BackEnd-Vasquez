package com.Donaton.MicroS_donaciones.Repository;

import com.Donaton.MicroS_donaciones.Model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}
