
package igra;

import java.util.Random;

public class Fight {
    
    public Monster fightRound(Monster monster1, Monster monster2){
        
        Monster attacker = new Monster();
        Monster defender = new Monster();
        
            //Faster monster is attacker
            if(monster1.speed >= monster2.speed){
                attacker = monster1;
                defender = monster2;
            
            } else {
                attacker = monster2;
                defender = monster1;
            }
            
        //Checking if any of monsters is dead
        while((defender.hp >= 0) && (attacker.hp >= 0))
        {    
            if(attacker.attack > defender.defence){
            
                int temp;
                int damageRand;
                Random random = new Random();
                int lowDamage = attacker.damageL;
                int highDamage = attacker.damageH;
                damageRand = randomDamage(lowDamage, highDamage, random);
                
                temp = attacker.attack - defender.defence;
                int damagePlus = ((temp * damageRand)/40)+1;
                int damageFinal = damageRand + damagePlus;
                int damageFinal2 = damageFinal * attacker.amount;
                defender = amountCount(damageFinal2, defender);

                
                //if defender survived
                if(defender.hp > 0) {
                    
                    if (defender.attack > attacker.defence){
                        
                        lowDamage = defender.damageL;
                        highDamage = defender.damageH;
                        damageRand = randomDamage(lowDamage, highDamage, random);
                
                        temp = defender.attack - attacker.defence;
                        damagePlus = ((temp * damageRand)/40)+1;
                        damageFinal = damageRand - damagePlus;
                        damageFinal2 = damageFinal * defender.amount;
                        attacker = amountCount(damageFinal2, attacker);

                    }else{
                        
                        lowDamage = defender.damageL;
                        highDamage = defender.damageH;
                        damageRand = randomDamage(lowDamage, highDamage, random);
                        
                        temp = attacker.defence - defender.attack;
                        int damageMinus = ((temp * damageRand)/40)+1;
                        damageFinal = damageRand - damageMinus;
                        damageFinal2 = damageFinal * defender.amount;
                        attacker = amountCount(damageFinal2, attacker);
                    }
                }
                else
                    break;
             
            }else{
            
                int temp;
                int damageRand;
                int lowDamage = attacker.damageL;
                int highDamage = attacker.damageH;
                Random random = new Random();
                Random generator = new Random();
                
                damageRand = randomDamage(lowDamage, highDamage, random);
            
                temp = defender.defence - attacker.attack;
                int damageMinus = ((temp * damageRand)/40)+1;
                int damageFinal = damageRand - damageMinus;
                int damageFinal2 = damageFinal * attacker.amount;
                defender = amountCount(damageFinal2, defender);
                
                if(defender.hp > 0){
                    
                    if (defender.attack > attacker.defence){
                
                        lowDamage = defender.damageL;
                        highDamage = defender.damageH;
                        damageRand = randomDamage(lowDamage, highDamage, random);
                        temp = defender.attack - attacker.defence;
                        
                        int damagePlus = ((temp * damageRand)/40)+1;
                        damageFinal = damageRand - damagePlus;
                        damageFinal2 = damageFinal * defender.amount;
                        attacker = amountCount(damageFinal2, attacker);
                    }else{
                       
                        lowDamage = defender.damageL;
                        highDamage = defender.damageH;
                        temp = attacker.defence - defender.attack;
                        damageRand = randomDamage(lowDamage, highDamage, random);
                       
                        damageMinus = ((temp * damageRand)/40)+1;
                        damageFinal = damageRand - damageMinus;
                        damageFinal2 = damageFinal * defender.amount;
                        attacker = amountCount(damageFinal2, attacker);
                    }
                }
                else
                    break;                  
            }
        } 
        
        if(attacker.hp <= 0)
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
            result = amountResult / defender.amount;
            hpLeft = amountResult % defender.amount;
            defender.amount = defender.amount - result;
            defender.hp = defender.hp - hpLeft;

            return defender;
    }
}
