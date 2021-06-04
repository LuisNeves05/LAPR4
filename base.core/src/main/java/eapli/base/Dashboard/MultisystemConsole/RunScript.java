package eapli.base.Dashboard.MultisystemConsole;

import java.io.IOException;

public class RunScript {
    public static void runScript() throws IOException {

        String operatingSystem = System.getProperty("os.name");
        String homeDirectory = System.getProperty("user.home");
        Process process;


        if(operatingSystem.contains("Windows")){
            //process = Runtime.getRuntime().exec("start http://localhost:8080");
        }else{
            process = Runtime.getRuntime().exec("open http://localhost:8080");
        }

    }
}
