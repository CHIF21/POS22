package bl;

import beans.Route;
import beans.Training;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainingsModel extends AbstractListModel<Training> {

    List<Training> allTraining = null;
    List<Training> filteredTraining = null;

    public TrainingsModel() {
        allTraining = new ArrayList<>();
        filteredTraining = new ArrayList<>(allTraining);
    }

    @Override
    public int getSize() {
        return filteredTraining.size();
    }

    @Override
    public Training getElementAt(int index) {
        return filteredTraining.get(index);
    }

    public void addTraining(Training training) throws Exception {
        if(!allTraining.contains(training)) {
            allTraining.add(training);
            filterTraining();
            this.fireContentsChanged(this, 0, allTraining.size());
        } else {
            throw new Exception();
        }
    }

    public void sortTraining() {
        Collections.sort(allTraining);
        this.fireContentsChanged(this, 0, allTraining.size());
    }

    public void filterTraining(Route selectedValue) {
        filteredTraining.clear();
        for (Training training : allTraining) {
            if (training.getRoute().equals(selectedValue)) {
                filteredTraining.add(training);
            }
        }
        this.fireContentsChanged(this, 0, filteredTraining.size());
    }

    private void filterTraining() {
        Route selectedValue = null;
        if (!filteredTraining.isEmpty()) {
            selectedValue = filteredTraining.get(0).getRoute();
        }
        filteredTraining.clear();
        for (Training training : allTraining) {
            if (selectedValue == null || training.getRoute().equals(selectedValue)) {
                filteredTraining.add(training);
            }
        }
    }
}
