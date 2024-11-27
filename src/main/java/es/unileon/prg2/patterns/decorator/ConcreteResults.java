package es.unileon.prg2.patterns.decorator;

import java.util.HashMap;
import es.unileon.prg2.patterns.handler.GenericId;



public class ConcreteResults implements Results{
    
    private HashMap<GenericId, Integer> votes = new HashMap<GenericId, Integer>();
    private HashMap<GenericId, Integer> seats = new HashMap<GenericId, Integer>();
    private GenericId[] partidos;//segun ricardo esto no va aqui
    private int numSeats;

    public ConcreteResults(GenericId[] partidosPol, int numSeats){
        //Aqui abria q poner los partidos en los hash map
        //Se crea el array de los partidos politicos
        this.numSeats = numSeats;
        for (GenericId partido : partidosPol){
            votes.put(partido,0);
            seats.put(partido,0);
        }
        for(int i=0;i<partidosPol.length;i++){
            partidos[i]=partidosPol[i];
        }
    }

    public int getNumSeats(){
        return this.numSeats;
    }
    public HashMap<GenericId, Integer> getVotes(){
        return this.votes;
    }

    public HashMap<GenericId, Integer> getSeats(){
        return this.seats;
    }

    public int getResultsSeats(GenericId partido) throws Exception{
        //Comprobar que el partido existe
        if(seats.containsKey(partido)){
            return seats.get(partido);
        }else{
            throw new Exception("El partido no fue encontrado en los escaños");//Crear excepcion concreta
        }
    }

    public int getResultsVotes(GenericId partido) throws Exception{
        if(seats.containsKey(partido)){
            return seats.get(partido);
        }else{
            throw new Exception("El partido no fue encontrado en los votos");//Crear excepcion concreta
        }
    }

    public void setResultsSeats(GenericId partido,int Seats) throws Exception{
        //Habria que comprobar en algun sitio si los escaños asignados son mayores de los que tiene asignados la provincia?
        if(seats.containsKey(partido)){
            seats.put(partido, Seats);
        }else{
            throw new Exception("El partido no fue encontrado en los excaños");//Crear excepcion concreta
        }
    }
    
    public void setResultsVotes(GenericId partido,int votes) throws Exception{
        //Habria que comprobar en algun sitio si los escaños asignados son mayores de los que tiene asignados la provincia?
        if(seats.containsKey(partido)){
            this.votes.put(partido, votes);
        }else{
            throw new Exception("El partido no fue encontrado en los votos");//Crear excepcion concreta
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados:\n");
        for (GenericId partido : partidos) {
            sb.append("Partido: ").append(partido).append(" - Votos: ").append(votes.get(partido))
              .append(", Escaños: ").append(seats.get(partido)).append("\n");
        }
        return sb.toString();
    }

    public void operation() {
        // No sabemos cual seria este metodo
        throw new UnsupportedOperationException("Unimplemented method 'operation'");
    }

    public GenericId[] getPartidos(){
        return this.partidos;
    }

    @Override
    public ConcreteResults getResults() {
        // TODO Auto-generated method stub
        return this;
    }

    


}

