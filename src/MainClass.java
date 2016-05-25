import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class MainClass {
	static final Integer pro = 10000000;
	static DateFormat dateF;
	static DateFormat dft = new SimpleDateFormat("MM/dd/yyyy"); 
	static Date startDate;
	static Integer ID;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		List<Object> writeDataObject = new ArrayList<Object>(pro);
	
		long start = 0;
		long stop = 0;
		
	    Stock st = new Stock(1, "MacBook" , 1200.55, 12, "23/05/2016");
		
		start = System.nanoTime();
//		
//		for(int i=0;i<pro;i++){
//			//writeDataObject.add(new Stock(i, "MacBook", 12.45, "23/05/2016"));
//			writeDataObject.add(st);
//		}
//		
//		try{
//			   
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file/stock.txt"));   
//			oos.writeObject(writeDataObject);
//			oos.close();
//			System.out.println("Transfer Data Done! ");
//			   
//		   }catch(Exception ex){
//			   ex.printStackTrace();
//		   }
		
		ObjectInputStream ois = new ObjectInputStream(new InflaterInputStream(new FileInputStream("file/stock.txt")));
		List<Stock> list = (List<Stock>) ois.readObject(); // cast is needed.
		ois.close();
		
		
		stop = System.nanoTime();
		 System.out.println((stop - start) / 1000000000D + " sec");
	
		//Collections.copy(getStock(), display);
		 
		//ArrayList <Stock> display = new ArrayList<Stock>(getStock());
		
		//System.out.print(display.get(0).Name);
		
	}
	
	public static Vector<Stock> getStock(){
		long start =0;
		start = System.nanoTime();
	    try{
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file/stock.txt"));
	        Vector<Stock> readObject = (Vector<Stock>) ois.readObject();
	        ois.close();
	        
	        long stop = 0;
		    stop = System.nanoTime();
		    System.out.println((stop - start) / 1000000000D + " sec");
		    
	        return readObject;
		    } catch(Exception ex){
	        System.out.println(ex.getMessage());
	        return null;
	    }
	   
	}
	

}
