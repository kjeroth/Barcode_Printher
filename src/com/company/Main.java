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
        paper.setImageableArea(1,10,width,height - cm_to_pp(1));

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
        new MyFrame();
    }
}
