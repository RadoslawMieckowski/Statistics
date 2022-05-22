package miniLotto.models;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Two implements Serializable {
    int firstNumber;
    int secondNumber;
    private int maxInterval;
    private int minInterval;
    private int avgInterval;
    private double medOfintervals;
    private double q3Ofintervals;
    int lastOccurence;
    private static final long serialVersionUID = -5833841541984247747L;
}
