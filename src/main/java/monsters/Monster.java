package monsters;

import Equipment.MonsterWeapon;
import Equipment.MonsterWeaponType;
import adventurers.Person;
import behaviours.IDefend;
import behaviours.IPlayer;

import java.util.ArrayList;


public class Monster implements IDefend {
    private int hp;
    private MonsterWeapon weapon;

    public Monster(int hp, MonsterWeapon weapon) {
        this.hp = hp;
        this.weapon = weapon;

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public MonsterWeaponType getMonsterWeapon(){
        return weapon.getWeaponType();
    }

    public int getWeaponDamage(){
        return this.weapon.getWeaponDamage();
    }

    public void takesDamage(double attack){
        int hp = this.getHp();
        if (attack >= hp){
            this.setHp(0);
        } else {
            hp -= attack;
            this.setHp(hp);
        }
    }

//    public void monsterAttack(ArrayList<IPlayer> players){
//        int damage = this.getWeaponDamage() / players.size();
//        for(IPlayer player : players){
//            ((Person) player).takesDamage(damage);
//        }
//    }

    public void attack(IPlayer player, int attack){
        ((Person) player).takesDamage(attack);
    }
}
