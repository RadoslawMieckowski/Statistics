package miniLotto.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Two implements Serializable {
    private int firstNumber;
    private int secondNumber;
    private List<Integer> distances;
    private int maxInterval;
    private int minInterval;
    private double avgInterval;
    private double medOfintervals;
    private double q3Ofintervals;
    private int lastOccurence;
    private static final long serialVersionUID = -5833841541984247747L;
}
