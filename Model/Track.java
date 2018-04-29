
package Model;

import java.util.ArrayList;
import java.util.List;

public class Track implements Constants {
    public List<Position> track;

    public Track(Piece w) {
        track = new ArrayList<>(TAM_TRACKS);
        int i=0;
        if(w instanceof Weapon){
            for (; i < N_ENEMY_SQUARES; i++) {
                if(i==0){
                    track.set(i,new Square(w));
                }else
                    track.set(i, new Square());
            }
            for(; i < N_ENEMY_SQUARES+N_ENEMY_CIRCLES;i++){
                track.set(i, new Circle());
            }
            for(; i< N_ENEMY_SQUARES+N_ENEMY_CIRCLES+N_ENEMY_CLOSE_COMBAT;i++){
                track.set(i, new Close_Combat_Square());
            }
        }else{
            for(;i < N_PLAYER_SQUARES;i++){
                if(i==0)
                    track.set(i, new Square(w));
                else
                    track.set(i, new Square());
            }
            }
        }
    }
    
    
    
}
