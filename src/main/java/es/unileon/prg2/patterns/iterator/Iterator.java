package es.unileon.prg2.patterns.iterator;

public interface Iterator<T> {
    
    public void firstElement();

    public void nextElement();

    public boolean hasMoreElements();

    public T currentElement();
}
