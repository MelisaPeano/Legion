package university.jala.capstonelegion.players;

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

    public List<Character> createCharacter(int[] amount) {
        List<Character> players = new ArrayList<>();
        Random random = new Random();

        int live = lives[random.nextInt(lives.length)];
        int speed = speeds[random.nextInt(speeds.length)];
        int force = forces[random.nextInt(forces.length)];
        int rank = ranks[random.nextInt(ranks.length)];

        int amountCommander = amount[0];
        int amountMedic = amount[1];
        int amountTanks = amount[2];
        int amountSnipers = amount[3];
        int amountInfantery = amount[4];

        for (int i = 0; i < amountCommander; i++) {
            String name = "Commander" + (i + 1);
            Commander commander = new Commander(name,live,speed,force,rank);
            players.add(commander);
        }
        for (int i = 0; i < amountMedic; i++) {
            String name = "Medic" + (i + 1);
            Medic medic = new Medic(name, live,speed,force, rank);
            players.add(medic);
        }
        for (int i = 0; i < amountTanks; i++) {
            String name = "Tank" + (i + 1);
            Tank tank = new Tank(name, live, speed, force, rank);
            players.add(tank);
        }
        for (int i = 0; i < amountSnipers; i++) {
            String name = "Sniper" + (i + 1);
            Sniper sniper = new Sniper(name, live, speed, force, rank);
            players.add(sniper);
        }
        for (int i = 0; i < amountInfantery; i++) {
            String name = "Infanter" + (i + 1);
            Infantry infantry = new Infantry(name, live, speed, force, rank);
            players.add(infantry);
        }

        return players;
    }


}
