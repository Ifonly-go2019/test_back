
package pkgameӢ�۵�ս��;
/** 
 * սʿ��
 * */
public class Warrior extends Hero{


    /** ���췽��*/
	public Warrior() {
		super();
		setName("Ĭ��Ӣ��");
	}
	public Warrior(long id,String name,int x,int y) {
             super(id,name)	;
             setX(x);
             setY(y);
	}
	
	
	
	public boolean canFightByDistance(Assailable assa) {
		double distance =getDistance(getX(), getY(), assa.getX(), assa.getY());
		//����սʿ�Ĺ�������Ϊ100
		return distance<=100;
	}
	

	@Override
	public void fight(Assailable hero) {
		//1.��������Ĺ�����
		//2.��������Ӣ�۵Ĺ�����
		int attack = ( (int) (Math.random() * 1000 ) ) %51+20;//��������20-70֮��
		setAttack(attack);
		hero.setHp(hero.getHp()-attack);
		System.out.println(getName()+"�ɹ�ʵʩ��һ�ν�ս������");
		
	}
	
	
	
}
