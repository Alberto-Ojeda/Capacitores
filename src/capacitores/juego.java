/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitores;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Casa
 */
public class juego extends javax.swing.JFrame {
    
     public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public int err2;
    public String res[];
    
    public juego() {
        initComponents();
        setSize(878,700);//cambiar tamaÃ±o de la ventana
        this.setLocationRelativeTo(null);//posicion de la ventana
                         
        Image icon=new ImageIcon(getClass().getResource("/imagenes/hol.png")).getImage();
        setIconImage(icon);
        
        imgs = new ImageIcon[12];
        btns = new JButton[28];
        msgs = new String[20];

        imgs[0] = new ImageIcon(getClass().getResource("/imagenes/portada.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/imagenes/fall.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/imagenes/fall2.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/imagenes/fallto.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/imagenes/fallc.png"));
        imgs[5] = new ImageIcon(getClass().getResource("/imagenes/final1.png"));

        
       imgs[6] = new ImageIcon(getClass().getResource("/imagenes/fallo0.png"));
       imgs[7] = new ImageIcon(getClass().getResource("/imagenes/fallo1.png"));
       imgs[8] = new ImageIcon(getClass().getResource("/imagenes/fallo2.png"));
       imgs[9] = new ImageIcon(getClass().getResource("/imagenes/fallo3.png"));
       imgs[10] = new ImageIcon(getClass().getResource("/imagenes/fallo4.png"));
       imgs[11] = new ImageIcon(getClass().getResource("/imagenes/fallo5.png"));
        //botones para las letras
        btns[1]=button_1;
        btns[2]=button_2;
        btns[3]=button_3;
        btns[4]=button_4;
        btns[5]=button_5;
        btns[6]=button_6;
        btns[7]=button_7;
        btns[8]=button_8;
        btns[9]=button_9;
        btns[10]=button_10;
        btns[11]=button_11;
        btns[12]=button_12;
        btns[13]=button_13;
        btns[14]=button_14;
        btns[15]=button_16;
        btns[16]=button_17;
        btns[17]=button_18;
        btns[18]=button_19;
        btns[19]=button_20;
        btns[20]=button_21;
        btns[21]=button_22;
        btns[22]=button_23;
        btns[23]=button_24;
        btns[24]=button_25;
        btns[25]=button_26;
        btns[26]=button_27;
        btns[27]=button_15;
        
        //palabras por advinar, para agregar una nueva palabra sera necesario declararla al inicio
        msgs[0] = "capacitor".toUpperCase();
        msgs[1] = "electricidad".toUpperCase();
        msgs[2] = "iman".toUpperCase();
        msgs[3] = "serie".toUpperCase();
        msgs[4] = "paralelo".toUpperCase();
        msgs[5] = "permitividad".toUpperCase();
        msgs[6] = "ceramica".toUpperCase();
        msgs[7] = "supercapacitor".toUpperCase();
        msgs[8] = "electrico".toUpperCase();
        msgs[9] = "voltaje".toUpperCase();
        msgs[10] = "resistencia".toUpperCase();
        msgs[11] = "corriente".toUpperCase();
        msgs[12] = "alterna".toUpperCase();
        msgs[13] = "continua".toUpperCase();
        msgs[14] = "conductor".toUpperCase();
        msgs[15] = "polaridad".toUpperCase();
        msgs[16] = "negativo".toUpperCase();
        msgs[17] = "positivo".toUpperCase();
        msgs[18] = "Computacion".toUpperCase();
       msgs[19] = "condensador".toUpperCase();
        
        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 28; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }

