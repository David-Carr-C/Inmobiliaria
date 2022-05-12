package com.proyectoexamen.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaVendedor extends JFrame implements ActionListener {
    //Declaración de componentes
    private JPanel pBotones, pPersonal, pVendedor, pOpcionP, pOpcionV, pPrincipal; //Secciones
    private JLabel lbTipo, lbClave, lbTamaño, lbCuarto, lbBaño, lbPrecio, lbStatus, lbPreL; //etiquetas
    private JTextField txtTipo, txtClave, txtTamaño, txtCuartos, txtBaños, txtPrecio, txtStatus, txtPreL; //campos de texto
    private JRadioButton[] opciones; //4 radio buttons
    private ButtonGroup grupo; //Un grupo de botones
    private JLabel foto;
    private JButton altasButton, bajasButton, modifButton, visButton;
    private JTextField elegir;
    private JButton comprar;

    public VistaVendedor(){
        super("EMPRESA DE MUEBLES");//Titulo

        initComponentes();
        add(pBotones, BorderLayout.EAST);
        add(pPersonal, BorderLayout.CENTER);
        add(pOpcionP, BorderLayout.SOUTH);
        setSize(620, 450);
        setLocationRelativeTo(null);//Centrar la app enmedio
        setVisible(true);//Para que se vea, cuando ya todo este inicializado
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    } //constructor

    private void initComponentes(){
        pBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));//Primera seccion
        ImageIcon imageIcon = new ImageIcon("casa.jpg");//Abarca toda la derecha
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(440,350,Image.SCALE_SMOOTH));//Rescalado de la imagen
        foto = new JLabel(imageIcon);//creamos la etiqueta con la imagen                           //hint
        pBotones.add(foto);

        //txtTipo.disable();
        pPersonal = new JPanel(new FlowLayout(FlowLayout.LEFT));//Todo a la izquierda
        lbTipo = new JLabel("Tipo de inmueble: ");
        txtTipo = new JTextField("n/a",10);
        lbClave = new JLabel("Clave de identificacion: ");
        txtClave = new JTextField("n/a",10);
        lbTamaño = new JLabel("Tamaño del area: ");
        txtTamaño = new JTextField("n/a",10);
        lbPrecio = new JLabel("Precio máximo: ");
        txtPrecio = new JTextField("n/a",10);
        lbCuarto = new JLabel("Num. de cuartos: ");
        txtCuartos = new JTextField("n/a",10);
        lbBaño = new JLabel("Num. de baños: ");
        txtBaños = new JTextField("n/a",10);
        lbPreL = new JLabel("Ubicacion: ");
        txtPreL = new JTextField("n/a",10);
        lbStatus = new JLabel("Status: ");
        txtStatus = new JTextField("n/a",10);

        pPersonal.add(lbClave);
        pPersonal.add(txtClave);
        pPersonal.add(lbTipo);
        pPersonal.add(txtTipo);
        pPersonal.add(lbTamaño);
        pPersonal.add(txtTamaño);
        pPersonal.add(lbPrecio);
        pPersonal.add(txtPrecio);
        pPersonal.add(lbCuarto);
        pPersonal.add(txtCuartos);
        pPersonal.add(lbBaño);
        pPersonal.add(txtBaños);
        pPersonal.add(lbPreL);
        pPersonal.add(txtPreL);
        pPersonal.add(lbStatus);
        pPersonal.add(txtStatus);//Se agregaron todos las etiquetas y botones

        pOpcionP = new JPanel ();
        pOpcionP.setLayout(new BoxLayout(pOpcionP, BoxLayout.X_AXIS));//Para posicionar items de forma vertical
        String []metodos = {
                "Altas",
                "Bajas",
                "Modificaciones",
                "Visualizar",
        };
        opciones = new JRadioButton[metodos.length];
        grupo = new ButtonGroup();
        for(int i=0; i<metodos.length; i++)	{
            opciones[i] = new JRadioButton(metodos[i]);
            opciones[i].addActionListener(this);
            grupo.add(opciones[i]);
            pOpcionP.add(opciones[i]);
        }
        //opciones[0].setSelected(true); //se establece la primera opci�n como seleccionada
        pOpcionP.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pOpcionP.setBorder(BorderFactory.createTitledBorder("Selecciona un metodo"));

        altasButton = new JButton("Dar de alta");
        pOpcionP.add(altasButton, 4);
        altasButton.addActionListener(this);
        altasButton.setVisible(false);

        bajasButton = new JButton("Dar de baja");
        pOpcionP.add(bajasButton, 4);
        bajasButton.addActionListener(this);
        bajasButton.setVisible(false);

        modifButton = new JButton("Modificar");
        pOpcionP.add(modifButton, 4);
        modifButton.addActionListener(this);
        modifButton.setVisible(false);

        visButton = new JButton("Visualizar");
        pOpcionP.add(visButton, 4);
        visButton.addActionListener(this);
        visButton.setVisible(false);

        elegir = new JTextField("",0);
        pOpcionP.add(elegir);
        elegir.setVisible(false);

        comprar = new JButton("Comprar");
        pOpcionP.add(comprar);
        comprar.addActionListener(this);
        comprar.setVisible(false);

        txtBaños.disable();
        txtCuartos.disable();
        txtTipo.disable();
        txtTamaño.disable();
        txtStatus.disable();
        txtPrecio.disable();
        txtPreL.disable();
        txtClave.disable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == opciones[1] ) { //Bajas
            txtBaños.disable();
            txtBaños.setText("n/a");
            txtCuartos.disable();
            txtCuartos.setText("n/a");
            txtTipo.disable();
            txtTipo.setText("n/a");
            txtTamaño.disable();
            txtTamaño.setText("n/a");
            txtStatus.disable();
            txtStatus.setText("n/a");
            txtPrecio.disable();
            txtPrecio.setText("n/a");
            txtPreL.disable();
            txtPreL.setText("n/a");
            txtClave.enable();
            txtClave.setText("");

            altasButton.setVisible(false);
            bajasButton.setVisible(true);
            modifButton.setVisible(false);
            visButton.setVisible(false);

            comprar.setVisible(false);
            elegir.setVisible(false);
        }

        if (e.getSource() == opciones[0]) { //Altas
            txtBaños.enable();
            txtBaños.setText("");
            txtCuartos.enable();
            txtCuartos.setText("");
            txtTipo.enable();
            txtTipo.setText("");
            txtTamaño.enable();
            txtTamaño.setText("");
            txtStatus.enable();
            txtStatus.setText("");
            txtPrecio.enable();
            txtPrecio.setText("");
            txtPreL.enable();
            txtPreL.setText("");
            txtClave.enable();
            txtClave.setText("");

            altasButton.setVisible(true);
            bajasButton.setVisible(false);
            modifButton.setVisible(false);
            visButton.setVisible(false);

            comprar.setVisible(false);
            elegir.setVisible(false);
        }

        if (e.getSource() == opciones[2]) { //Modif
            txtBaños.enable();
            txtBaños.setText("");
            txtCuartos.enable();
            txtCuartos.setText("");
            txtTipo.enable();
            txtTipo.setText("");
            txtTamaño.enable();
            txtTamaño.setText("");
            txtStatus.enable();
            txtStatus.setText("");
            txtPrecio.enable();
            txtPrecio.setText("");
            txtPreL.enable();
            txtPreL.setText("");
            txtClave.enable();
            txtClave.setText("");

            altasButton.setVisible(false);
            bajasButton.setVisible(false);
            modifButton.setVisible(true);
            visButton.setVisible(false);

            comprar.setVisible(false);
            elegir.setVisible(false);
        }

        if (e.getSource() == opciones[3]) { //Visualizar
            txtBaños.enable();//
            txtBaños.setText("");
            txtCuartos.enable();//
            txtCuartos.setText("");
            txtTipo.disable();
            txtTipo.setText("n/a");
            txtTamaño.disable();
            txtTamaño.setText("n/a");
            txtStatus.disable();
            txtStatus.setText("n/a");
            txtPrecio.enable();//
            txtPrecio.setText("");
            txtPreL.disable();
            txtPreL.setText("n/a");
            txtClave.disable();
            txtClave.setText("n/a");

            altasButton.setVisible(false);
            bajasButton.setVisible(false);
            modifButton.setVisible(false);
            visButton.setVisible(true);

            comprar.setVisible(false);
            elegir.setVisible(false);
        }

        if (e.getSource() == altasButton) {
            //Controller
            JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
        }

        if (e.getSource() == bajasButton) {
            //Controller
            JOptionPane.showMessageDialog(null, "Se ha dado de baja correctamente");
        }

        if (e.getSource() == modifButton) {
            //Controller
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
        }

        if (e.getSource() == visButton) {
            if (true) {//Se comparara si se encontro algun resultado
                int n = 1;
                //Controller
                JOptionPane.showMessageDialog(null, "Opcion "+n+" Visualizamos el contenido");
                JOptionPane.showMessageDialog(null, "Opcion "+n+" Visualizamos el contenido");
                JOptionPane.showMessageDialog(null, "Opcion "+n+" Visualizamos el contenido");
                elegir.setVisible(true);
                comprar.setVisible(true);
            } else {
                elegir.setVisible(false);
                comprar.setVisible(false);
            }

        }

        if (e.getSource() == comprar) {
            JOptionPane.showMessageDialog(null, "Se compro correctamente");
            comprar.setVisible(false);
            elegir.setVisible(false);
        }

    }
}