package CriterioPerdida;

import fabrica.ReglaConstruccion;

public interface CriterioPerdida {
	//Las perdidas deber�an afectar la regla de fabricaci�n de la fabrica de alguna manera
	public Boolean perdida(ReglaConstruccion r);

}
