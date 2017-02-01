package com.adri;

import com.adri.managers.CommandParser;
import com.adri.managers.ListOfPersons;
import com.adri.model.Command;
import com.adri.model.Contact;
import com.adri.view.Message;
import com.adri.view.Prompt;
import com.adri.managers.File;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;





public class App {
    ListOfPersons agenda = new ListOfPersons();
    File archivo = new File();

    List<String> names = new LinkedList<>();
    List<String> phones = new LinkedList<>();




    public App() {
        Message.title();
        try{
            Initialize();
        }catch (Exception e)
        {
            System.out.println(" La lista de contactos está vacía. ");

        }

    }

    public void bucle() {
        boolean end = false;
        while (!end) {
            Prompt.print(agenda.NumberOfPersons());
            String command = Prompt.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case QUIT:
                    Message.exit();
                    saveInFiles();
                    end = true;
                    break;
                case HELP:
                    Message.printHelp();
                    break;
                case LIST:
                    agenda.print();
                    break;
                case ADD:
                    addperson();
                    break;
                case DELETE:
                    deleteperson();
                    break;
                case UNKNOWN:
                    Message.unknown();
                    break;
            }
        }
    }

    private void saveInFiles() {
        LinkedList<Contact> personasRescribir = agenda.getListOfPersons();
        if(personasRescribir.size()== 0)
        {
            writtingInFile("","");
        }else{
            for (Contact p:personasRescribir) {
                writtingInFile(p.getName(),p.getPhone());
            }
        }
    }


    public void Initialize() {
        List<String> file_names = archivo.readFile("agenda_name.txt");
        List<String> file_phones = archivo.readFile("agenda_phone.txt");
        if(file_names.size() == file_phones.size()){
            for (int i = 0; i <file_names.size() ; i++) {
                Contact p = new Contact();
                p.setName(file_names.get(i));
                p.setPhone(file_phones.get(i));
                agenda.add(p);
            }
        }else{
            System.out.println("Por favor, introduzca un código válido.");
        }
    }

    void addperson(){
        System.out.print("Nombre: ");
        String name = Prompt.read();
        System.out.print("Telefono: ");
        String phone = Prompt.read();
        Contact persona = new Contact(name, phone);
        agenda.add(persona);
        System.out.println("Contacto guardado");
    }

    private void writtingInFile(String name, String phone) {
        try {
            names.add(name);
            archivo.createFile("agenda_name.txt", names);
            phones.add(phone);
            archivo.createFile("agenda_phone.txt", phones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteperson(){
        System.out.println("Qué posición borrar: ");

        try {
            String pos = Prompt.read();
            int position = Integer.parseInt(pos);
            if((position <= agenda.NumberOfPersons()) && position >=0)
            {
                agenda.delete(position);
                System.out.println("Contacto guardado");
            }else{
                System.out.println("ERROR!");
            }
        }catch (Exception e)
        {
            System.out.println("ERROR!");
        }
    }
}
