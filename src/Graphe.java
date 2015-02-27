
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
     * Initialise les listes de successeurs selon la règle du jeu de la lettre qui saute.
     */
    public void lettreQuiSaute() {
        //TODO
    }
    
    
    /**
     * Rajoute s à la liste des successeurs de d et d à celle de s, 
     * les mots d'indices s et d étant supposés différer d'une lettre
     * @param sommet
     * @param destination
     */
    public void ajouterArete (int s, int d) {
        
        // Ajout de s à la liste des successeurs de d
        listeSucc[s].add(d);
        
        // Ajout de d à la liste des successeurs de s
        listeSucc[d].add(s);
        
    }
    
    
    /**
     * Recherche une difference entre les mots a et b, supposees de meme taille.
     * @param a
     * @param b
     * @return true si une seule difference a ete trouvee sinon false
     */
    public boolean diffUneLettre (String a, String b) {
        // a et b supposees de meme longueur
        int i = 0;
        
        // parcouru du mot a la recherche d'une difference
        while(i<a.length() && a.charAt(i) == b.charAt(i))
            ++i;
        
        //on a parcouru le mot complet sans trouver de difference
        if(i == a.length()) return false;
        
        ++i;
        
        //une difference a ete trouve, recherche d'une seconde differe,ce
        while(i<a.length() && a.charAt(i) == b.charAt(i))
            ++i;
        
        // le mot complet a ete parcouru et pas de seconde difference trouvee
        if(i== a.length()) return true;
        
        // une deuxieme difference a ete trouvee
        return false;
    }
}
