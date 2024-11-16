package Utils;

import java.util.Random;

public class commonUtils {

    public static int RandomNumber(){
        int maxValue = 10000;
        int minValue = 2500;
        Random random = new Random();
        return random.nextInt(maxValue) + minValue;
    }
}
