package com.inmobiliaria.view;

import com.inmobiliaria.controller.ControllerPersonal;
import com.inmobiliaria.model.Inmueble;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class VistaPersonal extends JFrame implements ActionListener {
    //Declaración de componentes
    private JPanel pBotones, pPersonal, pVendedor, pOpcionP, pOpcionV, pPrincipal; //Secciones
    private JLabel lbTipo, lbClave, lbTamaño, lbCuarto, lbBaño, lbPrecio, lbStatus, lbUbicacion; //etiquetas
    private JTextField txtTipo, txtClave, txtTamaño, txtCuartos, txtBaños, txtPrecio, txtStatus, txtUbicacion; //campos de texto
    private JRadioButton[] opciones; //4 radio buttons
    private ButtonGroup grupo; //Un grupo de botones
    private JLabel foto;
    private JButton altasButton, bajasButton, modifButton, visButton;
    private JTextField elegir;
    private JButton comprar;

    public VistaPersonal(){
        super("EMPRESA DE INMUEBLES");//Titulo

        initComponentes();
        add(pBotones, BorderLayout.EAST);
        add(pPersonal, BorderLayout.CENTER);
        add(pOpcionP, BorderLayout.SOUTH);
        setSize(620, 450);
        setLocationRelativeTo(null);//Centrar la app enmedio
        setVisible(true);//Para que se vea, cuando ya todo este inicializado
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

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
        lbTamaño = new JLabel("Tamaño del area m²: ");
        txtTamaño = new JTextField("n/a",10);
        lbPrecio = new JLabel("Precio de Lista: ");
        txtPrecio = new JTextField("n/a",10);
        lbCuarto = new JLabel("Num. de cuartos: ");
        txtCuartos = new JTextField("n/a",10);
        lbBaño = new JLabel("Num. de baños: ");
        txtBaños = new JTextField("n/a",10);
        lbUbicacion = new JLabel("Ubicacion: ");
        txtUbicacion = new JTextField("n/a",10);
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
        pPersonal.add(lbUbicacion);
        pPersonal.add(txtUbicacion);
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
        txtUbicacion.disable();
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
            txtUbicacion.disable();
            txtUbicacion.setText("n/a");
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
            txtUbicacion.enable();
            txtUbicacion.setText("");
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
            txtUbicacion.enable();
            txtUbicacion.setText("");
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
            txtUbicacion.disable();
            txtUbicacion.setText("n/a");
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
            String clave = txtClave.getText();
            String tipoMueble = txtTipo.getText();
            String tamanio = txtTamaño.getText();
            String precio = txtPrecio.getText();
            String noCuartos = txtCuartos.getText();
            String noBaños = txtBaños.getText();
            String ubicacion = txtUbicacion.getText();
            String status = txtStatus.getText();
            String descripcionGeneral = JOptionPane.showInputDialog(null, "Descripcion general del inmueble");

            ControllerPersonal.Alta(clave,tipoMueble,tamanio,precio,noCuartos,noBaños,ubicacion,status,descripcionGeneral);

            JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
        }

        if (e.getSource() == bajasButton) {
            String clave = txtClave.getText();

            ControllerPersonal.Baja(clave);

            JOptionPane.showMessageDialog(null, "Se ha dado de baja correctamente");
        }

        if (e.getSource() == modifButton) {
            String clave = txtClave.getText();
            String tipoMueble = txtTipo.getText();
            String tamanio = txtTamaño.getText();
            String precio = txtPrecio.getText();
            String noCuartos = txtCuartos.getText();
            String noBaños = txtBaños.getText();
            String ubicacion = txtUbicacion.getText();
            String status = txtStatus.getText();
            String descripcionGeneral = JOptionPane.showInputDialog(null, "Descripcion general del inmueble");

            ControllerPersonal.Modificar(clave,tipoMueble,tamanio,precio,noCuartos,noBaños,ubicacion,status,descripcionGeneral);

            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
        }

        if (e.getSource() == visButton) {
            String precio = txtPrecio.getText();
            String numCuartos = txtCuartos.getText();
            String numBanios = txtBaños.getText();

            if (!precio.equals("") && !numBanios.equals("") && !numCuartos.equals("")){
                ArrayList<Inmueble> inmueblesArray = ControllerPersonal.Visualizar(precio,numCuartos,numBanios);
                int index = 1;
                if (!inmueblesArray.isEmpty()) {
                    for (Inmueble element:inmueblesArray) {
                        if (element!=null) {
                            JOptionPane.showMessageDialog(null, "Mueble "+index+"° \n"+element);
                            index++;
                        }
                    }
                }
            } else
            if (precio.equals("") && numBanios.equals("")) {
                ArrayList<Inmueble> inmueblesArray = ControllerPersonal.VisualizarCuarto(numCuartos);
                int index = 1;
                if (!inmueblesArray.isEmpty()) {
                    for (Inmueble element:inmueblesArray) {
                        if (element!=null) {
                            JOptionPane.showMessageDialog(null, "Mueble "+index+"° \n"+element);
                            index++;
                        }
                    }
                }
            } else
            if (numBanios.equals("") && numCuartos.equals("")) {
                ArrayList<Inmueble> inmueblesArray = ControllerPersonal.Visualizar(precio);
                int index = 1;
                if (!inmueblesArray.isEmpty()) {
                    for (Inmueble element:inmueblesArray) {
                        if (element!=null) {
                            JOptionPane.showMessageDialog(null, "Mueble "+index+"° \n"+element);
                            index++;
                        }
                    }
                }
            }else
            if (precio.equals("")) {
                ArrayList<Inmueble> inmueblesArray = ControllerPersonal.VisualizarNumero(numCuartos,numBanios);
                int index = 1;
                if (!inmueblesArray.isEmpty()) {
                    for (Inmueble element:inmueblesArray) {
                        if (element!=null) {
                            JOptionPane.showMessageDialog(null, "Mueble "+index+"° \n"+element);
                            index++;
                        }
                    }
                }
            }else
            if (numBanios.equals("")) {
                ArrayList<Inmueble> inmueblesArray = ControllerPersonal.VisualizarPrecioCuarto(precio,numCuartos);
                int index = 1;
                if (!inmueblesArray.isEmpty()) {
                    for (Inmueble element:inmueblesArray) {
                        if (element!=null) {
                            JOptionPane.showMessageDialog(null, "Mueble "+index+"° \n"+element);
                            index++;
                        }
                    }
                }
            }

        }

        if (e.getSource() == comprar) {
            JOptionPane.showMessageDialog(null, "Se compro correctamente");
            comprar.setVisible(false);
            elegir.setVisible(false);
        }

    }
}