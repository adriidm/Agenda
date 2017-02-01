package com.adri.view;


public class Message {

    public static void printHelp (){
        System.out.println("HELP\t\t Instrucciones de uso de la aplicación \n"
                + "QUIT (Q)\t\t Salir del Programa \n"
                + "LIST(L)\t\t Lista de Contactos \n"
                + "ADD(A)\t\t Añadir a Lista de Contactos \n"
                + "DELETE(D)\t\t Borrar de la Lista de Contactos \n");
    }
    public static void title(){
        System.out.println("Bienvenido a la Agenda");
    }

    public static void exit() {
        System.out.println("Nos vemos!!");
    }

    public static void unknown() {
        System.out.println("No se reconoce el comando... Presiona 'H' o 'help'");
    }
}
