import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class HotBalloon implements MovingObject {
	private int x;
	private int y;
	private int unit;
	private final int LINELENGTH = 2;

	public void draw(Graphics2D g2d) {

		// basic x symmetry
		int xCenter = x + unit / 2;
		
		//balloon
		int balloonXUpLeft = x;
		int balloonYUpLeft = y;
		int balloonSize = unit;
		Ellipse2D.Double balloon = new Ellipse2D.Double(balloonXUpLeft, balloonYUpLeft, balloonSize, balloonSize);
		
		//burner
		int burnerXTop = balloonXUpLeft;
		int burnerYTop = balloonYUpLeft + unit/2;
		int burnerXBottom = xCenter;
		int burnerYBottom = balloonYUpLeft + LINELENGTH*unit;
		Line2D.Double burnerLeft = new Line2D.Double(burnerXTop, burnerYTop, burnerXBottom, burnerYBottom);
		Line2D.Double burnerRight = new Line2D.Double(burnerXTop+unit, burnerYTop, burnerXBottom, burnerYBottom);
		
		//gondola
		Rectangle2D.Double gondola = new Rectangle2D.Double(x, y+LINELENGTH*unit, unit, unit);
		
		GeneralPath body = new GeneralPath();
		body.append(burnerLeft, false);
		body.append(burnerRight, false);
		
		g2d.fill(balloon);
		g2d.fill(gondola);
		g2d.draw(body);
	}

	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}

	public HotBalloon(int x, int y, int unit) {
		this.x = x;
		this.y = y;
		this.unit = unit;
	}

}
