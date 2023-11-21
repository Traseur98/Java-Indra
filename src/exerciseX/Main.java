package exerciseX;


import java.util.List;

import ExerciseVII.FileWritter;

public class Main {

	
	public static void main(String[] args) {
		final String URL = "C:\\Users\\pablo\\Desktop\\Cursos Pablo\\Java\\exercises\\INFO_VUELOS.txt";
		FileWritter fr = new FileWritter(URL,false);
		List<Flight> fl = fr.readCSV();
		for (Flight f: fl) {
			System.out.println(f.toString());
		}
	}

}