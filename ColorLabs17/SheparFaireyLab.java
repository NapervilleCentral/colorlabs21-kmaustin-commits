
/**
 * Write a description of class SheparFaireyLab here.
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    public static void main(String[] args)
    {
        Picture selfie = new Picture("images/IMG_63010.jpg");
        Picture selfieM1 = new Picture("images/IMG_63010.jpg");
        Picture selfieM2 = new Picture("images/IMG_63010.jpg");
        Picture selfieM3V1 = new Picture("images/IMG_63010.jpg");
        Picture selfieM3V2 = new Picture("images/IMG_63010.jpg");
        Picture selfieM3V3 = new Picture("images/IMG_63010.jpg");
        Picture selfieM3V4 = new Picture("images/IMG_63010.jpg");
        
        
        Pixel[] pixels; 
        pixels = selfie.getPixels();
        selfie.explore();
        
        
        
        pixels = selfieM1.getPixels();        
        /*
        METHOD 1
        Method one – a balanced approach.  This method uses all four colors in equal amounts. 
        This is easily done by dividing the sorted list of pixels values into four equally sized groups. 
        The pixels in group 1,2,3 and 4 are colored dark blue, red, light blue and off-white respectively.
         */

        for (Pixel spot1 : pixels) {
            int green = spot1.getGreen();
            green = (int)(green * 0.25); // reduce green by 75%
            spot1.setGreen(green);
        
            
            int darkBlue = 
            int red = spot1.getRed();
            int lightBlue = 
            int offWhite = 
        }
        selfieM1.explore();
        //selfie.write("images/MethodOneSelfie")
        
        
        
        
        
        pixels = selfieM2.getPixels();
        /*
        METHOD 2
        Method two- an intense approach.  This method colors by intensity and generally
        won't use the colors in equal amounts. After the sorting, find the smallest and 
        largest grayscale values in the image and call them s (small) and b (big).  Then, 
        divide the interval between s and b into 4 equally spaced subintervals. Therefore, 
        every pixel in the image has a value greater or equal to s and less than (b-s)/4 is
        in group 1. Note , we don't know how may pixels this will be.  The other groups are
        formed in a similar way.  Then, as before, the pixels in group 1,2,3 and 4 are colored 
        dark blue, red, light blue and off-white, respectively.Take your picture and run it
        thru both of your methods to see the result.
         */

        for (Pixel spot1 : pixels) {
           
        
        }
        selfieM2.explore();
        //selfie.write("images/MethodTwoSelfie")
        
       
        
        
        
        
        
        /* 
        METHOD 3
        Method three – a different set of colors. We all want to put our best foot forward. 
        We refine our work several times until it looks the way we want.Rarly is the first try our best work.
        Choose your own color palette and convert your picture. 
1)	Save you first attempt as SFtry1.pictureformat, ask for inputs and maybe your own thoughts in the ReadMe doc.
2)	Edit algorithm and display again- save as SFtry2.format get some more input/and your own thoughts
3)	Edit algorithm and display again- save as SFtry3.format get some more input/and your own thoughts
4)	Edit algorithm and display again save as SFmyFinal.format – I hope you are proud of your work

This link may help you choose a different 4-color pallet.
http://paletton.com/#uid=71T1p0kllll1FEsbvsfvberW17x

       COLORS:
       base color = FF96D1
       FFFFFF
       FFFBFD
       EE4CA7
       D00075

Turn in Repo  (FirstLastPictureLab) with: several pictures and source code.
After you change your picture can you extend & add or just add a word to the bottom (using Paint makes this easy)
You must  .write("path.jpg")  to save your picture.

        */
        
        
        

       
       
       
       
       
        
         
    }//main       
}//class
