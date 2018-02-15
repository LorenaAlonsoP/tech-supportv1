import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    ArrayList<String> respuestas;
    HashMap<String, String> respuestasInput;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestasInput = new HashMap<>();
        respuestas.add("Are you sure?");
        respuestas.add("We are working on your problem.");
        respuestas.add("Wait a minute!");
        respuestas.add("Can you give me more information?");
        respuestas.add("Let's do it!");
        respuestasInput.put("Windows", "We work with Windows, not with Linux.");
        respuestasInput.put("Linux", "We don't use this software, sorry.");
        respuestasInput.put("IOS", "We don't use this software, sorry.");
        respuestasInput.put("Sell", "We can see the sellers.");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> input1)
    {
        String respuesta = null;
        Iterator<String> iterator = input1.iterator();
        boolean searching = true;
        while(iterator.hasNext() && searching) {
            respuesta = respuestasInput.get(iterator.next());
            if(respuesta != null) {
                searching = false;
            }
        }
        
        for(String element : input1) {
            if(respuesta == null) {
                respuesta = respuestasInput.get(element);
            }
        }
        
        if(respuesta == null) {
            respuesta = respuestas.get(aleatorio.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}
