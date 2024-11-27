package es.unileon.prg2.patterns.handler;

public class GenericId implements Handler{

    private String id;

    public GenericId (String id){
        this.id = id;
    }

    public GenericId (Handler id){
        this.id = id.toString();
    }

    public int compareTo(Handler another) {
        return this.id.compareTo(another.toString());
    }

    public String toString(){
        return this.id;
    }

}
