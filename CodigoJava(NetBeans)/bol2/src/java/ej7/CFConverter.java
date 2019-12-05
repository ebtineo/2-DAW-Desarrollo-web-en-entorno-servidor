package ej7;

public class CFConverter {
    
    public static float celsiusToFahrenheit(String temperatura) {
        float c = Float.parseFloat(temperatura);
        return c * 9 / 5 + 32;
    }
    
    public static float fahrenheitToCelsius(String temperatura) {
        float f = Float.parseFloat(temperatura);
        return (f - 32) * 5/9;
    }
}
