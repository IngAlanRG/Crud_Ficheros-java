package funciones;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Captura {
    public String getString(){
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
