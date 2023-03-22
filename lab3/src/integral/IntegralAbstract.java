package integral;


import dto.InputData;

public abstract class IntegralAbstract {

    protected InputData data;

    public abstract Double func(Double x);

    public InputData getData() {
        return data;
    }

    public void setData(InputData data) {
        this.data = data;
    }
}
