package miniLotto.utilities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static miniLotto.utilities.Serializer.deserializeMap;
import static miniLotto.utilities.Serializer.serializeMap;

class SerializerTest {

    @Test
    void serializeMapAndDeserializeMapShouldReturnMapEqualToOriginalMap() {
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("hello", "hello".length());
        expectedMap.put("Radosław", "Radosław".length());
        final String path = "src/main/resources/mapOfDistances_serialized.ser";

        serializeMap(expectedMap, path);
        Map<String, Integer>deserializedMap = deserializeMap(path);

        assertThat(deserializedMap).isEqualTo(expectedMap);
        assertThat(deserializedMap).hasSize(2);
        assertThat(deserializedMap).containsEntry("hello", 5);
        assertThat(deserializedMap).containsEntry("Radosław", 8);
    }

    @Test
    void deserializeMapShouldReturnMapEqualToOriginalMap() {
        final String filepath = "src/main/resources/mapOfDistances_serialized.ser";

        HashMap<String, Double> deserializedMap = new HashMap<>(Serializer.deserializeMap(filepath));

        assertThat(deserializedMap).hasSize(2);
    }
}