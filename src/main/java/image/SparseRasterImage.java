package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage implements Image {
    Map<Point,Color> pixelsMap;

    public SparseRasterImage(Color[][] pixels){
        super(pixels.length,pixels[0].length);
        createRepresentation();
        setPixelsColor(pixels);
    }
    public SparseRasterImage(Color color, int width, int height) {
        super(width, height);
        createRepresentation();
        setPixelsColor(color);
    }
    @Override
    public Color getPixelColor(int x, int y) {
        return pixelsMap.getOrDefault(new Point(x,y),Color.WHITE);
    }
    public void createRepresentation(){
        pixelsMap = new HashMap<>();
    }
    public void setPixelColor(Color color,int x, int y){
        if(!(color==Color.WHITE))
            pixelsMap.put(new Point(x,y),color);
    }
    private void setPixelsColor(Color[][] pixels){
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        Matrices.requiresNonNull(pixels);
        this.pixelsMap.clear();
        for(int x=0;x< this.getWidth();x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }
    private void setPixelsColor(Color color){
        for(int x=0;x< this.getWidth();x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                this.setPixelColor(color,x,y);
            }
        }
    }


}