package com.donaton.MicroS_Necesidades.Service;

import com.donaton.MicroS_Necesidades.Model.Necesidad;
import com.donaton.MicroS_Necesidades.Repository.NecesidadRepository;
import com.donaton.MicroS_Necesidades.Service.NecesidadService;

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

class NecesidadServiceTest {

    @Mock
    private NecesidadRepository necesidadRepository;

    @InjectMocks
    private NecesidadService necesidadService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodasDeberiaRetornarLista() {
        Necesidad n1 = new Necesidad();
        Necesidad n2 = new Necesidad();
        when(necesidadRepository.findAll()).thenReturn(Arrays.asList(n1, n2));

        List<Necesidad> resultado = necesidadService.listarTodas();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(necesidadRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdDeberiaRetornarNecesidad() {
        Necesidad necesidad = new Necesidad();
        when(necesidadRepository.findById(1L)).thenReturn(Optional.of(necesidad));

        Optional<Necesidad> resultado = necesidadService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        verify(necesidadRepository, times(1)).findById(1L);
    }

    @Test
    void guardarDeberiaRetornarNecesidadGuardada() {
        Necesidad necesidadInput = new Necesidad();
        when(necesidadRepository.save(any(Necesidad.class))).thenReturn(necesidadInput);

        Necesidad resultado = necesidadService.guardar(necesidadInput);

        assertNotNull(resultado);
        verify(necesidadRepository, times(1)).save(necesidadInput);
    }

    @Test
    void eliminarDeberiaInvocarDeleteById() {
        doNothing().when(necesidadRepository).deleteById(1L);

        necesidadService.eliminar(1L);

        verify(necesidadRepository, times(1)).deleteById(1L);
    }
}
