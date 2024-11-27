package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;
import es.unileon.prg2.patterns.strategy.NullStrategy;

public class District extends ElectoralComposite{

    private final Levels nivel = Levels.REGION;

    public District(GenericId id,GenericId[] partidos) {
        super(id,partidos,0);
        //TODO Auto-generated constructor stub
    }
    
    public Levels getLevel(){
        return this.nivel;
    }

    public District(Name id,GenericId[] partidos,int numSeats){
        super(id.getGenericId(),partidos,numSeats);
    }
    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        //Creo q se pondria aqui null pero nose
        this.strategy= new NullStrategy();
        return ;
    }
}
