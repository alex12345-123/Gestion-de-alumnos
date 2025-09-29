package es.etg.dam;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import es.etg.dam.model.alumno;
import es.etg.dam.model.alumnosDAO;

@ExtendWith(MockitoExtension.class) 
public class alumnosSTest {

    @InjectMocks
    alumnoS service;  

    @Mock
    alumnosDAO dao;  

    @Test
    public void testInsertarAlumno() {
        Mockito.doNothing().when(dao).insertar(any(alumno.class));

        service.insertarAlumno("María", "García", 20);

        Mockito.verify(dao, Mockito.times(1)).insertar(any(alumno.class));
    }

    @Test
    public void testListarAlumnos() {
        alumno a1 = new alumno("Lionel", "Messi", 39);
        alumno a2 = new alumno("Jude", "Bellingham",22);

        Mockito.when(dao.listar()).thenReturn(Arrays.asList(a1, a2));

        List<alumno> lista = service.listarAlumnos();

        assertEquals(2, lista.size());
        assertEquals("Lionel", lista.get(0).getNombre());
    }
}
