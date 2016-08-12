
package igra;
import java.util.Scanner;
import java.sql.*;

public class Igra {

    public static void main(String[] args) throws SQLException {
        
        
        int temp;
        Scanner input = new Scanner(System.in);
        Monster monster1 = new Monster();
        Monster monster2 = new Monster();
        Monster winner = new Monster();
        Fight fight = new Fight();
        DataAccessLayer connect = new DataAccessLayer("root", "Split321");
        ResultSet result = connect.ExecuteQuery("select * from monster");
        
       
        
     
        System.out.println("Enter name of the monster1: \n");
        monster1.name = input.nextLine();
        System.out.printf("Enter attack of the %s: \n", monster1.name);
        monster1.attack = input.nextInt();
        System.out.printf("Enter defence of the %s: \n", monster1.name);
        monster1.defence = input.nextInt();
        System.out.printf("Enter lower damage of the %s: \n", monster1.name);
        monster1.damageL = input.nextInt();
        System.out.printf("Enter higher damage of the %s: \n", monster1.name);
        monster1.damageH = input.nextInt();
        System.out.printf("Enter hp of the %s: \n", monster1.name);
        monster1.hp = input.nextInt();
        System.out.printf("Enter speed of the %s: \n", monster1.name);
        monster1.speed = input.nextInt();
        System.out.printf("Enter amount of the %s: \n" , monster1.name);
        monster1.amount = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter name of the monster2: \n");
        monster2.name = input.nextLine();
        System.out.printf("Enter attack of the %s: \n", monster2.name);
        monster2.attack = input.nextInt();
        System.out.printf("Enter defence of the %s: \n", monster2.name);
        monster2.defence = input.nextInt();
        System.out.printf("Enter lower damage of the %s: \n", monster2.name);
        monster2.damageL = input.nextInt();
        System.out.printf("Enter higher damage of the %s: \n", monster2.name);
        monster2.damageH = input.nextInt();
        System.out.printf("Enter hp of the %s: \n", monster2.name);
        monster2.hp = input.nextInt();
        System.out.printf("Enter speed of the %s: \n", monster2.name);
        monster2.speed = input.nextInt();
        System.out.printf("Enter amount of the %s: \n", monster2.name);
        monster2.amount = input.nextInt();
        
        if(monster1.damageH < monster1.damageL){
            
            temp = monster1.damageH;
            monster1.damageH = monster1.damageL;
            monster1.damageL = temp;
            
        } 
        if(monster2.damageH < monster2.damageL){
            
            temp = monster2.damageH;
            monster2.damageH = monster2.damageL;
            monster2.damageL = temp;
            
        }
        
        
        
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
        
        monster1.amount = monster1.amount + 1;
        monster2.amount = monster2.amount + 1;
        
        winner = fight.fightRound(monster1, monster2);
        
        System.out.printf("The winner is %s\n", winner.name);
        System.out.printf("Amount left: %d\n", winner.amount);
        System.out.printf("Hit points left: %d", winner.hp);

    }  
}


