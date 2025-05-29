// Clase 2: ComparadoresPersona.java
// Aquí defines cómo comparar tu clase. Puedes crear comparadores para otros atributos o clases
import java.util.Comparator;

public class ComparadoresPersona {
    public static Comparator<Persona> porNombreAsc = Comparator.comparing(Persona::getNombre);
    public static Comparator<Persona> porIdAsc = Comparator.comparingInt(Persona::getId);
}
