
/**
 * Write a description of class SheparFaireyLab here.
 * Kaylie Austin 
 * 11/17/2025
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class SheparFaireyLab
{
    public static void main(String[] args)
    {
        Picture selfie = new Picture("images/IMG_6310.jpg");
        Picture selfieM1 = new Picture("images/IMG_6310.jpg");
        Picture selfieM2 = new Picture("images/IMG_6310.jpg");
        Picture selfieM3V1 = new Picture("images/IMG_6310.jpg");
        Picture selfieM3V2 = new Picture("images/IMG_6310.jpg");
        Picture selfieM3V3 = new Picture("images/IMG_6310.jpg");
        Picture selfieM3V4 = new Picture("images/IMG_6310.jpg");
        
        
        Pixel[] pixels;
        
        
        pixels = selfieM1.getPixels();


//Make a list of grayscale values
List<Integer> grayValues = new ArrayList<>(); //found on stackoverflow!!
for (Pixel p : pixels) {
    int gray = (int)((p.getRed() + p.getGreen() + p.getBlue()) / 3.0);
    grayValues.add(gray);
}


//Sort
Collections.sort(grayValues);


// Determine cut points
int size = grayValues.size();
int g1 = grayValues.get(size / 4);
int g2 = grayValues.get(size / 2);
int g3 = grayValues.get(3 * size / 4);


//Assign colors based on group
for (Pixel spot : pixels) {
    int gray = (spot.getRed() + spot.getGreen() + spot.getBlue()) / 3;

    Color darkBlue = new Color(0, 51, 102);
    Color red = new Color(204, 0, 0);
    Color lightBlue = new Color(102, 178, 255);
    Color offWhite = new Color(255, 249, 230);


    if (gray < g1) {
        spot.setColor(darkBlue);
    } else if (gray < g2) {
        spot.setColor(red);
    } else if (gray < g3) {
        spot.setColor(lightBlue);
    } else {
        spot.setColor(offWhite);
    }
}


selfieM1.explore();
//selfieM1.write("images/SFMethod1.jpg");








pixels = selfieM2.getPixels();


// Find smallest and biggest grayscale values
int s = 255;
int b = 0;


for (Pixel p : pixels) {
    int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
    if (gray < s) s = gray;
    if (gray > b) b = gray;
}


// Find interval ranges
int interval = (b - s) / 4;


// Color pixels by which interval they fall in
for (Pixel spot : pixels) {


    int gray = (spot.getRed() + spot.getGreen() + spot.getBlue()) / 3;


    Color darkBlue = new Color(0, 51, 102);
    Color red = new Color(204, 0, 0);
    Color lightBlue = new Color(102, 178, 255);
    Color offWhite = new Color(255, 249, 230);


    if (gray < s + interval) {
        spot.setColor(darkBlue);
    } else if (gray < s + 2 * interval) {
        spot.setColor(red);
    } else if (gray < s + 3 * interval) {
        spot.setColor(lightBlue);
    } else {
        spot.setColor(offWhite);
    }
}

selfieM2.explore();
//selfieM2.write("images/SFMethod2.jpg");






// METHOD 3 – 5-Color Palette (your full color set)------------------------------------------
pixels = selfieM3V1.getPixels();


//Build grayscale list
List<Integer> grayVals = new ArrayList<>();
for (Pixel p : pixels) {
    int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
    grayVals.add(gray);
}


//Sort
Collections.sort(grayVals);

//5 sections (20%, 40%, 60%, 80%)
size = grayVals.size();
int cut1 = grayVals.get(size / 6);       
int cut2 = grayVals.get(2 * size / 6);    
int cut3 = grayVals.get(3 * size / 6);
int cut4 = grayVals.get(4 * size / 6);
int cut5 = grayVals.get(5 * size / 6);


//Colors
Color c1 = new Color(208, 0, 117);        // D00075
Color c11 = new Color(246, 218, 233);     // F6DAE9
Color c2 = new Color(238, 76, 167);       // EE4CA7
Color c3 = new Color(255, 150, 209);      // FF96D1
Color c4 = new Color(255, 241, 243);      // FFFBFD
Color c5 = new Color(255, 249, 249);      // White


//Color each pixel based on 5 groups
for (Pixel spot : pixels) {
    int gray = (spot.getRed() + spot.getGreen() + spot.getBlue()) / 3;

    if (gray < cut1) {
        spot.setColor(c1);
    } else if (gray < cut2) {
        spot.setColor(c2);
    } else if (gray < cut3) {
        spot.setColor(c3);
    } else if (gray < cut4) {
        spot.setColor(c4);
    } else if (gray < cut5) {
        spot.setColor(c11);
    } else {
        spot.setColor(c5);
    }
}

selfieM3V1.explore();
//selfieM3V1.write("images/SFtry4_5colors.jpg");
//PRINT THIS VERSION^^^
         
    }     
}
