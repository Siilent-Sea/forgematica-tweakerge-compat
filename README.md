# ForgeMatica / Tweakerge Placement Compatibility

A small independent compatibility mod for Minecraft 1.21.1 / NeoForge when ForgeMatica and Tweakerge are installed together.

Both mods provide `itemUsePacketCheckBypass`. Their server-side redirects overlap, so with both installed the Tweakerge option can lose its effect. This compatibility mod combines the existing options: either option enables the bypass; with both disabled the vanilla check remains. It does not change either configuration.

## Installation

Use Java 21, Minecraft 1.21.1, NeoForge 21.1.x (tested with 21.1.265), ForgeMatica 0.4.3, Tweakerge 0.4.3 and their required dependencies, including MaFgLib 0.4.3. Add the compatibility JAR to the instance's `mods` directory.

Both mods are required. This preview declares `[0.4.3,0.4.4)` for both dependencies; NeoForge will reject unsupported versions. Recheck compatibility before upgrading those mods beyond that range.

## Validation

On macOS Apple Silicon, an isolated singleplayer pack was tested with all four option combinations. With both options off the deliberately invalid placement probe was rejected; with either option on it was accepted. Ordinary placement remained functional in every combination. The unpatched 0.4.3 pair still rejected the probe when only Tweakerge's option was enabled.

The build's Boolean-decision test passes. The preview JAR is byte-identical to the artifact used for the recorded gameplay checks. Multiplayer and dedicated servers have not been verified for this feature.

## Build

Place the official `forgematica-0.4.3+mc1.21.1.jar`, `tweakerge-0.4.3+mc1.21.1.jar` and `mafglib-0.4.3+mc1.21.1.jar` in a local dependency directory. With Java 21, run:

```sh
bash ./gradlew build -Pcompat_mods_dir=/absolute/path/to/dependencies
```

Those mod JARs are compile-only dependencies and are not included in this repository or release assets. The independent compatibility code is MIT licensed; the Gradle wrapper retains its own license.
