package exerciseXIII;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    Thread thread1 = new Thread(
      new Util(
        "C:\\Users\\pablo\\Desktop\\Cursos Pablo\\Java\\NewMainFolder\\NewFolder"
      )
    );
    thread1.setPriority(Thread.MAX_PRIORITY);
  

    City c1 = new City("Barcelona", 1000000, 1000000);
    City c2 = new City("Madrid", 2000000, 6000000);
    City c3 = new City("Milan", 3000000, 5000000);
    List<City> lc = List.of(c1, c2, c3);

    System.out.println("hilo principal");
    Thread thread2 = new Thread(
      new Util(
        "C:\\Users\\pablo\\Desktop\\Cursos Pablo\\Java\\NewMainFolder\\NewFolder\\cities.txt",
        lc
      )
    );
    thread2.setPriority(Thread.MIN_PRIORITY);
    thread2.start();  
    thread1.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
