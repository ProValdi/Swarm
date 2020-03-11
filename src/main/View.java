package main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class View extends Pane {

    private ViewModel viewModel;

    public View(ViewModel viewModel) {
        this.viewModel = viewModel;

        try {
            MasterNodeView master = new MasterNodeView(100, 100, 40, Color.CRIMSON, new MasterNodeViewModel());

            getChildren().addAll(master);

            addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    double x = e.getSceneX();
                    double y = e.getSceneY();
                    System.out.println(x + " " + y);
                    master.moveNodeTo(x, y);
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void moveObjects(MasterNodeView... masters) {
        for (MasterNodeView master: masters) {
            master.showSelectedNode();
        }
    }

}
