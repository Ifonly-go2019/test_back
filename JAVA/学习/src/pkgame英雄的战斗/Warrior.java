
package pkgame英雄的战斗;
/** 
 * 战士类
 * */
public class Warrior extends Hero{


    /** 构造方法*/
	public Warrior() {
		super();
		setName("默认英雄");
	}
	public Warrior(long id,String name,int x,int y) {
             super(id,name)	;
             setX(x);
             setY(y);
	}
	
	
	
	public boolean canFightByDistance(Assailable assa) {
		double distance =getDistance(getX(), getY(), assa.getX(), assa.getY());
		//假设战士的攻击距离为100
		return distance<=100;
	}
	

	@Override
	public void fight(Assailable hero) {
		//1.生成随机的攻击力
		//2.减掉传入英雄的攻击力
		int attack = ( (int) (Math.random() * 1000 ) ) %51+20;//攻击力在20-70之间
		setAttack(attack);
		hero.setHp(hero.getHp()-attack);
		System.out.println(getName()+"成功实施了一次近战攻击！");
		
	}
	
	
	
}
