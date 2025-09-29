package es.etg.dam;
import java.util.List;

import es.etg.dam.model.alumno;
import es.etg.dam.model.alumnosDAO;
public class alumnoS{
    private final alumnosDAO dao;
    public alumnoS(alumnosDAO dao) {
        this.dao = dao;
    }
    public void insertarAlumno(String nombre, String apellidos, int edad) {
        alumno alumno = new alumno(nombre, apellidos, edad); 
        dao.insertar(alumno); 
    }
    public List<alumno> listarAlumnos() {
        return dao.listar(); 
    }
}
