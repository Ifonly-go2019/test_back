package Ӣ����hero;

public abstract class LongRangeHero extends Hero{
     private int attackRange;

     /** ���췽��*/
     public LongRangeHero() {
    	 super();
     }
     public LongRangeHero(long id,String name,int attackRange, int x, int y) {
    	 super(id,name);
    	 setX(x);
         setY(y);
         setAttackRange(attackRange);
         
     }
     
	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
     
	
}
