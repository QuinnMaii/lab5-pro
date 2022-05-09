package Core;

public class InputChecker {

    private static final double eps = 1E-6;

    public boolean integerValidChecker(String s, int min, int max){
        try{
            int x = Integer.parseInt(s);
            if(x >= min && x <= max) return true;
            System.out.println("Input is invalid. Please enter the integer in the correct range");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Input is invalid. Please enter an integer");
            return false;
        }
    }

    public boolean longValidCheck(String s, Long min, Long max){
        try{
            long x = Long.parseLong(s);
            if(x >= min && x <= max) return true;
            System.out.println("Input is invalid. Please enter the long number in correct range");
            return false;
        } catch(NumberFormatException e){
            System.out.println("Input is invalid. Please enter a long number");
            return false;
        }
    }

    public boolean floatValidCheck(String s, Double min, Double max){
        try{
            Float x = Float.parseFloat(s);
            if( x - min > eps && max - x > eps){
                return true;
            }
            System.out.println("Input is invalid. Please enter the double number in correct range");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Input is invalid. Please enter a double number");
            return false;
        }
    }


}
