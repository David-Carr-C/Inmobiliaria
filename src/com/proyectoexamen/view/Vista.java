/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoexamen.view;

import com.proyectoexamen.model.ArchivoDB;
import com.proyectoexamen.model.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author lapto
 */
public class Vista extends JFrame implements ActionListener {
    private JPanel pBienvenida, pRes, pOpciones;
    private JLabel lbAcceso, lbAcceso2, et, lbAcceso3, lbAcceso4, lblContraseña, lblcot1, lblcot2;
    private JTextField txtAcceso, txtcot1, txtcot2, txtRes;
    JComboBox cmbTipos;
    private JButton btVendedor, btPersonal, btAlta, btBaja, btModi, btVisualizar, btVisualizar2, btCotizar, btVender, btApartar, btTerminar, btContraseña, btcod;
    private final String[] TIPO = {"SELECCIONE UNA OPCION", "Ej.1", "Ej.2", "Ej.3", "Ej.4", "Ej.5", "Ej.6", "Ej.7", "Ej.8", "Ej.9", "Ej.10",};
    private ButtonGroup grupo;
    ArchivoDB miarchivo;

    public Vista() {
        super("ACCESO");
        setLocation(500, 200);

        initComponentes();

        add(pBienvenida, BorderLayout.NORTH);
        add(pRes, BorderLayout.CENTER);
        add(pOpciones, BorderLayout.SOUTH);
        setSize(450, 465);


    } //constructor

