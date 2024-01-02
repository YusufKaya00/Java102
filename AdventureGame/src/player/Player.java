package player;

import Inventory.*;
import characters.*;

public class Player {
    private int id;
    private String name;
    private int damage;
    private int healty;

    private int money;

    public Inventory.inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory.inventory inventory) {
        this.inventory = inventory;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    private inventory inventory = new inventory();
    private Character character;

    public Player(String name) {
        this.setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void Printİnfo() {

    }

}
