
package Board;

public class Siege implements Weapon {

    @Override
    public int getPower() {
       return 4;
    }

    @Override
    public String getName() {
        return "Siege Tower";
    }
    
}
