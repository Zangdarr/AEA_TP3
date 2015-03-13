package exercice_3;

import dictionnaires.Dicos;
import exercice_3.Graphe;


public class Main_exo3 {

    
    public static void main(String[] args) {
        Graphe graphe_dico4 = new Graphe(Dicos.dico4);
        graphe_dico4.lettreQuiSaute();
        System.out.println("Dictionnaire 4");
        graphe_dico4.visit();
        graphe_dico4.chemin("lion", "peur");
    }
}
