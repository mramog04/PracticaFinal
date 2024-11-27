package es.unileon.prg2.patterns.handler;

public class ShortName implements Handler{

    private String id;

    public ShortName (String id) throws MalformedHandlerException{
        //CODE
        StringBuffer message = new StringBuffer();
        int length = id.length();
        if(length > 2){
            message.append("The length of the identifier should be less than 2.\n" + id + " is not valid.");
        }else if(length == 0){
            message.append("The identifier can not be an empty one.\n");
        }else if(length==1 && !Character.isLetter(id.charAt(0))){
            message.append("The identifier can only include letters.\n" + id + " is not valid."); //HE AÑADIDO EL "is not valid" en ambos casos, no se seguro si es así
        }else if(length==2 && (!Character.isLetter(id.charAt(0)) || !Character.isLetter(id.charAt(1)))){
            message.append("The identifier can only include letters.\n" + id + " is not valid.");
        }else{
            this.id = id;
        }
        if (message.length() != 0){ //he cambiado message.length(), antes tenia solo length, creo que lo tenia mal copiado
            throw new MalformedHandlerException(message.toString());
        }
    }

    public ShortName (Handler id) throws MalformedHandlerException{
        //NO REPETIR CODIGO
        this(id.toString());
    }

    public int compareTo(Handler another){
        return this.id.compareTo(another.toString());
    }

    public String toString(){
        return this.id;
    }
}
