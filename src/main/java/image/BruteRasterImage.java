package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image{
    Color color;
    int width;
    int height;

    public BruteRasterImage(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    public BruteRasterImage(Color[][]colors){

    }

    @Override
    public javafx.scene.paint.Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}

