package exercice_1;

public class Main_exo1 {
    
    public static void main(String[] args) {
        
        Graphe graphe_dico3 = new Graphe(Dicos.dico3);
        graphe_dico3.lettreQuiSaute();
        System.out.println("Dictionnaire 3");
        graphe_dico3.display();
        
        Graphe graphe_dico4 = new Graphe(Dicos.dico4);
        graphe_dico4.lettreQuiSaute();
        System.out.println("Dictionnaire 4");
        graphe_dico4.display();
        
        Graphe graphe_dico5 = new Graphe(Dicos.dico5);
        graphe_dico5.lettreQuiSaute();
        System.out.println("Dictionnaire 5");
        graphe_dico5.display();
    
    
    }

}
