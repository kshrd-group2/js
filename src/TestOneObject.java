import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestOneObject {
	public static void main(String[] args) throws Exception {
	    OutputStream os = new FileOutputStream("file/oneObject.txt");
	    ObjectOutputStream oos = new ObjectOutputStream(os);
	    for (Integer i = 0; i < 1E7; i++) {
	        oos.writeObject(i);
	    }
	    oos.close();
	}
}
