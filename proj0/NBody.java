import java.awt.*;

public class NBody{
    public static double readRadius(String dir){
        In in = new In(dir);
        int number=in.readInt();
        double radius=in.readDouble();
        return radius;
    }
    public static int readnubnmer(String dir){
        In in = new In(dir);
        int number=in.readInt();
        return number;
    }
    public static Body[] readBodies(String planetsTxtPath) {
        In in=new In(planetsTxtPath);
        int number=in.readInt();
        double radius=in.readDouble();
        Body[] bodies=new Body[number];
        for(int i=0;i<number;i++){
            bodies[i]=new Body(0,0,0,0,0,null);
        }
        for(int i=0;i<number;i++) {
            bodies[i].xxPos=in.readDouble();
            bodies[i].yyPos=in.readDouble();
            bodies[i].xxVel=in.readDouble();
            bodies[i].yyVel=in.readDouble();
            bodies[i].mass=in.readDouble();
            bodies[i].imgFileName=in.readString();
        }
        return bodies;
    }
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Body[] bodies=readBodies(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setScale(-radius,radius);
        /* Clears the drawing window. */
        StdDraw.clear();
        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0, 0, imageToDraw,radius,radius);
        for(int i=0;i<readnubnmer(filename);i++){
            bodies[i].draw();
        }
        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        StdDraw.show();
        StdDraw.pause(20);

        double time=0;
        while (time<T) {
            time=time+dt;
            double[] xforce=new double[readnubnmer(filename)];
            double[] yforce=new double[readnubnmer(filename)];
            for(int i=0;i<readnubnmer(filename);i++){
                xforce[i]=bodies[i].calcNetForceExertedByX(bodies);
                yforce[i]=bodies[i].calcNetForceExertedByY(bodies);
            }
            for(int i=0;i<readnubnmer(filename);i++){
                bodies[i].update(dt,xforce[i],yforce[i]);
            }
            StdDraw.clear();

            StdDraw.picture(0, 0, imageToDraw,2*radius,2*radius);
            for(int i=0;i<readnubnmer(filename);i++){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(20);

        }

    }



}

