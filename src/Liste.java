import java.util.ArrayList;
import java.util.Collection;


public class Liste {

    private ArrayList<Integer> liste;
    
    public Liste() {
        liste = new ArrayList<Integer>();
    }
    
    public Liste(ArrayList<Integer> liste) {
        this.liste = liste;
    }
    
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
