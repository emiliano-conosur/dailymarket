package dailymarket.swing.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dailymarket.lectorDeHuellas.UtilLectorHuellasSingleton;


@SuppressWarnings("serial")
public class CerrarCajaFrame extends DailyMarketFrame implements HuellaDigitalInterface{

	protected JFrame parentFrame;
	protected JLabel imgHuella = new JLabel();
    protected boolean FIRMA_CIERRE = false;
	JLabel mensaje = new JLabel();
	JLabel mensajeLector = new JLabel();

    protected JTextField montoCierre = new JTextField();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	JTextField monto = new JTextField();
	JTextField cajero = new JTextField("");
	CerrarCajaFrame frame ;
	
	JPanel imageHuellaPanel = new JPanel();
	JButton cerrarButton;
	UtilLectorHuellasSingleton  utilHuellas = UtilLectorHuellasSingleton.getInstance();
	
	
	public CerrarCajaFrame(JFrame f){
		
		parentFrame = f;
		frame = this;
		setTitle("Cerrar  Caja ");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(500,400));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel cierrePanel = new JPanel();
		cierrePanel.setPreferredSize(new Dimension(500,130));
		
		JPanel formPanel = new JPanel();
		formPanel.setPreferredSize(new Dimension(300,130));
		formPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		imageHuellaPanel.setPreferredSize(new Dimension(180,125));
		imageHuellaPanel.setLayout( new GridBagLayout());
		imageHuellaPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "Huella",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, Color.BLACK));
		imageHuellaPanel.remove(imgHuella);

		cierrePanel.add(formPanel);
		cierrePanel.add(imageHuellaPanel);
		
	
		
		JLabel cajeroLabel = new JLabel("Cajero :");
		JTextField cajero = new JTextField();
		cajero.setEditable(false);
		cajero.setPreferredSize(new Dimension(180,20));
		cajero.setText("Ottaviano, Gabriel Ignacio");
		
		JLabel dateAperturaCajaLabel = new JLabel("Fecha y hora de apertura :");
		JTextField dateAperturaCaja = new JTextField();
		dateAperturaCaja.setEditable(false);
		dateAperturaCaja.setPreferredSize(new Dimension(100,20));
		dateAperturaCaja.setText(sdf.format(new Date()));
		
		JLabel dateCierreCajaLabel = new JLabel("Fecha y hora de cierre :");
		JTextField dateCierreCaja = new JTextField();
		dateCierreCaja.setEditable(false);
		dateCierreCaja.setPreferredSize(new Dimension(100,20));
		dateCierreCaja.setText(sdf.format(new Date()));
		
		JLabel montoAperturaLabel = new JLabel("Monto de Apertura :");
		JTextField montoApertura = new JTextField();
		montoApertura.setEditable(false);
		montoApertura.setPreferredSize(new Dimension(100,20));
		montoApertura.setText("456,89");
		
		JLabel montoCierreLabel = new JLabel("Monto de Cierre :");
		montoCierre = new JTextField();
		montoCierre.setPreferredSize(new Dimension(100,20));
		
		formPanel.add(cajeroLabel);
		formPanel.add(cajero);
		formPanel.add(dateAperturaCajaLabel);
		formPanel.add(dateAperturaCaja);
		formPanel.add(dateCierreCajaLabel);
		formPanel.add(dateCierreCaja);
		formPanel.add(montoAperturaLabel);
		formPanel.add(montoApertura);
		formPanel.add(montoCierreLabel);
		formPanel.add(montoCierre);
		
			
		JPanel buttonsMainPanel = new JPanel();
		buttonsMainPanel.setPreferredSize(new Dimension(500,50));
		buttonsMainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel messageFingerPrintPanel = new JPanel();
		messageFingerPrintPanel.setPreferredSize(new Dimension(180,45));
		messageFingerPrintPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "Eventos del Lector",
				TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, null, null));
		messageFingerPrintPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		messageFingerPrintPanel.add(mensajeLector);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(300,50));
	
		buttonsMainPanel.add(buttonsPanel);
		buttonsMainPanel.add(messageFingerPrintPanel);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setPreferredSize(new Dimension(480, 60));
		messagePanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "Mensajes",
				TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, null, null));
		messagePanel.add(mensaje);
		
		mainPanel.add(cierrePanel);
		mainPanel.add(buttonsMainPanel);
		mainPanel.add(messagePanel);
		
		getContentPane().add(mainPanel);
		
		JButton firmar = new JButton("Firmar");
		firmar.setPreferredSize(new Dimension(80,30));
		firmar.setMnemonic(KeyEvent.VK_F);
		firmar.addActionListener(new firmarsButtonListener());
		buttonsPanel.add(firmar);
	
		cerrarButton = new JButton("Cancelar");
		cerrarButton.setPreferredSize(new Dimension(90,30));
		cerrarButton.setMnemonic(KeyEvent.VK_C);
		cerrarButton.setEnabled(false);
		cerrarButton.addActionListener(new CerrarButtonListener());
		
		buttonsPanel.add(cerrarButton);
		JButton volverButton = new JButton("Volver");
		volverButton.setMnemonic(KeyEvent.VK_V);
		volverButton.setPreferredSize(new Dimension(80,30));
		buttonsPanel.add(volverButton);
		volverButton.addActionListener(new volverButtonListener());
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		setBounds(200, 100, 600, 350);
		setVisible(true);

	}

	class CerrarButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			if(FIRMA_CIERRE){
				//CANCELAR LA FIRMA
				FIRMA_CIERRE  = false;
				mensaje.setText("Apertura cancelada");
				mensaje.setForeground(Color.red);
				utilHuellas.stop(mensajeLector);
				cerrarButton.setEnabled(false);
				
			}
		}
	}
	
	class volverButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			utilHuellas.stop(mensajeLector);
			
			String [] disabledButtons = new String[2];
			if(FIRMA_CIERRE){
				disabledButtons[0] = DailyMarketFrame.CERRAR_CAJA;
				disabledButtons[1] = DailyMarketFrame.NUEVA_SESION;
				
			}else{
				disabledButtons[0] = DailyMarketFrame.APERTURA_CAJA;
				disabledButtons[1] = DailyMarketFrame.CERRAR_APLICACION;
			}
			
			((CajaFrame)parentFrame).deshabilitarBotones(disabledButtons);
			parentFrame.setVisible(true);
			dispose();
			
		}
		
	}
	
	class firmarsButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if( montoCierre.getText().equals("") ){
				JOptionPane.showMessageDialog(frame, "Debe Ingresar el monto de cierre  ");
			}else{
				//VALIDAR Q SEA NUMERICO
				try{
					Double.parseDouble(montoCierre.getText());
		
					mensaje.setText("Esperando su huella digital");
					mensaje.setForeground(Color.red);
				
					utilHuellas.init( frame);
					utilHuellas.start(mensajeLector);
					FIRMA_CIERRE = true;

					
				}
				catch (NumberFormatException e) {
					mensaje.setText("El valor debe ser num�rico");
					mensaje.setForeground(Color.red);
				}	
			}
		}
		
  }

	public String getUserName() {
		return cajero.getText();
	}

	public JLabel getFingerPrintPicture() {
		return imgHuella;
	}

	public JLabel getFrameMensaje() {
		return mensaje;
	}

	public JPanel getImageHuellaPanel() {
		return imageHuellaPanel;
	}

	public JLabel getMensajeLector() {
		return mensajeLector;
	}

	public  void loguear(/*User*/){
   	 cajero.setEditable(false);
   	 monto.setEditable(false);
   	
	 FIRMA_CIERRE = true;
  	 cerrarButton.setEnabled(true);
		 
  	 
  	 //	setCurrentUser(user);
  	 
	 }
}