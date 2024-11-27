package es.unileon.prg2.patterns.strategy;

import es.unileon.prg2.patterns.decorator.Results;

public interface ElectoralStrategy {
    public void applyStrategy(Results results,int numSeats) throws Exception;
}
