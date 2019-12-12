package pkgame英雄的战斗;

public abstract class Hero implements Assailable {
	private long id;
	 private String name;
	 private int level;
	 private int maxHp;
	 private int hp;
	 private int attack;
	 private int x;
	 private int y;
	 
	 //构造方法
	 public Hero() {
		 setMaxHp(100);
		 setHp(100);	 
	 }
	 
	 public Hero(long id,String name) {
		 this();
		 setId(id);
		 setName(name);
	 }
	
	 
	 protected double getDistance(int x1,int y1,int x2,int y2) {
		 return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	 }
	 
	 /** 
	  * 英雄之间的pk
	  * 1.判断两者的距离
	  * 2.如果距离满足就进行攻击
	  * @param assa
	  * */
	 public void PK(Assailable assa) {
		 if(canFightByDistance(assa)==true && hp>0 &&assa.getHp()>0) {
			 fight(assa); 
		 }else {
			 System.out.println("由于攻击距离或其他原因，攻击失败！！");
		 }		 
		 //3.在控制台打印对战后的结果(控制台程序专用)
	   System.out.println("两位英雄的当前状态");
	   System.out.println("昵称\tHP\t坐标X\t坐标Y\t");
		System.out.println(name+"\t"+hp+"\t"+x+"\t"+y);
		System.out.printf("%s\t%d\t%d\t%d",
				assa.getName(),assa.getHp(),assa.getX(),assa.getY()
				);
	 }
	 
	
	 
	 
	public long getId() { 
	  return id; 
	}	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	 
	 
	 
}
