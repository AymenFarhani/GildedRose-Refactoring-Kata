package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class QualityAdjusterTest {

    private QualityAdjuster qualityAdjuster;
    private Item item;

    @BeforeEach
    void setUp() {
        qualityAdjuster = new QualityAdjuster();
        item = new Item();
    }

    @Test
    void testInitializeQualityWhenSellInNegativeSetsQualityToZero() {
        item.setSellIn(-1);
        qualityAdjuster.initializeQuality(item);
        assertEquals(0, item.getQuality());
    }

    @Test
    void testInitializeQualityWhenSellInZeroSetsQualityDoesNotChange() {
        item.setSellIn(0);
        item.setQuality(10);
        qualityAdjuster.initializeQuality(item);
        assertEquals(10, item.getQuality());
    }

    @Test
    void testInitializeQualityWhenSellInPositiveSetsQualityDoesNotChange() {
        item.setSellIn(5);
        item.setQuality(10);
        qualityAdjuster.initializeQuality(item);
        assertEquals(10, item.getQuality());
    }


    @Test
    void testDecreaseQualityDecreasesQualityByOne() {
        item.setQuality(5);
        qualityAdjuster.decreaseQuality(item);
        assertEquals(4, item.getQuality());
    }

    @Test
    void testDecreaseQualityWhenQualityIsZeroDoesNotDecreaseLessThanZero() {
        item.setQuality(0);
        qualityAdjuster.decreaseQuality(item);
        assertEquals(0, item.getQuality());
    }

    static Stream<Arguments> provideIncreaseQualityCases() {
        return Stream.of(
                Arguments.of(49, 50),   // When quality is 1, should increase to 50
                Arguments.of(50, 50)    // When quality is 50, should remain 50
        );
    }


    @ParameterizedTest
    @MethodSource("provideIncreaseQualityCases")
    void testIncreaseQuality(int initialQuality, int expectedQuality) {
        item.setQuality(initialQuality);
        qualityAdjuster.increaseQuality(item);
        assertEquals(expectedQuality, item.getQuality());
    }


    static Stream<Arguments> provideDecreaseQualityCases() {
        return Stream.of(
                Arguments.of(5, 3),    // When quality is 5, should decrease to 3
                Arguments.of(0, 0),    // When quality is 0, should remain 0
                Arguments.of(1, 0)     // When quality is 1, should remain 0
        );
    }

    @ParameterizedTest
    @MethodSource("provideDecreaseQualityCases")
    void testDecreaseQualityBy2(int initialQuality, int expectedQuality) {
        item.setQuality(initialQuality);
        qualityAdjuster.decreaseQualityBy2(item);
        assertEquals(expectedQuality, item.getQuality());
    }

}