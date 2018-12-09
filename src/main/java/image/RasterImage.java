package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage {
  int width;
  int height;

  public RasterImage(int width, int height) {
    this.width = width;
    this.height = height;
  }

  protected void setHeight(int height) {
    this.height = height;
  }

  protected void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

}

