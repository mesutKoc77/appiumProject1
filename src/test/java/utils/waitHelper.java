package utils;

public class waitHelper {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000); // Saniyeyi milisaniyeye çevirerek bekler
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Kesinti durumunda hatayı işler
        }
    }


}
