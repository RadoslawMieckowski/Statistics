package miniLotto.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

public class Two implements Serializable {
    @Setter
    @Getter
    private int firstNumber;
    @Setter
    @Getter
    private int secondNumber;
    @Setter
    @Getter
    private List<Integer> distances;
    @Setter
    @Getter
    private int maxInterval;
    @Setter
    @Getter
    private int minInterval;
    @Setter
    @Getter
    private double avgInterval;
    @NonNull
    @Getter
    private double medOfintervals;
    @NonNull
    @Getter
    private double q3Ofintervals;
    @NonNull
    @Getter
    private int lastOccurence;
    @Getter
    private boolean isLastBiggerthanMed;
    @Getter
    private boolean isLastBiggerthanQ3;
    private static final long serialVersionUID = -5833841541984247747L;

    public void setMedOfintervals(double medOfintervals) {
        this.medOfintervals = medOfintervals;
        setLastBiggerthanMed();
    }

    public void setQ3Ofintervals(double q3Ofintervals) {
        this.q3Ofintervals = q3Ofintervals;
        setLastBiggerthanQ3();
    }

    public void setLastOccurence(int lastOccurence) {
        this.lastOccurence = lastOccurence;
        if(lastOccurence > maxInterval) {
            maxInterval =lastOccurence;
        }
    }

    private void setLastBiggerthanMed() {
        isLastBiggerthanMed = lastOccurence > medOfintervals;
    }

    private void setLastBiggerthanQ3() {
        isLastBiggerthanQ3 = lastOccurence > q3Ofintervals;
    }
    @Builder
    public Two(int firstNumber, int secondNumber, List<Integer> distances, int maxInterval, int minInterval, double avgInterval, @NonNull double medOfintervals, @NonNull double q3Ofintervals, @NonNull int lastOccurence) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.distances = distances;
        this.maxInterval = maxInterval;
        this.minInterval = minInterval;
        this.avgInterval = avgInterval;
        this.medOfintervals = medOfintervals;
        this.q3Ofintervals = q3Ofintervals;
        this.lastOccurence = lastOccurence;
        setLastBiggerthanMed();
        setLastBiggerthanQ3();
    }

    @Override
    public String toString() {
        return firstNumber + " | "+ secondNumber + "\n"+
                "distances=" + distances + "\n" +
                "maxInterval=" + maxInterval + "\n" +
                "minInterval=" + minInterval + "\n" +
                "avgInterval=" + avgInterval + "\n" +
                "medOfintervals=" + medOfintervals + "\n" +
                "q3Ofintervals=" + q3Ofintervals + "\n" +
                "lastOccurence=" + lastOccurence + "\n" +
                "isLastBiggerthanMed=" + isLastBiggerthanMed + "\n" +
                "isLastBiggerthanQ3=" + isLastBiggerthanQ3;
    }
}
