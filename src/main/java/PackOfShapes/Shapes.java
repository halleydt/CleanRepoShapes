package PackOfShapes;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class Shapes implements Serializable {

    int size;
    String color;

    public Shapes(String color, int size) {
        this.size = size;
        this.color = color;
    }

    public Shapes() {
        new Shapes("white" , 0);
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj){
        boolean temp = false;
        if (obj instanceof Shapes) {
            Shapes newObj = (Shapes) obj;
            temp = (this.getColor().equalsIgnoreCase(newObj.getColor()) && this.getSize() == newObj.getSize());
        }
        return temp;
    }

    public static void serializeToXML(Shapes obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("Exception: " + e.toString());
            }
        });
        encoder.writeObject(obj);
        encoder.close();
        fos.close();
    }

    public static Shapes deserializeFromXML(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XMLDecoder decoder = new XMLDecoder(fis);
        Shapes decodedObj = (Shapes) decoder.readObject();
        decoder.close();;
        fis.close();
        return decodedObj;
    }
    public static void serialize(Shapes person, String fileAddress) {
        String CSVString = "";
        try {
            PrintWriter outFile = new PrintWriter(new FileOutputStream(fileAddress));
            outFile.println(person.getColor() + "," + person.getSize());
            outFile.flush();
            outFile.close();
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
    }

    public static Shapes deserialize(String fileAddress) {
        Shapes temp = null;
        try {
            Scanner fileInput = new Scanner(new FileInputStream(fileAddress));
            String inputLine = fileInput.nextLine();
            String [] line = inputLine.split(",");
            temp = new Shapes(line[0], Integer.parseInt(line[1]));
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
        return temp;
    }
}
