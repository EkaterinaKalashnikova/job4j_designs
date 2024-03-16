package ru.job4j.iassertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).element(2).isNotNull().isEqualTo("three");
        assertThat(list).last().isNotNull().isEqualTo("five");
        assertThat(list).filteredOn(e -> e.equals(list.get(0))).first().isEqualTo("first");
        assertThat(list).filteredOnAssertions(e -> assertThat(e).isLessThan("four"))
                .hasSize(2)
                .first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("dog", "cat", "horse", "cat", "bird", "turtle");
        assertThat(set).isNotNull()
                .anySatisfy(e -> {
                    assertThat(e).isNotEmpty();
                    assertThat(e).isEqualTo("cat");
                    assertThat(e).doesNotEndWith("y");
                })
                .anyMatch(e -> e.equals("bird"));
        assertThat(set).first().isEqualTo("horse");
        assertThat(set).element(1).isNotNull().isEqualTo("turtle");
        assertThat(set).element(2).isNotNull().isEqualTo("cat");
        assertThat(set).element(3).isNotNull().isEqualTo("bird");
        assertThat(set).last().isNotNull().isEqualTo("dog");
        assertThat(set).filteredOnAssertions(e -> assertThat(e).isGreaterThan("bird")
                .hasSize(3));
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("santiago", "krasnodar", "lima", "madrid", "rostov");
        assertThat(map).hasSize(5)
                .containsKey("santiago")
                .doesNotContainValue(5)
                .doesNotContainKey("oslo")
                .containsEntry("lima", 2)
                .containsValue(4)
                .containsKey("santiago");
        org.assertj.core.api.MapAssert<String, Integer> stringIntegerMapAssert = assertThat(map);
        stringIntegerMapAssert.isNotNull();
    }
}
