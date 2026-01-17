import java.util.ArrayList;
import java.util.Arrays;

public class PityCalculator {

    public int calculatePity (WishHistory wishHistory) {
        int pity = 0;
        WishItem five_star = null;
        int five_index = -1;


        for(int i = 0; i < wishHistory.getList().size(); i++) {
            WishItem wishItem = wishHistory.getList().get(i);
            String rarity =  wishItem.getRank_type();
            if(rarity.equals("5")) {
                five_star = wishItem;
                five_index = i;
            }
        }

        if(five_index == -1) {
            pity = wishHistory.getList().size();
        } else {
            pity = wishHistory.getList().size() - five_index - 1;
        }

        return pity;
    }

    public boolean calculateGuaranteed (WishHistory wishHistory) {
        ArrayList<String> standardCharacters = new ArrayList<>(Arrays.asList(
                "Jean", "Diluc", "Mona", "Qiqi", "Keqing", "Tighnari", "Dehya"
        ));
        boolean guaranteed;
        WishItem wishItem = null;
        for(int i = 0; i < wishHistory.getList().size(); i++) {
            if(wishHistory.getList().get(i).getRank_type().equals("5")) {
                wishItem = wishHistory.getList().get(i);
            }
        }
        if(wishItem != null && standardCharacters.contains(wishItem.getName())) {
            guaranteed = true;
        } else {
            guaranteed = false;
        }

        return guaranteed;
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
        }
    }

}