    private void initComponentes() {
        //instanciamos paneles y componentes
        pBienvenida = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lbAcceso = new JLabel(" BIENVENIDOS A LA INMOBILIARIA ");
        lbAcceso2 = new JLabel(" BIENVENIDO VENDEDOR ");
        lbAcceso3 = new JLabel(" BIENVENIDO PERSONAL ");
        lbAcceso4 = new JLabel(" INGRESE LA CONTRASEÑA PARA CONTINUAR ");
        txtcot1 = new JTextField("", 10);
        lblContraseña = new JLabel(" CONTRASEÑA  ");
        txtcot2 = new JTextField("", 10);
        lblcot1 = new JLabel("SUELDO");
        lblcot2 = new JLabel(" PRECIO  ");


        txtcot1.setVisible(false);
        lblcot1.setVisible(false);
        txtcot2.setVisible(false);
        lblcot2.setVisible(false);
        lbAcceso4.setVisible(false);
        lbAcceso2.setVisible(false);
        lbAcceso3.setVisible(false);
        //agregamos a su panel
        pBienvenida.add(lblcot1);

        pBienvenida.add(txtcot1);
        pBienvenida.add(lblcot2);
        pBienvenida.add(txtcot2);
        pBienvenida.add(lbAcceso4);
        pBienvenida.add(lbAcceso);
        pBienvenida.add(lbAcceso2);
        pBienvenida.add(lbAcceso3);


        //panel de resulatdo

        pRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBienvenida.setBackground(Color.LIGHT_GRAY);
        pRes.setBackground(Color.LIGHT_GRAY);

        JLabel et = new JLabel(new ImageIcon("inmobi.jpg"));
        pRes.add(et);
        et.setVisible(true);


        //panel de opciones
        pOpciones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        pRes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pOpciones.setBackground(Color.GRAY);
        btVendedor = new JButton("VENDEDOR");
        btcod = new JButton("CONTINUAR");
        btPersonal = new JButton("PERSONAL");
        btAlta = new JButton("ALTA");
        btBaja = new JButton("BAJA");
        btModi = new JButton("MODIFICAR");
        btVisualizar = new JButton("VISUALIZAR");
        lblContraseña = new JLabel(" CONTRASEÑA  ");
        btVisualizar2 = new JButton("VISUALIZAR");
        btCotizar = new JButton("COTIZAR");
        btVender = new JButton("VENDER");
        btApartar = new JButton("APARTAR");
        btTerminar = new JButton("TERMINAR");
        btContraseña = new JButton("CONTINUAR");
        txtAcceso = new JTextField("", 10);
        txtRes = new JTextField("", 10);

        pOpciones.add(lblContraseña);
        pOpciones.add(txtAcceso);
        pOpciones.add(txtRes);
        pOpciones.add(btAlta);
        pOpciones.add(btBaja);
        pOpciones.add(btModi);
        pOpciones.add(btcod);
        pOpciones.add(btVisualizar);
        pOpciones.add(btPersonal);
        pOpciones.add(btVendedor);
        pOpciones.add(btVisualizar2);
        pOpciones.add(btCotizar);
        pOpciones.add(btVender);
        pOpciones.add(btApartar);
        pOpciones.add(btTerminar);
        pOpciones.add(btContraseña);

        btcod.addActionListener(this);
        btVisualizar2.addActionListener(this);
        btCotizar.addActionListener(this);
        btVender.addActionListener(this);
        btApartar.addActionListener(this);
        btTerminar.addActionListener(this);
        btVendedor.addActionListener(this);
        btPersonal.addActionListener(this);
        btAlta.addActionListener(this);
        btBaja.addActionListener(this);
        btModi.addActionListener(this);
        btVisualizar.addActionListener(this);
        btContraseña.addActionListener(this);

        btcod.setVisible(false);
        lblContraseña.setVisible(false);
        txtAcceso.setVisible(false);
        btContraseña.setVisible(false);
        btVendedor.setVisible(true);
        btPersonal.setVisible(true);
        btAlta.setVisible(false);
        btBaja.setVisible(false);
        btModi.setVisible(false);
        btVisualizar.setVisible(false);
        btVisualizar2.setVisible(false);
        btCotizar.setVisible(false);
        btVender.setVisible(false);
        btApartar.setVisible(false);
        btTerminar.setVisible(false);
        txtRes.setVisible(false);


        String[] TIPO = {"BUSQUEDA POR: ", "CUARTOS", "UBICACION", "PRECIO"};
        cmbTipos = new JComboBox(TIPO);
        pOpciones.add(cmbTipos);
        cmbTipos.addActionListener(this);
        cmbTipos.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int contra = 12345;
        int ingresado = 0, tipo, m, n;
        if (e.getSource() == btPersonal) { //caso MCD seleccionado
            pRes.setVisible(false);
            setSize(350, 95); //Activa el menu de contraseña
            add(pOpciones, BorderLayout.CENTER);
            btVendedor.setVisible(false);
            lbAcceso4.setVisible(true);
            btPersonal.setVisible(false);
            lbAcceso.setVisible(false);
            lblContraseña.setVisible(true);
            txtAcceso.setVisible(true);
            btContraseña.setVisible(true);
        }

        if (e.getSource() == btContraseña) { //caso MCD seleccionado
            ingresado = Integer.parseInt(txtAcceso.getText());//Activa el menu de inmuebles desde Personal
            if (ingresado == contra) {
                VistaPersonal vistaPersonal = new VistaPersonal();
                this.dispose();
                //System.out.println("hola como estas");

            } else {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA", "Error datos de entrada", JOptionPane.ERROR_MESSAGE);
                txtAcceso.setText("");
            }
        }

        if (e.getSource() == btVendedor) {
            VistaVendedor vistaVendedor = new VistaVendedor();//Activa el menu de inmuebles desde Vendedor
            this.dispose();
        }

        if (e.getSource() == btVisualizar2) {
            pRes.setVisible(false);
            setSize(350, 140);
            add(pOpciones, BorderLayout.CENTER);
            btVendedor.setVisible(false);
            cmbTipos.setVisible(true);
            btCotizar.setVisible(false);
            btVender.setVisible(false);
            btApartar.setVisible(false);
            btTerminar.setVisible(false);
            tipo = cmbTipos.getSelectedIndex();
            switch (tipo) {
                case 1:
                    int cuartos = Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE CUARTOS REQUERIDA "));

                    break;
                case 2:
                    String Ubicacion = JOptionPane.showInputDialog(" UBICACION DESEADA ");

                    break;
                case 3:
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("PRECIO DESEADO "));
                    break;
            }
        }
        if (e.getSource() == btVisualizar) {
            pRes.setVisible(false);
            setSize(350, 140);
            add(pOpciones, BorderLayout.CENTER);
            btVendedor.setVisible(false);
            cmbTipos.setVisible(true);
            btAlta.setVisible(false);
            btBaja.setVisible(false);
            btModi.setVisible(false);
            btVisualizar.setVisible(true);
            tipo = cmbTipos.getSelectedIndex();
            switch (tipo) {
                case 1:
                    int cuartos = Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE CUARTOS REQUERIDA "));

                    break;
                case 2:
                    String Ubicacion = JOptionPane.showInputDialog(" UBICACION DESEADA ");

                    break;
                case 3:
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("PRECIO DESEADO "));
                    break;
            }
        }
        if (e.getSource() == btCotizar) {

            setSize(390, 140);

            btVender.setVisible(false);
            btApartar.setVisible(false);
            btVisualizar2.setVisible(false);
            btTerminar.setVisible(false);
            btCotizar.setVisible(false);
            btcod.setVisible(true);
            txtcot1.setVisible(true);
            lblcot1.setVisible(true);
            txtcot2.setVisible(true);
            lblcot2.setVisible(true);
            txtRes.setVisible(true);


        }
        if (e.getSource() == btcod) {
            int x = Integer.parseInt(txtcot1.getText());
            int y = Integer.parseInt(txtcot2.getText());
            txtRes.setText(Cliente.CalcularMensualidad(x, y) + "");
        }
        if (e.getSource() == btAlta) {
            String clave = JOptionPane.showInputDialog("CLAVE DE IDENTIFICACION ");
            String Ubicacion = JOptionPane.showInputDialog(" UBICACION ");
            double tamaño = Double.parseDouble(JOptionPane.showInputDialog(" TAMAÑO DEL AREA "));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("PRECIO "));
            int cuartos = Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE CUARTOS "));
            int baños = Integer.parseInt(JOptionPane.showInputDialog(" CANTIDAD DE BAÑOS "));
            String descrip = JOptionPane.showInputDialog(" DESCRIPCION GENERAL ");
            double PreLista = Double.parseDouble(JOptionPane.showInputDialog(" PRECIO DE LISTA "));
            String status = JOptionPane.showInputDialog(" STATUS(APARTADO,VENDIDO,CUOTAS) ");


            //ArchivoDB.Guardar(clave, Ubicacion, tamaño, precio, cuartos, baños, status);


        }

        if (e.getSource() == btBaja) {
            int clave = Integer.parseInt(JOptionPane.showInputDialog("CLAVE DE IDENTIFICACION "));
        }
        if (e.getSource() == btModi) {
            int clave = Integer.parseInt(JOptionPane.showInputDialog("CLAVE DE IDENTIFICACION "));
        }
    }

}
     
