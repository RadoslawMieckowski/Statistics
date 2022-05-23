package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.List;
import java.util.stream.Collectors;

public final class Filter {
    private Filter() {}

    public static List<Two> filterTwosWithLastBiggerthanMed(@NonNull List<Two> twoList) { //jak działać tylko na kopii nie zmieniając orginału?
        return  twoList.stream()
                .filter(x -> x.isLastBiggerthanMed() == true)
                .collect(Collectors.toList());
    }
}
