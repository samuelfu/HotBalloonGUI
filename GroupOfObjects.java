import java.awt.Graphics2D;

public interface GroupOfObjects {
	void draw(Graphics2D g2D);
	void translate(int xChange, int yChange);
	public void massTranslate(int xChange, int yChange);
	public void jitter(int xChange);
}
