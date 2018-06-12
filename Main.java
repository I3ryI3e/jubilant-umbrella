import UI.text.User_Interface_Text;
import Model.*;
import UI.Graphics.FrameNineCardSiege;

public class Main {
    public static void main(String[] args) {
        Siege_Game siege = new Siege_Game();
        ObservableGame modelo = new ObservableGame(siege);
        User_Interface_Text ui_text = new User_Interface_Text(modelo);
        FrameNineCardSiege ui_graph = new FrameNineCardSiege(modelo);
        ui_text.run();
    }
}
