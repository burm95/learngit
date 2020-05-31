public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G=6.67e-11;
    public Body(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Body(Body b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }
    public double calcDistance(Body body){
        double dis;
        dis=Math.sqrt(Math.pow(this.xxPos-body.xxPos,2)+Math.pow(this.yyPos-body.yyPos,2));
        return dis;
    }
    public double calcForceExertedBy(Body body){
        double force;
        force=G*this.mass*body.mass/Math.pow(this.calcDistance(body),2);
        return force;
    }
    public double calcForceExertedByX(Body body){
        double fx;
        fx=calcForceExertedBy(body)*(body.xxPos-this.xxPos)/calcDistance(body);
        return fx;
    }
    public double calcForceExertedByY(Body body){
        double fy;
        fy=calcForceExertedBy(body)*(body.yyPos-this.yyPos)/calcDistance(body);
        return fy;
    }
    public double calcNetForceExertedByX(Body[] body) {
        double[] fx = new double[body.length];
        double fnet=0;
        for (int i = 0; i < body.length;i++){
        if (body[i].equals(this) != true) {
            fx[i] = this.calcForceExertedByX(body[i]);
        }
            fnet=fnet+fx[i];
    }
        return fnet;
    }
    public double calcNetForceExertedByY(Body[] body){
        double[] fy= new double[body.length];
        double fnet=0;
        for (int i = 0; i < body.length;i++){
            if (body[i].equals(this) != true) {
                fy[i] = this.calcForceExertedByY(body[i]);
            }
            fnet=fnet+fy[i];

        }
        return fnet;
    }
    public void update(double dt,double fx,double fy){
        double ax,ay;
        ax=fx/this.mass;
        ay=fy/this.mass;
        this.xxVel=this.xxVel+dt*ax;
        this.yyVel=this.yyVel+dt*ay;
        this.xxPos=this.xxPos+this.xxVel*dt;
        this.yyPos=this.yyPos+this.yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }

}
