package Location;

import player.*;
import Armor.*;
import Weapons.*;

import java.util.Scanner;

public class MerchantStore extends NormalLocation {

    public int id;
    public String item;
    private Scanner scan = new Scanner(System.in);

    public MerchantStore(Player player, String name) {
        super(player, name);


    }

    @Override
    public boolean onLocation() {
        selectItem();
        return true;
    }

    public void WeaponMenu() {
        System.out.println("--------------------Weapons---------------------" +
                "CHOOSE WİSELY :)");

        Weapons[] weaponList = {new Pistol() , new Sword() , new Rifle()};
        for (Weapons weapons : weaponList) {
            System.out.println("Name : " + weapons.getName());
            System.out.println(" id  : " + weapons.getId());
            System.out.println(" Damage :" + weapons.getDamage());
            System.out.println(" Price :" + weapons.getGold());

        }
        System.out.println("-----------------------------------------------------");

    }

    public void ArmorMenu() {
        System.out.println("----------------------ARMORS----------------------" +
                "CHOOOSE WİSELY .* ");

        Armor[] armorList = {new Heavy(), new Light(), new Heavy()};
        for (Armor armors : armorList) {
            System.out.println("Name : " + armors.getName());
            System.out.println("id :" + armors.getId());
            System.out.println("BlockChance :" + armors.getBlock());
            System.out.println("Price :" + armors.getGold());


        }

        System.out.println("-------------------------------------------------------");
    }


    public void buyWeapon(Weapons weapons) {
        System.out.println(" Ur money is : " + player.getMoney());
        if (this.player.getMoney() >= weapons.getGold()) {
            this.player.getInventory().setWeaponDamage(weapons.getDamage());
            this.player.getInventory().setWeaponName(weapons.getName());
            this.player.setMoney(this.player.getMoney() - weapons.getGold());
            this.player.setDamage(this.player.getDamage() + weapons.getDamage());
            System.out.println(" U bought the item ur current money now : " + this.player.getMoney());
            System.out.println(" Ur weapon is : " + this.player.getInventory().getWeaponName() +
                    " you have :  " + this.player.getDamage() + " dmg anymore");
        } else
            System.out.println("u dont have enough money");


    }

    public void buyArmor(Armor armor) {
        System.out.println(" Ur Current Money is : " + this.player.getMoney());
        if (this.player.getMoney() >= armor.getGold()) {
            this.player.getInventory().setArmorDefence(armor.getBlock());
            this.player.getInventory().setArmorName(armor.getName());
            this.player.setMoney(this.player.getMoney() - armor.getGold());
            System.out.println("u bought a item ur current money is  " + this.player.getMoney());
            System.out.println("U have  : " + this.player.getInventory().getArmorName() +
                    " u Got: " + this.player.getInventory().getArmorDefence() + " defence ");

        } else {
            System.out.println("u dont have enough money");

        }
    }

    public void selectItem() {
        System.out.println(" Which u want to buy Armor ? or Weapon ? choose ");
        item = scan.nextLine();
        switch (item) {

            case "Weapon" : {
                WeaponMenu();
                System.out.println("Enter id of weapon u want to buy ");
                id = scan.nextInt();
                if (id == 1) {
                    buyWeapon(new Pistol());
                } else if (id == 2) {
                    buyWeapon(new Sword());
                } else if (id == 3) {
                    buyWeapon((new Rifle()));
                } else {
                    System.out.println("İnvalid weapon id !");
                }
break;

            }
            case "Armor": {
             ArmorMenu();
                System.out.println("Enter id of which armor u want to buy");
                id = scan.nextInt();
                if (id == 1) {
                    buyArmor(new Light());
                } else if (id == 2) {
                    buyArmor(new Medium());

                } else if (id == 3) {
                    buyArmor(new Heavy());

                } else {
                    System.out.println("invalid armor id !");
                }

            }

        }

    }
}
