package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image{
    Color[][] pixels;
    int width;
    int height;


    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Color[width][height];
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                pixels[x][y]=color;
            }
        }
    }
    public BruteRasterImage(Color[][]colors){
        Matrices.requiresNonZeroDimensions(colors);

    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPixelColor(Color color, int x,int y) {
        for (x=0;x<getWidth();x++){
            for(y=0;y<getHeight();y++){
                pixels[x][y] = color;
            }
        }
    }
    public void setPixelsColor(Color[][]pixels){

    }
    public void setPixelsColor(Color color){

    }
    public void createRepresentation(){

    }
}

