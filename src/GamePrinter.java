/**
 * Created by Pontus on 2016-03-06.
 */
public final class GamePrinter {
    public static boolean printEnabled = true;

    public static void print(String string){
        if(printEnabled){
            System.out.println(string);
        }
    }
}
