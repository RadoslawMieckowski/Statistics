package miniLotto.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Rounder {

    private Rounder() {

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        if (Double.isNaN(value))
        {
            return 0;
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
