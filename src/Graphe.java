
public class Graphe {
    
    protected String[] motsDepart;
    protected int      nombreMots;
    protected Liste[]  listeSucc;

    public Graphe(String[] lesMots) {
        motsDepart = lesMots;
        nombreMots = lesMots.length;
        //TODO listSucc
    }

}
