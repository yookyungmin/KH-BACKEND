

//VO Value object 값을 의미하는 객체
//DTO Data Transfer Object(값을 저장하고 전달하는 목적으로 사용되는 객체)
//강사님 DTO
public class CafeMenuDTO { 
	private int pid;
	private String pname;
	private int pprice;
	private String iced;
	
	
	
	
	
	public CafeMenuDTO(int pid, String pname, int pprice, String iced) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.iced = iced;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getIced() {
		return iced;
	}
	public void setIced(String iced) {
		this.iced = iced;
	}
	
	
	
	
	
}
