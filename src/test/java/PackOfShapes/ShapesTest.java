package PackOfShapes;

import org.junit.Assert;
import org.junit.*;

import java.io.IOException;

public class ShapesTest extends Serialization {

    @Test
    public void testEquals() throws Exception {
        Shapes first = new Shapes("red", 1);
        Shapes second = new Shapes("red", 1);
        Assert.assertEquals(first, second);
    }

    @Test
    public void testXMLSerialization() throws IOException {
        Shapes first = new Shapes("red", 1);
        Shapes second = new Shapes("red", 1);
        Shapes.serializeToXML(second, "shape.xml");
        Shapes XMLShape = Shapes.deserializeFromXML("shape.xml");
        Assert.assertTrue(first.equals(second));
    }
}