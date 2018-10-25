import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class MassAscension implements GroupOfObjects{
	private final int NUMBEROFBALLOONS = 5;
	private int size;
	private int windChange = 0;
	private int counter = 0;
	private ArrayList<HotBalloon> hbList = new ArrayList<HotBalloon>();
	
	public MassAscension() {
		Random rand = new Random();
		for(int i = 0; i < NUMBEROFBALLOONS; i ++) {
			int size = rand.nextInt(150) + 50;
			int x = rand.nextInt(600);
			int y = rand.nextInt(1000);
			hbList.add(new HotBalloon(x,y,size));
		}
	}
	
	public void draw(Graphics2D g2d) {
		for(HotBalloon hb:hbList)
			hb.draw(g2d);
	}

	public void massTranslate(int xChange, int yChange) {
		for(HotBalloon hb:hbList) {
			hb.translate(xChange, yChange);
			if(counter < 100) {
			hb.translate(windChange, 0);
			counter++;
			}
			else
			{
				counter = 0;
				windChange *= -1;
			}
		}
		
	}
	
	public void jitter(int windChange) {
		this.windChange = windChange;
	}

	public void translate(int xChange, int yChange) {
		// TODO Auto-generated method stub
		
	}

}
