import javax.swing.*;
import java.io.*;

public class FicheroCoches {
    public static void main(String[] args) {
        final String RUTA="vehiculos.txt";
        String matricula= JOptionPane.showInputDialog("Introduce la matrícula");
        String marca=JOptionPane.showInputDialog("Introduce la marca del vehículo");
        String texto=JOptionPane.showInputDialog("Introduce el tamaño del depósito");
        double tamanoDeposito=Double.parseDouble(texto);
        String modelo=JOptionPane.showInputDialog("Introduce el modelo del vehículo");

        try (DataOutputStream dos=new DataOutputStream(new FileOutputStream(RUTA, true));
             DataInputStream dis=new DataInputStream(new FileInputStream(RUTA))){
            introduceDatos(dos, matricula, marca, tamanoDeposito, modelo);
            muestraDatos(dis);
        }catch (EOFException e){

        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void introduceDatos(DataOutputStream dos, String matricula, String marca, double tamanoDeposito, String modelo) throws IOException{
        dos.writeUTF(matricula);
        dos.writeUTF(marca);
        dos.writeDouble(tamanoDeposito);
        dos.writeUTF(modelo);
    }
    public static void muestraDatos (DataInputStream dis) throws IOException{
        //Cuando se acabe el fichero lanzará la excepción
        while (true){
            JOptionPane.showMessageDialog(null, "El vehículo tiene una matrícula " + dis.readUTF()+" su marca es "+dis.readUTF()+ " el tamaño del depósito es "+ dis.readDouble()+ " litros y su modelo es " +dis.readUTF());
        }
    }
}