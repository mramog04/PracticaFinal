package es.unileon.prg2.patterns.iterator;

public class ListIterator<T> implements Iterator<T>{

    private Aggregate<T> aggregate;
    private int current;

    public ListIterator(Aggregate<T> aggregate){
        this.aggregate = aggregate;
        this.current = 0;
    }
    
    @Override
    public void firstElement() {
        // TODO Auto-generated method stub
        this.current = 0;
    }

    @Override
    public void nextElement() {
        // TODO Auto-generated method stub
        if (hasMoreElements()) {
            this.current++;
        }
    }

    @Override
    public boolean hasMoreElements() {
        // TODO Auto-generated method stub
        boolean aux = true;
        if (/*this.aggregate.get(this.current) == null*/ this.aggregate.getSize() == this.current) {
            aux = false;
        }

        return aux;
    }

    @Override
    public T currentElement() {
        // TODO Auto-generated method stub
        return this.aggregate.get(this.current);
    }
    
}
