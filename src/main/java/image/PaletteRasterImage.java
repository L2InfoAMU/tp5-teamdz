package image;
import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage implements Image {
    int[][] indexesOfColors;
    List<Color> palette;

    public PaletteRasterImage(Color color, int width, int height){
        super(width ,height);
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels) {
        super(pixels.length,pixels[0].length);
        createRepresentation();
        setPixelsColor(pixels);
    }
    public void createRepresentation(){
        palette = new ArrayList<>();
        indexesOfColors=new int[this.getWidth()][this.getHeight()];
    }
    public void setPixelColor(Color color,int x, int y){
        if (!palette.contains(color))
            palette.add(color);
        indexesOfColors[x][y]=palette.indexOf(color);
    }
    public void setPixelsColor(Color[][] pixels){
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        Matrices.requiresNonNull(pixels);
        this.palette.clear();
        for(int x=0;x< this.getWidth();x++) {
            for (int y = 0; y < this.getHeight(); y++) {
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
    @Override
    public Color getPixelColor(int x, int y){

        return palette.get(indexesOfColors[x][y]);
    }

}
