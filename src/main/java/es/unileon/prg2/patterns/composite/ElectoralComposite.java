package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.decorator.ConcreteResults;
import es.unileon.prg2.patterns.decorator.Results;
import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.iterator.Iterator;
import es.unileon.prg2.patterns.iterator.ListIterator;
import es.unileon.prg2.patterns.iterator.QueueIterator;
import es.unileon.prg2.patterns.iterator.VectorAggregate;
import es.unileon.prg2.patterns.strategy.ElectoralStrategy;

public class ElectoralComposite implements ElectoralComponent{
    
    private GenericId id;
    private VectorAggregate<ElectoralComponent> components2;
    protected ElectoralStrategy strategy;
    protected Results results;//nose si es concrete

    public ElectoralComposite(GenericId id,GenericId[] partidos,int numSeats){
        this.id = id;
        components2 = new VectorAggregate<>();
        this.results = new ConcreteResults(partidos,numSeats);
    }

    public ElectoralComposite(String id){
        this.id = new GenericId(id);
        components2 = new VectorAggregate<>();
    }

    @Override
    public boolean add(ElectoralComponent another) {
        boolean can = false;
        if (Level.getInstancia().canAdd(this, another)) {
            components2.add(another);
            can = true;
        }
        return can;
    }

    @Override
    public GenericId getId() {
        return this.id;
    }

    @Override
    public int size() {
        int total = 0;
        for (int i = 0; i < components2.getSize(); i++) {
            if (components2.get(i).getClass() == ElectoralSchool.class) {
                total++;
            } else {
                total += components2.get(i).size();
            }
        }
        return total;
    }

    @Override
    public ElectoralComponent search(GenericId id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            for (int i = 0; i < components2.getSize(); i++) {
                ElectoralComponent component = components2.get(i);
                if (component != null) {
                    if (component.getClass() == ElectoralSchool.class) {
                        if (component.getId().equals(id)) {
                            return component;
                        }
                    } else {
                        ElectoralComponent result = component.search(id);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(ElectoralComponent another) {
        boolean removed = components2.remove(another);
        if (!removed) {
            int i = 0;
            while (i < components2.size() && !removed) {
                ElectoralComponent component = components2.get(i);
                if (component != null && !component.getClass().equals(ElectoralSchool.class)) {
                    removed = component.remove(another);
                }
                i++;
            }
        }
        return removed;
    }

    @Override
    public Levels getLevel() {
        return null;
    }

    @Override
    public Iterator<ElectoralComponent> createIterator() {
        return new ListIterator<>(components2);
    }

    @Override
    public Iterator<ElectoralComponent> createIterator(String string) {
        if (string.equals("queue")) {
            return new QueueIterator<>(components2);
        } else {
            return this.createIterator();
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <= this.getLevel().ordinal(); j++) {
            sb.append("\t");
        }
        sb.append(this.getClass().getSimpleName() + ": " + this.getId().toString() + "\n");
        for (int i = 0; i < components2.size(); i++) {
            ElectoralComponent component = components2.get(i);
            if (component != null) {
                sb.append(component.toString());
            }
        }
        return sb.toString();
    }

    @Override
    public void setStrategy(ElectoralStrategy strategy) {
        return ;
    }
}