package dto;

public class Answer {
    private double answer;
    private int n;

    public Answer(double answer, int n) {
        this.answer = answer;
        this.n = n;
    }

    public double getAnswer() {
        return answer;
    }

    public int getN() {
        return n;
    }
}
