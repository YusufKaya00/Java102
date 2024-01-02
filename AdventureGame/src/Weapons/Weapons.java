package Weapons;

public class Weapons {
    private int id;
    private String name;
    private int damage;
    private int gold;

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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Weapons(int id, String name, int damage, int gold) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.gold = gold;
    }
}