package com.summer.algorithms.base.generate;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RandomIdGeneratorTest {

    @Test
    void generateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot("niujunfeng.pc");
    }

    @Test
    void getLastSubstrSplittedByDot() {
    }
}