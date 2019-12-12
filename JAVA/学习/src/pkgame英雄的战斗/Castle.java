package pkgame英雄的战斗;

public class Castle implements Assailable {
	 private String name;
	 private int maxHp;
	 private int hp;
	 private int attack;
	 private int attackRange;
	 private int x;
	 private int y;
	 
	 
	 
		public boolean canFightByDistance(Assailable assa) {
			// 1.计算与另一个可攻击对象之间的距离
			//2.如果攻击距离合法，就进行攻击
			return false;
		}
		@Override
		public void fight(Assailable assa) {
			// 假设城堡的攻击力固定
			int attack =15;
			assa.setHp(assa.getHp()-attack);
			
		}

	 
	 
	 
	 
	 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
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
