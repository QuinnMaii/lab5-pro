package Helpers;

import Data.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        newDragon.setAge(ageAsker());
        newDragon.setCreationDate(creationDateAsker());
        newDragon.setCoordinates(coordinatesAsker());
        newDragon.setCave(cavetoAsker());
        newDragon.setType(typetoAsker());
        newDragon.setColor(colortoAsker());
        newDragon.setCharacter(charactertoAsker());

        return newDragon;

    }
    /**
     *
     * @return float value of cave
     */
    public float cavetoAsker() {
        System.out.println("Set the cave lenght details");
        float x;
        x = floatAsker(Float.MIN_VALUE, Float.MAX_VALUE);
        return x;
    }
    /**
     *
     * @return enum value of dragon type
     */
    private DragonType typetoAsker() {
        DragonType type = null;
        String typeStr;

        try {
            System.out.println("Enter the type of the dragon from list: " + DragonType.nameList());
            typeStr = scanner.nextLine().trim();
            type = DragonType.valueOf(typeStr.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            System.out.println("This type doesn't in list. Pls try gain.");
            typeStr = scanner.nextLine().trim();

        }

        return type;
    }
    /**
     *
     * @return enum value of dragon color
     */
    private Color colortoAsker(){
        Color color = null;
        String colorStr;

        try {
            System.out.println("Enter the color of the dragon from list: " + Color.nameList());
            colorStr = scanner.nextLine().trim();
            color = Color.valueOf(colorStr.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            System.out.println("This color doesn't in list. Pls try gain.");
            colorStr = scanner.nextLine().trim();
        }
        return color;

    }
    /**
     *
     * @return enum value of dragin character
     */
    private DragonCharacter charactertoAsker() {
        DragonCharacter character =null;
        String characterStr;
        try {
            System.out.println("Enter the character of the dragon from list: " + DragonCharacter.nameList());
            characterStr = scanner.nextLine().trim();
            character = DragonCharacter.valueOf(characterStr.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            System.out.println("This character doesn't in list. Pls try gain.");
            characterStr = scanner.nextLine().trim();

        }

        return character;

    }


    /**
     *
     * @return long value of x
     */
    public Long toXAsker(){
        System.out.println("Insert x: ");
        long toX;
        toX = longAsker(Long.MIN_VALUE, Long.MAX_VALUE);
        return toX;
    }

    /**
     *
     * @return float value of y
     */
    public  float toYAsker(){
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

    public int intAsker(int min, int max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one int number: ");
            }
            else{
                int x;
                try {
                    x = Integer.parseInt(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an integer number");
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


    /**
     *
     * @return Int value of created id
     */

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
    }/**
     *
     * @return int value of age
     */
    public int ageAsker(){
        int newAGE = new Random().nextInt();
        if(CollectionManager.IDChecker.contains(newAGE) || newAGE <=0) {
            System.out.println("invalid age");
            return idAsker();
        }
        else {
            CollectionManager.IDChecker.add(newAGE);
            System.out.println("Age = " +newAGE + "has been generated");
            return newAGE;
        }
    }

    /**
     *
     * @return string value of name
     */
    public String nameAsker(){
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }
    public String creationDateAsker(){
        System.out.println("Creation date is automatically generated");
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String stringDate = df.format(today);
        System.out.println(stringDate);
        return stringDate;
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
                if(!inputChecker.longValidCheck(inputNumber[0],  Long.MIN_VALUE, 759L)) continue;
                if(!inputChecker.floatValidCheck(inputNumber[1], Float.MIN_VALUE, (float) 774)) continue;
                Long x = Long.parseLong(inputNumber[0]);
                Float y = Float.parseFloat(inputNumber[1]);
                return new Coordinates(x, y);
            }
        }
    }




}
