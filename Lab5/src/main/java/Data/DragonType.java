package Data;

public enum DragonType {
    WATER{
        @Override
        public String toString() {
            return "WATER";
        }
    },
    UNDERGROUND{
        @Override
        public String toString() {
            return "UNDERGROUND";
        }
    },
    AIR{
        @Override
        public String toString() {
            return "AIR";
        }
    },
    FIRE{
        @Override
        public String toString() {
            return "FIRE";
        }
    };

    /**
     * @return String with all types
     */
    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (DragonType category : values()) {
            nameList.append(category.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
