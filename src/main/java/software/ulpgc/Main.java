package software.ulpgc;

import software.ulpgc.control.HistogramGenerator;
import software.ulpgc.control.TsvTitleReader;
import software.ulpgc.model.Title;
import software.ulpgc.view.Histogram;
import software.ulpgc.view.MainFrame;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file = "./title.basics.tsv";
        if(args.length>0) file = args[0];

        TsvTitleReader reader = new TsvTitleReader(new File(file));
        Histogram histogram = generateHistogram(reader, file);
        display(histogram);
    }

    private static void display(Histogram histogram) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put(histogram);
        mainFrame.setVisible(true);
    }

    private static Histogram generateHistogram(TsvTitleReader reader, String file) {
        List<Title> titles = reader.read(file);
        return new HistogramGenerator().generate(titles);
    }
}
