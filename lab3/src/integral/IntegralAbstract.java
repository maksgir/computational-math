package integral;


public abstract class IntegralAbstract {

    protected double a;
    protected double b;
    protected int n;

    public IntegralAbstract(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public abstract Double func(Double x);
}
