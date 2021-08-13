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
    
    static String pattern, outputPosition = "", outputText = "";
    static Pattern p;
    static Matcher m;
    static int cont = 0;
    static String chain = "CONTRATO CON PERIODO DE PRUEBA.    \n" +
            "En la ciudad de Medellín y con fecha 06/08-2021 los que \n" +
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
            "declara    ser  propietario de los vehículos con placas: \nTXC654, JQP122, T4565, TT7898 y TYU89S\n" +
            "dedicada a escribir código en Java con variables:\n" +
            "int carroBonito, peraDulce;\n" +
            "y que pueden ser identificadas en la siguiente URL: http://www.micarrobonito.com.co o pueden ser identificados \n" +
            "con los códigos de barras 77056747 y 7707458734957\n" +
            "Para los suscritos en este contrato pueden acceder con la contraseña segura \naQueNoTeLaPillasHacker70@\n" +
            "Los abajo firmantes. Adios!";

    public static void main(String[] args) {
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
                        pattern = "\\b([A-Z]{3}\\d{3}|[A-Z]{1,2}\\d{4}|[A-Z]{3}\\d{2}[A-Z])(\\b|,|\\.)";
                        findPatronus(pattern, false);
                        break;

                    case 2: //Número de teléfonos fijos en Medellín
                        pattern = "\\b([2-8]\\d{6})\\b";
                        findPatronus(pattern, false);
                        break;

                    case 3:  //Números de teléfonos celulares en Colombia
                        pattern = "\\b(3(0[0-5]|1\\d|2[0-3]|5[0-1])\\d{7})(\\b|,|\\.)";
                        findPatronus(pattern, false);
                        break;

                    case 4: //Direcciones residenciales en Medellín
                        pattern = "\\b(Carrera|Cr|Cra|K|kra|CRS|Calle|C|Cl|Cll|Avenida|Av|Diagonal|Dg|Circular|Cq|Transversal|Tv)(\\. | ){0,1}(1[0-1]\\d|12[0-1]|[1-9]\\d{0,1})(\\. | ){0,1}([A-G]{0,2})(\\. | ){0,1}(este|sur){0,1}(\\. | ){0,1}(N|No|#)(\\. | ){0,1}(1[0-1]\\d|12[0-1]|[1-9]\\d{0,1})([A-G]{0,2})(\\. | |-| -|- | - ){0,1}(1[0-1]\\d|12[0-1]|[1-9]\\d{0,1})(\\b|\\.)";
                        findPatronus(pattern, true);
                        break;
                    
                    case 5: //Direcciones de correos electrónicos
                        pattern = "\\b([\\w_\\.-]+@[\\w_-]+(\\.[a-zA-Z]{2,6}){1,3})(\\b|,)";
                        findPatronus(pattern, false);
                        break;

                    case 6: //Fecha en formato dd mm aaaa
                        pattern = "\\b(0[1-9]|[1-2][0-9]|3[0-1])( |/|-)(0[1-9]|1[0-2])( |/|-)(19\\d\\d|20[0-1]\\d|202[0-1])(\\b|\\.)";//Fecha en formato dd mm aaaa
                        findPatronus(pattern, false);
                        break;

                    case 7: //Cédulas en Colombia
                        pattern = "\\b(1\\d{9}|[1-9]\\d{0,7})(\\b|\\.|,)";
                        findPatronus(pattern, false);
                        break;

                    case 8: //Una declaración de variable en Java
                        pattern = "(byte|short|int|long|float|double|boolean|char) +[a-z]\\w* *(, *[a-z]\\w* *)*;";
                        findPatronus(pattern, false);
                        break;
                    
                    case 9: //URL
                        pattern = "((https?|ftp|file)://[\\w%/\\.#\\?\\*\\+\\!-_\\$&‘;=~@\\[\\]\\(\\)]{1,248}|mailto:[\\w%/\\.#\\?\\*\\+\\!-_\\$&‘;=~]{1,249})\\b";
                        findPatronus(pattern, false);
                        break;

                    case 10: //Código de barras en Colombia
                        pattern = "\\b770(\\d{10}|\\d{5})(\\b|,)";
                        findPatronus(pattern, false);
                        break;

                    case 11: //Pasaporte en Colombia
                        pattern = "\\b[A-Z]{2}\\d{6}(\\b|\\.|,)";
                        findPatronus(pattern, false);
                        break;

                    case 12: //Nombres y apellidos
                        pattern = "\\b(([A-Z]|Á|É|Í|Ó|Ú)([a-z]|á|é|í|ó|ú)* ){3,4}(\\b|\\.|,)";
                        findPatronus(pattern, false);
                        break;
                    
                    case 13: //Contraseña segura
                        validatePassword();
                        break;

                    case 0: System.exit(0);
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida");
            }
        }while(option != 0);       
    }
    
    private static void findPatronus(String pattern,boolean sensitive) {
        if (sensitive){
            p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); //Compila el patrón ignorando el case sensitive
        }else {
            p = Pattern.compile(pattern); //Compila el patrón
        }
        m = p.matcher(chain); //Valida la coincidencia del patrón compilado con la cadena
        cont = 0;
        outputPosition = "";
        outputText = "";
        while (m.find()){ //Encuentra coincidencias del patrón dentro de la cadena
            cont++;
            outputPosition = outputPosition + "Desde " + m.start() + " hasta " + m.end() + "\n\n";
            outputText = outputText + chain.substring(m.start(), m.end()) + "\n";
        }
        
        if (cont == 0){
            JOptionPane.showMessageDialog(null, "No hay coincidencias");
        }else{
            JOptionPane.showMessageDialog(null, "El patrón se encuentra " + cont + " veces\n" + outputPosition + outputText);
            cutAndReplaceMenu();
        }
        
    }

    private static void validatePassword() {
        String psw = JOptionPane.showInputDialog("Ingrese una contraseña segura"
                + "\nMínimo una mayúscula, "
                + "\nun dígito "
                + "\ny un caracter especial (@$*._-)"
                + "\nEntre 8 y 26 caracteres");
        pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^0-9a-zA-Z])(?=\\S+$).{8,26}$";
        p = Pattern.compile(pattern);
        m = p.matcher(psw);
        if (m.matches()){
            JOptionPane.showMessageDialog(null,"Contraseña correcta");
        }else{
            JOptionPane.showMessageDialog(null,"No es válida la entrada");
        }
    }

    public static void cutAndReplaceMenu() {    
        String menu = "***MENÚ CORTAR Y REEMPLAZAR***"
                + "\n\n 1- Reemplazar todos"
                + "\n 2- Reemplazar el primero"
                + "\n 3- Cortar"
                + "\n 0- Salir\n\n(Ingrese una opción)";
        int option = -1;
        do
        {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(option){
                    case 1: //Reemplazar todos
                        cutAndReplace(option);
                        break;

                    case 2: //Reemplazar el primero
                        cutAndReplace(option);
                        break;

                    case 3:  //Cortar
                        cutAndReplace(option);
                        break;

                    case 0: 
                        break;
                }
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null,"Opción no válida");
            }
        }while(option != 0);
    }


    private static void cutAndReplace(int option) {
        String replaceString = "";
        if(option == 1 || option == 2){
            replaceString = JOptionPane.showInputDialog("Por favor ingrese el string de reemplazo");
        } 
        String s1 = "----------------------------\n";
        if (option == 1){
            s1 = chain.replaceAll(pattern, replaceString); //Reemplazar un patrón por un String
            JOptionPane.showMessageDialog(null, s1);
        }if (option == 2){
            s1 = chain.replaceFirst(pattern, replaceString);
            JOptionPane.showMessageDialog(null, s1);
        }if (option == 3){
            String[] s3 = chain.split(pattern);
            for (int i = 0; i < s3.length; i++) {
                s1 = s1 + s3[i] + "\n----------------------------\n";
            }
            JOptionPane.showMessageDialog(null, s1);
        }
    }
    
}
