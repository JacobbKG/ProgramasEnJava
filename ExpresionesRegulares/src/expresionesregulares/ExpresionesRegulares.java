package expresionesregulares;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JACOB
 */
public class ExpresionesRegulares {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            FileWriter file = new FileWriter("resultados.txt")){
            
            System.out.print("Ingrese un numero con decimales: ");
            String ingreso1 = scanner.nextLine();
            
            String regexDecimal = "\\d*[.,]\\d+";
            String resultado1 = evaluaRegex(regexDecimal,ingreso1);
            
            System.out.print("Ingrese letra con guiones y digitos: ");
            String ingreso2 = scanner.nextLine();
            
            String regexLetraGuion = "[a-zA-Z]-\\d{3}";
            String resultado2 = evaluaRegex(regexLetraGuion,ingreso2);
            
            System.out.print("Ingrese correo electronico: ");
            String ingreso3 = scanner.nextLine();
            
            String regexCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            String resultado3 = evaluaRegex(regexCorreo,ingreso3);
            
            System.out.print("Ingrese letras del abecedario en mayusculas y minusculas: ");
            String ingreso4 = scanner.nextLine();
            
            String regexAbecedario = "^[a-zA-Z]+$";
            String resultado4 = evaluaRegex(regexAbecedario,ingreso4);
            
            System.out.print("Ingrese numeros con letras y entre ellas tenga un @: ");
            String ingreso5 = scanner.nextLine();
            
            String regexNumLetras = "^\\d+@[a-zA-Z]+$";
            String resultado5 = evaluaRegex(regexNumLetras,ingreso5);
            
            file.write("1. Ingreso de números con decimales = " + resultado1 + "\n");
            file.write("2. Ingreso de letra con guiones y dígitos = " + resultado2 + "\n");
            file.write("3. Ingreso de correo electrónico = " + resultado3 + "\n");
            file.write("4. Ingreso de letras del abecedario en mayúsculas y minúsculas = " + resultado4 + "\n");
            file.write("5. Ingreso de números con letras y entre ellas tenga un @ = " + resultado5 + "\n");
            System.out.println("Resultados guardados exitosamente.");
            
        }catch(IOException e){
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }catch(Exception e){
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    
    private static String evaluaRegex(String regex, String entrada){
        try{
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(entrada);  
            if(matcher.matches()){
                return matcher.group();
            }else{
                return "No coincide";
            }
        }catch(Exception e){
            return "Error en la expresion expresión regular: "+ e.getMessage();
        }
    }
}
