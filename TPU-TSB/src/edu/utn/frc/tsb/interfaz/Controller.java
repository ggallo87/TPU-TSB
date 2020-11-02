package edu.utn.frc.tsb.interfaz;

import edu.utn.frc.tsb.service.Agrupaciones;
import edu.utn.frc.tsb.soport.TxtFile;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class Controller {

    public Label lblUbicacion;
    public TextArea txtAgrupaciones;

    public void cambiarUbicacion(ActionEvent actionEvent) {

        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccione ubicación de los datos");
        dc.setInitialDirectory(new File(lblUbicacion.getText()));
        File file =  dc.showDialog(null);

        if (file != null){
            lblUbicacion.setText(file.getPath());
        }
    }

    public void cargarDatos(ActionEvent actionEvent) {

        Agrupaciones agrupaciones = new Agrupaciones(lblUbicacion.getText());
        txtAgrupaciones.setText(agrupaciones.toString());

        TxtFile regiones = new TxtFile(lblUbicacion.getText() + File.separator + "descripcion_regiones.dsv");
        System.out.println(regiones.readHeader());
        TxtFile mesas = new TxtFile(lblUbicacion.getText() + File.separator + "mesas_totales_agrp_politica.dsv");
        System.out.println(mesas.readHeader());
    }
}
