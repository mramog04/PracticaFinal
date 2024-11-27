package es.unileon.prg2.patterns.strategy;




import es.unileon.prg2.patterns.decorator.Results;
import es.unileon.prg2.patterns.handler.GenericId;
public class MayorityStrategy implements ElectoralStrategy{


//
    @Override
    public void applyStrategy(Results results,int numSeats) throws Exception {
        // TODO Auto-generated method stub
        //poner algo por si dos partidos empatan
        GenericId winner = null;
        int vot = -1;

        for (GenericId partido : results.getResults().getVotes().keySet()){
            if(vot < results.getResults().getResultsVotes(partido)){
                vot = results.getResults().getResultsSeats(partido);
                winner = partido;
            }
        }

        if(vot==-1){
            throw new Exception("No se encontro ningun partido ganador");
        }else{
            results.getResults().setResultsSeats(winner, numSeats);
        }


    }


}
