package main;

import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.desktop.SystemEventListener;


public class MasterNodeView extends Circle {

    public MasterNodeView(double x, double y, double radius, Paint paint, MasterNodeViewModel masterViewModel) throws InterruptedException {
        super(x, y, radius, paint);

        addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                showSelectedNode();
            }
        });

    }

    public MasterNodeView(MasterNodeViewModel masterViewModel) {
        super();
    }

    private double inflateRadius = 10;

    public void showSelectedNode() {

        RadialGradient gradient1 = new RadialGradient(0,
                .1,
                getCenterX(),
                getCenterY(),
                getRadius() + 40,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.RED),
                new Stop(1, Color.BLACK));
        setFill(gradient1);
/*
        FillTransition ft = new FillTransition(Duration.millis(500), this, Color.RED, Color.LIGHTPINK);
        ft.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setFill(Color.BLUE);
            }
        });
        ft.setCycleCount(TranslateTransition.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
*/
    }

    public void moveNodeTo(double x, double y) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), this);
        transition.setToX(-getCenterX() + x);
        transition.setToY(-getCenterY() + y);
        transition.play();
    }

}