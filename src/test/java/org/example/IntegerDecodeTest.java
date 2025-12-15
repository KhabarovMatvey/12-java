package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerDecodeTest {

    // Базовые десятичные числа
    @Test
    public void testPositiveDecimal() {
        Integer result = Integer.decode("123");
        assertEquals(123, result.intValue());
    }

    @Test
    public void testNegativeDecimal() {
        Integer result = Integer.decode("-456");
        assertEquals(-456, result.intValue());
    }

    @Test
    public void testPositiveSignDecimal() {
        Integer result = Integer.decode("+789");
        assertEquals(789, result.intValue());
    }

    // Шестнадцатеричные числа
    @Test
    public void testHexadecimal0x() {
        Integer result = Integer.decode("0x1A");
        assertEquals(26, result.intValue());
    }

    @Test
    public void testHexadecimal0X() {
        Integer result = Integer.decode("0XFF");
        assertEquals(255, result.intValue());
    }

    @Test
    public void testHexadecimalHash() {
        Integer result = Integer.decode("#ABC");
        assertEquals(2748, result.intValue());
    }

    @Test
    public void testNegativeHexadecimal() {
        Integer result = Integer.decode("-0x20");
        assertEquals(-32, result.intValue());
    }

    @Test
    public void testPositiveHexWithSign() {
        Integer result = Integer.decode("+0xFF");
        assertEquals(255, result.intValue());
    }

    // Восьмеричные числа
    @Test
    public void testOctal() {
        Integer result = Integer.decode("077");
        assertEquals(63, result.intValue());
    }

    @Test
    public void testNegativeOctal() {
        Integer result = Integer.decode("-010");
        assertEquals(-8, result.intValue());
    }

    @Test
    public void testPositiveOctalWithSign() {
        Integer result = Integer.decode("+010");
        assertEquals(8, result.intValue());
    }

    // Специальные случаи
    @Test
    public void testMinValue() {
        Integer result = Integer.decode("-2147483648");
        assertEquals(Integer.MIN_VALUE, result.intValue());
    }

    @Test
    public void testZero() {
        Integer result = Integer.decode("0");
        assertEquals(0, result.intValue());
    }

    // Тесты на исключения
    @Test(expected = NumberFormatException.class)
    public void testInvalidFormat() {
        Integer.decode("abc");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignAfterPrefix() {
        Integer.decode("0x-123");
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testOnlySign() {
        Integer.decode("-");
    }

    @Test(expected = NumberFormatException.class)
    public void testOnlyPrefix() {
        Integer.decode("0x");
    }

    @Test(expected = NullPointerException.class)
    public void testNullString() {
        Integer.decode(null);
    }
}
