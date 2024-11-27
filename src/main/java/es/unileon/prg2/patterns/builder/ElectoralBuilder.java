package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.GenericId;

public interface ElectoralBuilder {
    public void build(String buildLine);
    
    public ElectoralComponent getBuild();

    public void buildElectoralSchool(GenericId name,GenericId[] partidos,GenericId parentId) throws CompositeException;

    public void buildCountry(GenericId name,GenericId[] partidos,int numSeats) throws CompositeException;

    public void buildRegion(GenericId name,GenericId[] partidos,int numSeats,GenericId parentId) throws CompositeException;

    public void buildProvince(GenericId name,GenericId[] partidos,int numSeats,GenericId parentId) throws CompositeException;

    public void buildTown(GenericId name,GenericId[] partidos,GenericId parentId) throws CompositeException;

    public void buildSection(GenericId name,GenericId[] partidos,GenericId parentId) throws CompositeException;

    public void buildDistrict(GenericId name,GenericId[] partidos,GenericId parentId) throws CompositeException;

    
}
