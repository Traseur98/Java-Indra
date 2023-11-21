package exerciseX;

import java.time.LocalDate;

public class Flight implements flightImpl{
	

	String name,rentable;
	Integer pasangers,price,finalPrice;
	FlightType type;
	LocalDate flight_date;
	
	public Flight(String name, Integer pasangers, Integer price, FlightType type, LocalDate flight_date) {
		this.name = name;
		this.pasangers = pasangers;
		this.price = price;
		this.type = type;
		this.flight_date = flight_date;
		finalPrice = ValorFinalPorVuelo();
		rentable = IsRentable();
	}
	@Override
	public Integer ValorFinalPorVuelo() {
		
		return price*pasangers;
	}

	@Override
	public String IsRentable() {
		if (type.equals(FlightType.ECONOMICO) && price <100) {
			return "No Rentable";
		}
		else if (type.equals(FlightType.PREMIER) && price <1500) {
			return "No Rentable";
		}
		else if (type.equals(FlightType.PREMIER) && price >=1500) {
			return "Rentable";
		}
		else {
			return "A Confirmar";
		}
		
	}
	@Override
	public String toString() {
		return "Flight [name=" + name + ", rentable=" + rentable + ", pasangers=" + pasangers + ", price=" + price
				+ ", finalPrice=" + finalPrice + ", type=" + type + ", flight_date=" + flight_date + "]";
	}

}
