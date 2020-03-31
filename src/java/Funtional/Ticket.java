package Funtional;

import java.text.DecimalFormat;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Meza
 */
public class Ticket {

    StringBuilder lieas = new StringBuilder();
    int maxCar = 40, cortar;

    public String LiniasGion() {
        String Giones = "";
        for (int i = 0; i < maxCar; i++) {
            Giones += "-";
        }
        return lieas.append(Giones).toString();
    }

    public String Asterico() {
        String LinAst = "";
        for (int i = 0; i < maxCar; i++) {
            LinAst += "*";
        }
        return lieas.append(LinAst).toString();
    }

    public void Encabezado() {
        lieas.append("PRODUCTO             CANT.  PREC.  IMPT.");
    }

    public void TextoLeft(String texto) {
        if (texto.length() > maxCar) {
            int caractAct = 0;
            for (int longText = texto.length(); longText < maxCar; maxCar--) {
                lieas.append(texto.substring(caractAct, maxCar));
                caractAct += maxCar;
            }
            lieas.append(texto.subSequence(caractAct, texto.length() - caractAct));
        } else {
            lieas.append(texto);
        }
    }

    public void TextoDerecha(String texto) {
        if (texto.length() > maxCar) {
            int caracterAct = 0;
            for (int LongituTexto = texto.length(); LongituTexto < maxCar; --maxCar) {
                lieas.append(texto.subSequence(caracterAct, maxCar));
                caracterAct += maxCar;
            }
            lieas.append(texto.substring(caracterAct, texto.length() - caracterAct));

            String espacios = "";
            for (int i = 0; i < (maxCar - texto.substring(caracterAct, texto.length() - caracterAct).length()); i++) {
                espacios += " ";
            }
            lieas.append(espacios).append(texto.substring(caracterAct, texto.length() - caracterAct));//Modificado
        } else {
            String espacios = "";
            for (int i = 0; i < (maxCar - texto.length()); i++) {
                espacios += " ";
            }
            lieas.append(texto);
        }
    }

    // metodo para definir el centro de los extremos
    public void TextoCentro(String texto) {
        if (texto.length() > maxCar) {
            int caracterAct = 0;
            for (int LongituTexto = texto.length(); LongituTexto < maxCar; --maxCar) {
                lieas.append(texto.substring(caracterAct, maxCar));
                caracterAct += maxCar;
            }
            lieas.append(texto.substring(caracterAct, texto.length() - caracterAct));

            String espacios = "";
            int centrar = (maxCar - texto.substring(caracterAct, texto.length() - caracterAct).length()) / 2;

            for (int i = 0; i < centrar; i++) {
                espacios += " ";
            }
            lieas.append(espacios).append(texto.substring(caracterAct, texto.length() - caracterAct));
        } else {
            String espacios = "";
            int centrar = (maxCar - texto.length()) / 2;

            for (int i = 0; i < centrar; i++) {
                espacios += " ";
            }
            lieas.append(espacios).append(texto);
        }
    }

    // metodo para agregar exto extremo
    public void textoExtremo(String textoIzquierda, String textoDerecho) {
        String textIzq, textDere, textCompleto = "", espacios = "";
        if (textoIzquierda.length() > 18) {
            cortar = textoIzquierda.length() - 18;
            textIzq = textoIzquierda.substring(18, cortar);
        } else {
            textIzq = textoIzquierda;
        }
        textCompleto = textIzq;
        if (textoDerecho.length() > 20) {
            cortar = textoDerecho.length() - 20;
            textDere = textoDerecho.substring(20, cortar);
        } else {
            textDere = textoDerecho;
        }

        int nroespacio = maxCar - (textIzq.length() + textDere.length());
        for (int i = 0; i < nroespacio; i++) {
            espacios += " ";
        }
        textCompleto += espacios + textDere;
        lieas.append(textCompleto);
    }

    // metodo para agregar subtotales
    public void Agregartotales(String texto, double total) {
        String resumen, Valor, TextoCompleto, espacios = "";
        if (texto.length() > 25) {
            cortar = texto.length() - 25;
            resumen = texto.substring(25, cortar);
        } else {
            resumen = texto;
        }
        TextoCompleto = resumen;
        DecimalFormat format = new DecimalFormat("#,#.00");
        Valor = format.format(total);

        int nrEspacio = maxCar - (resumen.length() + Valor.length());
        for (int i = 0; i < nrEspacio; i++) {
            espacios += " ";
        }
        TextoCompleto += espacios + Valor;
        lieas.append(TextoCompleto);
    }

    // metodo para agregar articulo
    public void AgregarArticulo(String articulo, int cantidad, double precio, double Importe) throws Exception {
        //string resumen, Valor, TextoCompleto, espacios = "";
        if (String.valueOf(cantidad).length() <= 5 && String.valueOf(precio).length() <= 7 && String.valueOf(Importe).length() <= 8) {
            String elemento = "", espacio = "";
            Boolean bandera = false;
            int norEspacio = 0;
            if (articulo.length() > 20) {
                norEspacio = (4 - String.valueOf(cantidad).length());
                espacio = " ";
                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(cantidad); // bandera

                norEspacio = (6 - String.valueOf(precio).length());
                espacio = " ";

                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(precio);

                norEspacio = (8 - String.valueOf(Importe).length());
                espacio = "";
                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(Importe);

                int CaracterActual = 0;
                for (int longituTexto = articulo.length(); longituTexto > 20; longituTexto -= 20) {
                    if (bandera == false) {
                        lieas.append(articulo.substring(CaracterActual, 20)).append(elemento);
                        bandera = true;
                    } else {
                        lieas.append(articulo.substring(CaracterActual, 20));
                        CaracterActual += 20;
                    }
                }
                // Imprimir Detalle Completo
                //Linea.AppendLine(articulo.Substring(CaracterActual, articulo.Length - CaracterActual));
            } else {
                for (int i = 0; i < 20 - articulo.length(); i++) {
                    espacio += " ";
                }
                elemento = articulo + espacio;

                norEspacio = (5 - String.valueOf(cantidad).length());
                espacio = "";
                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(cantidad).length();

                norEspacio = (7 - String.valueOf(precio).length());
                espacio = "";
                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(precio);

                norEspacio = (8 - String.valueOf(Importe).length());
                espacio = "";
                for (int i = 0; i < norEspacio; i++) {
                    espacio += " ";
                }
                elemento += espacio + String.valueOf(Importe);
                lieas.append(elemento);
            }
        } else {
            lieas.append("Los valores ingresados para esta fila");
            lieas.append("Superan las columnas soportadas por este");
            throw new Exception("los valores Ingresados para algunos ticket's\nSuperan las Columnas");
        }
    }

    public void listarImpresoras() {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Lista de impresoras disponibles");

        for (PrintService printService : printServices) {
            System.out.println("\t" + printService.getName());
        }
    }

    
    private PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            System.out.println(printService.getName());

            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }

}
