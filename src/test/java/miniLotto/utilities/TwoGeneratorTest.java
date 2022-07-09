package miniLotto.utilities;

import miniLotto.models.Two;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class TwoGeneratorTest {

    @Test
    void generateListOfTwosTest() {
        //napisz ten cholerny test
        int [] draw  = new int[] {13, 16, 26, 31};
        List<Two> deserializedList = Serializer.deserialize("src/main/resources/Twos_serialized.ser");

//        List<Two> actualList = TwoGenerator.generateListOfTwos(new int[] {1, 2, 3, 4, 5});
//
//        assertThat(actualList).hasSize(10);
    }
}