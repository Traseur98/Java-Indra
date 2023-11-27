package excerciseIntr3;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    Model model = new Model();
    System.out.print("Ingrese el detalle: ");
    model.setDetails(scanner.nextLine()); 

    System.out.print("Ingrese el color: ");
    model.setColor(scanner.nextLine()); 

    System.out.print("Ingrese el peso: ");
    model.setWeight(Double.parseDouble(scanner.nextLine())); 

    System.out.print("Ingrese el precio: ");
    model.setPrice(Double.parseDouble(scanner.nextLine())); 

    System.out.print("Ingrese las unidades vendidas: ");
    model.setAmount(scanner.nextInt()); 

    scanner.nextLine();

    System.out.print("Ingrese la fecha de elaboracion: ");
    String [] s = scanner.nextLine().split("/");
    model.setCreationDate(LocalDate.of(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])));

    String [] s2 = scanner.nextLine().split("/");
    System.out.print("Ingrese la fecha de expiracion: ");
    model.setExpirationDate(LocalDate.of(Integer.parseInt(s2[0]),Integer.parseInt(s2[1]),Integer.parseInt(s2[2])));

    scanner.close();

    Controler controler = new Controler(model);
    Thread thread1 = new Thread(controler);
    Thread thread2 = new Thread(new View(controler));
    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
