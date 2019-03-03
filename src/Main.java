public class Main {
    //x= 17.75/3 * (1 - (1 - y/ 500 ) ^20 ) * y

    //y=(0.198 * (1 - (1 - (250 - x - y)/1000) ^20 ) + 0.056) * x + 0.60(1-y/500)^20 * y

    //e^(20log(1-x)) = (1-x) ^ 20

    public static void main(String[] args){
        for(double y=-100; y<500; y++){
            getY(y);
        }
    }


    static double getX(double y){
        double yFraction = y/500;
        double twentyPower=Math.pow(1-yFraction, 20);
        double output = 17.75/3 * (1-twentyPower) * y;
        return output;
    }

    //y=(0.198 * (1 - (1 - (250 - x - y)/1000) ^20 ) + 0.056) * x + 0.60(1-y/500)^20 * y

    //y=(0.198 * (1 - (1 - xyFraction) ^20 ) + 0.056) * x + 0.60(1-yFraction)^20 * y

    //y=(0.198 * (1 - xyTwentyPower) + 0.056) * x + 0.60 * yTwentyPower * y

    //y =(xFactor) * x + (yFactor) * y


    static double getY(double y){
        double x = getX(y);
        double xyFraction = (250 - x - y)/1000;
        double yFraction = y/500;
        double xyTwentyPower = Math.pow(1-xyFraction, 20);
        double yTwentyPower = Math.pow(1-yFraction, 20);
        double xFactor = 0.198 * (1-xyTwentyPower) + 0.056;
        double yFactor = 0.60 * yTwentyPower;
        double output = xFactor * x + yFactor * y;
        System.out.println(y + ", " + x + ", " + output);
        return output;
    }

}
