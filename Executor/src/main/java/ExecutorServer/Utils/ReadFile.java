package ExecutorServer.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public static List<String> getAvailableIps() {
        List<String> ips = new ArrayList<>();

        try {
            File myObj = new File("Executor/src/main/java/ExecutorServer/ConfigFile/ipList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ips.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(ips);

        return ips;
    }
}