        iniciar();
    }

    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        //ERRORES EN 0
        err = 0;
        err2=6;
        Dibujo.setIcon(imgs[0]);
        txtPalabra.setText("");
        errores.setIcon(imgs[6]);//:___________________________________----
        //para activar las letras del tablero
        for (int i = 1; i < 28; i++) {
            btns[i].setEnabled(true);
        }
        //para generar una palabra aleatoriamente xD
        ran = (int) 0 + (int) (Math.random() * ((msgs.length - 1) + 1));
        //SEPARA EL MENSAJE POR PALABRAS
        String pal[] = msgs[ran].split(" ");
        res = new String[msgs[ran].length() + 1];
        int j = 0;
        // seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                txtPalabra.setText(txtPalabra.getText() + "_ ");
                res[j++] = "_";
            }
            txtPalabra.setText(txtPalabra.getText() + "\n");
            res[j++] = " ";
        }
    }
    
    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        Icon cp=new ImageIcon(getClass().getResource("/imagenes/copa.png"));//icono de la copa
        Icon cara=new ImageIcon(getClass().getResource("/imagenes/cara.png"));//icono de la copa
        JButton bt = (JButton) e.getSource();
        char c[];
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 28; i++) {
            if (bt == btns[i]) {
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < msgs[ran].length(); j++) {
                    if (c[0] == msgs[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                    if (esta) {
                    txtPalabra.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            txtPalabra.setText(txtPalabra.getText() + "\n");
                        } else {
                            txtPalabra.setText(txtPalabra.getText() + re + " ");
                        }
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    
                    if (gano) { 
                        JOptionPane.showMessageDialog(this, "FELICITACIONES GANASTES!!","",JOptionPane.INFORMATION_MESSAGE, cp);
                        iniciar();
                        return;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
        
                    Dibujo.setIcon(imgs[++err]);
                    errores.setIcon(imgs[++err2]);

//////////////////////////////////////_----
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 5) {
                        JOptionPane.showMessageDialog(this, "HAS PERDIDO\n la respuesta es: \n" + msgs[ran], "",JOptionPane.INFORMATION_MESSAGE, cara);
     
         

                        iniciar();
                        
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Iniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        help = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtPalabra = new javax.swing.JTextField();
        errores = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Dibujo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        button_2 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_10 = new javax.swing.JButton();
        button_11 = new javax.swing.JButton();
        button_12 = new javax.swing.JButton();
        button_13 = new javax.swing.JButton();
        button_14 = new javax.swing.JButton();
        button_16 = new javax.swing.JButton();
        button_17 = new javax.swing.JButton();
        button_18 = new javax.swing.JButton();
        button_19 = new javax.swing.JButton();
        button_20 = new javax.swing.JButton();
        button_21 = new javax.swing.JButton();
        button_22 = new javax.swing.JButton();
        button_23 = new javax.swing.JButton();
        button_24 = new javax.swing.JButton();
        button_25 = new javax.swing.JButton();
        button_26 = new javax.swing.JButton();
        button_27 = new javax.swing.JButton();
        button_15 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENÚ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Iniciar.setBackground(java.awt.Color.darkGray);
        Iniciar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(1, 7, 70));
        Iniciar.setText("GENERAR PALABRA NUEVA");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        jPanel2.add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 396, -1));

        btnSalir.setBackground(java.awt.Color.darkGray);
        btnSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(1, 7, 70));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 120, 40));

        help.setBackground(java.awt.Color.darkGray);
        help.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        help.setForeground(new java.awt.Color(1, 7, 70));
        help.setText("INSTRUCCIONES");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        jPanel2.add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 40));

        jLabel7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 430, 140));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 430, 140));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPalabra.setEditable(false);
        txtPalabra.setBackground(java.awt.Color.darkGray);
        txtPalabra.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        txtPalabra.setForeground(new java.awt.Color(1, 7, 70));
        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPalabraActionPerformed(evt);
            }
        });
        jPanel3.add(txtPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 368, -1));

        errores.setBackground(java.awt.Color.darkGray);
        errores.setForeground(new java.awt.Color(1, 7, 70));
        jPanel3.add(errores, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 124, 374, 40));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("PALABRA");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("ERRORE");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 95, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images_1.jpeg"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 410, 220));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 163, 410, 220));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAPAXPLO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), java.awt.Color.white)); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dibujo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DibujoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel6.add(Dibujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 31, 400, 320));

        jLabel6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 450, 380));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 420, 360));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TECLADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 18), java.awt.Color.white)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_2.setBackground(java.awt.Color.darkGray);
        button_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_2.setForeground(new java.awt.Color(1, 7, 70));
        button_2.setText("B");
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });
        jPanel7.add(button_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 100, -1));

        button_1.setBackground(java.awt.Color.darkGray);
        button_1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_1.setForeground(new java.awt.Color(1, 7, 70));
        button_1.setText("A");
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });
        jPanel7.add(button_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        button_3.setBackground(java.awt.Color.darkGray);
        button_3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_3.setForeground(new java.awt.Color(1, 7, 70));
        button_3.setText("C");
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });
        jPanel7.add(button_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 100, -1));

        button_4.setBackground(java.awt.Color.darkGray);
        button_4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_4.setForeground(new java.awt.Color(1, 7, 70));
        button_4.setText("D");
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });
        jPanel7.add(button_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 100, -1));

        button_5.setBackground(java.awt.Color.darkGray);
        button_5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_5.setForeground(new java.awt.Color(1, 7, 70));
        button_5.setText("E");
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });
        jPanel7.add(button_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 100, -1));

        button_6.setBackground(java.awt.Color.darkGray);
        button_6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_6.setForeground(new java.awt.Color(1, 7, 70));
        button_6.setText("F");
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });
        jPanel7.add(button_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, -1));

        button_7.setBackground(java.awt.Color.darkGray);
        button_7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_7.setForeground(new java.awt.Color(1, 7, 70));
        button_7.setText("G");
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });
        jPanel7.add(button_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 110, -1));

        button_8.setBackground(java.awt.Color.darkGray);
        button_8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_8.setForeground(new java.awt.Color(1, 7, 70));
        button_8.setText("H");
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });
        jPanel7.add(button_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, -1));

        button_9.setBackground(java.awt.Color.darkGray);
        button_9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_9.setForeground(new java.awt.Color(1, 7, 70));
        button_9.setText("I");
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });
        jPanel7.add(button_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        button_10.setBackground(java.awt.Color.darkGray);
        button_10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_10.setForeground(new java.awt.Color(1, 7, 70));
        button_10.setText("J");
        button_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_10ActionPerformed(evt);
            }
        });
        jPanel7.add(button_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 100, -1));

        button_11.setBackground(java.awt.Color.darkGray);
        button_11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_11.setForeground(new java.awt.Color(1, 7, 70));
        button_11.setText("K");
        button_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_11ActionPerformed(evt);
            }
        });
        jPanel7.add(button_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 100, -1));

        button_12.setBackground(java.awt.Color.darkGray);
        button_12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_12.setForeground(new java.awt.Color(1, 7, 70));
        button_12.setText("L");
        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });
        jPanel7.add(button_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        button_13.setBackground(java.awt.Color.darkGray);
        button_13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_13.setForeground(new java.awt.Color(1, 7, 70));
        button_13.setText("M");
        button_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_13ActionPerformed(evt);
            }
        });
        jPanel7.add(button_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 90, -1));

        button_14.setBackground(java.awt.Color.darkGray);
        button_14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_14.setForeground(new java.awt.Color(1, 7, 70));
        button_14.setText("N");
        button_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_14ActionPerformed(evt);
            }
        });
        jPanel7.add(button_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 110, -1));

        button_16.setBackground(java.awt.Color.darkGray);
        button_16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_16.setForeground(new java.awt.Color(1, 7, 70));
        button_16.setText("O");
        jPanel7.add(button_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 100, -1));

        button_17.setBackground(java.awt.Color.darkGray);
        button_17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_17.setForeground(new java.awt.Color(1, 7, 70));
        button_17.setText("P");
        button_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_17ActionPerformed(evt);
            }
        });
        jPanel7.add(button_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 100, -1));

        button_18.setBackground(java.awt.Color.darkGray);
        button_18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_18.setForeground(new java.awt.Color(1, 7, 70));
        button_18.setText("Q");
        button_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_18ActionPerformed(evt);
            }
        });
        jPanel7.add(button_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 100, -1));

        button_19.setBackground(java.awt.Color.darkGray);
        button_19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_19.setForeground(new java.awt.Color(1, 7, 70));
        button_19.setText("R");
        button_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_19ActionPerformed(evt);
            }
        });
        jPanel7.add(button_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 100, -1));

        button_20.setBackground(java.awt.Color.darkGray);
        button_20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_20.setForeground(new java.awt.Color(1, 7, 70));
        button_20.setText("S");
        button_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_20ActionPerformed(evt);
            }
        });
        jPanel7.add(button_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 90, -1));

        button_21.setBackground(java.awt.Color.darkGray);
        button_21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_21.setForeground(new java.awt.Color(1, 7, 70));
        button_21.setText("T");
        button_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_21ActionPerformed(evt);
            }
        });
        jPanel7.add(button_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 110, -1));

        button_22.setBackground(java.awt.Color.darkGray);
        button_22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_22.setForeground(new java.awt.Color(1, 7, 70));
        button_22.setText("U");
        button_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_22ActionPerformed(evt);
            }
        });
        jPanel7.add(button_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, -1));

        button_23.setBackground(java.awt.Color.darkGray);
        button_23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_23.setForeground(new java.awt.Color(1, 7, 70));
        button_23.setText("V");
        button_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_23ActionPerformed(evt);
            }
        });
        jPanel7.add(button_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 100, -1));

        button_24.setBackground(java.awt.Color.darkGray);
        button_24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_24.setForeground(new java.awt.Color(1, 7, 70));
        button_24.setText("W");
        button_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_24ActionPerformed(evt);
            }
        });
        jPanel7.add(button_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 100, -1));

        button_25.setBackground(java.awt.Color.darkGray);
        button_25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_25.setForeground(new java.awt.Color(1, 7, 70));
        button_25.setText("X");
        button_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_25ActionPerformed(evt);
            }
        });
        jPanel7.add(button_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 100, -1));

        button_26.setBackground(java.awt.Color.darkGray);
        button_26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_26.setForeground(new java.awt.Color(1, 7, 70));
        button_26.setText("Y");
        button_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_26ActionPerformed(evt);
            }
        });
        jPanel7.add(button_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 100, -1));

        button_27.setBackground(java.awt.Color.darkGray);
        button_27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_27.setForeground(new java.awt.Color(1, 7, 70));
        button_27.setText("Z");
        button_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_27ActionPerformed(evt);
            }
        });
        jPanel7.add(button_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 90, -1));

        button_15.setBackground(java.awt.Color.darkGray);
        button_15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button_15.setForeground(new java.awt.Color(1, 7, 70));
        button_15.setText("Ñ");
        button_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_15ActionPerformed(evt);
            }
        });
        jPanel7.add(button_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, -1));
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 220));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 810, 210));

        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 930, 660));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 930, 680);

        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setText("Juego");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setText("Nuevo Juego");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setText("Acerca de ");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_25ActionPerformed
       
        
    }//GEN-LAST:event_button_25ActionPerformed

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_1ActionPerformed
       
        
        
    }//GEN-LAST:event_button_1ActionPerformed

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2ActionPerformed
        
        
    }//GEN-LAST:event_button_2ActionPerformed

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_3ActionPerformed
        
        
    }//GEN-LAST:event_button_3ActionPerformed

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4ActionPerformed
        
        
    }//GEN-LAST:event_button_4ActionPerformed

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5ActionPerformed
       
    }//GEN-LAST:event_button_5ActionPerformed

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_6ActionPerformed
        
    }//GEN-LAST:event_button_6ActionPerformed

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_7ActionPerformed
       
    }//GEN-LAST:event_button_7ActionPerformed

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8ActionPerformed
        
    }//GEN-LAST:event_button_8ActionPerformed

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_9ActionPerformed
        
    }//GEN-LAST:event_button_9ActionPerformed

    private void button_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_10ActionPerformed
        
    }//GEN-LAST:event_button_10ActionPerformed

    private void button_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_11ActionPerformed
      
    }//GEN-LAST:event_button_11ActionPerformed

    private void button_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12ActionPerformed
        
    }//GEN-LAST:event_button_12ActionPerformed

    private void button_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_13ActionPerformed
        
    }//GEN-LAST:event_button_13ActionPerformed

    private void button_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_14ActionPerformed
        
    }//GEN-LAST:event_button_14ActionPerformed

    private void button_ÃActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ÃActionPerformed
        
    }//GEN-LAST:event_button_ÃActionPerformed

    private void button_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_17ActionPerformed
       
    }//GEN-LAST:event_button_17ActionPerformed

    private void button_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_18ActionPerformed
        
    }//GEN-LAST:event_button_18ActionPerformed

    private void button_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_19ActionPerformed

    }//GEN-LAST:event_button_19ActionPerformed

    private void button_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_20ActionPerformed
        
    }//GEN-LAST:event_button_20ActionPerformed

    private void button_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_21ActionPerformed
        
    }//GEN-LAST:event_button_21ActionPerformed

    private void button_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_22ActionPerformed
       
    }//GEN-LAST:event_button_22ActionPerformed

    private void button_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_23ActionPerformed
        
    }//GEN-LAST:event_button_23ActionPerformed

    private void button_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_24ActionPerformed
        
    }//GEN-LAST:event_button_24ActionPerformed

    private void button_26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_26ActionPerformed
       
    }//GEN-LAST:event_button_26ActionPerformed

    private void button_27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_27ActionPerformed
      
    }//GEN-LAST:event_button_27ActionPerformed

    private void button_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_15ActionPerformed
        
    }//GEN-LAST:event_button_15ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       iniciar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JOptionPane.showMessageDialog(null, "Ahoracdo V1.0", "Ahorcado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        Icon intru=new ImageIcon(getClass().getResource("/imagenes/intru.png"));
        JOptionPane.showMessageDialog(null,"Jugadores: 2 (1 adivinador y 1 moderador)\n" +
            "Objetivo: Descubrir la palabra o frase incógnita.\n" +
            "\n" +
            "Preparación:\n" +
            "- Al inicio el moderador pensará en una palabra o frase y dibujará en una hoja una línea por cada letra.\n Se dibuja la base de la horca (sin el muñeco). El moderador dará una pista al jugador (adivinador).\n"
            +"Turno:\n" +
            "- En su turno el jugador puede: Pedir una letra / Adivinar la palabra. \n" +
            "- Pedir una letra: El moderador revisa si la letra pedida se encuentra en la palabra secreta.\n" +
            "-- Si la letra está, entonces el moderador la anota sobre la línea que ocupa su lugar en la palabra secreta.\n" +
            "-- Si la letra no está, entonces el moderador anotará la letra sobre la horca y dibujará una parte del muñeco. \n" +
            "- Muñeco: El muñeco se dibuja en 5 partes (cabeza, tronco y extremidades), por lo que el adivinador tiene 5 posibilidades de fallar.\n" +
            "- Adivinar la Palabra: El jugador puede intentar adivinar la palabra o frase secreta.\n" +
            "-- Si acierta la palabra, entonces el moderador completa la solución en el papel.\n" +
            "-- Si no acierta la palabra, entonces el moderador dibujará una parte del muñeco.\n"+"Fin de la partida:\n" +
            "- GANA el adivinador si descubre la palabra o frase secreta. \n" +
            "- PIERDE el avidinador si se dibuja el muñeco completo en la horca.\n", "Ahorcado - Instrucciones", JOptionPane.INFORMATION_MESSAGE, intru);
    }//GEN-LAST:event_helpActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer regresar al menu principal?\n Se perdera todo su progreso..",
            "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
    {ini i=new ini();
        i.setVisible(true);
        this.setVisible(false);
        }
        else{
            setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer una palabra nueva?",
            "Ahorcado", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
    {iniciar();
        }
        else{
            setDefaultCloseOperation(0);
        }

    }//GEN-LAST:event_IniciarActionPerformed

    private void txtPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPalabraActionPerformed

    }//GEN-LAST:event_txtPalabraActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
                 ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/images_1.jpeg"));
         Icon fondoUno = new ImageIcon(imagen.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(),Image.SCALE_DEFAULT));
        jLabel5.setIcon(fondoUno);
           this.repaint();
           
             ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/fondoprin.jpeg"));
         Icon fondoprin = new ImageIcon(image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondoprin);
           this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jLabel6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel6AncestorAdded
             ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/images_1.jpeg"));
         Icon fondoprin = new ImageIcon(image.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(),Image.SCALE_DEFAULT));
        jLabel6.setIcon(fondoprin);
           this.repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6AncestorAdded

    private void jLabel7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel7AncestorAdded
               ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/images_1.jpeg"));
         Icon fondoprin = new ImageIcon(image.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(),Image.SCALE_DEFAULT));
        jLabel7.setIcon(fondoprin);
           this.repaint();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7AncestorAdded

    private void DibujoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DibujoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_DibujoAncestorAdded
   private void button_00ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dibujo;
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_10;
    private javax.swing.JButton button_11;
    private javax.swing.JButton button_12;
    private javax.swing.JButton button_13;
    private javax.swing.JButton button_14;
    private javax.swing.JButton button_15;
    private javax.swing.JButton button_16;
    private javax.swing.JButton button_17;
    private javax.swing.JButton button_18;
    private javax.swing.JButton button_19;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_20;
    private javax.swing.JButton button_21;
    private javax.swing.JButton button_22;
    private javax.swing.JButton button_23;
    private javax.swing.JButton button_24;
    private javax.swing.JButton button_25;
    private javax.swing.JButton button_26;
    private javax.swing.JButton button_27;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JLabel errores;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
