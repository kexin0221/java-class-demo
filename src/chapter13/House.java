package chapter13;

public class House implements Cloneable, Comparable<House> {
    private final int id;
    private final double area;
    private java.util.Date whenBuilt;

    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public java.util.Date getWhenBuilt() {
        return whenBuilt;
    }

    @Override
    public Object clone() {
        // Perform a shallow copy
        House houseClone = new House(id, area);
        // Deep copy on whenBuilt
        houseClone.whenBuilt = new java.util.Date();
        houseClone.getWhenBuilt().setTime(whenBuilt.getTime());
        return houseClone;
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
        return Double.compare(area, o.area);
    }
}
