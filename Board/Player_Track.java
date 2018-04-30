
package Board;

import static Model.Constants.N_PLAYER_SQUARES;
import java.util.ArrayList;

public class Player_Track extends Track{

    public Player_Track(Piece p) {
        track = new ArrayList<>(N_PLAYER_SQUARES);
            for(int i=0;i < N_PLAYER_SQUARES;i++){
                if(i==N_PLAYER_SQUARES-1)
                    track.set(i, new Square(p));
                else
                    track.set(i, new Square());
            }
    }
    
}
