package datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookInfo {
	private int bookid;
	private String bookname;
	private String author;
	private long price;
	private String PublicationDate;
	private long ISBN;
	private String publisher;
	private String category;	
	private String summary;
}
