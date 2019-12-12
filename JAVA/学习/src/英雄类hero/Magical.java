package 英雄类hero;

public class Magical extends LongRangeHero {

	public Magical() {
		super();
	}
	public Magical(long id,String name, int attackRange,int x, int y) {
		super(id,name,attackRange,x,y);
	}
	public boolean canFightByDistance(Hero hero) {
       double distance =getDistance(getX(), getY(), hero.getX(), hero.getY());
       if(Math.abs(distance)<=getAttackRange()) {//如果在攻击范围内
    	   
    	   return true;
       }
       System.out.println("目标攻击距离过远,无法攻击！");
		return false;
	}


	public void fight(Hero hero) {
	       //法师的攻击力设置为5-10
		setAttack((int)Math.random()*5+5);
		hero.setHp(hero.getHp()-getAttack());
		  System.out.println(getName()+"成功实施了一次远程攻击");
	}


}
