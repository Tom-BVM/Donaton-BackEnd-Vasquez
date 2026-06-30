package com.donaton.MicroS_Logistica.Controller;

import com.donaton.MicroS_Logistica.Model.Envio;
import com.donaton.MicroS_Logistica.Service.EnvioService;
import com.donaton.MicroS_Logistica.Controller.EnvioController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LogisticaControllerTest {

    @Mock
    private EnvioService envioService;

    @InjectMocks
    private EnvioController envioController; // Inyectamos tu clase real EnvioController

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarDeberiaRetornarListaDeEnvios() {
        Envio e1 = new Envio();
        when(envioService.listarTodos()).thenReturn(Arrays.asList(e1));

        List<Envio> resultado = envioController.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(envioService, times(1)).listarTodos();
    }

    @Test
    void obtenerDeberiaRetornarEnvioSiExiste() {
        Envio envio = new Envio();
        when(envioService.buscarPorId(1L)).thenReturn(Optional.of(envio));

        Envio resultado = envioController.obtener(1L);

        assertNotNull(resultado);
        verify(envioService, times(1)).buscarPorId(1L);
    }

    @Test
    void obtenerDeberiaRetornarNullSiNoExiste() {
        when(envioService.buscarPorId(1L)).thenReturn(Optional.empty());

        Envio resultado = envioController.obtener(1L);

        assertNull(resultado);
        verify(envioService, times(1)).buscarPorId(1L);
    }

    @Test
    void crearDeberiaRetornarEnvioCreado() {
        Envio envioInput = new Envio();
        when(envioService.guardar(any(Envio.class))).thenReturn(envioInput);

        Envio resultado = envioController.crear(envioInput);

        assertNotNull(resultado);
        verify(envioService, times(1)).guardar(envioInput);
    }

    @Test
    void eliminarDeberiaInvocarMetodoService() {
        doNothing().when(envioService).eliminar(1L);

        envioController.eliminar(1L);

        verify(envioService, times(1)).eliminar(1L);
    }
}
