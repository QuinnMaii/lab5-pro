package Core;

import Data.*;
import java.lang.Float;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CommandAsker {
    private final InputChecker inputChecker;

    public CommandAsker(InputChecker inputChecker) {
        this.inputChecker = inputChecker;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public Dragon createDragon(){
        Dragon newDragon = new Dragon();
        System.out.println("Finding a new dragon.");

        newDragon.setId(idAsker());
        newDragon.setName(nameAsker());
        newDragon.setCreationDate(creationDateAsker());
        newDragon.setCoordinates(coordinatesAsker());
        newDragon.setCave(cavetoAsker());
        newDragon.setType(typetoAsker());
        newDragon.setColor(colortoAsker());
        newDragon.setCharacter(charactertoAsker());

        return newDragon;

    }
    private DragonCave cavetoAsker() {
        System.out.println("Set the cave lenght details");

        return new DragonCave();
    }
    private DragonType typetoAsker() {
        DragonType type;
        String typeStr;

        System.out.println("Enter the type of the dragon from list: " + Color.nameList());
        typeStr = scanner.nextLine().trim();
        type = DragonType.valueOf(typeStr.toUpperCase());

        return type;
    }
    private Color colortoAsker(){
        Color color;
        String colorStr;

        System.out.println("Enter the color of the dragon from list: " + Color.nameList());
        colorStr = scanner.nextLine().trim();
        color = Color.valueOf(colorStr.toUpperCase());

        return color;

    }
    private DragonCharacter charactertoAsker() {
        DragonCharacter character;
        String characterStr;

        System.out.println("Enter the character of the dragon from list: " + Color.nameList());
        characterStr = scanner.nextLine().trim();
        character = DragonCharacter.valueOf(characterStr.toUpperCase());

        return character;
    }

    public Long toXAsker(){
        System.out.println("Insert x: ");
        long toX;
        toX = longAsker(Long.MIN_VALUE, Long.MAX_VALUE);
        return toX;
    }

    public  Float toYAsker(){
        System.out.println("Insert y: ");
        float toY;
        toY = floatAsker(Float.MIN_VALUE, Float.MAX_VALUE);
        return toY;
    }



    public float floatAsker(float min, float max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one float number: ");
            }
            else{
                float x;
                try {
                    x = Float.parseFloat(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an double number");
                }
            }
        }
    }

    public long longAsker(long min, long max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one long number: ");
            }
            else{
                long x;
                try {
                    x = Long.parseLong(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an long number");
                }
            }
        }
    }




    public int idAsker(){
        int newID = new Random().nextInt();
        if(CollectionManager.IDChecker.contains(newID) || newID <=0) {
            System.out.println("invalid id");
            return idAsker();
        }
        else {
            CollectionManager.IDChecker.add(newID);
            System.out.println("ID = " +newID + "has been generated");
            return newID;
        }
    }

    public String nameAsker(){
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }
    public Date creationDateAsker(){
        System.out.println("Creation date is automatically generated");
        Date date = new Date();
        System.out.println(date);
        return date;
    }

    public Coordinates coordinatesAsker(){
        System.out.println("Insert Coordinates: ");
        while(true){
            System.out.println("Insert the x and y respectively");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 2){
                System.out.println("please insert numbers (x and y respectively)");
            }
            else{
                if(!inputChecker.longValidCheck(inputNumber[1], Long.MIN_VALUE, (long) 759)) continue;
                if(!inputChecker.floatValidCheck(inputNumber[1], Float.MIN_VALUE, (float) 774.0)) continue;
                Long x = Long.parseLong(inputNumber[0]);
                Float y = Float.parseFloat(inputNumber[1]);
                return new Coordinates(x, y);
            }
        }
    }




}
