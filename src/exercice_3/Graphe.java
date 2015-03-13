package exercice_3;
import java.util.ArrayList;
import java.util.Iterator;


public class Graphe {
    
    /*
     * Attributs
     */
    protected String[] motsDepart;
    protected int      nombreMots;
    protected Liste[]  listeSucc;
    protected boolean[] dejaVu;
    protected ArrayList<String> composante;
    protected int[] pere;
    

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
        dejaVu = new boolean[nombreMots];
        composante = new ArrayList<String>();
        pere = new int[nombreMots];
        
        //initialisation de la liste des successeur avec des listes vides
        listeSucc  = new Liste[nombreMots];
        for (int i = 0; i < nombreMots; i++) {
            listeSucc[i] = new Liste();
            dejaVu[i] = false;
        }
        
    }
    
    /*
     * Méthodes
     */
    
    /**
     * Initialise les listes de successeurs selon la règle du jeu de la lettre qui saute.
     */
    public void lettreQuiSaute() {
        // Pour chaque mot
        for (int i = 0; i < nombreMots; i++) {
            // Pour chaque mot qui n'a pas déjà été traité ou pas entrain de l'être
            for (int j = i+1; j < nombreMots; j++) {
                // si une seule lettre diffère
                if(diffUneLettre(motsDepart[i], motsDepart[j])){
                    // ajout d'une arête entre les deux mots
                    ajouterArete(i, j);
                }
            }
        }
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
    
    public void display(){
        
        StringBuffer result = new StringBuffer();
        result.append("Graphe : \n");
        
        for (int i = 0; i < listeSucc.length; i++) {
            result.append(motsDepart[i] + " : ");
            
            Iterator<Integer> it = listeSucc[i].getSucc();
            
            for (Iterator<Integer> iterator = it; iterator.hasNext();) {
                int type = iterator.next();
                result.append(motsDepart[type] + ", ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }
    
    public static void main (String[] args) {
        String[] dico3court = {
           "gag", "gai", "gaz", "gel", "gks", "gin",
           "gnu", "glu", "gui", "guy", "gre", "gue",
           "ace", "acm", "agi", "ait", "aie", "ail",
           "air", "and", "alu", "ami", "arc", "are",
           "art", "apr", "avr", "sur", "mat", "mur" } ;
        Graphe g = new Graphe (dico3court) ;
        g.lettreQuiSaute();
        //System.out.println(g.DFS(0));
        g.visit();
        
      }

    public String DFS(int x){
        if(dejaVu[x])
           return "";
        dejaVu[x] = true;
        String result = getWord(x) + " ";
        
        Iterator<Integer> it = listeSucc[x].getSucc();
        for (Iterator<Integer> iterator = it; iterator.hasNext();) {
            int succ = iterator.next();
            pere[succ] = x;
            result += DFS(succ);
        }
        return result;
    }
    
    public void visit(){
        int searchFrom = 0;
        String tmp_result = "";
        while((searchFrom = nextComposante()) != -1){
            pere[searchFrom] = -1;
            tmp_result += DFS(searchFrom);
            composante.add(tmp_result);
            tmp_result = "";
        }
        
        int i = 0;
        for (Iterator<String> iterator = composante.iterator(); iterator.hasNext();) {
            System.out.println(i++ + ": " + (String) iterator.next());
        }
        
    }
    
    public void getComposanteOf(String word){
        int i = 0;
        for (Iterator<String> iterator = composante.iterator(); iterator.hasNext();) {
            if(((String)iterator.next()).contains(word)){
               System.out.println("La composante du mot \'" + word + "\' est la numéro " + i );
               return;
            }
            i++;
        }
        System.out.println("Le mot \'" + word + "\' n'apparaît dans aucune composante.");
    }
    
    private int nextComposante(){
        for (int i = 0; i < dejaVu.length; i++) {
            if(dejaVu[i] == false)
                return i;
        }
        return -1;
    }
    
    private String getWord(int x){
        return motsDepart[x];
    }



}
