public class PruebaRacional
{

    public static void main(String[] args)
    {
        // Ejemplo de uso
        Racional racional1 = new Racional(2, 3);
        Racional racional2 = new Racional(-5, -6);

        // Suma
        Racional suma = Racional.sumar(racional1, racional2);
        System.out.println("Suma: " + suma);

        // Resta
        Racional resta = Racional.restar(racional1, racional2);
        System.out.println("Resta: " + resta);

        // Multiplicación
        Racional multiplicacion = Racional.multiplicar(racional1, racional2);
        System.out.println("Multiplicación: " + multiplicacion);

        // División
        Racional division = Racional.dividir(racional1, racional2);
        System.out.println("División: " + division);

        // Representación en forma a/b
        System.out.println("Representación a/b: " + racional1);

        // Representación en formato de punto flotante con precisión específica
        System.out.println("Representación flotante: " + racional1.toFloatString(2));
    }
}
