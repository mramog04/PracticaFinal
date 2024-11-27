package es.unileon.prg2.patterns.handler;

public class LongName implements Handler{

    private String id;

    public LongName (String id){
        this.id = id;
    }

    public LongName (Handler id){
        this.id = id.toString();
    }

    public int compareTo(Handler another) {
        return this.id.compareTo(another.toString());
    }

    public String toString(){
        return this.id;
    }

}
