package antSimFiles;

public class Vector {
    public double x;
    public double y;

    public Vector(){
        x = 0;
        y = 0;
    }

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector mult(double multiplier){
        return new Vector(this.x*multiplier,this.y*multiplier);
    }

    public Vector add(Vector adder){
        return new Vector(this.x + adder.x,this.y + adder.y);
    }
}
