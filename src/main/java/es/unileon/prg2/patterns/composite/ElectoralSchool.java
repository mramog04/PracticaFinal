package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.decorator.ConcreteResults;
import es.unileon.prg2.patterns.decorator.Results;
import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.iterator.Iterator;
import es.unileon.prg2.patterns.iterator.NullIterator;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;
import es.unileon.prg2.patterns.strategy.NullStrategy;

public class ElectoralSchool implements ElectoralComponent{

    private final Levels nivel = Levels.ELECTORALSCHOOL;
    private GenericId id;
    private ElectoralStrategy strategy;
    private Results results;//no se si puede ser concrete

    public ElectoralSchool(GenericId id,GenericId[] partidos){
        this.id = id;
        this.results = new ConcreteResults(partidos,0);

    }

    public ElectoralSchool(String id){
        this.id = new GenericId(id);
    }

    public ElectoralSchool(Name id){
        this.id = id.getGenericId();
    }

    @Override
    public boolean add(ElectoralComponent another) throws CompositeException {
        // TODO Auto-generated method stub
        throw new CompositeException("Nothing can be added to a leaf");
    }

    @Override
    public GenericId getId() {
        // TODO Auto-generated method stub
        return this.id;
    }

    public Results getResults(){
        return this.results;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public ElectoralComponent search(GenericId id) {
        // TODO Auto-generated method stub
        ElectoralComponent aux = null;
        if (this.id.compareTo(id) == 0) {
            aux = this;
        }

        return aux;
    }

    public ElectoralComponent search(Name id) {
        // TODO Auto-generated method stub
        ElectoralComponent aux = null;
        if (this.id.compareTo(id.getGenericId()) == 0) {
            aux = this;
        }

        return aux;
    }

    @Override
    public boolean remove(ElectoralComponent another) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Levels getLevel() {
        return this.nivel;
    }

    @Override
    public Iterator<ElectoralComponent> createIterator() {
        // TODO Auto-generated method stub
        return new NullIterator<>();
    }

    @Override
    public Iterator<ElectoralComponent> createIterator(String string) {
        // TODO Auto-generated method stub
        return new NullIterator<>();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= this.getLevel().ordinal(); i++) {
            sb.append("\t");
        }
        sb.append(this.getClass().getSimpleName() + ": " + this.id.toString() + "\n");
        return sb.toString();
    }

    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        this.strategy = new NullStrategy();
    }
    
}
