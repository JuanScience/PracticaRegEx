/**
 * @authors ormolgud_cardona82182@elpoli.edu.co
 *          juan_salazar82182@elpoli.edu.co 
 */

package practicaregex;
import javax.swing.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*;

public class PracticaRegEx {
    
    static String chain, pattern, outputPosition = "", outputText = "";
    static Pattern p;
    static Matcher m;
    static int cont = 0;

    public static void main(String[] args) {
        chain = "CONTRATO CON PERIODO DE PRUEBA.    \n" +
            "En la ciudad de Medellín y con fecha 06 08 2021 los que \n" +
            "suscribimos el presente a saber: que celebran por una parte la persona \n" +
            "(física/moral) denominada Juan Carlos Salazar Muñoz con cédula 1098607290 y teléfono fijo 2334587\n" +
            "representada  por Ormolgud Gonzalez Cardona con pasaporte Colombiano CK486257  y correo electrónico ormolgud_gonzalez@elpoli.edu.co\n" +
            "a  quien  en  lo  sucesivo  se  le \n" +
            "denominará  para  efectos  de  este  contrato  como  “El  PATRÓN”,  y  por  la  otra \n" +
            "Gildardo Antonio Quintero Correa con celular No. 3052271438 y dirección Cra 69 Sur No. 46E-54 con  por su propio derecho quien en delante de le \n" +
            "denominará  “EL  TRABAJADOR”;  hacemos  constar,    que  hemos  convenido  en \n" +
            "celebrar un contrato individual de trabajo, al tenor de las siguientes:   \n" +
            "DECLARACIONES  \n" +
            " I. Para los efectos del artículo 25 de la Ley Federal del Trabajo, “El PATRÓN” \n" +
            "declara    ser  propietario de los vehículos con placas: TXC654 JQP122 T456 TT789 TYU89S\n" +
            "dedicada a escribir código en Java con variables:\n" +
            "int carroBonito, peraDulce;\n" +
            "y que pueden ser identificadas en la siguiente URL: http://www.micarrobonito.com.co o pueden ser identificados \n" +
            "con los códigos de barras 77056747 y 7707458734957\n" +
            "Para los suscritos en este contrato pueden acceder con la contraseña segura aQueNoTeLaPillasHacker70@\n" +
            "Los abajo firmantes. Adios!";
        mainMenu();        
    } 
    
    //Método para el menú principal
    public static void mainMenu(){      
        String menu = "***MENÚ EXPRESIONES REGULARES***"
                + "\n\n 1- Placas de vehículos en Colombia"
                + "\n 2- Número de teléfonos fijos en Medellín"
                + "\n 3- Números de teléfonos celulares en Colombia"
                + "\n 4- Direcciones residenciales en Medellín"
                + "\n 5- Direcciones de correos electrónicos"
                + "\n 6- Fecha en formato dd mm aaaa"
                + "\n 7- Cédulas en Colombia"
                + "\n 8- Una declaración de variable en Java"
                + "\n 9- URL"
                + "\n10- Código de barras en Colombia"
                + "\n11- Pasaporte en Colombia"
                + "\n12- Nombres y apellidos"
                + "\n13- Contraseña segura"
                + "\n 0- Salir\n\n(Ingrese una opción)";
        int option = -1;
        do
        {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option)
                {
                    case 1: //Placas de vehículos en Colombia
                        pattern = "\\b([A-Z]{3}\\d{3}|[A-Z]{1,2}\\d{4}|[A-Z]{3}\\d{2}[A-Z])\\b";
                        findPatronus(pattern);
                        break;

                    case 2: //Número de teléfonos fijos en Medellín
                        
                        break;

                    case 3:  //Números de teléfonos celulares en Colombia
                        
                        break;

                    case 4: //Direcciones residenciales en Medellín
                        
                        break;
                    
                    case 5: //Direcciones de correos electrónicos
                            
                        break;

                    case 6: //Fecha en formato dd mm aaaa
                        
                        break;

                    case 7: //Cédulas en Colombia
                        
                        break;

                    case 8: //Una declaración de variable en Java
                        
                        break;
                    
                    case 9: //URL
                        
                        break;

                    case 10: //Código de barras en Colombia
                        
                        break;

                    case 11: //Pasaporte en Colombia
                        
                        break;

                    case 12: //Nombres y apellidos
                        
                        break;
                    
                    case 13: //Contraseña segura
                        
                        break;

                    case 0: System.exit(0);
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida");
            }
        }while(option != 0);       
    }
    
    private static void findPatronus(String pattern) {
        p = Pattern.compile(pattern); //Compila el patrón
        m = p.matcher(chain); //Valida la coincidencia del patrón compilado con la cadena
        while (m.find()){ //Encuentra coincidencias del patrón dentro de la cadena
            cont++;
            outputPosition = outputPosition + "Desde " + m.start() + " hasta " + m.end() + "\n\n";
            outputText = outputText + chain.substring(m.start(), m.end()) + "\n";
        }
        
        if (cont == 0){
            JOptionPane.showMessageDialog(null, "No hay coincidencias");
        }else{
            JOptionPane.showMessageDialog(null, "El patrón se encuentra " + cont + " veces\n" + outputPosition + outputText);
        }        
    }
    
}
