
public class Graphe {
    
    protected String[] motsDepart;
    protected int      nombreMots;
    protected Liste[]  listeSucc;

    public Graphe(String[] lesMots) {
        motsDepart = lesMots;
        nombreMots = lesMots.length;
        
        //initialisation de la liste des successeur avec des listes vides
        listeSucc  = new Liste[nombreMots];
        for (int i = 0; i < nombreMots; i++) {
            listeSucc[i] = new Liste();
        }
        
    }

}
