
import java.io.Serializable;

public class Book implements Serializable{
	private long ID;
	private String Title,Content;
		
	public Book(long ID, String Title, String Content) {
		super();
		this.ID = ID;
		this.Title = Title;
		this.Content = Content;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
