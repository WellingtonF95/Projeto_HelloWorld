package Datas;

import java.time.LocalTime;

public class LocalTimeExemplo {

    public static void main(String[] args) {

        // LocalTime

        LocalTime localTime = LocalTime.now(); // a hora atual em hh:mm:ss.nanoSegundos
        System.out.println(localTime);

        localTime = LocalTime.of(20, 0, 10);
        System.out.println(localTime);

    }

}
