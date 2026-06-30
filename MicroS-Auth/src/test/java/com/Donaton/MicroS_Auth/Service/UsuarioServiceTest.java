package com.Donaton.MicroS_Auth.Service;

import com.Donaton.MicroS_Auth.Model.Usuario;
import com.Donaton.MicroS_Auth.Repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private final UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
    private final UsuarioService usuarioService = new UsuarioService(usuarioRepository);

    @Test
    void registrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("test@test.com");
        usuario.setContraseña("123456");

        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.registrar(usuario);
        assertEquals("test@test.com", resultado.getCorreo());
    }

    @Test
    void loginCorrecto() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("test@test.com");
        usuario.setContraseña("123456");

        Mockito.when(usuarioRepository.findByCorreo("test@test.com")).thenReturn(usuario);

        Usuario resultado = usuarioService.login("test@test.com", "123456");
        assertNotNull(resultado);
    }

    @Test
    void loginIncorrecto() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("test@test.com");
        usuario.setContraseña("123456");

        Mockito.when(usuarioRepository.findByCorreo("test@test.com")).thenReturn(usuario);

        Usuario resultado = usuarioService.login("test@test.com", "wrongpass");
        assertNull(resultado);
    }
}
