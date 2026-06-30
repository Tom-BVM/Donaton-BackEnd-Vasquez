package com.donaton.MicroS_Necesidades.Service;

import com.donaton.MicroS_Necesidades.Model.Necesidad;
import com.donaton.MicroS_Necesidades.Repository.NecesidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NecesidadService {

    private final NecesidadRepository necesidadRepository;

    public NecesidadService(NecesidadRepository necesidadRepository) {
        this.necesidadRepository = necesidadRepository;
    }

    public List<Necesidad> listarTodas() {
        return necesidadRepository.findAll();
    }

    public Optional<Necesidad> buscarPorId(Long id) {
        return necesidadRepository.findById(id);
    }

    public Necesidad guardar(Necesidad necesidad) {
        return necesidadRepository.save(necesidad);
    }

    public void eliminar(Long id) {
        necesidadRepository.deleteById(id);
    }
}
