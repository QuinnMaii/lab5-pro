package Core;

import Data.Coordinates;
import Data.Dragon;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileParser {
    private static Data.Coordinates Coordinates;

    public static LinkedHashMap<Dragon,Coordinates> parse (String InputFileName){
        LinkedHashMap<Dragon,Coordinates> collectionInput= new LinkedHashMap<>();
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(InputFileName)){
            Object obj = jsonParser.parse(reader);
            JSONArray dragonMap = (JSONArray) obj;
            collectionInput = saveToColection(dragonMap);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return collectionInput;
    }

    private static LinkedHashMap<Dragon, Coordinates> saveToColection(JSONArray dragonMap) {
        LinkedHashMap<Dragon,Coordinates> LHM = new LinkedHashMap<>();
        dragonMap.forEach(r -> {
            try {
                LHM.put(convertJsonObjIntoDragon((JSONObject) r), Coordinates);
            } catch (java.text.ParseException e){
                e.printStackTrace();
            }
        });
        return LHM;
    }
    /**
     * This method convert JsonObj to Person
     * @return Product which is converted from JsonObject
     * @throws java.text.ParseException throw if occurs error
     */

    private static Dragon convertJsonObjIntoDragon(JSONObject jsonObject) throws java.text.ParseException {
        Dragon r = new Dragon();

        //set ID (generates new ID)
        Integer newID = (Integer) jsonObject.get("id");
        if(CollectionManager.IDChecker.contains(newID)){
            System.out.println("ID is duplicate, please insert valid input!");
        }
        else{
            CollectionManager.IDChecker.add(newID);
            r.setId(newID);
        }

        //set route name
        r.setName((String) jsonObject.get("name"));


        JSONObject coordinatesObj = (JSONObject) jsonObject.get("coordinates");
        r.setCoordinates(new Coordinates(
                (Long) coordinatesObj.get("cx"), (Float) coordinatesObj.get("cy")
        ));

         /*
           parse String to Date
        */

        //date in String
        Date date = new Date();
        r.setCreationDate(date);

        //set age
        r.setAge((int) jsonObject.get("age"));

        return r;
    }


}
