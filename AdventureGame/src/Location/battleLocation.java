package Location;

import obstacle.*;
import org.w3c.dom.ls.LSOutput;
import player.Player;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public abstract class battleLocation extends Location {
    private Player player;
    private String name;
    private Obstacle obstacle;
    private String prize;
    private int maxObstacle;

    private int obstacleNumber;
    private String selectState;
    private Random r;
    private Scanner scan;


    @Override
    public boolean onLocation() {
        System.out.println("You Are in " + this.getName());
        System.out.println(" Be careful "
                + this.randomObstacle() + " "
                + this.getObstacle().getName().toLowerCase() + " s live here");
        System.out.println("-------------------------------------------");

        System.out.println(" U  have two choices  Run or Fight  : ");
        selectState = scan.nextLine().toLowerCase();
        System.out.println();
        setObstacleDamage();


        switch (selectState) {
            case "fight":
                fight();
                break;
            case "run":
                break;
            default:
                System.out.println("wrong state");
                break;

        }

        if (this.player.getInventory().isWater() && this.player.getInventory().isFood() && this.player.getInventory().isFirewood()) {
            System.out.println("---------------------------------------");
            System.out.println(" YOU WON THE GAME !!! SEE U NEXT TIME");
            System.out.println("-----------------------------------------");
            System.exit(0);
        }
        return true;
    }

    public void fight() {
        System.out.println("------Health Status Of The Characters-----");
        this.obstacle.setHealth(this.obstacle.getHealth() * this.getObstacleNumber());
        System.out.println(this.player.getName() + "-->" + this.player.getHealty() + "\n"
                + this.obstacle.getName() + "(s)-->" + this.obstacle.getHealth()
                + "\n------------------------------------------------------");

        while (this.player.getHealty() > 0 && this.obstacle.getHealth() > 0) {
            hit();
        }
    }

    public void getSnakePrize() {
        int num = r.nextInt(100);

        if (num < 3) {
            this.player.getInventory().setWeaponName("Rifle");
            this.player.setDamage(this.player.getDamage() + 7);
            System.out.println("You earned rifle.Your new damage is " + this.player.getDamage());
        } else if (num < 8) {
            this.player.getInventory().setWeaponName("Sword");
            this.player.setDamage(this.player.getDamage() + 3);
            System.out.println("You earned sword.Your new damage is " + this.player.getDamage());

        } else if (num < 15) {
            this.player.getInventory().setWeaponName("Gun");
            this.player.setDamage(this.player.getDamage() + 2);
            System.out.println("You earned gun. Your new damage is" + this.player.getDamage());
        } else if (num < 18) {
            this.player.getInventory().setArmorName("Heavy");
            System.out.println("Your earned heavy armor");
        } else if (num < 23) {
            this.player.getInventory().setArmorName("Medium");
            System.out.println("You earned medium armor");
        } else if (num < 30) {
            this.player.getInventory().setArmorName("Light");
            System.out.println("You earned light armor");
        } else if (num < 35) {
            this.player.setMoney(this.player.getMoney() + 10);
            System.out.println("You earned 10 money. Your new balance is " + this.player.getMoney());
        } else if (num < 42) {
            this.player.setMoney(this.player.getMoney() + 5);
            System.out.println("You earned 5 money Your new balance is " + this.player.getMoney());
        } else if (num < 55) {
            this.player.setMoney(this.player.getMoney() + 1);
            System.out.println("You earned 1 money Your new balance is " + this.player.getMoney());
        } else {
            System.out.println("You earned anything");
        }
    }

    public void hit() {
        int chance = (int) (Math.random() * 10);

        if (chance <= 5) {
            //player hits to obstacle
            if (this.player.getHealty() > 0) {
                this.obstacle.setHealth(this.obstacle.getHealth() - this.player.getDamage());
                System.out.println(this.player.getName()
                        + " Dealt " + this.player.getDamage()
                        + " Given to " + this.obstacle.getName()
                        + "\n New Health Status " + this.player.getName() + " --->" + this.player.getHealty()
                        + "\n " + this.obstacle.getName() + "-->" + this.obstacle.getHealth());
                System.out.println("------------------------------------------");
            }
        }
        if (chance > 5) {
            //obstacle hits to player
            if (this.obstacle.getHealth() > 0) {
                this.player.setHealty(this.player.getHealty() - this.obstacle.getDamage());
                System.out.println(this.obstacle.getName()
                        + " Dealt" + this.obstacle.getDamage()
                        + " Given to " + this.player.getName()
                        + "\n New Health Status " + this.player.getName() + " --->" + this.player.getHealty()
                        + "\n " + this.obstacle.getName() + "-->" + this.obstacle.getHealth());
                System.out.println("------------------------------------------");
            }
        }


        // print winne after the fight
        if (this.obstacle.getHealth() <= 0) {
            System.out.println(this.obstacle.getName() + " is dead .. Your health  : " + this.player.getHealty());
            System.out.println();

            getObstaclePrize();
            gainMoney();


        } else if (this.player.getHealty() <= 0) {
            System.out.println("----You Are Dead----"
                    + this.obstacle.getName() + " s health " + this.obstacle.getHealth()
                    + " your health : " + this.player.getHealty());
            System.out.println("------------------------------------");
            System.out.println("GAME OVER See You Next Time !!!!");
            System.out.println("------------------------------------");
            System.exit(0);

        }
    }


    public void gainMoney() {
        System.out.println("Ur old balance was = " + this.player.getMoney());
        System.out.println("Obstacle Had " + this.obstacle.getMoney() * this.obstacleNumber);
        this.player.setMoney(this.player.getMoney() + (this.obstacle.getMoney() * this.obstacleNumber));
        System.out.println("Ur new balance is : " + this.player.getMoney());
    }


    public void getObstaclePrize() {
        int obstacleId = this.obstacle.getId();
        switch (obstacleId) {
            case 3: {
                this.player.getInventory().setWater(true);
                System.out.println("U earned -WATER- for killing the  " + getObstacle().getName());
                break;
            }

            case 2: {
                this.player.getInventory().setFirewood(true);
                System.out.println(" U earned -FIREWOOD- for killing the " + getObstacle().getName());
                break;
            }

            case 1: {
                this.player.getInventory().setFood(true);
                System.out.println("U earned -FOOD- for killing the " + getObstacle().getName());
                break;
            }

            case 4:
                getSnakePrize();
                break;

        }
    }


    public void setObstacleDamage() {
        this.obstacle.setDamage(this.obstacle.getDamage() - this.player.getInventory().getArmorDefence());
    }

    public int randomObstacle() {
        r = new Random();
        return obstacleNumber = r.nextInt(this.getMaxObstacle()) + 1;
    }

    public battleLocation(Player player, String name, Obstacle obstacle, String prize, int maxObstacle) {
        this.player = player;
        this.name = name;
        this.obstacle = obstacle;
        this.prize = prize;
        this.maxObstacle = maxObstacle;
        this.scan = new Scanner(System.in);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public void setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
    }

    public String getSelectState() {
        return selectState;
    }

    public void setSelectState(String selectState) {
        this.selectState = selectState;
    }
}

