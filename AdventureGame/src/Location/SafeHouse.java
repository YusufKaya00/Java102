package Location;

import player.Player;

public class SafeHouse extends NormalLocation {


    public SafeHouse(Player player, String name) {
        super(player, name);

    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesin canın yenileniyor");
        updateHealth();
        System.out.println("Health " + this.player.getHealty());
        return true;
    }

    public void updateHealth() {
        try {

            if (this.player.getId() == 1) {
                this.player.setHealty(21);
            } else if (this.player.getId() == 2) {
                this.player.setHealty(18);


            } else if (this.player.getId() == 3) {
                this.player.setHealty(24);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

}
