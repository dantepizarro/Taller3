package dominio;

public interface HechizoVisitor {
	double visitar(Fuego fuego);
	double visitar(Agua agua);
	double visitar(Tierra tierra);
	double visitar(Planta planta);

}
