package dev.minecraftcompat.placement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlacementDecisionTest {
    @Test
    void eitherModCanEnableItsOwnBypassWithoutChangingTheOtherOption() {
        assertFalse(PlacementDecision.bypass(false, false));
        assertTrue(PlacementDecision.bypass(false, true));
        assertTrue(PlacementDecision.bypass(true, false));
        assertTrue(PlacementDecision.bypass(true, true));
    }
}
