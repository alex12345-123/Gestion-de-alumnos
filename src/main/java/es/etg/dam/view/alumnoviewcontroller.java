package es.etg.dam.view;

import es.etg.dam.controller.alumnoController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class alumnoviewcontroller {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextArea txtAreaAlumnos;

    protected alumnoController alumnoController;

    public void setAlumnoController(alumnoController controller) {
        this.alumnoController = controller;
    }

    @FXML
    private void insertarAlumno() {
        final String MSG_TITLE = "Error en el formulario";
        final String MSG_CONTENT = "Todos los campos son obligatorios y la edad debe ser un número";

        if(camposRellenos()) {
            try {
                int edad = Integer.parseInt(txtEdad.getText());
                alumnoController.insertarAlumno(txtNombre.getText(), txtApellidos.getText(), edad);
                txtAreaAlumnos.setText("Alumno insertado: " + txtNombre.getText() + " " + txtApellidos.getText());
                limpiarCampos();
            } catch(NumberFormatException e) {
                mostrarError(MSG_TITLE, MSG_CONTENT);
            }
        } else {
            mostrarError(MSG_TITLE, MSG_CONTENT);
        }
    }

    @FXML
    private void listarAlumnos() {
        StringBuilder sb = new StringBuilder();
        alumnoController.listarAlumnos().forEach(a ->
            sb.append(a.getNombre())
              .append(" ")
              .append(a.getApellidos())
              .append(", Edad: ")
              .append(a.getEdad())
              .append("\n")
        );
        txtAreaAlumnos.setText(sb.toString());
    }

    private boolean camposRellenos() {
        return campoRelleno(txtNombre) && campoRelleno(txtApellidos) && campoRelleno(txtEdad);
    }

    private boolean campoRelleno(TextField campo) {
        return campo != null && !"".equals(campo.getText().trim());
    }

    private void mostrarError(String title, String content) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(title);
        alerta.setContentText(content);
        alerta.show();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellidos.clear();
        txtEdad.clear();
    }
}
