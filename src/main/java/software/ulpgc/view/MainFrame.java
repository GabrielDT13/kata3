package software.ulpgc.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final JFreeBarCharHistogram histogramDisplay;

    public MainFrame() throws HeadlessException {
        setTitle("Histogram Display");
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        histogramDisplay = new JFreeBarCharHistogram();
        add(histogramDisplay);
    }

    public void put(Histogram histogram) {
        histogramDisplay.display(histogram);
    }
}
