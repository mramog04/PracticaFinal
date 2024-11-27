package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;

public class Province extends ElectoralComposite{

    private final Levels nivel = Levels.PROVINCE;
    

    public Province(GenericId id,GenericId[] partidos,int numSeats){ 
        super(id,partidos,numSeats);
    }

    public Province (Name id,GenericId[] partidos,int numSeats){
        super(id.getGenericId(),partidos, numSeats);
    }
    
    public Levels getLevel(){
        return this.nivel;
    }

    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        //entienddo que aqui se aplicaria la estrategio aplicada, no se donde xd
        this.strategy = strategy;
    }
}
