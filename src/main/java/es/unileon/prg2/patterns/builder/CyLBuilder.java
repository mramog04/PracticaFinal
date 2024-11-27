package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.GenericId;

public class CyLBuilder implements ElectoralBuilder{

    private ElectoralComponent root;

    @Override
    public void build(String buildLine){
        
    
    }

    @Override
    public ElectoralComponent getBuild() {
        return this.root;
    }

    //entiendo que lo que voy a poner esta mal, debido a que le estoy haciendo add a caada componente nuevo que creo q una root, con lo que todos los elementos, por ejemplo creo una town, cuando hago root.add("esa town que cree"), no la estare añadiendo a una province sino a mi root que no se que sera
    @Override
    public void buildElectoralSchool(GenericId name, GenericId[] partidos, GenericId parentId) throws CompositeException {
        // TODO Auto-generated method stub
        ElectoralComposite parent = (ElectoralComposite) root.search(parentId);
        parent.add(new ElectoralSchool(name, partidos));
    }

    @Override
    public void buildCountry(GenericId name, GenericId[] partidos, int numSeats) throws CompositeException {
        //Entiendo que como solo estamos ccreando CYL este metodo no lo usaremos pero debe quedar impllementado para que no de error al estar implementando la interfaz ElectoralBuilder
        return;
    }

    @Override
    public void buildRegion(GenericId name, GenericId[] partidos, int numSeats, GenericId parentId) throws CompositeException {
        this.root = new Region(name, partidos, numSeats);
    }

    @Override
    public void buildProvince(GenericId id, GenericId[] parties, int numSeats,GenericId parentId) throws CompositeException {
        root.add(new Province(id, parties, numSeats));
    }

    @Override
    public void buildTown(GenericId name, GenericId[] partidos, GenericId parentId) throws CompositeException {
        ElectoralComposite parent = (ElectoralComposite) root.search(parentId);
        parent.add(new Town(name, partidos, 0));
    }

    @Override
    public void buildSection(GenericId name, GenericId[] partidos, GenericId parentId) throws CompositeException {
        ElectoralComposite parent = (ElectoralComposite) root.search(parentId);
        parent.add(new Section(name, partidos));
    }

    @Override
    public void buildDistrict(GenericId name, GenericId[] partidos, GenericId parentId) throws CompositeException {
        ElectoralComposite parent = (ElectoralComposite) root.search(parentId);
        parent.add(new District(name, partidos));
    }

   
}
