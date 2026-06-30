package com.donaton.MicroS_Logistica.Service;

import com.donaton.MicroS_Logistica.Model.Envio;
import com.donaton.MicroS_Logistica.Repository.EnvioRepository;
import com.donaton.MicroS_Logistica.Service.EnvioService;

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

class LogisticaServiceTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioService envioService; // Inyectamos tu clase real EnvioService

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodosDeberiaRetornarLista() {
        Envio e1 = new Envio();
        Envio e2 = new Envio();
        when(envioRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Envio> resultado = envioService.listarTodos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(envioRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdDeberiaRetornarEnvio() {
        Envio envio = new Envio();
        when(envioRepository.findById(1L)).thenReturn(Optional.of(envio));

        Optional<Envio> resultado = envioService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        verify(envioRepository, times(1)).findById(1L);
    }

    @Test
    void guardarDeberiaRetornarEnvioGuardado() {
        Envio envioInput = new Envio();
        when(envioRepository.save(any(Envio.class))).thenReturn(envioInput);

        Envio resultado = envioService.guardar(envioInput);

        assertNotNull(resultado);
        verify(envioRepository, times(1)).save(envioInput);
    }

    @Test
    void eliminarDeberiaInvocarDeleteById() {
        doNothing().when(envioRepository).deleteById(1L);

        envioService.eliminar(1L);

        verify(envioRepository, times(1)).deleteById(1L);
    }
}
