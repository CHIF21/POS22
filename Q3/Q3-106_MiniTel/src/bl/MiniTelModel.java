package bl;

import beans.MiniTelEntry;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniTelModel extends AbstractListModel<MiniTelEntry> {

    private List<MiniTelEntry> allEntries = null;
    private List<MiniTelEntry> filteredEntries = null;
    private String strFilter = "all";

    public MiniTelModel() {
        allEntries = new ArrayList<>();
        filteredEntries = new ArrayList<>(allEntries);
    }

    @Override
    public int getSize() {
        return filteredEntries.size();
    }

    @Override
    public MiniTelEntry getElementAt(int index) {
        return filteredEntries.get(index);
    }

    public void removeEntry(List<MiniTelEntry> entries) {
        allEntries.removeAll(entries);
        filterEntries();
    }

    public void insertEntry(MiniTelEntry entry) {
        if(!allEntries.contains(entry)) {
            allEntries.add(entry);
            Collections.sort(allEntries);
            filterEntries();
        }
    }

    public void filterEntries() {
        filterEntries(strFilter);
    }

    public void filterEntries(String filter) {
        strFilter = filter;
        filteredEntries.clear();
        if(strFilter.equals("all")) {
            filteredEntries.addAll(allEntries);
        } else {
            for (MiniTelEntry entry: allEntries) {
                if((entry.isOffical() ? "offical" : "privat").equalsIgnoreCase(strFilter)) {
                    filteredEntries.add(entry);
                }
            }
        }

        this.fireContentsChanged(this, 0, filteredEntries.size() - 1);
    }
}
