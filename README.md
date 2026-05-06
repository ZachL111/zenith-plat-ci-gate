# zenith-plat-ci-gate

`zenith-plat-ci-gate` treats platform engineering as a local verification problem. The Java implementation is intentionally narrow, but the fixtures and notes make the behavior explicit.

## Zenith Plat Ci Gate Checkpoints

Treat the compact fixture as the contract and the extended examples as a scratchpad. The code should stay boring enough that a change in behavior is obvious from the test output.

## What This Is For

The repository exists to keep a technical idea small enough to reason about. The implementation avoids external dependencies where possible, then uses fixtures to make changes easy to review.

## Architecture Notes

The design is intentionally direct: parse or construct a signal, score it, classify it, and verify the expected branch. This makes the repository useful for studying platform engineering behavior without needing a service or database unless the language project itself is SQL. The Java implementation uses a compact package layout and direct assertion checks.

## Case Study

`pressure` is the first example I would inspect because it lands on the `review` path with a score of 53. The broader file also keeps `degraded` at -6 and `recovery` at 196, which gives the model a useful low-to-high spread.

## Useful Pieces

- Uses fixture data to keep route policy changes visible in code review.
- Includes extended examples for rollout constraints, including `recovery` and `degraded`.
- Documents environment checks tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.

## Tooling

Clone the repository, enter the directory, and run the verifier. No database server, cloud account, or token is required.

## Quality Gate

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Project Layout

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Scope

The fixture set is deliberately small. That keeps the review surface clear, but it also means the model should not be treated as a complete domain simulator.

## Expansion Ideas

- Add a loader for `examples/extended_cases.csv` and promote selected cases into the language test suite.
- Add a short report command that prints the score breakdown for a single scenario.
- Add malformed input fixtures so the failure path is as visible as the happy path.
- Add one more platform engineering fixture that focuses on a malformed or borderline input.

## Local Workflow

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.
