package com.donaton.MicroS_Necesidades.Controller;

import com.donaton.MicroS_Necesidades.Model.Necesidad;
import com.donaton.MicroS_Necesidades.Service.NecesidadService;
import com.donaton.MicroS_Necesidades.Controller.NecesidadController;

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

class NecesidadControllerTest {

    @Mock
    private NecesidadService necesidadService;

    @InjectMocks
    private NecesidadController necesidadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarDeberiaRetornarListaDeNecesidades() {
        Necesidad n1 = new Necesidad();
        when(necesidadService.listarTodas()).thenReturn(Arrays.asList(n1));

        List<Necesidad> resultado = necesidadController.listar();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(necesidadService, times(1)).listarTodas();
    }

    @Test
    void obtenerDeberiaRetornarNecesidadSiExiste() {
        Necesidad necesidad = new Necesidad();
        when(necesidadService.buscarPorId(1L)).thenReturn(Optional.of(necesidad));

        Necesidad resultado = necesidadController.obtener(1L);

        assertNotNull(resultado);
        verify(necesidadService, times(1)).buscarPorId(1L);
    }

    @Test
    void obtenerDeberiaRetornarNullSiNoExiste() {
        when(necesidadService.buscarPorId(1L)).thenReturn(Optional.empty());

        Necesidad resultado = necesidadController.obtener(1L);

        assertNull(resultado);
        verify(necesidadService, times(1)).buscarPorId(1L);
    }

    @Test
    void crearDeberiaRetornarNecesidadCreada() {
        Necesidad necesidadInput = new Necesidad();
        when(necesidadService.guardar(any(Necesidad.class))).thenReturn(necesidadInput);

        Necesidad resultado = necesidadController.crear(necesidadInput);

        assertNotNull(resultado);
        verify(necesidadService, times(1)).guardar(necesidadInput);
    }

    @Test
    void eliminarDeberiaInvocarMetodoService() {
        doNothing().when(necesidadService).eliminar(1L);

        necesidadController.eliminar(1L);

        verify(necesidadService, times(1)).eliminar(1L);
    }
}
