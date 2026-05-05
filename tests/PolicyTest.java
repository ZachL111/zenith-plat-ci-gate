package io.portfolio;

public final class PolicyTest {
    public static void main(String[] args) {
        var signalcase_1 = new Policy.Signal(66, 106, 19, 11, 5);
        if (Policy.score(signalcase_1) != 144) throw new AssertionError("score mismatch");
        if (!Policy.classify(signalcase_1).equals("review")) throw new AssertionError("decision mismatch");
        var signalcase_2 = new Policy.Signal(76, 71, 11, 5, 10);
        if (Policy.score(signalcase_2) != 191) throw new AssertionError("score mismatch");
        if (!Policy.classify(signalcase_2).equals("accept")) throw new AssertionError("decision mismatch");
        var signalcase_3 = new Policy.Signal(69, 71, 18, 12, 11);
        if (Policy.score(signalcase_3) != 123) throw new AssertionError("score mismatch");
        if (!Policy.classify(signalcase_3).equals("review")) throw new AssertionError("decision mismatch");
    }
}
