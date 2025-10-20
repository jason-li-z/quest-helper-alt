# Repository Guidelines

## Project Structure & Modules
- Source: `src/main/java/com/questhelper/**` (plugin, helpers, steps, bank, util).
- Resources: `src/main/resources/**` (icons, overlays, metadata).
- Tests: `src/test/java/**` (JUnit 5). Use `*Test` suffix.
- Build: `build.gradle`, `gradlew`, `gradlew.bat` (Java 11).
- Metadata: `runelite-plugin.properties` (display name, main plugin class).
- Docs/Assets: `README.md`, `images/` (screenshots), `icon.png`.

## Build, Test, and Development
- Build: `./gradlew build` (Windows: `gradlew.bat build`). Compiles and runs tests.
- Tests only: `./gradlew test`. Uses JUnit Platform.
- Fat jar (for local dev tooling): `./gradlew shadowJar` → `build/libs/quest-helper-<version>-all.jar`.
- Snapshot against latest RuneLite: `./gradlew --refresh-dependencies -Puse.snapshot clean build -x test`.

## Coding Style & Naming
- Language: Java 11. Package root `com.questhelper`.
- Indentation: tabs, size 4; max line length 120 (see `.editorconfig`).
- Braces: next line for classes/methods/blocks.
- Imports: single-class imports; avoid wildcard.
- Class naming: `PascalCase`; methods/fields: `camelCase`.
- Tests: `*Test` with clear, behavior-driven method names.
- Annotations: JetBrains annotations allowed; Lombok is configured (compileOnly).

## Implementing Steps
- For every step, if it requires an interaction/chat with NPC, highlight that NPC.
- If it requires an action like thieve from a stall or need to do anything with some object, highlight that object too.
- For any quests related steps, **always consult the existing quest helper source** (`helpers/quests/**`) to mirror the correct NPC IDs, dialogue prompts, interaction wording, and stopping points the user requested. Evaluate the provided instruction to determine how far to progress within that quest and reuse/adjust the quest helper text accordingly.
- Additionally highlight all the NPCs/ladders/objects, whatever it may be especially if it's 2+ floors and the highlighted text and ensure it is also implemented into the sequence of steps to follow. Make sure if interacting with NPC as part of the quest, the text is highlighted just like the quest helper does.
- If I need to kill or gather items, use the on tick system to constantly refresh/always render if I have it in inventory, if I do, highlight the item just as quest helper does. Would also be good to somehow show the items as requirements as well.

## Architecture & Tips
- Core entry: `QuestHelperPlugin` and `QuestHelperConfig`.
- Helpers live under `helpers/**`; reusable steps under `steps/**`; requirements under `requirements/**`.
- Keep game logic in steps/helpers; UI in overlays; share utilities via `util/**`.
- Do not hardcode account-specific data; respect RuneLite APIs and client state.
