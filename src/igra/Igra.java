
package igra;

import java.util.Scanner;

public class Igra {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Monster monster1 = new Monster();
        Monster monster2 = new Monster();
        Monster winner = new Monster();
        Fight F = new Fight();
        
     
        System.out.println("Enter name of the monster1: \n");
        monster1.name = input.nextLine();
        System.out.println("Enter attack of the monster1: \n");
        monster1.attack = input.nextInt();
        System.out.println("Enter defence of the monster1: \n");
        monster1.defence = input.nextInt();
        System.out.println("Enter lower damage of the monster1: \n");
        monster1.damageL = input.nextInt();
        System.out.println("Enter higher damage of the monster1: \n");
        monster1.damageH = input.nextInt();
        System.out.println("Enter hp of the monster1: \n");
        monster1.hp = input.nextInt();
        System.out.println("Enter speed of the monster1: \n");
        monster1.speed = input.nextInt();
        System.out.println("Enter amount of the monster1");
        monster1.amount = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter name of the monster2: \n");
        monster2.name = input.nextLine();
        System.out.println("Enter attack of the monster2: \n");
        monster2.attack = input.nextInt();
        System.out.println("Enter defence of the monster2: \n");
        monster2.defence = input.nextInt();
        System.out.println("Enter lower damage of the monster2: \n");
        monster2.damageL = input.nextInt();
        System.out.println("Enter higher damage of the monster2: \n");
        monster2.damageH = input.nextInt();
        System.out.println("Enter hp of the monster2: \n");
        monster2.hp = input.nextInt();
        System.out.println("Enter speed of the monster2: \n");
        monster2.speed = input.nextInt();
        System.out.println("Enter amount ofthe monster2");
        monster2.amount = input.nextInt();
        
        
        
        System.out.printf("+++++++%s+++++++\n", monster1.name);
        System.out.printf("Attack: %d\n", monster1.attack);
        System.out.printf("Defence: %d\n", monster1.defence);
        System.out.printf("DamageL: %d\n", monster1.damageL);
        System.out.printf("DamageH: %d\n", monster1.damageH);
        System.out.printf("HP: %d\n", monster1.hp);
        System.out.printf("Speed: %d\n", monster1.speed);
        System.out.printf("Amount: %d\n", monster1.amount);
        
        System.out.printf("+++++++%s+++++++\n", monster2.name);
        System.out.printf("Attack: %d\n", monster2.attack);
        System.out.printf("Defence: %d\n", monster2.defence);
        System.out.printf("DamageL: %d\n", monster2.damageL);
        System.out.printf("DamageH: %d\n", monster2.damageH);
        System.out.printf("HP: %d\n", monster2.hp);
        System.out.printf("Speed: %d\n", monster2.speed);
        System.out.printf("Amount: %d\n", monster2.amount);
        
        winner = F.fightRound(monster1, monster2);
        
        System.out.printf("The winner is %s\n", winner.name);
        System.out.printf("Hit points left: %d", winner.hp);

    }  
}


