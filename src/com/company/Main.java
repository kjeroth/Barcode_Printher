package com.company;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import java.awt.print.*;

public class Main {



    public static void main(String[] args) {
	// write your code here
        PrintRequestAttributeSet aset;
        PageFormat seitenvormat;
        Book buch=null;

        PrinterJob drucker = PrinterJob.getPrinterJob();
         aset=new HashPrintRequestAttributeSet();

         //aset.add(MediaSizeName.ISO_A4);
         aset.add(new MediaPrintableArea(30,20,5,10 ,MediaPrintableArea.MM));
        // aset.add(OrientationRequested.PORTRAIT);

         boolean ok = drucker.printDialog(aset);
         seitenvormat = drucker.getPageFormat(aset);

         if (aset.containsKey(MediaPrintableArea.class)){

             MediaPrintableArea mpa = (MediaPrintableArea) aset.get(MediaPrintableArea.class);

             double mpax = (double) (mpa.getX(MediaPrintableArea.INCH) * 72);
             double mpay = (double) (mpa.getY(MediaPrintableArea.INCH) * 72);
             double mpawidth = (double) (mpa.getWidth(MediaPrintableArea.INCH) * 72);
             double mpaheight = (double) (mpa.getHeight(MediaPrintableArea.INCH) * 72);

             Paper papier = seitenvormat.getPaper();

             papier.setImageableArea(mpax, mpay, mpawidth, mpaheight);

             seitenvormat.setPaper(papier);
         }
        buch =new Book();
         buch.append(new Druck(),seitenvormat);
         drucker.setPageable(buch);

        MediaPrintableArea mpa = (MediaPrintableArea)aset.get(MediaPrintableArea.class);

        System.out.println(mpa);

        System.out.println("breite"+  seitenvormat.getWidth());
        System.out.println("höhe"+    seitenvormat.getHeight());

        System.out.println("bild x"+    seitenvormat.getImageableX());
        System.out.println("bil y"+      seitenvormat.getImageableY());
        System.out.println("bild breite"+seitenvormat.getImageableWidth());
        System.out.println("bild höhe"+  seitenvormat.getImageableHeight());

       // drucker.setPrintable(new Druck());


        try {

            drucker.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }


    }


    }

