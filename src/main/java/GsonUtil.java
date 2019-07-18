import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by anmi0217 on 18/7/2019.
 */
public class GsonUtil {
    public static void save(Object o,String fileName){
        Gson gson = new Gson();
        String s  = gson.toJson(o);
        File file = new File(fileName);
        if (file.exists()){
            try (FileWriter fileWriter = new FileWriter(file)){
                char[] arrayOfChars = s.toCharArray();
                for (char v :
                        arrayOfChars) {
                    fileWriter.write(v);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static <T> T load(String fileName,Class<T> tClass){
        Gson gson = new Gson();
        File file = new File(fileName);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                String resultString="";
                while (scanner.hasNext()){
                    resultString+=scanner.nextLine();
                }
                return gson.fromJson(resultString,tClass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //подразумеваеи что в json будет храниться Несколько объектов листом
    public static void append(Object o,String fileName){
        Gson gson = new Gson();

        Object object = load(fileName,o.getClass());
        List<Object> objects = new ArrayList<>();

        objects.add(object);
        objects.add(o);
        String s  = gson.toJson(objects);

        File file = new File(fileName);
        List<Object> fromJsons;
        if (file.exists()){
            try (FileWriter fileWriter = new FileWriter(file)){
                char[] arrayOfChars = s.toCharArray();
                for (char v :
                        arrayOfChars) {
                    fileWriter.write(v);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
