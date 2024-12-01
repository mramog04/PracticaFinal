package es.unileon.prg2.patterns.builder;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;


public class ElectoralDirector {
    private ElectoralBuilder builder;
    //atributos csv
    private String csvFile = "src/main/resources/Elecciones2022CyL_censo(1).csv";//Esto deberia ser pasado por el constructor creo
    private String csvFile2 = "src/main/resources/Elecciones2022CyL_partidosYprocuradores(1).csv";//Esto deberia ser pasado por el constructor creo

    public ElectoralDirector(ElectoralBuilder builder){
        this.builder=builder;
    }

    //En algun sitio se tendra que pasar el nobre de lo que queremos crear
    public void construct(){
        
        String[] nextLine;

        try(CSVReader reader = new CSVReader(new FileReader(csvFile))){
            while((nextLine = reader.readNext())!=null){
                builder.build(nextLine);
            }
        }catch(IOException | CsvValidationException e){
            e.printStackTrace();
            //No se que hacer si algo falla a la hora de leer el csv
        }

        try(CSVReader reader = new CSVReader(new FileReader(csvFile2))){
            while((nextLine = reader.readNext())!=null){
                builder.build(nextLine);
            }
        }catch(IOException | CsvValidationException e){
            e.printStackTrace();
            //No se que hacer si algo falla a la hora de leer el csv
        }
    }
}
