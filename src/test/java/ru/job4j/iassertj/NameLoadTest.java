package ru.job4j.iassertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkName() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key : value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("this name: key : value does not contain the symbol '='")
                .hasMessageMatching("^.+")
                .message()
                .isNotEmpty();
    }

    @Test
    void checkKeyName() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("= value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: = value does not contain a key");
    }

    @Test
    void checkValueName() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key ="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: key = does not contain a value");
    }

    @Test
    void checkNamesZero() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name:  does not contain the symbol '='");
    }

    @Test
    void checkNames() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+");
    }
}
    
