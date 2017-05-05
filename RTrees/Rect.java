import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GPoint;
import java.awt.Color;

public class Rect {

  private GPoint center;
  private double width;
  private double height;
  private GRect rect;

  public Rect(int _w, int _h) {
    width = _w;
    height = _h;
    rect = new GRect(0,0,0,0);
    rect.setSize(width, height);

    rect.setFilled(true);
    rect.setColor(Color.RED);

  }

  public void setWidth(double _width) {
    width = _width;
  }

  public void setHeight(double _height) {
	  height = _height;
  }

  public void setCenter(GPoint _center) {
    center = _center;
    locate();
  }

  public void setColor(String _color) {
	if(_color.equals("WHITE"))
	  rect.setColor(Color.WHITE);
	if(_color.equals("BLUE"))
	  rect.setColor(Color.BLUE);
	if(_color.equals("RED"))
	  rect.setColor(Color.RED);
  }

  public GObject getForm() {
    return rect;
  }

  public void locate() {
    rect.setLocation(center.getX() - width/2, center.getY() - height/2);
    rect.setSize(width, height);
  }

  public double getX() { return rect.getX();}
  public double getY() { return rect.getY();}
  public double getWidth() { return rect.getWidth();}
  public double getHeight() { return rect.getHeight();}

}