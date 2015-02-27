import java.util.ArrayList;
import java.util.Collection;


public class Liste {

    private ArrayList<Integer> liste;
    
    public Liste() {
        // TODO Auto-generated constructor stub
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
