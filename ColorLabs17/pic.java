
/**
 * Poster Project
 * Kaylie Austin 
 * May 5th, 2026
 **/ 
 
public class pic
{
    public static void main(String[] args)
    {
         Picture acanvas = new Picture("images/canvas.jpg"); 
         Picture asucculent = new Picture("images/succulent.jpg"); 
         
         mirrorVertical(asucculent); 
         
         asucculent.explore();
         copytoCanvas(asucculent, acanvas);
         acanvas.explore();
         
         //-------------------------------------------------------------------------------------//
         
         Picture temple = new Picture("images/temple.jpg");
         temple.explore();
         
         //reflect the left part of the temples roof from the top point to the center, 
         //over to the right side but don't reflect the whole picture, only the top of the roof
         
         //center point of temple is (276,28)
         //left starting point of the temple is (15, 86)
         //right ending point of the temple is (538, 86)
         
    /**
     * Method to mirror a vertical line in the middle of the picture based on the width 
     */
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        // loop through all of the rows
        for (int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle (mirror Point)
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
                
            }
        }
    } //mirrorVertical 
    
         
        /**     
         
    }//main
    
    /**
     * Method to mirror a vertical line in the middle of the picture based on the width 
     */
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        // loop through all of the rows
        for (int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle (mirror Point)
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
                
            }
        }
    } //mirrorVertical 
    
    /**
     * Copy one picture to another pic/canvas
     * Add two ints to the paramaters to place you want picture on the target
     */
    
    public static void copytoCanvas(Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        //loop through jcollums (targetX is the starting point on Canvas)
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            for (int sourceY = 0, targetY = 0; sourceY < source.getWidth(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }
    
} //class