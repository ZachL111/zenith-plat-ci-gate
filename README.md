# zenith-plat-ci-gate

`zenith-plat-ci-gate` explores platform engineering with a small Java codebase and local fixtures. The technical goal is to package a Java local lab for ci analysis with bounded scenario files, conflict explanations, and documented operating limits.

## Project Rationale

The point is to make a small domain rule concrete enough that a reader can change it and immediately see what broke.

## Zenith Plat Ci Gate Review Notes

The first comparison I would make is `quota pressure` against `route drift` because it shows where the rule is most opinionated.

## Feature Set

- `fixtures/domain_review.csv` adds cases for rollout width and quota pressure.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/zenith-plat-ci-walkthrough.md` walks through the case spread.
- The Java code includes a review path for `quota pressure` and `route drift`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Architecture

The core code exposes a scoring path and the added review layer uses `signal`, `slack`, `drag`, and `confidence`. The domain terms are `rollout width`, `quota pressure`, `route drift`, and `secret scope`.

The Java implementation avoids hidden state so fixture changes are easy to reason about.

## Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Test Command

The verifier is intentionally local. It should fail if the fixture score math, lane assignment, or language-specific test drifts.

## Next Improvements

This remains a local project with deterministic fixtures. It does not depend on credentials, hosted services, or live data. Future work should add richer malformed inputs before widening the public API.
