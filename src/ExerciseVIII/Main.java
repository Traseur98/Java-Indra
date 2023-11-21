package ExerciseVIII;

import ExerciseVII.Api;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

  public static void main(String[] args) {
    final String URL = "https://api.thecatapi.com/v1/images/search";
    Api api = new Api(URL);
    try {
      String imageUrl = api.getCatUrl();
      System.out.println(imageUrl.toString());
      JFrame ventana = new JFrame("EjercicioVIII");
      JLabel screen = new JLabel();
      JButton boton = new JButton("Gatito");
      ventana.setSize(100, 100);
      ventana.setVisible(true);
      ventana.add(boton);

      boton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              URL url = new URL(imageUrl.replaceAll("\"", ""));
              Image imagen = ImageIO.read(url);
              screen.setIcon(new ImageIcon(imagen));
              ventana.add(screen);
              ventana.pack();
              
            } catch (Exception err) {
              // TODO Auto-generated catch block
              System.out.println(err.getMessage());
            }
          }
        }
      );
    } catch (Exception err) {
      // TODO Auto-generated catch block
      err.printStackTrace();
    }
  }
}
