package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.List;
import java.util.stream.Collectors;

public final class Filter {
    private Filter() {}

    public static List<Two> filterTwosWithLastBiggerthanMed(@NonNull List<Two> twoList) { //jak działać tylko na kopii nie zmieniając orginału?
        return  twoList.stream() //czy to nie załatwia sprawy??     załatwia ;)
                .filter(Two::isLastBiggerthanMed)
                .collect(Collectors.toList());
    }

    public static List<Two> filterTwosWithLastBiggerthan3Q(@NonNull List<Two> twoList) {
        return  twoList.stream()
                .filter(Two::isLastBiggerthanQ3)
                .collect(Collectors.toList());
    }

    public static List<Two> filterTwosWithLastLessthanMed(@NonNull List<Two> twoList) {
        return  twoList.stream()
                .filter(x -> !x.isLastBiggerthanMed())
                .collect(Collectors.toList());
    }

    public static List<Two> filterTwosWithLastLessthan3Q(@NonNull List<Two> twoList) {
        return  twoList.stream()
                .filter(x -> !x.isLastBiggerthanQ3())
                .collect(Collectors.toList());
    }
}
