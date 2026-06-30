package com.example.MicroS_donaciones.Service;

import com.Donaton.MicroS_donaciones.Model.Donacion;
import com.Donaton.MicroS_donaciones.Repository.DonacionRepository;
import com.Donaton.MicroS_donaciones.Service.DonacionService; 

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

class DonacionServiceTest {

    @Mock
    private DonacionRepository donacionRepository;

    @InjectMocks
    private DonacionService donacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodasDeberiaRetornarLista() {
        Donacion d1 = new Donacion();
        Donacion d2 = new Donacion();
        when(donacionRepository.findAll()).thenReturn(Arrays.asList(d1, d2));

        List<Donacion> resultado = donacionService.listarTodas();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(donacionRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdDeberiaRetornarDonacion() {
        Donacion donacion = new Donacion();
        when(donacionRepository.findById(1L)).thenReturn(Optional.of(donacion));

        Optional<Donacion> resultado = donacionService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        verify(donacionRepository, times(1)).findById(1L);
    }

    @Test
    void guardarDeberiaRetornarDonacionGuardada() {
        Donacion donacionInput = new Donacion();
        when(donacionRepository.save(any(Donacion.class))).thenReturn(donacionInput);

        Donacion resultado = donacionService.guardar(donacionInput);

        assertNotNull(resultado);
        verify(donacionRepository, times(1)).save(donacionInput);
    }

    @Test
    void eliminarDeberiaInvocarDeleteById() {
        doNothing().when(donacionRepository).deleteById(1L);

        donacionService.eliminar(1L);

        verify(donacionRepository, times(1)).deleteById(1L);
    }
}
