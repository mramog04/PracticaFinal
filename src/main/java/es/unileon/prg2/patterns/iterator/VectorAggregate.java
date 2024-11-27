package es.unileon.prg2.patterns.iterator;

public class VectorAggregate<T> extends java.util.Vector<T> implements Aggregate<T> {

    @Override
    public Iterator<T> createIterator() {
        // TODO Auto-generated method stub
        return new ListIterator<>(this);
    }

    @Override
    public Iterator<T> createIterator(String type) {
        // TODO Auto-generated method stub
        if (type.equals("queue")) {
            return new QueueIterator<>(this);

        }else{ //PROBABLEMENTE ESTO SEA SI TYOE ES LIST, QUIZA HAYA QUE CAMBIARLO Y PONER UNA EXCEPCION PARA OTROS TYPES
            return new ListIterator<>(this);
        }
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return this.size();
    }

}
