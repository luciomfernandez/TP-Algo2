package CriterioPerdida;

import fabrica.ReglaConstruccion;

public class SinPerida implements CriterioPerdida {
	public Boolean perdida(ReglaConstruccion regla) {
		return true;
	}
}