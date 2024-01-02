package Game;

import characters.Archer;
import characters.Knight;
import characters.Samurai;
import player.*;
import Location.*;
import Location.place.*;

import java.util.Scanner;


public class game {
    private final Scanner input;
    public String name;
    public Player player;
    public Location location;

    public game() {
        this.input = new Scanner(System.in);

    }


    public void start() {
        System.out.println("Adventure Game");
        System.out.println("Enter Name");
        name = input.next();
        player = new Player(name);


    }

    private void printChar() {
        System.out.println("____________________________________________________\n"
                + "\tWhich character you want to be? \n"
                + "\t1-Samurai\tDamage:5\tHealth:21\tmoney:25\n"
                + "\t2-Archer\tDamage:7\tHealth:18\tmoney:20 \n"
                + "\t3-Knight\tDamage:8\tHealth:24\tmoney:5 \n"
                + "____________________________________________________");
    }


    private void printLocation() {
        System.out.println("\tWhere dou you want to go? \n"
                + "\t-Merchant Store\t\tYou can buy weapon and armor\n"
                + "\t-Safe House\t\t    Your health will be restore.\n"
                + "\t-River\t\tGo to the river but be careful! Bears are everywhere\n"
                + "\t-Forest\t\tGo to the forest but be careful! Zombies are everywhere\n"
                + "\t-Cave\t\tGo to the cave but be careful! Vampires are everywhere\n"
                + "\t-Mine\t\tGo to the mine but be careful! Snakes are everywhere\n"
                + "_______________________________________________________________________________");
    }

    public void selectChar() {
        printChar();
        int secim = input.nextInt();




        switch (secim) {


            case 1:
                System.out.println(" You are Samurai anymore");
                Samurai Samurai = new Samurai();
                player.setId(Samurai.getId());
                player.setDamage(Samurai.getDamage());
                player.setHealty(Samurai.getHealty());
                player.setMoney(Samurai.getMoney());
                break;

            case 2:
                System.out.println(" You are Archer anymore");
                Archer Archer = new Archer();
                player.setId(Archer.getId());
                player.setDamage(Archer.getDamage());
                player.setHealty(Archer.getHealty());
                player.setMoney(Archer.getMoney());
                break;

            case 3:
                System.out.println(" You are Knight anymore");
                Knight Knight = new Knight();
                player.setId(Knight.getId());
                player.setDamage(Knight.getDamage());
                player.setHealty(Knight.getHealty());
                player.setMoney(Knight.getMoney());
                break;


        }

    }

    public void selectLocation() {
        printLocation();

        String locName = input.nextLine();
        while (true) {
            System.out.println("Please enter location u want to go");
            locName = input.nextLine();
            switch (locName.toLowerCase()) {
                case "merchant store": {
                    location = new MerchantStore(player, name);
                    location.onLocation();
break;
                }
                case "safe house": {
                    location = new SafeHouse(player, name);
                    location.onLocation();
                    break;
                }

                case "river": {
                    if (!this.player.getInventory().isWater()) {
                        location = new river(player);
                        location.onLocation();

                    } else {
                        System.out.println(" U cant go back yet u aint won the prize (water) ");
                    }
                    break;

                }

                case "forest": {
                    if (!this.player.getInventory().isFood()) {
                        location = new forest(player);
                        location.onLocation();
                    } else {
                        System.out.println("U cant go back yet u aint won the prize (food)");
                    }
                    break;
                }

                case "cave": {
                    if (!this.player.getInventory().isFirewood()) {
                        location = new cave(player);
                        location.onLocation();
                    } else {
                        System.out.println("U cant go back yet u aint won the prize (firewood)");
                    }
                    break;
                }

                case "mine": {
                    location = new mine(player);
                    location.onLocation();
                    break;
                }


                case "exit": {
                    System.out.println("U are leaving See u soon");
                    System.exit(0);
                }

                default: {
                    location = new SafeHouse(player, name);
                    location.onLocation();
                    System.out.println("Wrong location but u still in the safehouse");
                }
            }
            System.out.println();
        }
    }

}



