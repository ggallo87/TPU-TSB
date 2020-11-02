package edu.utn.frc.tsb.soport;

import edu.utn.frc.tsb.soport.hashtable.TSBHashtable;
import edu.utn.frc.tsb.service.Agrupacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtFile {

    private File ubicacion;


    public TxtFile(String path) {

        ubicacion = new File(path);
    }


    public String readHeader(){

        String primera = "";
        try {

            Scanner scanner = new Scanner(ubicacion);
            while (scanner.hasNext()){
                primera =scanner.nextLine();
                break;
            }

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("No se pudo leer el archivo " );

        }

        return primera;
    }

    public TSBHashtable filtrarAgrupaciones() {

        String linea = "", campos[];
        TSBHashtable tsb_oaHashtable = new TSBHashtable(10);
        Agrupacion agrupacion;
        try {

            Scanner scanner = new Scanner(ubicacion);
            while (scanner.hasNext()){
                linea =scanner.nextLine();
                campos = linea.split("\\|");
                if (campos[0].compareTo("000100000000000") == 0){

                    agrupacion = new Agrupacion(campos[2], campos[3]);
                    tsb_oaHashtable.put(agrupacion.getCode(), agrupacion);
                }
            }

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("No se pudo leer el archivo ");
        }

        return tsb_oaHashtable;

    }

    public void sumarVotosPorAgrupacion(TSBHashtable tsbHashtable) {

        String linea = "", campos[];
        Agrupacion agrupacion;
        int votos;
        try {

            Scanner scanner = new Scanner(ubicacion);
            while (scanner.hasNext()){
                linea =scanner.nextLine();
                campos = linea.split("\\|");
                if (campos[4].compareTo("000100000000000") == 0){

                   agrupacion = (Agrupacion) tsbHashtable.get(campos[5]);
                   votos  = Integer.parseInt(campos[6]);
                   agrupacion.sumarVotos(votos);
                }
            }

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("No se pudo leer el archivo ");
        }


    }
}
