package com.company;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Druck implements Printable {
    Graphics2D g2d;

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // wenn Seiten Index größer als 1 rückgabe das der Druck bendet ist
        // verhindert endloschleife von aufträgen
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;

        }
        g2d = (Graphics2D) graphics;
        g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
        double width = pageFormat.getImageableWidth();

      g2d.drawString("Danke, Aroan <3 ",12,20);

       // writeLinesToGraphic("Hallo welt, Wie geht?s dir?");

        return PAGE_EXISTS;
    }
    public void writeLinesToGraphic (String s) {
        //Mache Schleife > suche Punkt zum Schneiden > Punkt zum Schneiden = nach x Buchstaben oder bei \n
        //Wenn schneide Punkt gefunden. Schneide den Teil aus dem String s aus > speichern und drawString()
        // ...mit der Line
        //g2d.drawString(s //Hier den ausgeschnoitten Teil (Die line), 12, 20);
    }
}
