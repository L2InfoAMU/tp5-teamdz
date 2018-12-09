package image;
import java.util.List;
import javafx.scene.paint.Color;
public class VectorImage implements Image {
  List<Shape> shapes;
  int height;
  int width;

  VectorImage(List<Shape> shapes, int width, int height) {
    this.height = height;
    this.width = width;
    this.shapes = shapes;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    for (Shape shape : this.shapes)
      if (shape.contains(new Point(x, y)))
        return shape.getColor();
    return Color.WHITE;
  }
}
