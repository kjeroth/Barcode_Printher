package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener {
    JButton buttton;

    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setLayout(new FlowLayout());

         buttton = new JButton("Floppy  Auslesen");
         buttton.addActionListener(this);

         this.add(buttton);
         this.pack();
         this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==buttton){

            JFileChooser fileChooser =new JFileChooser();

            fileChooser.setCurrentDirectory(new File("A:\\"));
            int response =fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file =new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }

        }

    }
}
