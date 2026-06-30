package com.Donaton.MicroS_donaciones.Service;

import com.Donaton.MicroS_donaciones.Model.Donacion;
import com.Donaton.MicroS_donaciones.Repository.DonacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {

    private final DonacionRepository donacionRepository;

    public DonacionService(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    public List<Donacion> listarTodas() {
        return donacionRepository.findAll();
    }

    public Optional<Donacion> buscarPorId(Long id) {
        return donacionRepository.findById(id);
    }

    public Donacion guardar(Donacion donacion) {
        return donacionRepository.save(donacion);
    }

    public void eliminar(Long id) {
        donacionRepository.deleteById(id);
    }
}
