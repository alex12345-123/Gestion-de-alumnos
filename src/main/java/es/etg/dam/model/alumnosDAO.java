package es.etg.dam.model;
import java.util.List;

public interface alumnosDAO {
    void insertar(alumno alumno);       
    List<alumno> listar();              
}

