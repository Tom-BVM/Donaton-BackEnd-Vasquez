package com.Donaton.MicroS_Auth.Controller;

import com.Donaton.MicroS_Auth.Model.Usuario;
import com.Donaton.MicroS_Auth.Service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registrarUsuario() throws Exception {
        Usuario usuarioInput = new Usuario();
        usuarioInput.setCorreo("test@test.com");
        usuarioInput.setContraseña("123456");

        when(usuarioService.registrar(any(Usuario.class))).thenReturn(usuarioInput);

        Usuario respuesta = usuarioController.registrar(usuarioInput);
        
        assertNotNull(respuesta);
        assertEquals("test@test.com", respuesta.getCorreo());
    }

    @Test
    void iniciarSesionCorrecto() throws Exception {
        Usuario usuarioInput = new Usuario();
        usuarioInput.setCorreo("test@test.com");
        usuarioInput.setContraseña("123456");

        Usuario usuarioMock = new Usuario();
        usuarioMock.setCorreo("test@test.com");
        usuarioMock.setContraseña("123456");

        when(usuarioService.buscarPorCorreo("test@test.com")).thenReturn(usuarioMock);

        ResponseEntity<?> respuesta = usuarioController.iniciarSesion(usuarioInput);
        
        assertNotNull(respuesta);
        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals("Inicio de sesión correcto", respuesta.getBody());
    }

    @Test
    void iniciarSesionIncorrecto() throws Exception {
        Usuario usuarioInput = new Usuario();
        usuarioInput.setCorreo("test@test.com");
        usuarioInput.setContraseña("wrong");

        when(usuarioService.buscarPorCorreo("test@test.com")).thenReturn(null);

        ResponseEntity<?> respuesta = usuarioController.iniciarSesion(usuarioInput);
        
        assertNotNull(respuesta);
        assertEquals(401, respuesta.getStatusCode().value());
        assertEquals("Credenciales inválidas", respuesta.getBody());
    }
}
