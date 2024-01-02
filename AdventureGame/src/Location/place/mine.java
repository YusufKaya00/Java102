package Location.place;
import Location.battleLocation;
import obstacle.*;
import player.Player;

public class mine extends battleLocation {
    public mine(Player player){
        super(player , "Mine", new Snake() , "null" ,5);
    }
}
