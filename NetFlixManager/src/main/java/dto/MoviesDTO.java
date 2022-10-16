package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MoviesDTO {
	private int id;
	private String title;
	private String genre;
	private Timestamp launch_date;
	private String input_date;
	
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
	public Timestamp getLaunch_date() {
		return launch_date;
	}
	public void setLaunch_date(Timestamp launch_date) {
		this.launch_date = launch_date;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public MoviesDTO() {
		super();
	}
	public MoviesDTO(int id, String title, String genre, Timestamp launch_date, String input_date) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.launch_date = launch_date;
		this.input_date = input_date;
	}
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
		return sdf.format(this.launch_date);
	}
}
