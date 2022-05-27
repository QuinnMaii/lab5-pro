package Helpers;

import Data.*;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.lang.String;
/**
 * class for parse file input
 */
public class FileParser {

    public static Set<Dragon> parse(String InputFileName) throws FileNotFoundException {
        Set<Dragon> collectionInput = new HashSet<>();
        CSVReader reader = null;
        try {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader(InputFileName));
            String[] nextLine;

            //reads one line at a time
            Integer cnt = 0;
            Dragon r = new Dragon();
            Long cx = null;
            while ((nextLine = reader.readNext()) != null)
            {
                String pre="";
                for (String token: nextLine) {
                    if (pre == "id"){
                        Integer newID = Integer.valueOf(token);
                        if(CollectionManager.IDChecker.contains(newID)){
                            System.out.println("ID is duplicate, please insert valid input!");
                        }
                        else{
                            CollectionManager.IDChecker.add(newID);
                            r.setId(newID);
                        }
                    }
                    if(pre == "name") r.setName(token);
                    if(pre == "age") r.setAge(Integer.parseInt(token));
                    if(pre == "coordinates") cx = Long.valueOf(token);
                    if(cx != null)
                    {
                        r.setCoordinates(new Coordinates(cx,Float.valueOf(token)));
                        cx = null;
                    }
                    if(pre == "charecters") r.setCharacter(DragonCharacter.valueOf(token));
                    if(pre == "color") r.setColor(Color.valueOf(token));
                    if(pre == "type") r.setType(DragonType.valueOf(token));
                    if(pre == "cave") r.setCave(Float.valueOf(token));

                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return collectionInput;
    }
}
