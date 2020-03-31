package Config;

/**
 *
 * @author Meza
 */
public class GenerarNumeroSerie {

    int dato;
    String NumeroS;

    public String NumeroSerie(int dato) {
        this.dato = dato + 1;
        String tam = Integer.toString(this.dato);
        String ceros = "0";
        for (int i = 1; i < 10 - tam.length(); i++) {
            ceros += "0";
        }
        NumeroS = ceros+this.dato;
        return NumeroS;
    }
}
