
public class Graphe {
    
    /*
     * Attributs
     */
    protected String[] motsDepart;
    protected int      nombreMots;
    protected Liste[]  listeSucc;

    /*
     * Constructeurs
     */
    
    /**
     * Constructeur de graphe. Initialise le Graphe avec une liste de mots passés en paramètre.
     * @param lesMots
     */
    public Graphe(String[] lesMots) {
        motsDepart = lesMots;
        nombreMots = lesMots.length;
        
        //initialisation de la liste des successeur avec des listes vides
        listeSucc  = new Liste[nombreMots];
        for (int i = 0; i < nombreMots; i++) {
            listeSucc[i] = new Liste();
        }
        
    }
    
    /*
     * Méthodes
     */

}
