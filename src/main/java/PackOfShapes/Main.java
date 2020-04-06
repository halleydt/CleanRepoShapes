package PackOfShapes;

import PackOfShapes.Serialization;
import PackOfShapes.Shapes;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Shapes firstShape = new Shapes("red", 5);
        Shapes secondShape = new Shapes("red", 5);
        Shapes.serializeToXML(secondShape, "shape.xml");
        Shapes XMLShape = Shapes.deserializeFromXML("shape.xml");
        Serialization.Serialize(secondShape, "binarySerializeFile.ser"); //.ser
        Shapes BinaryShape = (Shapes) Serialization.Deserialize("binarySerializeFile.ser");
        Shapes.serialize(secondShape, "csvSerializeFile.csv");
        Shapes CSVShape = (Shapes) Shapes.deserialize("csvSerializeFile.csv"); //.csv
        System.out.println(firstShape.equals(XMLShape));
        System.out.println(firstShape.equals(BinaryShape));
        System.out.println(firstShape.equals(CSVShape));
    }
}