public class Temperature {
	
	private double degreesFahrenheit;
	private double degreesCelsius;
	private double degreesKelvin;
	
	public Temperature(double temp, String type) {
		if (type.equalsIgnoreCase("F"))
		{
			setDegreesFahrenheit(temp);
		}
		else if (type.equalsIgnoreCase("C"))
		{
			setDegreesCelsius(temp);
		}
		else if (type.equalsIgnoreCase("K"))
		{
			setDegreesKelvin(temp);
		}
	}
	
	public double getDegreesFahrenheit() {
		return degreesFahrenheit;
	}
	
	public double getDegreesCelsius() {
		return degreesCelsius;
	}
	
	public double getDegreesKelvin() {
		return degreesKelvin;
	}
	
	public void setDegreesFahrenheit(double temp) {
		degreesFahrenheit = temp;
		degreesCelsius = (temp - 32) * 5 / 9;
		degreesKelvin = (temp - 32)* 5 / 9 + 273.15;
	}
	public void setDegreesCelsius(double temp) {
		degreesCelsius = temp;
		degreesFahrenheit = (temp * 9) / 5 + 32;
		degreesKelvin = temp + 273.15;
	}
	public void setDegreesKelvin(double temp) {
		degreesKelvin = temp;
		degreesFahrenheit = (temp - 273.15) * 9 / 5 + 32;
		degreesCelsius = temp - 273.15;
	}
}
