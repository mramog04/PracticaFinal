package es.unileon.prg2.patterns.composite;

//import es.unileon.prg2.patterns.composite.Level.Levels;
import es.unileon.prg2.patterns.iterator.*;
import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;

public interface ElectoralComponent {
    
    public boolean add(ElectoralComponent another) throws CompositeException;

    public GenericId getId();

    public int size();

    public String toString();

    public ElectoralComponent search(GenericId id);

    public boolean remove(ElectoralComponent another);

    public Levels getLevel();

    public Iterator<ElectoralComponent> createIterator();
    
    public Iterator<ElectoralComponent> createIterator(String string);

    public void setStrategy(ElectoralStrategy strategy);

    //public void attach(Observer observer);

    //public void dettach(Observer observer);

    //public void notify();
}
