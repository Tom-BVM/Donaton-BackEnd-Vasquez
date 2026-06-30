package com.donaton.MicroS_Logistica.Service;

import com.donaton.MicroS_Logistica.Model.Envio;
import com.donaton.MicroS_Logistica.Repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }

    public Optional<Envio> buscarPorId(Long id) {
        return envioRepository.findById(id);
    }

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    public void eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}
