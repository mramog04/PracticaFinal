package es.unileon.prg2.patterns.decorator;

public class PercentageDecorator implements ElectoralDecorator{
    public ConcreteResults results;

    //entiendo que aqui estariasn los metodos para decorar ConcreteResults pero no comprendo muy bien.
    public PercentageDecorator(ConcreteResults results){
        this.results=results;
    }
    @Override
    public void operation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'operation'");
    }

    @Override
    public ConcreteResults getResults() {
        // TODO Auto-generated method stub
        return this.results;
    }
}
