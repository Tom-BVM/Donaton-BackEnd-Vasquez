package com.example.MicroS_donaciones.Controller;

import com.Donaton.MicroS_donaciones.Model.Donacion;
import com.Donaton.MicroS_donaciones.Service.DonacionService;
import com.Donaton.MicroS_donaciones.Controller.DonacionController; 

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

class DonacionControllerTest {

    @Mock
    private DonacionService donacionService;

    @InjectMocks
    private DonacionController donacionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarDeberiaRetornarListaDeDonaciones() {
        Donacion d1 = new Donacion();
        when(donacionService.listarTodas()).thenReturn(Arrays.asList(d1));

        List<Donacion> resultado = donacionController.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(donacionService, times(1)).listarTodas();
    }

    @Test
    void obtenerDeberiaRetornarDonacionSiExiste() {
        Donacion donacion = new Donacion();
        when(donacionService.buscarPorId(1L)).thenReturn(Optional.of(donacion));

        Donacion resultado = donacionController.obtener(1L);

        assertNotNull(resultado);
        verify(donacionService, times(1)).buscarPorId(1L);
    }

    @Test
    void obtenerDeberiaRetornarNullSiNoExiste() {
        when(donacionService.buscarPorId(1L)).thenReturn(Optional.empty());

        Donacion resultado = donacionController.obtener(1L);

        assertNull(resultado);
        verify(donacionService, times(1)).buscarPorId(1L);
    }

    @Test
    void crearDeberiaRetornarDonacionCreada() {
        Donacion donacionInput = new Donacion();
        when(donacionService.guardar(any(Donacion.class))).thenReturn(donacionInput);

        Donacion resultado = donacionController.crear(donacionInput);

        assertNotNull(resultado);
        verify(donacionService, times(1)).guardar(donacionInput);
    }

    @Test
    void eliminarDeberiaInvocarMetodoService() {
        doNothing().when(donacionService).eliminar(1L);

        donacionController.eliminar(1L);

        verify(donacionService, times(1)).eliminar(1L);
    }
}
