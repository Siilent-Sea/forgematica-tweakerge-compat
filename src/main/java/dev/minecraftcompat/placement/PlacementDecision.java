package dev.minecraftcompat.placement;

public final class PlacementDecision {
    private PlacementDecision() {}

    public static boolean bypass(boolean forgematica, boolean tweakerge) {
        return forgematica || tweakerge;
    }
}
