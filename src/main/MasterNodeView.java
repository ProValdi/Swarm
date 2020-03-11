package main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MasterNodeView extends Circle {

    public MasterNodeView(double x, double y, double radius, Paint paint, MasterNodeViewModel masterViewModel) {
        super(x, y, radius, paint);

        addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setFill(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
                setCenterX(e.getX());
                setCenterY(e.getY());
                setRadius(getRadius() + 1);
            }
        });
    }

    public MasterNodeView(MasterNodeViewModel masterViewModel) {
        super();
    }

}