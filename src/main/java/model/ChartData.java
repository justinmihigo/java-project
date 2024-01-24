
package model;

import java.util.List;

public class ChartData {
    private List<Integer> timePoints;
    private List<Integer> values;

    public List<Integer> getTimePoints() {
        return timePoints;
    }

    public void setTimePoints(List<Integer> timePoints) {
        this.timePoints = timePoints;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public ChartData(List<Integer> timePoints, List<Integer> values) {
        this.timePoints = timePoints;
        this.values = values;
    } 
}
