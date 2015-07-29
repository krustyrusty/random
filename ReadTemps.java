import java.io.File;
import java.io.IOException;
import java.util.*;


public class ReadTemps {

  public static void main(String[] args) throws IOException
  {
    Scanner inFile1 = new Scanner(new File("test.txt"));//.useDelimiter(" ");

    ArrayList<Float> temps = new ArrayList<Float>();

    while (inFile1.hasNext()) {
      temps.add(inFile1.nextFloat());
    }
    
    inFile1.close();

    Float[] tempsArray = temps.toArray(new Float[0]);

    for (Float s : tempsArray) {
      System.out.println(s);
    }
  }
}