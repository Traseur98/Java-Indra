package exerciseXIII;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Util implements Runnable {

  private String route;

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  private BufferedWriter bf;
  private Path p;
  private List<?> obj;

  public Util(String route) {
    this.route = route;
    p = Paths.get(route);
    try {
      this.bf = new BufferedWriter(new FileWriter(route));
    } catch (IOException e) {
      System.err.println(
        "There was a problem while creating this file: " + e.getMessage()
      );
    }
  }

  public Util(String route, List<?> obj) {
    this.route = route;
    this.obj = obj;
    try {
      this.bf = new BufferedWriter(new FileWriter(route));
    } catch (IOException e) {
      System.err.println(
        "There was a problem while creating this file: " + e.getMessage()
      );
    }
  }

  @Override
  public void run() {
    if (this.obj == null) {
      System.out.println("hilo secundario I");
      this.CreateDir();
    } else {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("hilo secundario II");
      this.WriteOneTxt();
    }
  }

  private void WriteOneTxt() {
    this.WriteTxt(obj);
    try {
      if (this.bf != null)this.bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void WriteAllTxt() {
    for (Object obj : obj) {
      this.WriteTxt(obj);
    }
    try {
      if (this.bf != null) this.bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void WriteTxt(Object obj) {
    try {
      bf.write(obj.toString());
      bf.newLine();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private Boolean validation(Boolean f, String msg) {
    if (!f) {
      return true;
    } else {
      System.out.println(msg);
      return false;
    }
  }

  private void CreateDir() {
    Boolean v = validation(Files.exists(p), "El directorio ya existe.");
    if (v) {
      try {
        Files.createDirectories(p);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Directorio creado exitosamente.");
    }
  }
}
