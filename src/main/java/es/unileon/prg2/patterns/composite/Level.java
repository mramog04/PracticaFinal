package es.unileon.prg2.patterns.composite;

import java.util.HashMap;

public class Level {

    private static Level instance;
    private HashMap<Levels, Levels[]> niveles = new HashMap<Levels, Levels[]>();

    private Level(){

        niveles.put(Levels.COUNTRY, new Levels[] {Levels.PROVINCE, Levels.REGION, Levels.PROVINCE, Levels.TOWN, Levels.SECTION, Levels.DISTRICT, Levels.ELECTORALSCHOOL});

        niveles.put(Levels.REGION, new Levels[] {Levels.PROVINCE, Levels.TOWN, Levels.SECTION, Levels.DISTRICT, Levels.ELECTORALSCHOOL});

        niveles.put(Levels.PROVINCE, new Levels[] {Levels.TOWN, Levels.SECTION, Levels.DISTRICT, Levels.ELECTORALSCHOOL});

        niveles.put(Levels.TOWN, new Levels[] {Levels.SECTION, Levels.DISTRICT, Levels.ELECTORALSCHOOL});

        niveles.put(Levels.SECTION, new Levels[] {Levels.DISTRICT, Levels.ELECTORALSCHOOL});

        niveles.put(Levels.DISTRICT, new Levels[] {Levels.ELECTORALSCHOOL});
    }

    public static Level getInstancia(){
        if (instance == null) {
            instance = new Level();
        }
        return instance;
    }

    public boolean canAdd(ElectoralComponent padre, ElectoralComponent hijo){
        Levels[] temp = niveles.get(padre.getLevel());
        boolean can = false;
        if (temp != null) {
            for (int i = 0; i < temp.length; i++) {
                if (hijo.getLevel().equals(temp[i])) {
                    can = true;
                }
            }
        }

        return can;
    }
}
