package antSimFiles;

public class Pheremone {
    private Type type;
    private Vector pos;
    private Vector dir;
    public final double lifespan = 200;
    private double strength;

    public Pheremone(Type type, Vector pos, Vector dir) {
        this.type = type;
        this.pos = pos;
        this.dir = dir;
        this.strength = lifespan;
    }

    public void update(){
        strength--;
    }

    public Type getType() {
        return type;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getDir() {
        return dir;
    }

    public double getStrength() {
        return strength;
    }

    enum Type{
        TOHOME,TOFOOD
    }
}
