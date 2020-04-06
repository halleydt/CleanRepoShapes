package PackOfShapes;

import java.io.*;
public class Serialization {
    public static void Serialize(Object obj, String fileAddress){
        try {
            FileOutputStream fileOut = new FileOutputStream(fileAddress);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Object Deserialize(String fileAddress){
        Object obj = null;
        try {
            FileInputStream fileInput = new FileInputStream(fileAddress);
            ObjectInputStream objIn = new ObjectInputStream(fileInput);
            obj = objIn.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}