package en_p3_001_hard;
import java.util.Scanner;

/******start******/
interface PCI{
	void NameCard() ;
	void start();
	void stop();
}
class  NetworkCard implements PCI{

	
	public void NameCard() {
		System.out.println("-----NetworkCard-----");
	}

	
	public void start() {
		System.out.println("sending");
	}

	public void stop() {
		System.out.println("stop...");
	}
	
	
}



/******end******/

class SoundCard implements PCI {
	public void NameCard() {
		System.out.println("-----SoundCard-----");
	}

	public void start() {
		System.out.println("du..du");
	}

	public void stop() {
		System.out.println("sound stop");
	}
}

/******start******/
class MainBoard{

	public void usePCICard(PCI nc) {
		nc.NameCard();
		nc.start();
		nc.stop();
	}
	
}





 /******end******/

public class Main{
	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		NetworkCard nc = new NetworkCard();
		SoundCard sc = new SoundCard();
		
		Scanner san = new Scanner(System.in);
		String type = san.next();
		
		if (type.equals("n")) {
			mb.usePCICard(nc);
		} else if (type.equals("s")) {
			mb.usePCICard(sc);
		} else {}
	}
}
