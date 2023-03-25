package com.company;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import java.awt.*;
import java.awt.print.*;

public class Main {
    private double bHeight = 1;
    public Main() {



        bHeight = 1;//Double.valueOf(itemName.size());
        PrinterJob drucker = PrinterJob.getPrinterJob();

        drucker.setPrintable(new Druck(), getPageFormat(drucker));
        try {
            drucker.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    public PageFormat getPageFormat(PrinterJob pj)
    {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight+bodyHeight+footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0,10,width,height - cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }


    protected static double cm_to_pp(double cm)
    {
        return toPPI(cm * 0.393600787);
    }
    protected static double toPPI(double inch)
    {
        return inch * 72d;
    }

    public static void main(String[] args) {
        new Main();
    }
}
// write your code here
        /*PrintRequestAttributeSet aset;
        PageFormat seitenvormat;
        Book buch=null;
         aset=new HashPrintRequestAttributeSet();

         //aset.add(MediaSizeName.ISO_A4);
         aset.add(new MediaPrintableArea(10,10,5,10 ,MediaPrintableArea.MM));
        // aset.add(OrientationRequested.PORTRAIT);

         boolean ok = drucker.printDialog(aset);
         seitenvormat = drucker.getPageFormat(aset);

         if (aset.containsKey(MediaPrintableArea.class)){

             MediaPrintableArea mpa = (MediaPrintableArea) aset.get(MediaPrintableArea.class);

             double mpax = (double) (mpa.getX(MediaPrintableArea.INCH)*72);
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

       //
      */
