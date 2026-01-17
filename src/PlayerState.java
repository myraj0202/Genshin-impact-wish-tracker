public class PlayerState {

    private int wishes;
    private int primogems;
    private int pity;
    private boolean guaranteed;

    public PlayerState(int wishes, int primogems, int pity, boolean guaranteed) {
        this.wishes = wishes;
        this.primogems = primogems;
        this.pity = pity;
        this.guaranteed = guaranteed;
    }

    public int getWishes() {
        return wishes;
    }
    public int getPrimogems() {
        return primogems;
    }
    public int getPity() {
        return pity;
    }
    public boolean isGuaranteed() {
        return guaranteed;
    }

    public int getTotalWishes() {
        return wishes + (primogems / 160);
    }

}
