package DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class NetflixDTO {

	
	private int id;
	private String title;
	private String genre;
	private Timestamp launch_Date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Timestamp getLaunch_Date() {
		return launch_Date;
	}
	public void setLaunch_Date(Timestamp launch_Date) {
		this.launch_Date = launch_Date;
	}
	
	public NetflixDTO(int id, String title, String genre, Timestamp launch_Date) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.launch_Date = launch_Date;
	}
	
	
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
		return sdf.format(this.launch_Date);
	}
	
	
	
}
