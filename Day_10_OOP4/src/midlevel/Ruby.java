package midlevel;

public class Ruby extends Member {
	public Ruby(int id, String name, int point) {
		super(id, name, point);
	}
	
	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return this.getPoint()*0.04;
	}
}
