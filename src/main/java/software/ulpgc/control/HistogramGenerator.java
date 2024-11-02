package software.ulpgc.control;

import software.ulpgc.model.Title;
import software.ulpgc.view.Histogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistogramGenerator {


    public Histogram generate(List<Title> titles) {
        HashMap<String, Integer> result = new HashMap<>();
        for(Title title: titles){
            result.put(title.titleType().name(), result.getOrDefault(title.titleType().name(), 0) +1);
        }

        return new Histogram() {
            @Override
            public String title() {
                return "Title types Distribution";
            }

            @Override
            public List<String> labels() {
                return new ArrayList<>(result.keySet());
            }

            @Override
            public int valueOf(String label) {
                return result.get(label);
            }
        };
    }
}
