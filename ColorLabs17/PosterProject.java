import java.awt.Color;

/**
 * Poster Project
 * Kaylie Austin 
 * May 6th, 2026
 **/ 
 
//one transformation must be a horizontal or vertical mirroring (potentially of the entire collage) (DONE)
//one transformation must be an original manipulation of the image(rotate, sepia, blend, etc . . . ) 
//one transformation must be a recursive manipulation of the image

// The collage must be saved as an image file
// ex. picture.write(FileChooser.getMediaPath(fileName));
// ex. picture.write(“thisfolder.finalcollege.jpg”);

//the orginal image will be put on the canvas on the top right slot

//Vertical Mirroring (DONE), Grayscale (DONE), Blending, Recursion, Hue shifting (DONE), Orginal (DONE)

//The image is 2560 x 1440 pixels 
//my canvas that I want to post my 6 images on is 5140 x 3855 pixels

//The image I am going to blend and integrate into the picture called IWannaBeYours. It is 1320 x 990 pixels. 
//for the blend, I want the IWannaBeYours image to be in the center of an orginal picture and then blend it so we see 50% of my orginal and 50% of my second image

//I also would like to change my vertical mirror to also reflect horizontaly based on the bottom right hand side of the orginal imge
//Bascially I want to flip it vertically, then flip it horizontally, and then put that new picture in the canvas

//for my recursive method, I want it in the bottom left hand side
//I would like it to recursive into the bottom left hand corner 

public class PosterProject
{
    public static void main(String[] args)
    {
        Picture acanvas = new Picture("images/canvas.jpg"); 
        Picture original = new Picture("images/succulent.jpg"); 
        Picture IWannaBeYours = new Picture("images/IWannaBeYours.jpg");
        
        // mirror version
        Picture mirrored = new Picture(original);
        mirrorVertical(mirrored);
        
        // hue-shift (teal) version
        Picture tealVersion = new Picture(original);
        hueShiftTeal(tealVersion);
        
        // gray scale version 
        Picture grayScale = new Picture(original);
        GrayScale(grayScale); 
        
        // put on Canvas
        copyToCanvas(tealVersion, acanvas, 2560, 0); // top right area original
        copyToCanvas(original, acanvas, 0, 0); //top left area
        copyToCanvas(mirrored, acanvas, 2560, 1440); // middle right area
        copyToCanvas(grayScale, acanvas, 0, 1440); // middle right area
        
        // display
        acanvas.explore();
    }

    
//GRAY SCALE
    public static void GrayScale(Picture source)
        {
         Pixel pixel = null;
         for (int x = 0; x < source.getWidth(); x++)
            {
                for (int y = 0; y < source.getHeight(); y++)
                {
                    pixel = source.getPixel(x, y);
                    int red = pixel.getRed();
                    int green = pixel.getGreen();
                    int blue = pixel.getBlue();
                    
                    int avg = (red + green + blue) / 3;
                    Color Gray = new Color (avg, avg, avg);
                    pixel.setColor(Gray);
                }
            }
        }
                  
                
//CHANGE COLORS
    public static void hueShiftTeal(Picture source)
    {
        Pixel pixel = null;
    
        for (int x = 0; x < source.getWidth(); x++)
        {
            for (int y = 0; y < source.getHeight(); y++)
            {
                pixel = source.getPixel(x, y);
    
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
    
                // brightness average
                int avg = (red + green + blue) / 3;
    
                int newRed = avg / 4;                   //red
                int newGreen = Math.min(255, avg + 50); //green
                int newBlue = avg / 2;                  //blue
    
                pixel.setRed(newRed);
                pixel.setGreen(newGreen);
                pixel.setBlue(newBlue);
            }
        }
    }


//MIRRORS THE IMAGE 
    /**
     * Method to mirror a vertical line in the middle of the picture based on the width 
     */
        public static void mirrorVertical(Picture source)
        {
            int width = source.getWidth();
            int mirrorPoint = width/2;
            Pixel leftPixel = null;
            Pixel rightPixel = null;
            
            //loop through all of the rows
            for (int y = 0; y < source.getHeight(); y++)
            {
                //loop from 0 to the middle (mirror Point)
                for (int x = 0; x < mirrorPoint; x++)
                {
                    leftPixel = source.getPixel(x, y);
                    rightPixel = source.getPixel(width - 1 - x, y);
                    rightPixel.setColor(leftPixel.getColor());
                    
                }
            }
        } //mirrorVertical 


//COPY TO CANVAS
    public static void copyToCanvas(Picture source, Picture target, int startX, int startY)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
    
        for (int sourceX = 0; sourceX < source.getWidth(); sourceX++)
        {
            for (int sourceY = 0; sourceY < source.getHeight(); sourceY++)
            {
                // make sure we don’t go off the canvas
                if (startX + sourceX < target.getWidth() && startY + sourceY < target.getHeight())
                {
                    sourcePix = source.getPixel(sourceX, sourceY);
                    targetPix = target.getPixel(startX + sourceX, startY + sourceY);
                    targetPix.setColor(sourcePix.getColor());
                }
            }
        }
    }
} //class