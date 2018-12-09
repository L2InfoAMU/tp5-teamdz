package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {
  Point point;
  int height;
  int width;
  Color color;
  Rectangle(int x, int y, int width, int height, Color color){
    this.point=new Point(x,y);
    this.width=width;
    this.height=height;
    this.color=color;
  }

  @Override
  public boolean contains(Point point) {
    if(point.x<=this.point.x+width && point.x>=this.point.x
    && point.y<=this.point.y+height && point.y>=this.point.y)
      return true;
    return false;
  }

  @Override
  public Color getColor() {
    return this.color;
  }
}
