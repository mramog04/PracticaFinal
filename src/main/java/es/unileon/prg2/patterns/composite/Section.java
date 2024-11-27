package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;
import es.unileon.prg2.patterns.strategy.NullStrategy;

public class Section extends ElectoralComposite{

    private final Levels nivel = Levels.SECTION;

    public Section(GenericId id,GenericId[] partidos) {
        super(id,partidos,0);
    }
    
    public Levels getLevel(){
        return this.nivel;
    }

    public Section(Name id,GenericId[] partidos){
        super(id.getGenericId(),partidos,0);
    }
    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        //Creo q se pondria aqui null pero nose
        this.strategy= new NullStrategy();
        return ;
    }
}