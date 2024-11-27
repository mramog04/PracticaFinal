package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;
import es.unileon.prg2.patterns.strategy.NullStrategy;//No se si este import deberia de estar asi.

public class Region extends ElectoralComposite{

    private final Levels nivel = Levels.REGION;

    public Region(GenericId id,GenericId[] partidos,int numSeats) {
        super(id,partidos,numSeats);
        //TODO Auto-generated constructor stub
    }
    
    public Levels getLevel(){
        return this.nivel;
    }

    public Region(Name id,GenericId[] partidos,int numSeats){
        super(id.getGenericId(),partidos,numSeats);
    }

    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        //Creo q se pondria aqui null pero nose
        this.strategy= new NullStrategy();
        return ;// tiene que crear esto por defecto en todos laos.
    }
}
