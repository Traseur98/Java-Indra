package excerciseXI;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameConBotones extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<Temperature> lt;
	private JPanel panel;

	public JFrameConBotones(List<Temperature> lt) throws HeadlessException {
		super();
		this.lt = lt;
		panel = new JPanel(new GridLayout(2, 2));
		getFrame();
	}

	public void getFrame() {
	        // Configurar el JFrame
	        setTitle("JFrame con Botones");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	        // Crear los botones
	        JButton boton = new JButton("Barcelona");
	        JButton boton2 = new JButton("Madrid");
	        JButton boton3 = new JButton("Berlin");
	        JButton boton4 = new JButton("Buenos Aires");
	        JButton [] jb = {boton,boton2,boton3,boton4};

	        // Agregar los botones al panel
	        int i = 0;
	        for (JButton b:jb) {
	        	panel.add(b);
	        	ShowInfo(lt.get(i).toString(),b);
	        	i++;
	        }

	      
	        // Agregar el panel al JFrame
	        add(panel);

	        // Hacer visible el JFrame
	        setVisible(true);
	    }
    private void ShowInfo(String data,JButton b) {
        b.addActionListener(
       	      new ActionListener() {
       	        @Override
       	        public void actionPerformed(ActionEvent e) {
       	        JOptionPane.showMessageDialog(panel, data);
       	        }
       	      }
       	    );	
   }
}
