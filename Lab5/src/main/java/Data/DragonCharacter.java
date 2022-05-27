package Data;

public enum DragonCharacter {
    CHAOTIC{
        @Override
        public String toString() {
            return "CHAOTIC";
        }
    },
    CHAOTIC_EVIL{
        @Override
        public String toString() {
            return " CHAOTIC_EVIL";
        }
    },
    FICKLE{
        @Override
        public String toString() {
            return " FICKLE";
        }
    };

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
