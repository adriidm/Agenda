package com.adri.managers;


import com.adri.model.Contact;

import java.util.LinkedList;

public class ListOfPersons {

    private LinkedList<Contact> listOfPerson = new LinkedList();


    public ListOfPersons() {
    }

    public LinkedList<Contact> getListOfPersons() {
        return listOfPerson;
    }

    public void setListOfPersons(LinkedList<Contact> listOfPersons) {
        this.listOfPerson = listOfPersons;
    }
    public void add(Contact person){
        this.listOfPerson.add(person);
    }
    public void delete(int position){
        this.listOfPerson.remove(position);
    }
    public void print(){
        if(listOfPerson.size() == 0)
        {
            System.out.println(" No hay contactos ");
        }
        for (Contact person: listOfPerson) {
            System.out.println(listOfPerson.indexOf(person) + " - " + person.toString());
        }
    }
    public int NumberOfPersons(){
        return listOfPerson.size();
    }
}


