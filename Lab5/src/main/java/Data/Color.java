package Data;

public enum Color {
    GREEN{
        @Override
        public String toString() {
            return "GREEN";
        }
    },
    RED
    {
        @Override
        public String toString() {
        return "RED";
    }
    },
    ORANGE{
        @Override
        public String toString() {
            return "ORANGE";
        }
    };

        /**
         *
         * @return String with all enum values of color
         */
        public static String nameList() {
            StringBuilder nameList = new StringBuilder();
            for (Color category : values()) {
                nameList.append(category.name()).append(", ");
            }
            return nameList.substring(0, nameList.length()-2);
        }

}
