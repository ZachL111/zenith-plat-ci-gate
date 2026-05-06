# Zenith Plat Ci Gate Walkthrough

I use this file as a small checklist before changing the Java implementation.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | rollout width | 146 | ship |
| stress | quota pressure | 229 | ship |
| edge | route drift | 142 | ship |
| recovery | secret scope | 153 | ship |
| stale | rollout width | 192 | ship |

Start with `stress` and `edge`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

`stress` is the optimistic case; use it to make sure the scoring path still rewards strong signal.
