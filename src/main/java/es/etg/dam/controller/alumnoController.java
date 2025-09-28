package es.etg.dam.controller;

import es.etg.dam.alumnoS;
import es.etg.dam.model.alumnosdaomemoria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class alumnoController extends Application {

    private alumnoS service;

    @Override
    public void start(Stage stage) throws Exception {
        alumnosdaomemoria daoMemoria = new alumnosdaomemoria();
        service = new alumnoS(daoMemoria);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/es/etg/dam/view/alumnoviewcontroller.fxml"));
        Parent root = loader.load();

        es.etg.dam.view.alumnoviewcontroller viewController = loader.getController();
        viewController.setAlumnoController(this);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gestión de Alumnos");
        stage.show();
    }

    public void insertarAlumno(String nombre, String apellidos, int edad) {
        service.insertarAlumno(nombre, apellidos, edad);
    }

    public java.util.List<es.etg.dam.model.alumno> listarAlumnos() {
        return service.listarAlumnos();
    }

    public static void main(String[] args) {
        launch();
    }
}