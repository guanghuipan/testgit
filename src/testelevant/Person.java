package testelevant;

public class Person {
	//编号
	private int id;
	//上下电梯需要的时间（随机生成）
	private int timeInMilliSeconds;
	
	public Person() {
		super();
	}
	public Person(int id, int timeInMilliSeconds) {
		super();
		this.id = id;
		this.timeInMilliSeconds = timeInMilliSeconds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTimeInMilliSeconds() {
		return timeInMilliSeconds;
	}
	public void setTimeInMilliSeconds(int timeInMilliSeconds) {
		this.timeInMilliSeconds = timeInMilliSeconds;
	}
	
}
