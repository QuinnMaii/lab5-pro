package Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * class with main type of element in collection
 */
public class Dragon {
    private int id;
    private String name;
    private Coordinates coordinates;
    private String creationDate;
    private DragonType type;

    private DragonCharacter character;
    private float depth;
    private Color color;
    private int age;

    public Dragon(int id, String name, Coordinates coordinates, String creationDate, DragonType type, DragonCharacter character, float cave, Color color, int age) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.type = type;
        this.character = character;
        this.depth = cave;
        this.color = color;
        this.age = age;
    }

    public Dragon() {

    }

    /**
     *
     * @return id of Dragon
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name of Dragon
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return coordinates of Dragon
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCreationDate() {
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String creationDate = df.format(today);
        return creationDate;
    }

    /**
     *
     * @return the date today
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return type of Dragon
     */
    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    /**
     *
     * @return character of Dragon
     */
    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    /**
     *
     * @return the length of the cave of Dragon
     */
    public float getCave() {
        return depth;
    }

    public void setCave(float depth) {
        this.depth = depth;
    }

    /**
     *
     * @return color of Dragon
     */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return age of Dragon
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /**
     *
     * @return String with all fields
     */
    public String toString(){
        return "Dragon" + "\r\n"+
                "id," + id + "\r\n" +
                "name,'" + name + "\r\n" +
                "coordinates," + coordinates.getX() + ","  +coordinates.getY() + "\r\n"+
                "date,," + creationDate +"\r\n"+
                "age," + age +"\r\n"+
                "color," + color +"\r\n"+
                "type," + type +"\r\n"+
                "character," + character +"\r\n"+
                "cave," + depth;

    }

    public double compareTo(Object o) {
        Dragon product = (Dragon) o;
        return (getAge() - product.getAge());
    }
}
