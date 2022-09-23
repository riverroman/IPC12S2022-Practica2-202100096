
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class REPORTE_THML {
    
    public static void main(String[] args) {
    
    
        String cadenahtml = "<!DOCTYPE html>\n"
                            + "<htm lang=\"en\">"
                            + "     <meta charset = \"utf-8\">\n"
                            + "     <title>REPORTE DE JUEGO</title>\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "<table>\n"
                            + "     <tr>\n"
                            + "          <h1>NOMBRE: RIVER ANDERSON ISMALEJ ROMAN</h1>\n"
                            + "          <p>DIFICULTAD: </p>\n"
                            + "          <p>INTERVALO: </p>\n"
                            + "          <p>TAMAÑO DE SERPIENTE: </p>\n"
                            + "      </tr>\n"
                ;
        
           
        File archivo = new File("202100096.html");
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(cadenahtml);
            bw.close();
        } catch (Exception e) {
        }
       
    }
        
 }




