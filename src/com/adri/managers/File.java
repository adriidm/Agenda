package com.adri.managers;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class File {
    public void createFile(String file, List<String> arrData)
            throws IOException {
        FileWriter writer = new FileWriter(file);
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1) {
                writer.write("\n");
            }
        }
        writer.close();
    }
    public List<String>readFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {

            System.out.print(" La información no ha sido encontrada ");
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(" No es posible leer los contactos ");
        }
        return lines;
    }
}
