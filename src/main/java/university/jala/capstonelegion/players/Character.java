package university.jala.capstonelegion.players;

public abstract class Character {
    protected String name;
    protected int live;
    protected int speed;
    protected int force;
    protected int rank;

    public Character(String name, int live, int speed, int force, int rank) {
        this.name = name;
        this.live = live;
        this.speed = speed;
        this.force = force;
        this.rank = rank;
    }

}
