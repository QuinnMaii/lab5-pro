package Data;

public enum DragonCharacter {
    CHAOTIC,
    CHAOTIC_EVIL,
    FICKLE;

    /**
     *
     * @return String with all types
     */
    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (DragonCharacter category : values()) {
            nameList.append(category.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
