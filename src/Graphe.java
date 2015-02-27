
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
    
    /**
     * Rajoute s à la liste des successeurs de d et d à celle de s, 
     * les mots d'indices s et d étant supposés différer d'une lettre
     * @param sommet
     * @param destination
     */
    public void ajouterArete (int sommet, int destination) {
        //TODO 
    }
}
