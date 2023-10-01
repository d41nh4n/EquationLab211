
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class SuperlativeEquation {
    private float a, b;

    public SuperlativeEquation(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public SuperlativeEquation() {
    }
    

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }
    
    public List<Float> calculateSuperlativeEquation(){
        List<Float> listResult = new ArrayList<>();
        float x;
        x = -this.b/this.a;
        listResult.add(a);
        listResult.add(b);
        listResult.add(x);
        return listResult;       
    }
    
}
