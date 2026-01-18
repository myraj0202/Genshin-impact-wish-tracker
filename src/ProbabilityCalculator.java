public class ProbabilityCalculator {

    private double getSinglePullProbability(int currentPity) {
        double fiveStarProbability = 0.006;
        if (currentPity >= 90) {
            fiveStarProbability = 1.0;
        } else if (currentPity >= 74  && currentPity < 90 ) {
            int residuePity = currentPity - 73;
            for (int i = 1; i <= residuePity; i++) {
                fiveStarProbability += 0.06;
            }
        }
        return fiveStarProbability;
    }

    public double calculateFiveStarProbability(int wishes, int currentPity) {
        double no5Star = 1;
        for (int i = 1; i <= wishes; i++) {
            no5Star *= (1 - getSinglePullProbability(currentPity));
            currentPity++;
        }
        return 1 - no5Star;

    }

    public static void main(String[] args) {
        WishParser parser = new WishParser();
        WishHistory history = parser.parseWishHistory("test_wish_history.json");

        if (history != null) {
            System.out.println("Loaded " + history.getList().size() + " wishes");

            PityCalculator calculator = new PityCalculator();
            int pity = calculator.calculatePity(history);
            boolean guaranteed = calculator.calculateGuaranteed(history);

            System.out.println("Current pity: " + pity);
            System.out.println("Guaranteed: " + guaranteed);

            ProbabilityCalculator probCalc = new ProbabilityCalculator();

            double prob = probCalc.calculateFiveStarProbability(80, 0);
            System.out.println("Probability of 5-star with 80 wishes at pity 0: " + (prob * 100) + "%");

            double probCurrent = probCalc.calculateFiveStarProbability(50, pity);
            System.out.println("Probability of 5-star with 50 wishes at current pity: " + (probCurrent * 100) + "%");
        }
    }

}
