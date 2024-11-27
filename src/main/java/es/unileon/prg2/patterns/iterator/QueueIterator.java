package es.unileon.prg2.patterns.iterator;

public class QueueIterator<T> implements Iterator<T> {

    private Aggregate<T> aggregate;
    private int current;

    public QueueIterator(Aggregate<T> aggregate){
        this.aggregate = aggregate;
        this.current = aggregate.getSize() - 1;
    }
    
    @Override
    public void firstElement() {
        // TODO Auto-generated method stub
        this.current = this.aggregate.getSize() - 1;
    }

    @Override
    public void nextElement() {
        // TODO Auto-generated method stub
        if (hasMoreElements()) {
            this.current--;
        }
    }

    @Override
    public boolean hasMoreElements() {
        // TODO Auto-generated method stub
        boolean aux = true;
        if (this.current < 0) {
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
