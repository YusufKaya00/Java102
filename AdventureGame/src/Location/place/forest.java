package Location.place;
import Location.battleLocation;
import obstacle.*;
import player.Player;

public class forest extends battleLocation {
    public forest(Player player){
        super(player , "Forest" , new Zombie() , "food", 3);
    }
}
