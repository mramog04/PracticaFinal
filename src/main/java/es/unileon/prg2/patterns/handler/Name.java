package es.unileon.prg2.patterns.handler;

public class Name implements Handler{

    private String id;

    public Name (String id){
        this.id = id;
    }

    public Name (Handler id){
        this.id = id.toString();
    }

    /*public Name (Name id){
        this.id = id.getId();
    }*/

    public int compareTo(Handler another) {
        return this.id.compareTo(another.toString());
    }

    public GenericId getGenericId(){
        return new GenericId(this.id);
    }

    /*public String getId(){
        return this.id;
    }*/

    public String toString(){
        return this.id;
    }
}
