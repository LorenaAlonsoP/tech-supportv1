import java.util.Random;
import java.util.ArrayList;

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
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("Are you sure?");
        respuestas.add("We are working on your problem.");
        respuestas.add("Wait a minute!");
        respuestas.add("Can you give me more information?");
        respuestas.add("Let's do it!");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int numAleatorio = aleatorio.nextInt(respuestas.size());
        return respuestas.get(numAleatorio);
    }
}
