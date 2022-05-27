package Helpers;

import Data.Color;
import Data.Dragon;

import java.text.DateFormat;
import java.util.List;

import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Set;
/**
 * class to work with collection's elements
 */
public class CollectionManager {
    /**
     *
     * @param dragons with collection's elements
     */
    private Set<Dragon> mapDragon = new HashSet<>();
    public static HashSet<Integer> IDChecker = new HashSet<>();
    private final Date creationDate = new Date();
    public void readInputFromCSVFile(String InputFileName) throws FileNotFoundException {
        System.out.println(InputFileName);
        mapDragon =  FileParser.parse(InputFileName);
    }

    public Date getCreationDate(){
        return this.creationDate;
    }
    public int size(){
        return mapDragon.size();
    }
    public void PrintCollection(){
        for (Dragon key : mapDragon) {
            Dragon value = key;
            System.out.println(value.toString());
        }
    }

    public void add(Dragon D){
        mapDragon.add(D);
    }
    public void addIfMax(Dragon D){
        boolean judge = true;
        for (Dragon key : mapDragon) {
            Dragon product = key;
            if (D.compareTo(product) < 0) {
                judge = false;
            }
        }
        if (judge) {
            mapDragon.add(D);
        }
    }
    @SuppressWarnings("unchecked")

    public void save(String filename){
        List<List<String[]>> DragonList = new ArrayList<>();

        for (Dragon dragon : mapDragon){

            System.out.println(mapDragon.toString());
            List<String[]> data = new ArrayList<String[]>();
            Dragon Data = new Dragon();
            data.add(new String[] { "id",",",String.valueOf( dragon.getId()),"\r\n"});
            data.add(new String[] { "name",",",String.valueOf( dragon.getName()),"\r\n"});
            Data.setId(dragon.getId());
            Data.setName(dragon.getName());

            //write coordinates to file
            data.add(new String[] { "coordinates:","\r\n"});
            data.add(new String[] { "cx",",",String.valueOf(dragon.getCoordinates().getX()),"\r\n"});
            data.add(new String[] { "cy",",",String.valueOf(dragon.getCoordinates().getY()),"\r\n"});
            Data.setCoordinates((dragon.getCoordinates()));

            //Write time
            String pattern = "MM/dd/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();
            String stringDate = df.format(today);
            data.add(new String[] { "date",",", String.valueOf(stringDate),"\r\n"});

            //write color of dragon
            data.add(new String[] { "color of dragon", ",",String.valueOf(dragon.getColor()),"\r\n"});
            Data.setColor(dragon.getColor());

            //write type of dragon
            data.add(new String[] { "type of dragon",",", String.valueOf(dragon.getType()),"\r\n"});
            Data.setType(dragon.getType());
            //write character of dragon
            data.add(new String[] { "character of dragon",",", String.valueOf(dragon.getCharacter()),"\r\n"});
            Data.setCharacter(dragon.getCharacter());
            //set age
            data.add(new String[] { "age of dragon", ",",String.valueOf(dragon.getAge()),"\r\n"});
            Data.setAge(dragon.getAge());
            //set lenght of dragon cave
            data.add(new String[] { "lenght of dragon cave",",", String.valueOf(dragon.getCave()),"\r\n"});
            Data.setCave(dragon.getCave());

            DragonList.add(data);
            mapDragon.add(Data);
        }
        try{
            FileOutputStream outputStream = new FileOutputStream(filename);
            System.out.println("using output stream writer");
           String eline="\r\n";
            byte[] E=eline.getBytes();
            for(List<String[]> value: DragonList) {
                for (String[] p : value) {
                    for (String q : p) {
                        byte[] str = q.getBytes();
                        outputStream.write(str);
                    }
                    //outputStream.write(E);
                }
            }

            outputStream.flush();
            outputStream.close();
            } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        mapDragon.clear();
    }

    public boolean removeById(int id) {
        boolean flag = false;

        for(Iterator<Dragon> iterator = mapDragon.iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            if(dragon.getId()==id){
                flag = true;
                iterator.remove();
            }
        }
        return flag;
    }

    public boolean removeGreater(Integer input) {
        boolean flag = false;
        for(Iterator<Dragon> iterator = mapDragon.iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            Integer p =(Integer) dragon.getId();
            Integer q =(Integer) dragon.getAge();
            if(p > input || q > input){
                flag = true;
                iterator.remove();
            }
        }
        if(flag) System.out.println("The greater element has been removed");
        return !flag;
    }
    public boolean removeLower(Integer input) {
        boolean flag = false;

        for(Iterator<Dragon> iterator = mapDragon.iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            Integer p =(Integer) dragon.getId();
            Integer q =(Integer) dragon.getAge();
            if(p < input || q < input){
                flag = true;
                iterator.remove();
            }
        }
        if(flag) System.out.println("The lower element has been removed");
        return !flag;
    }


    public void printUniqueColor() {
        try {
                for(Iterator<Dragon> iterator = mapDragon.iterator(); iterator.hasNext();) {
                    Dragon dragon = iterator.next();
                    String p = dragon.getName();
                    Color q = dragon.getColor();
                    System.out.println(p + " " + q);
                }
            }

            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("There is no color. Pls add first");
            }
        }


}