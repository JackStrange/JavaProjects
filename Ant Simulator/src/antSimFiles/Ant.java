package antSimFiles;

import java.util.Random;

public class Ant {
    private final double speed = 3;
    private final double turningAngle = 15;
    private Vector pos;

    private Vector dir;

    public boolean isFood() {
        return food;
    }

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
        Pheremone bestPher = new Pheremone(null,new Vector(9999999,9999999),null,0);
        boolean pherFound = false;
        for(Pheremone pher:Main.pheremones){
            Vector diffVec = this.pos.add(pher.getPos().mult(-1));
            double dist = Math.sqrt(Math.pow(diffVec.x,2) + Math.pow(diffVec.y,2));
            if(dist < 20 && pher.getStrength() > bestPher.getStrength()){
                if ((food && pher.getType() == Pheremone.Type.TOHOME) || (!food && pher.getType() == Pheremone.Type.TOFOOD)){
                    bestPher = pher;
                    pherFound = true;
                }
            }
        }

        if(!food) {
            Food foundFood = null;
            for (Food food : Main.foods) {
                Vector diffVec = this.pos.add(food.getPos().mult(-1));
                double dist = Math.sqrt(Math.pow(diffVec.x, 2) + Math.pow(diffVec.y, 2));
                if (dist < 20) {
                    this.food = true;
                    foundFood = food;
                    break;
                }
            }
            if(!(foundFood == null)){
                Main.foods.remove(foundFood);
            }
        }

        if(pherFound && rn.nextDouble()>0.15){
            dir = bestPher.getDir();
        }else {
            double adjustAngle = ((rn.nextDouble() * 2) - 1) * turningAngle * Math.PI / 180;
            double newAngle = Math.atan2(this.dir.x, this.dir.y) + adjustAngle;
            dir = new Vector(Math.sin(newAngle), Math.cos(newAngle));
        }
        pos = pos.add(dir.mult(speed));
        if(pos.x < 0){
            pos.x = 0;
            dir.x = -dir.x;
        }
        if(pos.x > 1000){
            pos.x = 1000;
            dir.x = -dir.x;
        }
        if(pos.y > 1000){
            pos.y = 1000;
            dir.y = -dir.y;
        }
        if(pos.y < 0){
            pos.y = 0;
            dir.y = -dir.y;
        }

        if(rn.nextDouble() < 0.01){
            if(this.food){
                Main.pheremones.add(new Pheremone(Pheremone.Type.TOFOOD,this.pos,this.dir.mult(-1)));
            }else{
                Main.pheremones.add(new Pheremone(Pheremone.Type.TOHOME, this.pos, this.dir.mult(-1)));
            }
        }
    }

    public Vector getPos(){
        return this.pos;
    }

    public Vector getDir(){
        return this.dir;
    }
}
