package integral;


import dto.InputData;

public abstract class Integral {

    protected InputData data;

    public abstract Double func(Double x);

    public abstract double primordial(double x);

    public InputData getData() {
        return data;
    }

    public void setData(InputData data) {
        this.data = data;
    }
}
