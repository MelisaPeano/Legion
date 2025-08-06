package university.jala.capstonelegion.players;

import university.jala.capstonelegion.enums.CharacterSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterFactory {
    int[] lives = {
            100, 90, 80, 110, 95, 85, 120, 70, 100, 105,
            80, 90, 75, 100, 110, 95, 85, 105, 115, 100
    };

    int[] speeds = {
            10, 12, 14, 9, 11, 13, 15, 8, 10, 12,
            14, 9, 11, 13, 15, 8, 10, 12, 14, 9
    };

    int[] forces = {
            20, 25, 30, 22, 28, 26, 24, 32, 18, 27,
            21, 29, 23, 26, 30, 25, 22, 28, 24, 31
    };

    int[] ranks = {
            1, 2, 3, 1, 2, 4, 5, 2, 3, 1,
            4, 5, 3, 2, 1, 4, 5, 3, 2, 1
    };
    public CharacterFactory() {}

    public List<GameCharacter> createCharacter(int[] amount) {
        List<GameCharacter> players = new ArrayList<>();
        Random random = new Random();

        CharacterSymbol symbolC= CharacterSymbol.COMMANDER;
        CharacterSymbol symbolM = CharacterSymbol.MEDIC;
        CharacterSymbol symbolT = CharacterSymbol.TANK;
        CharacterSymbol symbolS = CharacterSymbol.SNIPER;
        CharacterSymbol symbolI = CharacterSymbol.INFANT;


        int amountCommander = amount[0];
        int amountMedic = amount[1];
        int amountTanks = amount[2];
        int amountSnipers = amount[3];
        int amountInfantry = amount[4];

        for (int i = 0; i < amountCommander; i++) {
            String name = "Commander" + (i + 1);
            int live = lives[random.nextInt(lives.length)];
            int speed = speeds[random.nextInt(speeds.length)];
            int force = forces[random.nextInt(forces.length)];
            int rank = ranks[random.nextInt(ranks.length)];

            players.add(new Commander(name,live,speed,force,rank,symbolC));
        }
        for (int i = 0; i < amountMedic; i++) {
            String name = "Medic" + (i + 1);
            int live = lives[random.nextInt(lives.length)];
            int speed = speeds[random.nextInt(speeds.length)];
            int force = forces[random.nextInt(forces.length)];
            int rank = ranks[random.nextInt(ranks.length)];

            players.add(new Medic(name, live,speed,force, rank, symbolM));
        }
        for (int i = 0; i < amountTanks; i++) {
            String name = "Tank" + (i + 1);
            int live = lives[random.nextInt(lives.length)];
            int speed = speeds[random.nextInt(speeds.length)];
            int force = forces[random.nextInt(forces.length)];
            int rank = ranks[random.nextInt(ranks.length)];

            players.add(new Tank(name, live, speed, force, rank, symbolT));
        }
        for (int i = 0; i < amountSnipers; i++) {
            String name = "Sniper" + (i + 1);
            int live = lives[random.nextInt(lives.length)];
            int speed = speeds[random.nextInt(speeds.length)];
            int force = forces[random.nextInt(forces.length)];
            int rank = ranks[random.nextInt(ranks.length)];

            players.add(new Sniper(name, live, speed, force, rank, symbolS));
        }
        for (int i = 0; i < amountInfantry; i++) {
            String name = "Infant" + (i + 1);
            int live = lives[random.nextInt(lives.length)];
            int speed = speeds[random.nextInt(speeds.length)];
            int force = forces[random.nextInt(forces.length)];
            int rank = ranks[random.nextInt(ranks.length)];

            players.add(new Infantry(name, live, speed, force, rank, symbolI));
        }
        return players;
    }

}
