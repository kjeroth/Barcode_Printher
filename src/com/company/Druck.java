package com.company;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Druck implements Printable {
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // wenn Seiten Index größer als 1 rückgabe das der Druck bendet ist
        // verhindert endloschleife von aufträgen
        if(pageIndex >0){
            return NO_SUCH_PAGE;

        }
        Graphics2D g2d =(Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableWidth(), pageFormat.getImageableY());
         double width = pageFormat.getImageableWidth();


        g2d.drawString("hallo welt, Wie geht?s dir?",30,20);


        return PAGE_EXISTS;
    }
}
