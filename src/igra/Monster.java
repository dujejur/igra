
package igra;

public class Monster {
    
    String name;
    int attack;
    int defence;
    int damageL;
    int damageH;
    int hp;
    int speed;
    int amount;
    
    public Monster(){
        
    }
    
    public Monster(String monsterName, int monsterAttack, int monsterDefence, int monsterDamageL,int monsterDamageH, int monsterHp, int monsterSpeed, int monsterAmount){
        
        name = monsterName;
        attack = monsterAttack;
        defence = monsterDefence;
        damageL = monsterDamageL;
        damageH = monsterDamageH;
        hp = monsterHp;
        speed = monsterSpeed;
        amount = monsterAmount;
    
        }
    
    public Monster amountCount(int attackerDamage, Monster defender, int damageDone){
        
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

