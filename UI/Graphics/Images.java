
package UI.Graphics;

import Model.MyException;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Images implements ConstantsGUI {
    
    private static Map<String, Image> images = new HashMap<String, Image>();
  
    static {
        try {
            try {
                images.put(PLAYER_BOARD, ImageIO.read(getResourceFile(PATH_IMG_PLAYER_BOARD)));
            } catch (MyException ex) {}
            try {
                images.put(ENEMY_BOARD, ImageIO.read(getResourceFile(PATH_IMG_ENEMY_BOARD)));
            } catch (MyException ex) {}
            try {
                images.put(CARD_BACK, ImageIO.read(getResourceFile(PATH_IMG_CARD_BACK)));
            } catch (MyException ex) {}
            try {
                images.put(CARD1, ImageIO.read(getResourceFile(PATH_IMG_CARD1)));
            } catch (MyException ex) {}
            try {
                images.put(CARD2, ImageIO.read(getResourceFile(PATH_IMG_CARD2)));
            } catch (MyException ex) {}
            try {
                images.put(CARD3, ImageIO.read(getResourceFile(PATH_IMG_CARD3)));
            } catch (MyException ex) {}
            try {
                images.put(CARD4, ImageIO.read(getResourceFile(PATH_IMG_CARD4)));
            } catch (MyException ex) {}
            try {
                images.put(CARD5, ImageIO.read(getResourceFile(PATH_IMG_CARD5)));
            } catch (MyException ex) {}
            try {
                images.put(CARD6, ImageIO.read(getResourceFile(PATH_IMG_CARD6)));
            } catch (MyException ex) {}
            try {
                images.put(CARD7, ImageIO.read(getResourceFile(PATH_IMG_CARD7)));
            } catch (MyException ex) {}
            try{
                images.put(BACKGROUND, ImageIO.read(getResourceFile(PATH_IMG_BACKGROUND)));
            } catch (MyException ex){}
        } catch (IOException e) {
        }
    }
    
     public static Image getImage(String name) {
        return images.get(name);
     }
    public static Map<String, Image> getImages() {
        return images;
    }
    private static URL getResourceFile(String name) throws MyException{
        URL url= Images.class.getResource(name);
        if(url == null)
            throw new MyException();
	return url; 
    }
}
