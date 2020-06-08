package Input_pack;

public class Board {
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String title;
	private String password;
	private String publcity;
	private String exitDate;
	private String content;
	public Board(String title, String password, String publcity, String exitDate, String content) {
		super();
		this.title = title;
		this.password = password;
		this.publcity = publcity;
		this.exitDate = exitDate;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public String getPassword() {
		return password;
	}
	public String getPublcity() {
		return publcity;
	}
	public String getExitDate() {
		return exitDate;
	}
	public String getContent() {
		return content;
	}
	
}
