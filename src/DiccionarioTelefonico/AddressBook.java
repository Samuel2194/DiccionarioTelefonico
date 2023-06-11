package DiccionarioTelefonico;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, String> directorio;
    String archCSV = ".\\src\\DiccionarioTelefonico\\Files\\Diccionario.csv";

    public AddressBook() {
        directorio = new HashMap<String, String>();
    }
    public boolean Load() {
        boolean result=false;
        String[] direccion;
        try {
            Scanner sc = new Scanner(new File(archCSV));
            sc.useDelimiter(",");   //sets the delimiter pattern
            while (sc.hasNextLine())  //returns a boolean value
            {
                direccion= sc.nextLine().split(",");
                Create(direccion[0],direccion[1]);
            }
            sc.close();

            result = true;
        }catch (Exception e) {
            result = false;
        }

        return result;
    }

    public  String Save(){
        String result="";
        String eol = System.getProperty("line.separator");
        try {
            Writer writer = new FileWriter(archCSV);
            for (Map.Entry<String, String> entry : directorio.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);
            }
            writer.close();
            result= "Se han guardado los cambios";
        }catch (Exception e){
            result ="Ocurrio un problema al guardar los cambios";
        }

        return result;
    }

    public  String List(){
        String result="";
        try {
            for (String i : directorio.keySet()) {
                System.out.println("Numero: " + i + " Nombre: " + directorio.get(i));
            }
        }catch (Exception e){
            result ="Ocurrio un problema al intentar mostrar los contactos";
        }

        return result;
    }

    public String Create(String numero, String nombre){
        String result="";
        try {
            directorio.put(numero,nombre);
            result= "El contacto se ha agregado";
        }catch (Exception e){
            result ="Ocurrio un problema al crear el contacto";
        }

        return result;
    }

    public  String Delete(String numero){
        String result="";
        try {
            directorio.remove(numero);
            result= "El contacto se ha borrado";
        }catch (Exception e){
            result ="Ocurrio un problema al borrar el contacto";
        }

        return result;
    }
}
