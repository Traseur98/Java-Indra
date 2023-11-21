package ExerciseVII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exerciseX.Flight;
import exerciseX.FlightType;

public class FileWritter {

  private String route;

  private BufferedWriter bf;
  private BufferedReader br;
  private FileInputStream fs;

  public FileWritter(String route,Boolean write) {
	  if(write) {
		  
	  
    try {
      this.bf = new BufferedWriter(new FileWriter(route));
    } catch (IOException e) {
      System.err.println(
        "There was a problem while creating this file: " + e.getMessage()
      );
    }}
	  else {
		  try {
        FileInputStream fs = new FileInputStream(route);
        this.fs = fs;
        BufferedReader d = new BufferedReader(new InputStreamReader(fs));
        br = d;
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
  }  
	  }
  

  public String getRoute() {
    return route;
  }

  public void WriteAllTxt(List<?> o) {
    for (Object obj : o) {
      this.WriteTxt(obj);
    }
    try {
      this.bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void WriteOneTxt(Object o) {
    this.WriteTxt(o);
    try {
      this.bf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void WriteTxt(Object o) {
    try {
      bf.write(o.toString());
      bf.newLine();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public List<Flight> readCSV() {
	    String s;
	    List<Flight> l = new ArrayList<>();
	    int first = 0;
	    while (true) { // recorre las filas
	      try {
	        s = br.readLine();
	        if (s == null) break;
	        if(first !=0) {
	        	 String[] splitted = s.split(";");
	        FlightType ft = (splitted[2].startsWith("E"))?FlightType.ECONOMICO:FlightType.PREMIER;
	        Flight f = new Flight(
	          splitted[0],
	          Integer.parseInt(splitted[1]),
	          Integer.parseInt(splitted[3]),
	          ft,
	          parseDate(splitted[4])
	        );
	        l.add(f);
	        }
	        first++;
	       
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	    try {
			this.fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return l;
	  }

	  private LocalDate parseDate(String d) {
	    String[] sd = d.split("/");
	    return LocalDate.of(
	      Integer.parseInt(sd[2]),
	      Integer.parseInt(sd[1]),
	      Integer.parseInt(sd[0])
	    );
	  }
}
