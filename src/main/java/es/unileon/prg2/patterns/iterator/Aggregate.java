package es.unileon.prg2.patterns.iterator;

public interface Aggregate<T> {

    public Iterator<T> createIterator();

    public Iterator<T> createIterator(String type);

    public int getSize();

    public T get(int index);

    public boolean add(T element);

    public T remove(int index);
}
