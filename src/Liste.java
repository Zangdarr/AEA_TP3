import java.util.ArrayList;
import java.util.Collection;


public class Liste {

    /*
     * Attributs
     */
     
    private ArrayList<Integer> liste;
    
    
    /*
     * Constructeur
     */
    
    public Liste() {
        liste = new ArrayList<Integer>();
    }
    
    public Liste(ArrayList<Integer> liste) {
        this.liste = liste;
    }
    
    
    /*
     * Méthodes
     */
    
    public int getSize() {
        return liste.size();
    }
    
    public void add(int newValue){
        liste.add(newValue);
    }
    
    public void remove(int index){
        liste.remove(index);
    }
    
}
