package Core;

import Data.Coordinates;
import Data.Dragon;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCSVException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionManager {
    private LinkedHashMap<Dragon, Coordinates> mapDragon = new LinkedHashMap<>();
    public static HashSet<Integer> IDChecker = new HashSet<>();
    private final Date creationDate = new Date();
    public void readInputFromJSONFile(String InputFileName){
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
        for (Dragon key : mapDragon.keySet()) {
            Dragon value = mapDragon.get(key);
            System.out.println(value.toString());
        }
    }

    public void add(Dragon D,Coordinates C){
        mapDragon.put(D,C);
    }
    public void addIfMax(Dragon D, Coordinates C){
        boolean judge = true;
        for (Entry<Dragon, Coordinates> entry : mapDragon.entrySet()) {
                Dragon product = entry.getKey();
            if (D.compareTo(product) < 0) {
                judge = false;
            }
        }
        if (judge) {
            mapDragon.put(D,C);
        }
    }

    public void save(String filename){
        Map<String, String> DragonSet = new HashMap<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(String key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<String> values() {
                return null;
            }

            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        for (Dragon dragon : mapDragon.keySet()){

            System.out.println(mapDragon.toString());
            Map<String, String> CsvMap = new HashMap<>();
            CsvMap.put("id", String.valueOf(dragon.getId()));
            CsvMap.put("name", dragon.getName());

            //write coordinates to file
            CsvMap.put("coordinates", "");
            CsvMap.put("cx", String.valueOf(dragon.getCoordinates().getX()));
            CsvMap.put("cy", String.valueOf(dragon.getCoordinates().getY()));

            //Write time
            SimpleDateFormat stringDate = new SimpleDateFormat ("dd/MM/yyyy",Locale.ROOT);
            CsvMap.put("date", String.valueOf(stringDate));

            //write color of dragon
            CsvMap.put("color of dragon", String.valueOf(dragon.getColor()));

            //write type of dragon
            CsvMap.put("type of dragon", String.valueOf(dragon.getType()));

            //write character of dragon
            CsvMap.put("character of dragon",  String.valueOf(dragon.getCharacter()));

            //set age
            CsvMap.put("age of dragon", String.valueOf((dragon.getAge())));

            //set lenght of dragon cave
            CsvMap.put("lenght of dragon cave", String.valueOf(dragon.getCave()));


        }
        try{
            FileOutputStream outputStream = new FileOutputStream(filename);
            System.out.println("using output stream writer");
            try (ICsvListWriter listWriter = new CsvListWriter(outputStream,
                    CsvPreference.STANDARD_PREFERENCE)){
                for (Map.Entry<String, String> entry : CsvMap.entrySet()){
                    listWriter.write(entry.getKey(), entry.getValue());
                }
            }
            System.out.println(outputStream);
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
        for(Iterator<Dragon> iterator = mapDragon.keySet().iterator(); iterator.hasNext();){
            Dragon dragon = iterator.next();
            if(dragon.getId()==id){
                flag = true;
                iterator.remove();
            }
        }
        return !flag;
    }

    public boolean removeGreater(Integer input) {
        mapDragon.keySet().removeIf(r -> r.compareTo(input) > 0);
        System.out.println("The greater route has been deleted");
        return true;
    }
    public boolean removeLower(Integer input) {
        mapDragon.keySet().removeIf(r -> r.compareTo(input) > 0);
        System.out.println("The lower route has been deleted");
        return true;
    }


    public boolean printUniqueColor() {
        for(Dragon r: mapDragon.keySet()){
            System.out.println(r.getName() + " " + r.getAge());
        }
        return true;
    }


}