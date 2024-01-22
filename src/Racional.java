public class Racional {
    private int numerador;
    private int denominador;

    // Constructor con valores predeterminados
    public Racional() {
        this(0, 1); // Representa el número 0 por defecto
    }

    // Constructor para inicializar con numerador y denominador
    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }

        // Reducir la fracción a su forma más simple
        int gcd = gcd(Math.abs(numerador), Math.abs(denominador));
        this.numerador = numerador / gcd;
        this.denominador = denominador / gcd;

        // Ajustar el signo
        if (denominador < 0) {
            this.numerador = -this.numerador;
            this.denominador = -this.denominador;
        }
    }

    // Método para calcular el máximo común divisor usando el algoritmo de Euclides
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método estático para sumar dos números racionales
    public static Racional sumar(Racional racional1, Racional racional2) {
        int nuevoNumerador = racional1.numerador * racional2.denominador + racional2.numerador * racional1.denominador;
        int nuevoDenominador = racional1.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método estático para restar dos números racionales
    public static Racional restar(Racional racional1, Racional racional2) {
        int nuevoNumerador = racional1.numerador * racional2.denominador - racional2.numerador * racional1.denominador;
        int nuevoDenominador = racional1.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método estático para multiplicar dos números racionales
    public static Racional multiplicar(Racional racional1, Racional racional2) {
        int nuevoNumerador = racional1.numerador * racional2.numerador;
        int nuevoDenominador = racional1.denominador * racional2.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método estático para dividir dos números racionales
    public static Racional dividir(Racional racional1, Racional racional2) {
        if (racional2.numerador == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        int nuevoNumerador = racional1.numerador * racional2.denominador;
        int nuevoDenominador = racional1.denominador * racional2.numerador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método para obtener la representación de cadena en forma a/b
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    // Método para obtener la representación de cadena en formato de punto flotante con precisión específica
    public String toFloatString(int precision) {
        double resultado = (double) numerador / denominador;
        String formato = "%." + precision + "f";
        return String.format(formato, resultado);
    }
}