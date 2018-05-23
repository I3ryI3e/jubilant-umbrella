
import UI.text.User_Interface_Text;
import Model.*;


public class Main {
    public static void main(String[] args) {
        Siege_Game modelo = new Siege_Game();
        User_Interface_Text ui_text = new User_Interface_Text(modelo);
        ui_text.run();
    }
}
