package es.etg.dam.model;
import java.util.ArrayList;
import java.util.List;
public class alumnosdaomemoria implements alumnosDAO {
    private final List<alumno> alumnos = new ArrayList<>();
    @Override
    public void insertar(alumno alumno) {
        alumnos.add(alumno);
    }
    @Override
    public List<alumno> listar() {
        return new ArrayList<>(alumnos);
    }
}

