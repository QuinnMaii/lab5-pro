package Core;
import Data.Dragon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.lang.String;
public class CollectionManager {
    private HashSet<Dragon> setDragon = new HashSet<>();
    public static HashSet<Integer> IDChecker = new HashSet<>();
    private final Date creationDate = new Date();
    public void readInputFromJSONFile(String InputFileName){
        System.out.println(InputFileName);
        setDragon =  FileParser.parse(InputFileName);
    }

    public Date getCreationDate(){
        return this.creationDate;
    }
    public int size(){
        return setDragon.size();
    }
    public void PrintCollection(){
        setDragon.forEach(p ->
                System.out.println(p.toString()));
    }

    public void add(Dragon R){
        setDragon.add(R);
    }
    public void addIfMax(Dragon P){
        boolean judge = true;
        for (Dragon product : setDragon) {
            if (P.compareTo(product) < 0) {
                judge = false;
            }
        }
        if (judge) {
            setDragon.add(P);
        }
    }

    @SuppressWarnings("unchecked")
    public void save(String filename){
        JSONArray RouteSet = new JSONArray();
        for (Dragon dragon : setDragon){

            System.out.println(setDragon.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", dragon.getId());
            jsonObject.put("name", dragon.getName());

            //write coordinates to file
            JSONObject coordinatesObj = new JSONObject();
            coordinatesObj.put("cx", dragon.getCoordinates().getX());
            coordinatesObj.put("cy", dragon.getCoordinates().getY());
            jsonObject.put("coordinates", coordinatesObj);

            //Write time
            SimpleDateFormat stringDate = new SimpleDateFormat ("dd/MM/yyyy",Locale.ROOT);
            jsonObject.put("date", stringDate);

            //write color of dragon
            JSONObject color = new JSONObject();
            color.put("color", dragon.getColor());
            jsonObject.put("color of dragon", color);

            //write type of dragon
            JSONObject type = new JSONObject();
            type.put("type", dragon.getType());
            jsonObject.put("type of dragon", type);

            //write character of dragon
            JSONObject character = new JSONObject();
            character.put("character", dragon.getCharacter());
            jsonObject.put("character of dragon", character);

            //set age
            jsonObject.put("age of dragon", dragon.getAge());

            //set lenght of dragon cave
            jsonObject.put("lenght of dragon cave", dragon.getCave());


            RouteSet.add(jsonObject);


        }
        try{
            FileOutputStream outputStream = new FileOutputStream(filename);
            System.out.println("using file output stream");
            String s = RouteSet.toJSONString();
            byte[] bytesArray = s.getBytes();
            outputStream.write(bytesArray);
            outputStream.flush();
            outputStream.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        setDragon.clear();
    }

    public boolean removeById(int id) {
        boolean flag = false;
        for(Iterator<Dragon> iterator = setDragon.iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            if(dragon.getId()==id){
                flag = true;
                iterator.remove();
            }
        }
        return !flag;
    }

    public boolean removeGreater(Integer input) {
        setDragon.removeIf(r -> r.compareTo(input) > 0);
        System.out.println("The greater route has been deleted");
        return true;
    }
    public boolean removeLower(Integer input) {
        setDragon.removeIf(r -> r.compareTo(input) > 0);
        System.out.println("The lower route has been deleted");
        return true;
    }


    public boolean printUniqueColor() {
        for(Dragon r: setDragon){
            System.out.println(r.getName() + " " + r.getAge());
        }
        return true;
    }


}