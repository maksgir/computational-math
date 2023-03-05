package com.maksgir.lab2.graphic;

import com.maksgir.lab2.dto.AnswerEquation;
import com.maksgir.lab2.dto.AnswerSystem;
import com.maksgir.lab2.dto.InputData;
import com.maksgir.lab2.system.SystemTask;
import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiFunction;

public class GraphicWorker {



    public static void showEquation(AnswerEquation answer) {

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        addEquationOnGraph(plot, (Double x, Double y) -> answer.getEquation().f(x), answer.getInterval());

//        Point2D point2D = new Point2D.Double(answer.getX(), 0);

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("Ответ");
        frame.setSize(800, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    public static void showSystem(AnswerSystem answer) {

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();


//        Point2D point2D = new Point2D.Double(answer.getX(), 0);

        addSystemOnGraph(plot, answer.getSystem(), new InputData(answer.getInterval().getA(), answer.getInterval().getB()));

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("Ответ");
        frame.setSize(800, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    private static void addEquationOnGraph(Plot2DPanel plot, BiFunction<Double, Double, Double> f, InputData interval) {
        double[] x = new double[30];
        double[] y = new double[30];
        double start = interval.getA() - 0.5;
        for (int i = 0; i < 30; i++) {
            x[i] = start;
            y[i] = f.apply(start, 0d);
            start += 0.05;
        }

        plot.addLinePlot("", Color.BLUE, x, y);

        double[] x0 = {interval.getA() - 2, 0};
        double[] y0 = {interval.getB() + 2, 0};
        plot.addLinePlot("y=0", Color.DARK_GRAY, x0, y0);


    }

    private static void addSystemOnGraph(Plot2DPanel plot, SystemTask system, InputData interval) {
        addEquationOnGraph(plot, system::firstEquation, interval);
        addEquationOnGraph(plot, system::secondEquation, interval);
    }
}
