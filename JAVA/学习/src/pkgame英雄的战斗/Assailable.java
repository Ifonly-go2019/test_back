package pkgameӢ�۵�ս��;
/** 
 * �ɹ����ӿ�--ֻҪʵ���˱��ӿڣ����൱�ھ߱��˿�ʵʩ��������Ļ�������
 * */
public interface Assailable {
	String getName();
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	int getHp();
	void setHp(int hp);
	//���ݾ����ж��Ƿ��ܹ�����һ���߱����������Ķ���
	boolean canFightByDistance(Assailable assa);
	
	/** ������һ���ɹ������� 
	 * @param assa
	 * */
	void fight(Assailable assa);

}
