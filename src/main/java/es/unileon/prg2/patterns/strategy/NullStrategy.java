package es.unileon.prg2.patterns.strategy;

import es.unileon.prg2.patterns.decorator.Results;

public class NullStrategy implements ElectoralStrategy{
    @Override
    public void applyStrategy(Results result,int numSeats) throws Exception{
        return ;
    }
}
