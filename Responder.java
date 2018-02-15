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
    HashMap<HashSet<String>, String> respuestasInput;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        createDefaultRespuesta();
        respuestasInput = new HashMap<>();
        HashSet<String> set01 = new HashSet<>();
        set01.add("windows");
        HashSet<String> set02 = new HashSet<>();
        set02.add("linux");
        HashSet<String> set03 = new HashSet<>();
        set03.add("IOS");
        HashSet<String> set04 = new HashSet<>();
        set04.add("sell");
        respuestasInput.put(set01, "We work with Windows, not with Linux.");
        respuestasInput.put(set02, "We don't use this software, sorry.");
        respuestasInput.put(set03, "We don't use this software, sorry.");
        respuestasInput.put(set04, "We can see the sellers.");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> input1)
    {
        String respuesta = null;
        respuesta = respuestasInput.get(input1);

        if(respuesta == null) {
            if(respuestas.size() > 0) {
                respuesta = respuestas.remove(aleatorio.nextInt(respuestas.size()));
            }
            else {
                respuesta = "Sorry, I don't understand your question.";
            }
        }
        return respuesta;
    }

    private void createDefaultRespuesta() 
    {
        respuestas = new ArrayList<>();
        respuestas.add("Are you sure?");
        respuestas.add("We are working on your problem.");
        respuestas.add("Wait a minute!");
        respuestas.add("Can you give me more information?");
        respuestas.add("Let's do it!");
    }
}
