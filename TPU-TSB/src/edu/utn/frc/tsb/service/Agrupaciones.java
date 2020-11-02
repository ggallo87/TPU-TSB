package edu.utn.frc.tsb.service;

import edu.utn.frc.tsb.soport.TxtFile;
import edu.utn.frc.tsb.soport.hashtable.TSBHashtable;

import java.io.File;

public class Agrupaciones {

    private TxtFile fileAgrupacion;
    private TxtFile filaMesas;

    private TSBHashtable tsbHashtable;


    public Agrupaciones(String path) {
        fileAgrupacion = new TxtFile(path + File.separator + "descripcion_postulaciones.dsv");
        filaMesas = new TxtFile(path + File.separator + "mesas_totales_agrp_politica.dsv");
        tsbHashtable = fileAgrupacion.filtrarAgrupaciones();
        filaMesas.sumarVotosPorAgrupacion(tsbHashtable);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Object o : tsbHashtable.values()){
            sb.append("\n" + o);
        }

        return sb.toString();
    }
}
