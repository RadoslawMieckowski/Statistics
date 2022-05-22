package miniLotto.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Two {
    int firstNumber;
    int secondNumber;
    private int maxInterval;
    private int minInterval;
    private int avgInterval;
    private double medOfintervals;
    private double q3Ofintervals;
    int lastOccurence;
}
