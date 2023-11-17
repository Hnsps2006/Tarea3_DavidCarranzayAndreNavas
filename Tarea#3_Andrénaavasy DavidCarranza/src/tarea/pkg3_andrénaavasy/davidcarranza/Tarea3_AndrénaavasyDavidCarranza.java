/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg3_andrénaavasy.davidcarranza;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
public class Tarea3_AndrénaavasyDavidCarranza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.print("Bienvenido a mi programa");
        entrada.nextLine();
         int opcion;
        do { //obligo al usuario entrar obligatoriamente al menu
            System.out.println("Menú:");
            System.out.println("1. Programa 1");
            System.out.println("2. Programa 2");
            System.out.println("3. Programa 3");
            System.out.println("4. Programa 4");
            System.out.println("5. Programa 5");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt(); //leo menu
            entrada.nextLine(); // Limpiar el buffer después de leer el número

            switch (opcion) { //dependiendo de la opcion que elija el usuario entra a estos diferentes case
                case 1:
                    System.out.println("Usted ha elegido el Programa 1");
                    mensajeImprimirMensaje("Bienvenido al primer programa 1. Veamos si podemos formar la palabra"); //ejecuto metodo 1
                    break; //cierro el case 1 para que no se vuelta a ejecutar
                case 2:
                    System.out.println("Usted ha elegido el Programa 2");
                    numerosprimeros("Bienvenido al segundo programa 2. Números primero");
                    break;
                case 3:
                    System.out.println("Usted ha elegido el Programa 3");
                    ordenaralfabeticamente("Bienvenido al tercer programa 3. ");
                    break;
                case 4:
                    System.out.println("Usted ha elegido el Programa 4");
                    Imprision();
                    codificarTexto("");
                    break;
                case 5:
                    System.out.println("Usted ha elegido el Programa 5");
                    int[] arreglo = {1, 2, 3, 4, 5,6,7,8,9,10};  // Inicialización directa con valores conocidos,hasta 10 para que le pida 10 veces al usuario
                    completararreglo(arreglo);
                    imprimirarreglo(arreglo);
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!"); //salida del programa
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo."); //si pone cualquier otro entero que no sea menor o igual que 6
                    break;
            }
        } while (opcion != 6);
    }

    public static String mensajeImprimirMensaje(String mensaje) { //metodo 1 lo declaramos como string
        Scanner entrada = new Scanner(System.in); //importo scanner para leer y lo llamo entrada
        System.out.println(mensaje); 
        System.out.println("Ingrese la primera cadena: "); //le pido ingresar cadena 1
        String cadena1 = entrada.nextLine();
        System.out.println("Ingrese la segunda cadena: "); //le pido ingresar al usuario la cadena 2
        String cadena2 = entrada.nextLine();
        System.out.println("");

        int longituddecadena1 = cadena1.length(); //declaro como entero el tamaño de cadena 1
        int longituddecadena2 = cadena2.length(); //y cadena 2
        String cadenalarga = ""; 
        String cadenacorta = ""; 

        if (longituddecadena1 > longituddecadena2) { //esto es para saber el orden si la cadena 1 es mayor a cantidad de posiciones que la cade na 2 entonces cadena 1 es la mas larga
            //y cadena 2 la ams pequeña igual con else if es lo mismo pero arreves
            cadenalarga = cadena1;
            cadenacorta = cadena2;
        } else if (longituddecadena2 > longituddecadena1) {
            cadenalarga = cadena2;
            cadenacorta = cadena1;
        } else {
            System.out.println("Por favor, ingrese otra cadena debido a que las cadenas son iguales al tamaño"); //si son igual imprime lo siguiente
            return ""; //return para que regrese al main si sale igual 
        }

        String cadenalarganueva = cadenalarga.toLowerCase();  //validar que pueden ser minúsculas
        String cadenacortanueva = cadenacorta.toLowerCase();
         boolean seforma = true; //se forma la declaro verdaadera 

        for (int i = 0; i < cadenacortanueva.length(); i++) {
            char letra = cadenacortanueva.charAt(i); //practicamente lo que hago es que le asigno a letra una sola letra de cadenacorta y eso lo meto a un ciclo que tiene cosntante cambio porque el i
            //es contador que aumenta al acaabar cada ciclo
            boolean encontrada = false; //encontrada la declaro como falsa porque si encontrada queda como falsa no se puede formar por eso luego hago una condición con if

            for (int j = 0; j < cadenalarganueva.length(); j++) { //nuevo ciclo pero para cadena larga
                if (letra == cadenalarganueva.charAt(j)) {
                    encontrada = true; //y si se encuentra encontrada sera verdadera para que en el if se pueda ejecutar todo 
                    break;
                }
            }

            if (encontrada == false) {
                seforma = false;
                break;
            }
        }

        if (seforma) {
            System.out.println("Sí se puede formar " + cadenacorta + " con las letras de " + cadenalarga);
        } else {
            System.out.println("No se puede formar " + cadenacorta + " con las letras de " + cadenalarga);
        }
        return ""; //regreso al main
    }
    
    public static String numerosprimeros(String mensaje) { 
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una cadena que contenga numeros y letras "); 
        String leacadena = entrada.nextLine(); 
        
        String accum_num = ""; //practicamente lo que hago aquí son dos accumuladores uno para números y otro para letras por eso estan vacíos 
        String accum_letras = "";  //aquí hago otro accumulador pero esta vez el accumulador es para letras 
        
        for (int i = 0; i < leacadena.length(); i++) {  //hacemos un ciclo que se repetira cada vez que i sea menor que el tama;o de la cadena ingresada
            char cambiodeletraonumero = leacadena.charAt(i); //Aqui cambiamos el string por un caracter, porque de esta manera vamos a poder acceder a diferentes posiciones del tamano de
            //la cadena ingresada, revisando una por una y cambiando por ejemplo si la palabra es Hola, entonces la posicion de H es 0, y inicializamos i en 0, le pedimos que acceda a la
            //posicion en i con el charAt entonces se crea un ciclo en constante crecimiento por que en el ciclo for sumamos a i+1 cada vez que termina el ciclo, asi accediendo cada vez a differente 
            //posicion al entrar al ciclo
            
            if (cambiodeletraonumero >= '0' && cambiodeletraonumero <= '9') {
                accum_num += cambiodeletraonumero;
            } else if ((cambiodeletraonumero >= 'a' && cambiodeletraonumero <= 'z') ||
                       (cambiodeletraonumero >= 'A' && cambiodeletraonumero <= 'Z')) {
                accum_letras += cambiodeletraonumero;
            } else {
                System.out.println("Solo se permiten letras y números.");
                return "";
            }
        }
            String cadenaordenada = accum_num + accum_letras; 
            System.out.println("La cordenada resultante de forma ordenada seria: "+cadenaordenada);
        
        return "";
    }
    
    public static String ordenaralfabeticamente(String mensaje){  
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una cadena: ");
        String cadena = entrada.nextLine().toLowerCase(); 

        for (int i = 0; i < cadena.length() - 1; i++) { //este ciclo se repetira si y solo si i es menor que tamaño-1 esto es porque para realizar múltiples pasadas 
            //de comparación e intercambio de caracteres en la cadena. La variable i representa el número de pasadas que se han realizado hasta el momento. 
            //El bucle se ejecuta mientras i sea menor que la longitud de la cadena menos 1, ya que en cada pasada el último carácter estará ya en su posición correcta.
        boolean cambio = false;
            for (int j = 0; j < cadena.length() - 1 - i; j++) {  //se utiliza para comparar los caracteres adyacentes en la cadena y realizar intercambios si es necesario. 
                //La variable j representa la posición actual en la cadena durante una pasada determinada.
                    if (cadena.charAt(j) > cadena.charAt(j + 1)) {   
                        // Intercambiar los caracteres
                        char caracter = cadena.charAt(j);
                        cadena = cadena.substring(0, j) + cadena.charAt(j + 1) + cadena.charAt(j) //para obtener subcadenas de la cadena original y construir la nueva cadena con los caracteres intercambiados. 
                                + cadena.substring(j + 2);
                        cambio = true;
                    }
                }
            if (cambio == false) {
                // Si no se ha realizado ningún intercambio en esta iteración, la cadena ya está ordenada
                break;
            }
        }
        
        String letras = "";
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {  //solo letras y solo letras podran cumplir la función
                letras += caracter; //accumulador
            }
        }

        // Contar la cantidad de números
        int cantidadnum = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= '0' && cadena.charAt(i) <= '9') { //condición que solo números podran cumplir la fúncion
                cantidadnum=cantidadnum+1; 
            }
        }
        
        System.out.println("Cadena ordenada alfabéticamente: " + letras); //creamos dos accumuladores uno de letra para poder sumar las letras  y lo ponemos alfabeticamento con los ciclso for y los otros métodos de arriba etc.
        System.out.println("Cantidad de números en la cadena: " + cantidadnum); //el otro accumulador es de numeros y solo cuenta cuantos numeros hay no dice el numero
        return "";
    }
    
    public static void completararreglo(int[] arreglo) { //metodo declarado como entero en arreglos 
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese 10 posiciones cualquier de numeros:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese el valor para la posición " + i + ": ");
            arreglo[i] = entrada.nextInt(); //repetir la pregunta dependiendo de la cantidad de si i es menor que tamaño que el arreglo,que esa cantidad esta en el main
        }
    }

    // Método para imprimir el array en consola
    public static void imprimirarreglo(int[] arreglo) {
        System.out.println("Arreglo impreso:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("La Posicion es " + i + ": " + arreglo[i]);
        }
    } //se repite condición
    
    public static void Imprision() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);

        // Pedir al usuario que ingrese el texto a codificar
        System.out.println("Ingrese el texto a codificar:");
        String texto = entrada.nextLine();

        // Codificar el texto
        String textoCodificado = codificarTexto(texto);

        // Imprimir el texto codificado
        System.out.println("Texto codificado: " + textoCodificado);
    }

    public static String codificarTexto(String texto) {
    // Crear una cadena vacía para almacenar el texto codificado
    String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if ((caracter >= '0' && caracter <= '9')) {
                int valorNumero = caracter - '0';
                resultado += (char) (valorNumero + 64) + "-"; 
            } else if ((caracter >= 'a' && caracter <= 'z') ||
                       (caracter >= 'A' && caracter <= 'Z')) {
                int valorLetra = (caracter + "").toUpperCase().charAt(0) - 'A' + 1;
                resultado += valorLetra + "-";
            } else if (caracter == ' ') {
                resultado += " ";
            }
        }

        return resultado;
    }
}
