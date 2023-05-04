package beans;

import java.util.Objects;

public class MiniTelEntry implements Comparable<MiniTelEntry> {

    private String name;
    private String number;
    private boolean offical;

    public MiniTelEntry(String name, String number, boolean offical) {
        this.name = name;
        this.number = number;
        this.offical = offical;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isOffical() {
        return offical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiniTelEntry that = (MiniTelEntry) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return String.format("%-20s - %s", name, number);
    }

    @Override
    public int compareTo(MiniTelEntry o) {
        return name.compareTo(o.getName());
    }
}
