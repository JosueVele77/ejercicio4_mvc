package controller;

public interface parametrizable {
	public default boolean validatePSW(String cadena) {		
		return cadena.matches("^[a-z0-9]{8,}[_@*#]$");
	}
	public default boolean validateEmail(String cadena) {
		return cadena.matches("^[a-z]\\w+[@]([a-z]{3,5}[.]?){2,4}$");
	}
	public default String formatText(char[] password) {
		String cadena="";
		for(char c:password) {
			cadena+=String.valueOf(c);
		}
		return cadena;
	}
	
}
