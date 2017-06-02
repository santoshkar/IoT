import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by Santosh Kumar Kar on 30-05-2017.
 */
public class ReadTemperature {
    public static void main(String[] args) throws IOException,InterruptedException {
        while(true){
            String line_2 = Files.readAllLines(Paths.get("/sys/bus/w1/devices/28-80000003c64d/w1_slave")).get(1);
            String temperaturedata = line_2.split(" ")[9];
            String data = temperaturedata.split("=")[1];
            System.out.println(Float.valueOf(data)/1000);
            Thread.sleep(1000);
        }
    }
}

