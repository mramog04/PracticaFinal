package es.unileon.prg2.patterns.builder;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ElectoralDirector {
    private ElectoralBuilder builder;
    //atributos csv
    private String csvFile;

    public ElectoralDirector(ElectoralBuilder builder){
        this.builder=builder;
    }

    public void construct(){
        StringBuilder sb = new StringBuilder();



        try(){

        }
        
        //Entiendo que aqui creamos CyL en funcion a las entradas del documento este que nos dan,
        //pero no se donde se sacan del documento que nos dan las instrucciones para crear CyL
    }
}
