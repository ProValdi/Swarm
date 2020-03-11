package main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class View extends Pane {

    private ViewModel viewModel;

    public View(ViewModel viewModel) {
        this.viewModel = viewModel;

        MasterNodeView master = new MasterNodeView(100, 100, 40, Color.CRIMSON, new MasterNodeViewModel());

        getChildren().add(master);
    }

}
