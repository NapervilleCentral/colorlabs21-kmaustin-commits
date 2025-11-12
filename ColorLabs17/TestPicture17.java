/**
 * Kaylie Austin 
 * Test Picture Classes
 * 11/12/2025
 */

import java.awt.*; //the color class is in the awt librairy 
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class TestPicture17
{
  public static void main(String[] args)
  {
      
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
    
      /**/
     //relative path
     //Picture apic = new Picture("images\\beach.jpg");
     //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture moto = new Picture("images/redMotorcycle.jpg");
     //Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
 
        Picture pic1 = new Picture("images/blue-mark.jpg"); 
        Picture pic2 = new Picture("images/blue-mark.jpg"); 
        Picture pic3 = new Picture("images/blue-mark.jpg"); 
        Picture pic4 = new Picture("images/blue-mark.jpg"); 
        Picture pic5 = new Picture("images/blue-mark.jpg"); 
        Picture pic6 = new Picture("images/blue-mark.jpg"); 
        Picture pic7 = new Picture("images/blue-mark.jpg"); 
        //Pixel[] Mpixels = pic1.getPixels();
        Pixel[] pixels; 
        pixels = pic1.getPixels();
        
        pic1.explore();
          
        // ADJUST COLOR 
        for (Pixel spot1 : pixels) {
            int green = spot1.getGreen();
            green = (int)(green * 0.25); // reduce green by 75%
            spot1.setGreen(green);
        }
        pic1.explore();
        
        // NEGATE GREEN 
        for (Pixel spot1 : pixels) {
            int green = spot1.getGreen();
            green = 255 - green;
            spot1.setGreen(green);
        }
        pic1.explore();
        
        // GRAYSCALE FIX 
        for (Pixel spot1 : pixels) {
            int red = spot1.getRed();
            int green = spot1.getGreen();
            int blue = spot1.getBlue();
            
            int avg = (red + green + blue) / 3;
            spot1.setRed(avg);
            spot1.setGreen(avg);
            spot1.setBlue(avg);
        }
        pic1.explore();

        
        // LIGHTEN OR DARKEN 
        for (Pixel spot1 : pixels) {
            // increase brightness by 20%
            int red = Math.min((int)(spot1.getRed() * 1.2), 255);
            int green = Math.min((int)(spot1.getGreen() * 1.2), 255);
            int blue = Math.min((int)(spot1.getBlue() * 1.2), 255);
            
            spot1.setRed(red);
            spot1.setGreen(green);
            spot1.setBlue(blue);
        }
        pic1.explore();

        
        // CHANGE COLOR /////////////////////////////FIXXXXXXXXXX!!!!!!!!!!!!
        for (Pixel spot1 : pixels) {
            //backgorund is very blue. change the blue background to orange. dont change the color of the person in the middle of the background
            int blue = spot1.getBlue();
            blue = 100 - blue;
            spot1.setBlue(blue);
        }
         pic1.explore();

        // BLUEIFY 
        for (Pixel spot1 : pixels) {
        int blue = (spot1.getBlue() * 5);
        spot1.setBlue(blue);
        }
        pic1.explore();

    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/*     
     

     //apic.explore(); //THIS DISPLAYS THE PICTURE
     ferris1.explore();
     //moto.explore();
     
     
     //to change color of pic get all of the pizels!!!!!!
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();

     Mpixels= moto.getPixels();

     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


  
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433, 283);
    Pixel ferr17 = pixels[17];
    
    ferr17.setRed(240);
    ferr17.setGreen(160);
    ferr17.setBlue(200);
    
    Color newColor = new Color(255, 99, 71);
    spot2.setColor(Color.blue);
    
    spot.setColor(newColor);
    
    
    ferris1.explore();
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    
    
    for(int i = 0; i<10000; i++)
    {
        Pixel yuck = ferris1.getPixel((int)(Math.random()*600), (int)(Math.random()*+600));
        yuck.setColor(Color.green);
    }
    ferris1.explore();
    
    
    
    
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();

   // loop to access indexes of array or collection

    //for each loop spot  is a ?
  
    
    
    
    
    int red;
    for (Pixel spot1 : Mpixels)
    {
        //System.out.println( spot );
        red = spot1.getRed();
        red = (int)(red * .25);
        spot1.setRed(red);
    }
    moto.explore();
    
    int blue;
    for (Pixel spot1  : Mpixels)
    {
        blue = spot1.getBlue();
        blue = (int)(blue * (Math.random()));
        spot1.setBlue(blue);
        
        green = spot1.getGreen();
        green = (int)(green * (Math.random()));
        spot1.setGreen(green);
    }
    moto.explore();
    
    
    

   

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
   // ferris1.write("images/ferris11.jpg");

    /**/


