package Ӣ����hero;

public class Magical extends LongRangeHero {

	public Magical() {
		super();
	}
	public Magical(long id,String name, int attackRange,int x, int y) {
		super(id,name,attackRange,x,y);
	}
	public boolean canFightByDistance(Hero hero) {
       double distance =getDistance(getX(), getY(), hero.getX(), hero.getY());
       if(Math.abs(distance)<=getAttackRange()) {//����ڹ�����Χ��
    	   
    	   return true;
       }
       System.out.println("Ŀ�깥�������Զ,�޷�������");
		return false;
	}


	public void fight(Hero hero) {
	       //��ʦ�Ĺ���������Ϊ5-10
		setAttack((int)Math.random()*5+5);
		hero.setHp(hero.getHp()-getAttack());
		  System.out.println(getName()+"�ɹ�ʵʩ��һ��Զ�̹���");
	}


}
