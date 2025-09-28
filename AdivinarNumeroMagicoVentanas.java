import javax.swing.JOptionPane;

public class AdivinarNumeroMagicoVentanas {
    public static void main(String[] args) {
        // Definir las 5 matrices
        int[][] matriz1 = {
                { 4, 5, 6, 7 },
                { 12, 13, 14, 15 },
                { 20, 21, 22, 23 },
                { 28, 29, 30, 31 }
        };

        int[][] matriz2 = {
                { 1, 3, 5, 7 },
                { 9, 11, 13, 15 },
                { 17, 19, 21, 23 },
                { 25, 27, 29, 31 }
        };

        int[][] matriz3 = {
                { 2, 3, 6, 7 },
                { 10, 11, 14, 15 },
                { 18, 19, 22, 23 },
                { 26, 27, 30, 31 }
        };

        int[][] matriz4 = {
                { 8, 9, 10, 11 },
                { 12, 13, 14, 15 },
                { 24, 25, 26, 27 },
                { 28, 29, 30, 31 }
        };

        int[][] matriz5 = {
                { 16, 17, 18, 19 },
                { 20, 21, 22, 23 },
                { 24, 25, 26, 27 },
                { 28, 29, 30, 31 }
        };

        // Guardamos todas las matrices en un arreglo 3D
        int[][][] todas = { matriz1, matriz2, matriz3, matriz4, matriz5 };

        // Primeros elementos de cada matriz (clave para el truco)
        int[] primeros = { 4, 1, 2, 8, 16 };

        int numeroMagico = 0;

        // Paso inicial
        JOptionPane.showMessageDialog(null,
                "🤔 Piensa en un número del 1 al 31.\nNo lo digas, solo respóndeme con Sí o No.");

        // Recorrer las 5 matrices
        for (int k = 0; k < todas.length; k++) {
            // Convertimos la matriz en texto legible
            String matrizTexto = matrizToString(todas[k]);

            // Mostramos la pregunta
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "Matriz " + (k + 1) + ":\n\n" + matrizTexto + "\n¿Tu número está aquí?",
                    "Pregunta " + (k + 1),
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                numeroMagico += primeros[k];
            }
        }

        // Mostrar el número adivinado
        JOptionPane.showMessageDialog(null, "🎩 Tu número mágico es: " + numeroMagico);

        // Créditos finales
        JOptionPane.showMessageDialog(null,
                "Créditos:\n" +
                        "Estudiante Lic. Tecnología: Wilton Martinez Escorcia\n" +
                        "Universidad del Magdalena\n" +
                        "Santa Marta - Octubre 2025");
    }

    // Método para convertir matriz a texto con buen formato
    public static String matrizToString(int[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            for (int valor : fila) {
                sb.append(String.format("%2d  ", valor)); // siempre ocupa 2 espacios + separación
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
