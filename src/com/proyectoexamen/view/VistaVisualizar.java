package com.proyectoexamen.view;

import com.proyectoexamen.controller.ControllerConsulta;
import com.proyectoexamen.model.Inmueble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaVisualizar extends JFrame implements ActionListener {
    private JButton returning;
    private JLabel show1,show2,show3,show4,show5,show6,show7;
    private int clave;

    public VistaVisualizar(int clave) {
        this.clave = clave;
        init();
        initComponents();
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    private void init() {
        super.setTitle("Status del inmueble");
        //super.setSize(500,500);
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
        super.setResizable(true);
    }

    private void initComponents(){
        super.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        returning = new JButton("Volver");
        returning.addActionListener(this);
        returning.setSize(500,500);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weighty = 1.00;
        gridBagConstraints.weightx = 1.00;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        //String showSomething = ControllerConsulta.Consulta(clave);
        //show = new JLabel(showSomething);

        Inmueble inmueble = ControllerConsulta.Consulta(clave,true);
        show1 = new JLabel(inmueble.getClave());
        show2 = new JLabel(inmueble.getDir());
        show3 = new JLabel(String.valueOf(inmueble.getTamArea()));
        show4 = new JLabel(String.valueOf(inmueble.getValor()));
        show5 = new JLabel(String.valueOf(inmueble.getNumBaños()));
        show6 = new JLabel(String.valueOf(inmueble.getNumCuartos()));
        show7 = new JLabel(inmueble.getStatus());

        super.add(show1,gridBagConstraints);//Parrafos

        gridBagConstraints.gridy = 4;
        super.add(show2,gridBagConstraints);

        gridBagConstraints.gridy = 6;
        super.add(show3,gridBagConstraints);

        gridBagConstraints.gridy = 8;
        super.add(show4,gridBagConstraints);

        gridBagConstraints.gridy = 10;
        super.add(show5,gridBagConstraints);

        gridBagConstraints.gridy = 12;
        super.add(show6,gridBagConstraints);

        gridBagConstraints.gridy = 14;
        super.add(show7,gridBagConstraints);//Parrafos


        //gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        //gridBagConstraints.gridwidth = 1;
        //gridBagConstraints.gridheight = 1;
        //gridBagConstraints.weighty = 1.00;
        //gridBagConstraints.weightx = 1.00;
        //gridBagConstraints.fill = GridBagConstraints.BOTH;

        super.add(returning,gridBagConstraints);//Boton

        super.pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==returning) {
            setVisible(false); //you can't see me!
            dispose(); //Destroy the JFrame object
        }
    }
}
