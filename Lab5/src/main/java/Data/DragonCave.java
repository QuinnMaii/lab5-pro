package Data;

public class DragonCave {

    private Float depth;

    public DragonCave() {
    }

    public DragonCave(Float depth) {
        this.depth = depth;
    }


    /**
     *
     * @return number of depth
     */
    public Float getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "DragonCave{" +
                ", depth=" + depth +
                '}';
    }

    /**
     *
     * @return String with all fields
     */
    public String toConsole(){
        String str = "";
        if(depth == null){
            str += "lenght of depth undefined";
        }else{
            str += " lenght of depth = " + depth;
        }
        return str;
    }
}