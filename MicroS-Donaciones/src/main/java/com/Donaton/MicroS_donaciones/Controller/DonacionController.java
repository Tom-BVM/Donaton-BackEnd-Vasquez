package com.Donaton.MicroS_donaciones.Controller;

import com.Donaton.MicroS_donaciones.Model.Donacion;
import com.Donaton.MicroS_donaciones.Service.DonacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"}, allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/api/donaciones")
public class DonacionController {

    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping
    public List<Donacion> listar() {
        return donacionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Donacion obtener(@PathVariable Long id) {
        return donacionService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Donacion crear(@RequestBody Donacion donacion) {
        return donacionService.guardar(donacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        donacionService.eliminar(id);
    }
}
