package es.unileon.prg2.patterns.strategy;

import java.util.ArrayList;
import java.util.List;

import es.unileon.prg2.patterns.decorator.Results;
import es.unileon.prg2.patterns.handler.GenericId;

public class DhontStrategy implements ElectoralStrategy{

    private int[][] votos;
    @Override
    public void applyStrategy(Results results,int numSeats) throws Exception{

        int numPartidos = results.getResults().getPartidos().length;
        int numEscaños = numSeats;
        int[][] votos=new int[numPartidos][numEscaños];//crear el array para el tamaño de partidos que haya en la provincia
        int k = 0;
        for (GenericId partido : results.getResults().getVotes().keySet()){
            for(int i = 0;i<votos.length;i++){
                k = 0;
                for(int j = 0;i<votos[i].length;j++){
                    votos[i][j]=results.getResults().getResultsVotes(partido)/(k+1);
                    k++;
                }
            }
        }
        //localizar que posiciones del array votos son las n de valor mas alto y en funcion de que fila esten se le asignara a un partido o a otro los escaños en results.setResultSeat(partido)
        
        // Lista para almacenar los valores más altos
        List<Integer> valoresMasAltos = new ArrayList<>();
        // Lista de partidos
        List<GenericId> partidos = new ArrayList<>(results.getResults().getVotes().keySet());

        // Iterar sobre el número de escaños
        for (int i = 0; i < numEscaños; i++) {
            int max = -1; // Valor máximo inicial
            int indicePartido = -1; // Índice del partido con el valor máximo
            int indiceEscaño = -1; // Índice del escaño con el valor máximo

            // Iterar sobre el número de partidos
            for (int j = 0; j < numPartidos; j++) {
            // Iterar sobre el número de escaños
            for (int l = 0; l < numEscaños; l++) {
                // Si el valor actual es mayor que el máximo y no está en la lista de valores más altos
                if (votos[j][l] > max && !valoresMasAltos.contains(votos[j][l])) {
                max = votos[j][l]; // Actualizar el valor máximo
                indicePartido = j; // Actualizar el índice del partido
                indiceEscaño = l; // Actualizar el índice del escaño
                }
            }
            }

            // Añadir el valor máximo a la lista de valores más altos
            valoresMasAltos.add(max);
            // Asignar el escaño al partido correspondiente
            results.getResults().setResultsSeats(partidos.get(indicePartido), indiceEscaño);;
        }

        
    }

}
