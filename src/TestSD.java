import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class TestSD {
	static final Integer pro = 10_000_000;
	static List<Stock> insertData = new Vector<Stock>();
	static List<Stock> storeData;
	static List<Stock> readData;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	   long start = System.nanoTime(); 
	   writeObject(10_000_000);
	   long end = System.nanoTime();
	   System.out.println("Insert Data:" + (end - start) / 1000000000D + " sec");
	    
	   long st = System.nanoTime();
	   readObject("file/test.txt");
	   long ed = System.nanoTime();
	   System.out.println("Read Data:" + (ed - st) / 1000000000D + " sec");
	   
	   displayData(0,5);
	  showMenu();
	 
	    
	}
	
	public static void displayData(Integer offset, Integer record){
		Integer no = 0;
		
		Table t = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.ALL);
		CellStyle numberStyle = new CellStyle(HorizontalAlign.center);
		
		t.setColumnWidth(0, 15, 30);
	    t.setColumnWidth(1, 15, 30);
	    t.setColumnWidth(2, 15, 30);
	    t.setColumnWidth(3, 15, 30);
	    t.setColumnWidth(4, 15, 30);
	    
	    t.addCell("ID", numberStyle);
	    t.addCell("name", numberStyle);
	    t.addCell("Unit Price", numberStyle);
	    t.addCell("Quantity", numberStyle);
	    t.addCell("Imported Date",numberStyle);
	    
		 
	    for(int i=offset;i<record;i++){
	    	no = readData.get(i).ID -i ;
	    	t.addCell(no.toString(), numberStyle);
	    	t.addCell(readData.get(i).Name.toString(), numberStyle); 
	    	t.addCell(readData.get(i).Price.toString(), numberStyle);
	    	t.addCell(readData.get(i).qty.toString(), numberStyle);
	    	t.addCell(readData.get(i).dateImported.toString(),numberStyle);		 
	    }
	    t.addCell("Page: " + 1 + "/" + (int)readData.get(0).ID/(int)record , numberStyle, 3);
	    t.addCell("Total Records: " + (int)readData.get(0).ID ,numberStyle, 2);
	    
	    System.out.println(t.render());	
	    
	}
	
	public static void writeObject(Integer record) throws IOException, ClassNotFoundException{
		Stock stock = new Stock(record,"MacBook", 1200.89, 12, "23/05/2015");
		for(int i=1;i<=record;i++){
			insertData.add(stock);
		}
		ObjectOutputStream oos = new ObjectOutputStream(new DeflaterOutputStream(new FileOutputStream("file/test.txt")));
	    oos.writeObject(insertData);
	    oos.close();
	}

	public static void readObject(String fileName) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new InflaterInputStream(new FileInputStream(fileName)));
		readData = (Vector<Stock>) ois.readObject(); // cast is needed.
	    storeData = new ArrayList<Stock>(readData);
	    ois.close();
	}
	
	public static void showMenu(){

		Table t = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,  
				ShownBorders.SURROUND);
		CellStyle numberStyle = new CellStyle(HorizontalAlign.center);

		t.setColumnWidth(0, 80, 120);
	    
		t.addCell("*)Display | W)rite | R)ead | U)pdate | D)elete | F)irst | P)revious | "
				+ "L)ast",numberStyle);
		t.addCell(" ");
		t.addCell("S)earch | G)o to | Se)t row | Sa)ve | B)ack up | Re)store | H)elp |"
				+ " E)xit",numberStyle);
		
		System.out.println(t.render());
	}
	

}
