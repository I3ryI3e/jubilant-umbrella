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
            try {
                images.put(BACKGROUND, ImageIO.read(getResourceFile(PATH_IMG_BACKGROUND)));
            } catch (MyException ex) {}
            try {
                images.put(BACKGROUND2, ImageIO.read(getResourceFile(PATH_IMG_BACKGROUND2)));
            } catch (MyException ex) {}
            try {
                images.put(NEW, ImageIO.read(getResourceFile(PATH_IMG_NEW)));
            } catch (MyException ex) {}
            try {
                images.put(LOAD, ImageIO.read(getResourceFile(PATH_IMG_LOAD)));
            } catch (MyException ex) {}
            try {
                images.put(SAVE, ImageIO.read(getResourceFile(PATH_IMG_SAVE)));
            } catch (MyException ex) {}
            try {
                images.put(REDCROSS, ImageIO.read(getResourceFile(PATH_IMG_REDCROSS)));
            } catch (MyException ex) {}
            try {
                images.put(OPTIONS, ImageIO.read(getResourceFile(PATH_IMG_OPTIONS)));
            } catch (MyException ex) {}
            try {
                images.put(INFO, ImageIO.read(getResourceFile(PATH_IMG_INFO)));
            } catch (MyException ex) {}
            try {
                images.put(INFO2, ImageIO.read(getResourceFile(PATH_IMG_INFO2)));
            } catch (MyException ex) {}
            try {
                images.put(LADDER_ICON, ImageIO.read(getResourceFile(PATH_LADDER_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(BATTERING_RAM_ICON, ImageIO.read(getResourceFile(PATH_BATTERING_RAM_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(SIEGE_TOWER_ICON, ImageIO.read(getResourceFile(PATH_SIEGE_TOWER_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(RED_SQUARE_ICON, ImageIO.read(getResourceFile(PATH_RED_SQUARE_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(WALL_ICON, ImageIO.read(getResourceFile(PATH_WALL_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(MORALE_ICON, ImageIO.read(getResourceFile(PATH_MORALE_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(SUPPLY_ICON, ImageIO.read(getResourceFile(PATH_SUPPLY_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(SOLDIER_ICON, ImageIO.read(getResourceFile(PATH_SOLDIER_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(APPLES_ICON, ImageIO.read(getResourceFile(PATH_APPLES_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(LADDER_ICON_CIRCLE, ImageIO.read(getResourceFile(PATH_LADDER_ICON_CIRCLE)));
            } catch (MyException ex) {}
            try {
                images.put(BATTERING_RAM_ICON_CIRCLE, ImageIO.read(getResourceFile(PATH_BATTERING_RAM_ICON_CIRCLE)));
            } catch (MyException ex) {}
            try {
                images.put(SIEGE_TOWER_ICON_CIRCLE, ImageIO.read(getResourceFile(PATH_SIEGE_TOWER_ICON_CIRCLE)));
            } catch (MyException ex) {}
            try {
                images.put(LOSS_ICON, ImageIO.read(getResourceFile(PATH_LOSS_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(WIN_ICON, ImageIO.read(getResourceFile(PATH_WIN_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(SOLDIER_RUN_FORWARD_ICON, ImageIO.read(getResourceFile(PATH_SOLDIER_RUN_FORWARD_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(SOLDIER_RUN_BACKWARD_ICON, ImageIO.read(getResourceFile(PATH_SOLDIER_RUN_BACKWARD_ICON)));
            } catch (MyException ex) {}
            try {
                images.put(DICE1, ImageIO.read(getResourceFile(PATH_DICE1)));
            } catch (MyException ex) {}
            try {
                images.put(DICE2, ImageIO.read(getResourceFile(PATH_DICE2)));
            } catch (MyException ex) {}
            try {
                images.put(DICE3, ImageIO.read(getResourceFile(PATH_DICE3)));
            } catch (MyException ex) {}
            try {
                images.put(DICE4, ImageIO.read(getResourceFile(PATH_DICE4)));
            } catch (MyException ex) {}
            try {
                images.put(DICE5, ImageIO.read(getResourceFile(PATH_DICE5)));
            } catch (MyException ex) {}
            try {
                images.put(DICE6, ImageIO.read(getResourceFile(PATH_DICE6)));
            } catch (MyException ex) {}
        } catch (IOException e) {}
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
