import java.awt.Color;

/**
 * Poster Project
 * Kaylie Austin 
 * May 7th, 2026
 **/ 
 
// The collage must be saved as an image file
// ex. picture.write(FileChooser.getMediaPath(fileName));
// ex. picture.write(“thisfolder.finalcollege.jpg”);

//Oringal         Hue Shift
//Grayscale       Vertical & Horizontal mirroring
//Recurision      Blend

//center the second image in blend to the center of the orginal image
//for my recursive method, I want it in the bottom left hand side
//I would like it to recursive into the bottom left hand corner 
//make the the hue shift a bit more green and less bright

public class PosterProject
{
    public static void main(String[] args)
    {
        Picture acanvas = new Picture("images/canvas.jpg");  //2560 x 1440 pixels 
        Picture original = new Picture("images/succulent.jpg"); //5140 x 4320 pixels
        Picture IWannaBeYours = new Picture("images/IWannaBeYours.jpg"); //1320 x 990 pixels
        
        // mirror version
        Picture mirrored = new Picture(original);
        mirrorVertical(mirrored);
        mirrorHorizontal(mirrored);
        
        // hue-shift version
        Picture tealVersion = new Picture(original);
        hueShiftTeal(tealVersion);
        
        // gray scale version 
        Picture grayScale = new Picture(original);
        GrayScale(grayScale); 
        
        // blend version
        Picture blendedPic = blend(original, IWannaBeYours);
        
        // put on Canvas
        copyToCanvas(tealVersion, acanvas, 2560, 0); // top right area original
        copyToCanvas(original, acanvas, 0, 0); //top left area
        copyToCanvas(mirrored, acanvas, 2560, 1440); // middle right area
        copyToCanvas(grayScale, acanvas, 0, 1440); // middle right area
        copyToCanvas(blendedPic, acanvas, 2560, 2880); //bottom right area
        //copyToCanvas(recursion, acanvas, 0, 2880); //bottom left area
        
        // display
        acanvas.explore();
    }

  
// // RECURSION
// public static Picture recursion(Picture source)
// {
    // Pixel sourcePix = null;
    // Pixel targetPix = null;
    
    // int width = source.getWidth();
    // int height = source.getHeight();
    // Pixel leftPixel = null;
    // Pixel rightPixel = null;
        // for (int sourceX = 0; sourceX < source.getWidth(); sourceX++)
        // {
            // for (int sourceY = 0; sourceY < source.getHeight(); sourceY++)
            // {

            // }
        // }
// }
    


//BLEND TWO IMAGES
    public static Picture blend(Picture pic1, Picture pic2)
    {
        // copy of the first picture
        Picture blended = new Picture(pic1);
        
        //center the second image to the center of my orginal one
    
        Pixel pixel1 = null;
        Pixel pixel2 = null;
        Pixel blendedPixel = null;
    
        int width = Math.min(pic1.getWidth(), pic2.getWidth());
        int height = Math.min(pic1.getHeight(), pic2.getHeight());
    
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                pixel1 = pic1.getPixel(x, y);
                pixel2 = pic2.getPixel(x, y);
                blendedPixel = blended.getPixel(x, y);
    
                // average each color channel
                int red = (pixel1.getRed() + pixel2.getRed()) / 2;
                int green = (pixel1.getGreen() + pixel2.getGreen()) / 2;
                int blue = (pixel1.getBlue() + pixel2.getBlue()) / 2;
    
                blendedPixel.setColor(new Color(red, green, blue));
            }
        }
        return blended;
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
        
    public static void mirrorHorizontal(Picture source)
    {
        int height = source.getHeight();
        int mirrorPoint = height / 2;
    
        Pixel topPixel = null;
        Pixel bottomPixel = null;
    
        // loop through top half
        for (int y = 0; y < mirrorPoint; y++)
        {
            // loop through all columns
            for (int x = 0; x < source.getWidth(); x++)
            {
                topPixel = source.getPixel(x, y);
    
                // opposite pixel on bottom
                bottomPixel = source.getPixel(x, height - 1 - y);
    
                // copy color
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    } //mirrorHorizontal


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