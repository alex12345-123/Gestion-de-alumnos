package es.etg.dam.controller;

import java.io.IOException;

import es.etg.dam.alumnoS;
import es.etg.dam.model.alumnosdaomemoria;
import es.etg.dam.view.alumnoviewcontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class alumnoController extends Application {

    private final static String VIEW_MAIN = "alumnoviewcontroller.fxml";

    private static alumnoS service;

    @Override
    public void start(Stage stage) throws IOException {
        alumnosdaomemoria daoMemoria = new alumnosdaomemoria();
        service = new alumnoS(daoMemoria);

        stage.setScene(cargarVista(VIEW_MAIN));
        stage.setTitle("Gestión de Alumnos");
        stage.show();
    }

    private Scene cargarVista(String ficheroView) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/" + ficheroView));
        Parent root = fxmlLoader.load();

        alumnoviewcontroller viewController = fxmlLoader.getController();
        viewController.setAlumnoController(this);

        return new Scene(root);
    }

    public void insertarAlumno(String nombre, String apellidos, int edad) {
        service.insertarAlumno(nombre, apellidos, edad);
    }

    public java.util.List<es.etg.dam.model.alumno> listarAlumnos() {
        return service.listarAlumnos();
    }
}
