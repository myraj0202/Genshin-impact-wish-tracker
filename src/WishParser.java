import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class WishParser {
    private WishHistory wishHistory;

    public WishHistory parseWishHistory (String fileName) {

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            wishHistory = gson.fromJson(bufferedReader, WishHistory.class);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return wishHistory;

    }

    public static void main(String[] args) {
        WishParser wishParser = new WishParser();
        wishParser.parseWishHistory("test_wish_history.json");

        WishItem wishItem = wishParser.wishHistory.getList().getFirst();

        if(wishParser.wishHistory != null) {
            System.out.println("Wish History Loaded: " + wishParser.wishHistory.getList().size());
            System.out.printf("Wish no. 1: %s \n", wishItem.getName());
            System.out.printf("Rarity: %s \n", wishItem.getRank_type());
            System.out.printf("Type: %s", wishItem.getItem_type());
        }
    }

}
