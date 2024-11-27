package es.unileon.prg2.patterns;

import es.unileon.prg2.patterns.builder.ElectoralDirector;

public class ElectoralMain {
    public ElectoralDirector director;

    public void createTree(ConcreteBuilder builder){
        director = new ElectoralDirector(builder);
        director.construct();
    }

    public static void main(String[] args) {
        ElectoralMain main = new ElectoralMain();
        if(/* ha pulsado boton 1 */){
            createTree(new CyLBuilder());
        }else{
            createTree(new SpainBuilder());
        }
    }
}
