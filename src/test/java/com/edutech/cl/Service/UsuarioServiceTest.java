package com.edutech.cl.Service;

import com.edutech.cl.model.Usuario;
import com.edutech.cl.dto.UsuarioDTO;
import com.edutech.cl.dto.UsuarioCreateDTO;
import com.edutech.cl.repository.UsuarioRepository;
import com.edutech.cl.services.UsuarioService;
import com.edutech.cl.mapper.UsuarioMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;  

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {


    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsuarios() {
        // Arrange: no necesario por simplicidad

        // Act
        usuarioService.getAllUsuarios();

        // Assert
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testGetUsuarioById_UsuarioEncontrado() {
        // Arrange
        Long userId = 1L;
        Usuario mockUsuario = new Usuario();
        mockUsuario.setId(userId);
        mockUsuario.setNombre("Ana Pérez");

        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(mockUsuario));
        when(usuarioMapper.toDTO(mockUsuario)).thenReturn(new UsuarioDTO());

        // Act
        UsuarioDTO result = usuarioService.getUsuarioById(userId);

        // Assert
        assertNotNull(result);
        verify(usuarioRepository, times(1)).findById(userId);
    }

    @Test
    void testCreateUsuario() {
        // Arrange
        UsuarioCreateDTO createDTO = new UsuarioCreateDTO();
        createDTO.setNombre("Carlos Rojas");
        createDTO.setEmail("carlos@example.com");
        createDTO.setPassword("password123");
        createDTO.setRol(Usuario.Rol.ESTUDIANTE);

        Usuario mockUsuario = new Usuario();
        mockUsuario.setId(1L);
        mockUsuario.setNombre("Carlos Rojas");

        // Aquí creamos un DTO con valores definidos
        UsuarioDTO expectedDTO = new UsuarioDTO();
        expectedDTO.setId(1L);
        expectedDTO.setNombre("Carlos Rojas");
        expectedDTO.setEmail("carlos@example.com");
        expectedDTO.setRol(Usuario.Rol.ESTUDIANTE);

        when(usuarioMapper.toEntity(createDTO)).thenReturn(mockUsuario);
        when(usuarioRepository.save(mockUsuario)).thenReturn(mockUsuario);
        when(usuarioMapper.toDTO(mockUsuario)).thenReturn(expectedDTO); // <-- Ahora sí tiene valores

        // Act
        UsuarioDTO result = usuarioService.createUsuario(createDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Carlos Rojas", result.getNombre());
        assertEquals("ESTUDIANTE", result.getRol().name());
        verify(usuarioRepository, times(1)).save(mockUsuario);
    }

    @Test
    void testUpdateUsuario() {
        // Arrange
        Long userId = 1L;
    
        // DTO con nuevos datos para actualizar
        UsuarioCreateDTO updateDTO = new UsuarioCreateDTO();
        updateDTO.setNombre("Ana Pérez Actualizada");
        updateDTO.setEmail("anaperez.actualizado@example.com");
        updateDTO.setPassword("nuevacontraseña");
        updateDTO.setRol(Usuario.Rol.INSTRUCTOR);
        updateDTO.setDireccion("Nueva Dirección");
        updateDTO.setTelefono("+56999999999");
    
        // Usuario existente antes de la actualización
        Usuario existingUsuario = new Usuario();
        existingUsuario.setId(userId);
        existingUsuario.setNombre("Ana Pérez Original");
        existingUsuario.setEmail("ana.perez@original.cl");
        existingUsuario.setRol(Usuario.Rol.ESTUDIANTE);
    
        // Simulamos que el repositorio encuentra el usuario
        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(existingUsuario));
    
        // Simulamos que el repositorio guarda el usuario actualizado
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(existingUsuario);
    
        // Simulamos el resultado del mapper
        UsuarioDTO updatedDTO = new UsuarioDTO();
        updatedDTO.setId(userId);
        updatedDTO.setNombre("Ana Pérez Actualizada");
        updatedDTO.setEmail("anaperez.actualizado@example.com");
        updatedDTO.setRol(Usuario.Rol.INSTRUCTOR);
    
        when(usuarioMapper.toDTO(existingUsuario)).thenReturn(updatedDTO);
    
        // Act
        UsuarioDTO result = usuarioService.updateUsuario(userId, updateDTO);
    
        // Assert
        assertNotNull(result);
        assertEquals("Ana Pérez Actualizada", result.getNombre());
        assertEquals("INSTRUCTOR", result.getRol().name());
    
        verify(usuarioRepository, times(1)).findById(userId);
        verify(usuarioRepository, times(1)).save(existingUsuario);
    }

    @Test
    void testDeleteUsuario() {
        // Arrange
        Long userId = 1L;

        doNothing().when(usuarioRepository).deleteById(userId);

        // Act
        usuarioService.deleteUsuario(userId);

        // Assert
        verify(usuarioRepository, times(1)).deleteById(userId);
    }
}