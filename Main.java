
import UI.text.User_Interface_Text;
import Model.*;
import UI.Graphics.FrameNineCardSiege;


public class Main {
    public static void main(String[] args) {
        Siege_Game modelo = new Siege_Game();
        //User_Interface_Text ui_text = new User_Interface_Text(modelo);
        FrameNineCardSiege ui_graph = new FrameNineCardSiege(modelo);
        //ui_text.run();
    }
}
