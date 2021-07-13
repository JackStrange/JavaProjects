package antSimFiles;

import java.util.Random;

public class Ant {
    private final double speed = 3;
    private final double turningAngle = 15;
    private Vector pos;
    private Vector dir;
    private boolean food;

    public Ant(){
        Random rn = new Random();
        pos = new Vector(rn.nextDouble()*1000,rn.nextDouble()*1000);
        double angle = rn.nextDouble() * 2 * Math.PI;
        dir = new Vector(Math.sin(angle),Math.cos(angle));
        food = false;
    }

    public Ant(Vector pos){
        Random rn = new Random();
        this.pos = pos;
        double angle = rn.nextDouble() * 2 * Math.PI;
        dir = new Vector(Math.sin(angle),Math.cos(angle));
        food = false;
    }

    public Ant(Vector pos, Vector dir){
        this.pos = pos;
        this.dir = dir;
        food = false;
    }

    public void move(){
        Random rn = new Random();
        double adjustAngle = ((rn.nextDouble() * 2) - 1) * turningAngle * Math.PI / 180;
        double newAngle = Math.atan2(this.dir.x,this.dir.y) + adjustAngle;
        dir = new Vector(Math.sin(newAngle),Math.cos(newAngle));
        pos = pos.add(dir.mult(speed));
    }
}
