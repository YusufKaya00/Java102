package Armor;

public class Armor {
    private int id;
    private String name;
    private int block;
    private int gold;


    public Armor(int id, String name, int block, int gold) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.gold = gold;

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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
