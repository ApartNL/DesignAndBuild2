package View;

import javax.swing.*;
import java.awt.*;
import Model.Simulator;

public class ImageView extends AbstractView {
    private ImageIcon image;
    private JLabel imageLabel;

    public ImageView(Simulator sim) {
        super(sim);
        this.image = new ImageIcon(getClass().getResource("../images/CityParkingGroningen_120x40.png"));
        this.imageLabel = new JLabel(image);
    }

    @Override public void updateView() {
        setLayout(new FlowLayout());
        this.add(imageLabel);
    }
}
