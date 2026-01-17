public class TargetCharacter {

    private String name;
    private int patchNumber;
    private int priority;

    public TargetCharacter(String name, int patchNumber, int priority) {
        this.name = name;
        this.patchNumber = patchNumber;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public int getPatchNumber() {
        return patchNumber;
    }
    public int getPriority() {
        return priority;
    }

}
