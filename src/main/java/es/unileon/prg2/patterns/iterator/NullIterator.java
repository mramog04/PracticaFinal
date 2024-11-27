package es.unileon.prg2.patterns.iterator;

public class NullIterator<T> implements Iterator<T>{

    public NullIterator(){

    }
    
    @Override
    public void firstElement() {
        // TODO Auto-generated method stub
    }

    @Override
    public void nextElement() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean hasMoreElements() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T currentElement() {
        // TODO Auto-generated method stub
        return null;
    }

}
