package DiccionarioTelefonico;

import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    static AddressBook addressBook = new AddressBook();
    public static void main(String[] args) throws CsvValidationException, IOException {
        if (addressBook.Load()){
            Menu();
        }else{
            System.out.println("Ocurrio un problema al cargar los contactos");
        }
    }
    public static void Menu() throws IOException {
        String opcion="",numero="",nombre="";
        System.out.println("¡Bienvenido!\n¿Que deseas hacer?\n 1) Ver Contactos\n 2) Agregar Contacto\n 3) Eliminar Contacto\n 4) Salir");
        opcion = scanner.readLine();
        switch(opcion.toUpperCase()) {
            case "1": {
                addressBook.List();
                Menu();
                break;
            }
            case "2": {
                System.out.println("Ingresa el numero de telefono");
                numero = scanner.readLine();
                System.out.println("Ingresa el nombre de tu contacto");
                nombre = scanner.readLine();
                if (numero != "" && nombre != ""){
                    if (numero.length()==10){
                        System.out.println(addressBook.Create(numero,nombre));
                    }else{
                        System.out.println("Numero de telefono invalido");
                    }
                }else {
                    System.out.println("Ningun campo puede quedar vacio");
                }
                Menu();
                break;
            }
            case "3": {
                System.out.println("Ingresa el numero de telefono");
                numero = scanner.readLine();
                if (numero != ""){
                    System.out.println(addressBook.Delete(numero));
                }else {
                    System.out.println("Ningun campo puede quedar vacio");
                }
                Menu();
                break;
            }
            case "4": {
                System.out.println(addressBook.Save());
                System.out.println("Adios");
                break;
            }
            default: {
                System.out.println("Opcion invalida");
                Menu();
                break;
            }
        }
    }
}