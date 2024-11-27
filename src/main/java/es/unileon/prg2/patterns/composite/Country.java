package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;
import es.unileon.prg2.patterns.strategy.NullStrategy;

public class Country extends ElectoralComposite{

    private final Levels nivel = Levels.COUNTRY;

    public Country(GenericId id,GenericId[] partidos,int numSeats) {
        super(id,partidos,numSeats);
    }

    public Country(String id){
        super(id);
    }

    public Country(Name id,GenericId[] partidos,int numSeats){
        super(id.getGenericId(),partidos,numSeats);
    }

    public Levels getLevel(){
        return this.nivel;
    }

    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        //Creo q se pondria aqui null pero nose
        this.strategy= new NullStrategy();
        return ;
    }


    /*public String toString2(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= this.getLevel().ordinal(); i++) {
            sb.append("\t");
        }
        sb.append("Country: " + this.getId().toString() + "\n");
        return sb.toString();
    }*/
}
