package exercice_2;

import dictionnaires.Dicos;
import exercice_2.Graphe;

public class Main_exo2 {

    
    public static void main(String[] args) {
        Graphe graphe_dico4 = new Graphe(Dicos.dico4);
        graphe_dico4.lettreQuiSaute();
        System.out.println("Dictionnaire 4");
        graphe_dico4.visit();
        graphe_dico4.getComposanteOf("lion");
        graphe_dico4.getComposanteOf("peur");
    }
}
