package org.guimo.jokempo;

import org.guimo.jokempo.utils.IntegerUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTests {

    @Test
    public void randon_integer_without_exception() {
        assertDoesNotThrow(() -> IntegerUtils.Random(), "The integer number should be generated without exceptions");
    }
}
