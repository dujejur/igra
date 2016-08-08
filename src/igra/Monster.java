
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
    }

