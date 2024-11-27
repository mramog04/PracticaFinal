package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.GenericId;

public class CyLBuilder implements ElectoralBuilder{

    private ElectoralComponent root;
    private int numSeats;
    private GenericId[] partidos;

    //Creo que en el constructor se tiene que iniciar la raiz
    
    @Override
    public void build(Sting[] buildLine){
        String[] nextLine = buildLine.split(",");
        if(nextLine.length==6){
            buildTree(nextLine);
        }else{
            buildProvinces(nextLine);
        }
    }


    public void buildProvinces(String[] buildLine){
        int i=2, j=0;
        GenericId[] partidos = new GenericId[buildLine.length-2];
        for(String part : buildLine){
            partidos[j]=buildLine[i];
            i++;
            j++;
        }
        boolean found = false;
        for(GenericId part : partidos){
            for (GenericId part2 : this.partidos){
                if(part.equals(part2)){
                    found = true;
                }
            }
        }
        this.numSeats = this.numSeats + Integer.parseInt(buildLine[1]);
        buildProvince(buildLine[0], partidos, Integer.parseInt(buildLine[1]));
    }


    public void buildTree(String[] nextLine){
        if(root==null){
            buildRegion("CyL", null, numSeats);
        }
        if(root.search(nextLine[0])!=null){
            buildTown(nextLine[1], null, nextLine[0]);
            buildDistrict(nextLine[2], null, nextLine[1]);
            buildSection(nextLine[3], null, nextLine[2]);
            buildElectoralSchool(nextLine[4], null, nextLine[3], Integer.parseInt(nextLine[5]));
        }
    }

    @Override
    public ElectoralComponent getBuild() {
        return this.root;
    }

    //entiendo que lo que voy a poner esta mal, debido a que le estoy haciendo add a caada componente nuevo que creo q una root, con lo que todos los elementos, por ejemplo creo una town, cuando hago root.add("esa town que cree"), no la estare añadiendo a una province sino a mi root que no se que sera
    @Override
    public void buildElectoralSchool(GenericId name, GenericId[] partidos, GenericId parentId,int numVotos) throws CompositeException {
        // TODO Auto-generated method stub
        ElectoralComposite parent = (ElectoralComposite) root.search(parentId);
        parent.add(new ElectoralSchool(name, partidos,numVotos));
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
    public void buildProvince(GenericId id, GenericId[] parties, int numSeats) throws CompositeException {
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
