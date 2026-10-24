# AGENTS.md

JavaFX 21 dice/craps game, single Maven module (`com.example.crapsgame262`). README only lists authors; this file is the setup source of truth.

## Commands

- Use `mvn`, not `./mvnw`: the wrapper scripts are committed but `.mvn/wrapper/` is missing, so `./mvnw` fails immediately.
- Run the app: `mvn clean javafx:run` (plugin config in `pom.xml` launches `HelloApplication` directly).
- Compile: `mvn compile` (verified).
- Tests: `mvn test`. There are currently no `src/test` sources, though JUnit Jupiter 5.12.1 is already configured. For a future single test: `mvn -Dtest=ClassName#method test`.
- No lint, formatter, or typecheck plugin is configured; do not invent one.

## Architecture

- Entry flow: `Launcher.main` (useful for IDE runs) → `HelloApplication.start` → `WelcomeView` → `WelcomeController` → `GameView` → `GameController`.
- `WelcomeView` and `GameView` are `Stage` subclasses with hand-rolled singleton holders and FXML-loaded controllers. Reusing them keeps the same controller instance, so previously set player/UI state persists; do not create new views casually.
- FXML lives at `src/main/resources/com/example/crapsgame262/{welcome,game}-view.fxml` and must be loaded with absolute paths (`/com/example/crapsgame262/...`).
- `module-info.java` opens only `com.example.crapsgame262` and `.controllers` to `javafx.fxml`. A controller in any new package needs an `opens` entry or FXML injection/loading fails.
- FXML handlers use `onMouseClicked="#handler"` (not `onAction`); controller handlers and injected fields are `@FXML` and usually private.

## Gotchas

- `WelcomeController` checks `nickname == ""`, which is always false. Use `isEmpty()`/`isBlank()` when touching nickname validation.
- Dice images are hardcoded by value in `Dice.getImagePath()` as `/com/example/crapsgame262/images/dices/dice{value}.png`; new faces need matching assets there.
- UI text is Spanish; code identifiers and comments are English.
- `ArithmeticOperations` is an unused leftover demo class, not part of gameplay.
