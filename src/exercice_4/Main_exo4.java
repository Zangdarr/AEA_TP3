package exercice_4;

import dictionnaires.Dicos;
import exercice_4.Graphe;



public class Main_exo4 {

    
    public static void main(String[] args) {
        Graphe graphe_dico4 = new Graphe(Dicos.dico4);
        graphe_dico4.lettreQuiSaute();
        System.out.println("Dictionnaire 4\n\nBFS : ");
        graphe_dico4.chemin_bfs("lion", "peur");
        
        System.out.println("Amelioration de l'exo 3 : ");
        
        graphe_dico4.exo4_chemin_plus_court("lion", "peur");
    }
}
