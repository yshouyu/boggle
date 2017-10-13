import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class ReadDataUtils
 */
public class ReadDataUtils {

    public static List<String> readData(String filename){
        Scanner in = null;
        FileInputStream inputStream = null;
        List<String> data = new ArrayList<String>();
        try {
            inputStream = new FileInputStream(filename);
            in = new Scanner(inputStream);
            while(in.hasNext()){
                data.add(in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                in.close();
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
