package com.company;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Druck implements Printable {
    private Graphics2D g2d;
    private int y = 20;

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // wenn Seiten Index größer als 1 rückgabe das der Druck bendet ist
        // verhindert endloschleife von aufträgen
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;

        }
        g2d = (Graphics2D) graphics;
        // gute Fonts:  "Courier New"  "monospaced" "MS Gothic" "Trebuchet MS" "MS PGothic" "MS PMincho"
        g2d.setFont(new Font("MS Gothic", Font.PLAIN, 10));
        g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
        double width = pageFormat.getImageableWidth();

      //g2d.drawString("Danke, Aroan <3 ",12,20);
       // Test String :  "Hallo welt, Wie geht es dir? Dies ist eine neue Zeile :3 und wir Testen die Kontinuität der einzelnen Wörter  \n yeeeey !!! \n A23456789 B23456789 C23456789 D234567890   "
       String textZumDrucken = "Bitte sehr Dies ist jetzt die Gewählte Schriftart für alle Ausdrucke      " ;
       writeLinesToGraphic(textZumDrucken);

        return PAGE_EXISTS;
    }
    public void writeLinesToGraphic (String s) {
        int lengthOfLine = 40; //Hier kann eingestellt werden, wie viele Zeichen pro Zeile erlaubt sind.


        while(s.length()>0) {
            //Guard-clause
            if(s.length()<lengthOfLine) {
                g2d.drawString(s,12, erhoeheY());
                return;
            }

            String line = "";

            //Schleife sucht Position zum schneiden von s
            int indexLastSpace = -1;
            int i=0;
            while(i<lengthOfLine && s.charAt(i)!='\n') {
                if( s.charAt(i) == ' ') indexLastSpace = i;
                i++;
            }
            i++;
            //finde Ende letztes Wort: //Notiz: Evtl ein Zeichen zu viel pro Zeile :think
            if(indexLastSpace>=0 && s.charAt(i-1) !='\n' && s.charAt(i)!=' ') {
                i=indexLastSpace+1;
            }

            //Schneide Teil aus s aus und füge als Line in g2d
            line = s.substring(0,i);
            s = s.substring(i);

            //print line:
            g2d.drawString(line,12, erhoeheY());
        }
        //2 Leere Zeilen am Ende:
        g2d.drawString(" ",12,erhoeheY());
        g2d.drawString(" ",12,erhoeheY());
    }
    private int erhoeheY () {
        y=y+15;
        return y;
    }
}
