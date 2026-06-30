package com.donaton.MicroS_Logistica.Controller;

import com.donaton.MicroS_Logistica.Model.Envio;
import com.donaton.MicroS_Logistica.Service.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logistica")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping("/envio")
    public Envio crear(@RequestBody Envio envio) {
        return envioService.guardar(envio);
    }

    @GetMapping("/envios")
    public List<Envio> listar() {
        return envioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id) {
        return envioService.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        envioService.eliminar(id);
    }
}
