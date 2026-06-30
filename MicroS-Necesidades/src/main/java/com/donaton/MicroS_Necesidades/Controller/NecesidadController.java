package com.donaton.MicroS_Necesidades.Controller;

import com.donaton.MicroS_Necesidades.Model.Necesidad;
import com.donaton.MicroS_Necesidades.Service.NecesidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/necesidades")
public class NecesidadController {

    private final NecesidadService necesidadService;

    public NecesidadController(NecesidadService necesidadService) {
        this.necesidadService = necesidadService;
    }

    @GetMapping
    public List<Necesidad> listar() {
        return necesidadService.listarTodas();
    }

    @GetMapping("/{id}")
    public Necesidad obtener(@PathVariable Long id) {
        return necesidadService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Necesidad crear(@RequestBody Necesidad necesidad) {
        return necesidadService.guardar(necesidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        necesidadService.eliminar(id);
    }
}
