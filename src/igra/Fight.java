
package igra;

import java.util.Random;

public class Fight {
    
    public Monster fightRound(Monster monster1, Monster monster2){
        
        Monster attacker = new Monster();
        Monster defender = new Monster();
        
            //Faster monster is attacker
            if(monster1.speed > monster2.speed){
                attacker = monster1;
                defender = monster2;
            } else {
                attacker = monster2;
                defender = monster1;
            }
            
        //Checking if any of monsters is dead
        while((defender.amount > 0) && (attacker.amount > 0)){                
                
            int temp;
            int damageRand;
            int lowDamageA;
            int lowDamageD;
            int highDamageD;
            int highDamageA;
            int damageBonus;
            int damageFinal;
            Random random = new Random();
            
            lowDamageA = attacker.damageL;
            highDamageA = attacker.damageH;
            
            damageRand = randomDamage(lowDamageA, highDamageA, random);

            temp = attacker.attack - defender.defence;
            damageBonus = ((temp * damageRand)/40)+1;
            damageFinal = (damageRand + damageBonus) * attacker.amount -1;
            defender = amountCount(damageFinal, defender);
     
                //if defender survived
            if(defender.amount > 0) {

                lowDamageD = defender.damageL;
                highDamageD = defender.damageH;
                int i = 2;
                
                while(i > 0){
                
                    damageRand = randomDamage(lowDamageD, highDamageD, random);

                    temp = defender.attack - attacker.defence;
                    damageBonus = ((temp * damageRand)/40)+1;
                    damageFinal = ((damageRand + damageBonus) * defender.amount -1)/i;
                    attacker = amountCount(damageFinal, attacker);
                    
                    i--;
                }
            }
            else
                break;
            
            if(attacker.amount > 0){
            
                damageRand = randomDamage(lowDamageA, highDamageA, random);

                temp = attacker.attack - defender.defence;
                damageBonus = ((temp * damageRand)/40)+1;
                damageFinal = ((damageRand + damageBonus) * attacker.amount -1)/2;
                defender = amountCount(damageFinal, defender);
            }
            else
                break;
                             
        } 
        
        if(attacker.amount <= 0)
            return defender;
        else
            return attacker;
    }    
    
        private static int randomDamage(int aStart, int aEnd, Random aRandom){

            if (aStart > aEnd) {
                throw new IllegalArgumentException("Start cannot exceed End.");
            }

            long range = (long)aEnd - (long)aStart + 1;
            long fraction = (long)(range * aRandom.nextDouble());
            int randomNumber =  (int)(fraction + aStart);

            return randomNumber;
       }
    
        private Monster amountCount(int attackerDamage, Monster defender){

            int defenderHpAmount;
            int attackerDamageAmount;
            int amountResult;
            int result;
            int hpLeft;

            defenderHpAmount = defender.hp * defender.amount;
            attackerDamageAmount = attackerDamage;
            amountResult = defenderHpAmount - attackerDamageAmount;
            result = amountResult / defender.hp;
            hpLeft = amountResult % defender.hp;
            defender.amount = result;
            defender.hp = hpLeft;

            return defender;
    }
}
