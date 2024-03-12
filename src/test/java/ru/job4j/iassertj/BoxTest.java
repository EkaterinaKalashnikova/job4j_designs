package ru.job4j.iassertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void whatsThisOne() {
        Box box = new Box(4, 2);
        String result = box.whatsThis();
        assertThat(result).asString()
                .isNotEmpty()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whatsThisToo() {
        Box box = new Box(-1, 3);
        String result = box.whatsThis();
        assertThat(result).startsWith("Unk")
                .isNotBlank()
                .contains("ect")
                .isEqualTo("Unknown object");
    }

    @Test
    void getNumberOfVerticesOne() {
        Box box = new Box(0, 5);
        int result = box.getNumberOfVertices();
        assertThat(result).isEven()
                .isNotPositive()
                .isEqualTo(0);
    }

    @Test
    void getNumberOfVerticesToo() {
        Box box = new Box(-1, 2);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotPositive()
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void getNumberOfVerticesThree() {
        Box box = new Box(4, -1);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void isExistOne() {
        Box box = new Box(4, -1);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void isExistToo() {
        Box box = new Box(8, 15);
        boolean result = box.isExist();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void getAreaOne() {
        Box box = new Box(8, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(24.0d, withPrecision(0.006d))
                .isLessThan(26.0);
    }

    @Test
    void getAreaToo() {
        Box box = new Box(4, 4);
        double result = box.getArea();
        assertThat(result).isGreaterThan(26.0);
    }

    @Test
    void getAreaThree() {
        Box box = new Box(0, 5);
        double result = box.getArea();
        assertThat(result).isCloseTo(314.0d, withPrecision(0.16d))
                .isBetween(300.0, 315.0);
    }

    @Test
    void getAreaFour() {
        Box box = new Box(5, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(0.0);
    }
}
    
