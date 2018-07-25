package CriterioPerdida;

import fabrica.ReglaConstruccion;

public interface CriterioPerdida {
	//Las perdidas deberían afectar la regla de fabricación de la fabrica de alguna manera
	public Boolean perdida(ReglaConstruccion r);

}
