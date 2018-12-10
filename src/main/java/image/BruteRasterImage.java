package image;

import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage extends RasterImage implements Image{
    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        super(width ,height);
        this.createRepresentation();
        this.setPixelsColor(color);
    }


    public BruteRasterImage(Color[][]colors){
        super(Matrices.getRowCount(colors),Matrices.getColumnCount(colors));
        this.createRepresentation();
        this.setPixelsColor(colors);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

    public void setPixelColor(Color color, int x,int y) {
        pixels[x][y] = color;
    }
    public void setPixelsColor(Color[][]pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        for (int x=0 ; x<this.getWidth() ; x++){
            for (int y=0 ; y<this.getHeight() ; y++){
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }
    public void setPixelsColor(Color color){
        for(int x=0;x< this.getWidth();x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                this.setPixelColor(color,x,y);

            }
        }
    }
    public void createRepresentation(){
        this.pixels = new Color[width][height];
    }
}

