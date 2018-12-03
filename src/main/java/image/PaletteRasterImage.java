package image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {
    int width;
    int height;
    int[][] indexesOfColors;
    List<Color> palette;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height =height;
        palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels) {
        this.width=pixels.length;
        this.height=pixels[0].length;
        palette = new ArrayList<>();
        indexesOfColors=new int[width][height];
        for(int x=0;x< width;x++) {
            for (int y = 0; y < height; y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }
    public void createRepresentation(){

    }
    public void setPixelColor(Color color,int x, int y){
        if (!palette.contains(color))
            palette.add(color);
        indexesOfColors[x][y]=palette.indexOf(color);
    }
    public void setPixelsColor(Color[][] pixels){
        for(int x=0;x< width;x++) {
            for (int y = 0; y < height; y++) {
               setPixelColor(pixels[x][y],x,y);
            }
        }
    }
    public void setPixelsColor(Color color){
        for(int x=0;x< width;x++) {
            for (int y = 0; y < height; y++) {
                this.setPixelColor(color,x,y);

            }
        }
    }
    @Override
    public Color getPixelColor(int x, int y){

        return palette.get(indexesOfColors[x][y]);
    }
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}
