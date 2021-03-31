import Equipment.*;
import adventurers.Cleric;
import adventurers.Knight;
import monsters.Troll;
import org.junit.Before;
import org.junit.Test;
import quest.Quest;
import room.MonsterRoom;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Knight knight;
    Cleric cleric;
    Troll troll;
    MonsterRoom room;
    MonsterWeapon mWeapon;
    Weapon weapon;
    Quest quest;
    Quest quest1;
    HealingTool healing;

    @Before
    public void before(){
        weapon = new Weapon(WeaponType.SWORD);
        healing = new HealingTool(HealingToolType.POTION);
        knight = new Knight("Harold", 100, weapon);
        cleric = new Cleric("Tod", 100, healing);
        mWeapon = new MonsterWeapon(MonsterWeaponType.SPEAR);
        troll = new Troll(100, mWeapon);
        room = new MonsterRoom("Bridge", troll);
        quest = new Quest(knight, room);
        quest1 = new Quest(cleric, room);
    }

    @Test
    public void questHasKnight(){
        assertEquals("Harold", quest.getPlayerName());
    }

    @Test
    public void questHasRoom(){
        assertEquals("Bridge", quest.getRoomName());
    }

    @Test
    public void questHasTrollAttack(){
        assertEquals(15, quest.getMonsterAttack());
    }

    @Test
    public void questHasFighterAttack(){
        assertEquals(15, quest.getPlayerAttack());
    }

    @Test
    public void playerHasHp(){
        assertEquals(100, quest.getPlayerHp());
    }

    @Test
    public void playerTakesDamage(){
        quest.monsterAttacksPlayer();
        assertEquals(95, quest.getPlayerHp());
    }

    @Test
    public void playerTakesDamage1(){
        quest1.monsterAttacksPlayer();
        assertEquals(85, quest1.getPlayerHp());
    }

    @Test
    public void playerAttacks(){
        quest.playerAttack();
        assertEquals(85, quest.getMonsterHp());
    }


}
