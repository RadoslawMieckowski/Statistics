package miniLotto.utilities;

import java.util.List;

public final class ListPresenter {
    private ListPresenter() {}
    public static <T> String present(List<T> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T x : list) {
            stringBuilder.append(x + "\n\n");
        }
        return stringBuilder.toString();
    }
}
