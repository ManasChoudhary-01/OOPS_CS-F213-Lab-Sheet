package lab10;

public class TemperatureConverter {
	
	public static double CelsiusToFahrenheit(double celsius) {
		
		assert celsius >= -273.15 : "Enter a valid temperature";
		
		double result = celsius*1.8 + 32;
		return result;
		
	}
	
	public static double FahrenheitToCelsius(double fahrenheit) {
		
		assert fahrenheit >= -459.67 : "Enter a valid temperature";
		
		double result = (fahrenheit - 32)/1.8 ;
		return result;
	}
	
	public static void main(String arg[]) {
		
		System.out.println(CelsiusToFahrenheit(-92.00));
		System.out.println(FahrenheitToCelsius(23.00));
	}

}
