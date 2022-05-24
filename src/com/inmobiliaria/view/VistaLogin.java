package com.inmobiliaria.view;

import com.inmobiliaria.model.ArchivoDB;

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
 * Ventana principal de la aplicacion
 */
public class VistaLogin extends JFrame implements ActionListener {
    private JPanel pBienvenida, pRes, pOpciones;
    private JLabel lbAcceso, lbAcceso2, et, lbAcceso3, lbAcceso4, lblContraseña, lblcot1, lblcot2;
    private JTextField txtAcceso, txtcot1, txtcot2, txtRes;
    private JComboBox cmbTipos;
    private JButton btVendedor, btPersonal, btAlta, btBaja, btModi, btVisualizar, btVisualizar2, btCotizar, btVender, btApartar, btTerminar, btContraseña, btcod;
    private final String[] TIPO = {"SELECCIONE UNA OPCION", "Ej.1", "Ej.2", "Ej.3", "Ej.4", "Ej.5", "Ej.6", "Ej.7", "Ej.8", "Ej.9", "Ej.10",};
    private ButtonGroup grupo;
    private ArchivoDB miarchivo;

    public VistaLogin() { //Constructor del objeto 'ventana principal'
        super("ACCESO"); //Se invoca al constructor JFrame al pasarle el titulo como argumento

        initComponentes(); //Se inician los componentes

        this.add(pBienvenida, BorderLayout.NORTH); //Cada panel es ordenado bajo el Layout por defecto 'BorderLayout'
        this.add(pRes, BorderLayout.CENTER); //Norte, centro y sur
        this.add(pOpciones, BorderLayout.SOUTH);

        super.setSize(450, 465); //Se selecciona el tamaño de la ventana
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Se le da el atributo de poder finalizar el programa cuando se sale de la ventana
        super.setLocationRelativeTo(null); //Se centra la ventana al eliminar la locacion relativa a algo
        super.setVisible(true); //Se pone visible la ventana
    }

    private void initComponentes() { //Instanciamos paneles y componentes
        pBienvenida = new JPanel(new FlowLayout(FlowLayout.CENTER));//Se intancia un JPanel con FlowLayout centrando los items
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

        pOpciones.add(lblContraseña); //Se agregan los item al Panel
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

        btcod.addActionListener(this); //Todos los botones se les agrega un Action Listener para ir al metodo de 'este' Objeto
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

        btcod.setVisible(false); //Se les cambia el atributo de visible por false
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
        cmbTipos = new JComboBox(TIPO); //Se instancia el JComboBox
        pOpciones.add(cmbTipos);
        cmbTipos.addActionListener(this); //Y se añade con Action Listener
        cmbTipos.setVisible(false);
    }


    /**
     * Se declara un metodo el cual actuara como listener para aquel item que sea presionado o modificado por el usuario
     * en la Ventana/Objeto/Panel
     * */
    @Override
    public void actionPerformed(ActionEvent e) {

        int contra = 12345;
        int ingresado = 0, tipo, m, n;

        if (e.getSource() == btPersonal) { //Boton de Personal
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


            this.setLocationRelativeTo(null);
        }

        if (e.getSource() == btContraseña) { //Boton de Personal, Contraseña
            ingresado = Integer.parseInt(txtAcceso.getText());//Activa el menu de inmuebles desde Personal
            if (ingresado == contra) {
                VistaPersonal vistaPersonal = new VistaPersonal();
                this.dispose(); //Crea una nueva ventana de Personal y destruye la actual

            } else {
                JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA", "Error datos de entrada", JOptionPane.ERROR_MESSAGE);
                txtAcceso.setText("");
            }
        }

        if (e.getSource() == btVendedor) { //Al pulsar el boton de Vendedor se loggeara
            VistaVendedor vistaVendedor = new VistaVendedor(); //Activa el menu de inmuebles desde Vendedor
            this.dispose(); //Cierra la ventana
        }
    }
}