package excerciseIntr3;

public class View implements Runnable{

  private Controler controler;

  public View(Controler controler) {
    this.controler = controler;
  }
  private void prt(){
    System.out.println(controler.toString());
  }
@Override
public void run() {
   prt();
}
}
