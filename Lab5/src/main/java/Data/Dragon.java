package Data;

import java.util.Date;

public class Dragon {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private DragonType type;

    private DragonCharacter character;
    private DragonCave depth;
    private Color color;
    private int age;

    public Dragon(int id, String name, Coordinates coordinates, Date creationDate, DragonType type, DragonCharacter character, DragonCave cave, Color color, int age) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public DragonCave getCave() {
        return depth;
    }

    public void setCave(DragonCave depth) {
        this.depth = depth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", color=" + color +
                ", type=" + type +
                ", character=" + character +
                ", cave=" + depth +
                '}';
    }

    public double compareTo(Object o) {
        Dragon product = (Dragon) o;
        return (getAge() - product.getAge());
    }
}
