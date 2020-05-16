package com.mycompany.app;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class LeerArchivo {

    public static List<Profesor>  LeerExcel(String ruta) throws IOException {
        List<Profesor> lista = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(new File(ruta));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            int i = 0;
            String Fila[] = new String[8];
            String contenidoCelda ;
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    contenidoCelda = formatter.formatCellValue(cell);
                    Fila[i] = contenidoCelda;
                    i++;
                    if (Fila[0].equals("")) {
                        System.out.println("El archivo esta vacío o ya llego a su linea final");
                        break;
                    } else if (i == 8) {
                        for(int x=1;x<7;x++)
                            Fila[x]= Fila[x].replaceAll("\\s","");

                            //System.out.println(Arrays.toString(Fila));
                            lista.add(new Profesor(Integer.valueOf(Fila[0]), Fila[1], Fila[2], Fila[3], Fila[4], Fila[5], Fila[6], Integer.valueOf(Fila[7])));
                            i = 0;
                        }
                    }
            }
            return lista;
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un problema al tratar de encontrar el archivo...");
            e.printStackTrace();
        }
        return lista;
    }


    public static void printList(List<Profesor> A){
        int i=0;
        System.out.println("--------------------------------------------------------------------");
        while (i <A.size()) {
            System.out.println(A.get(i).getClave()+".- "+A.get(i).getGrado()+" | "+A.get(i).getNombre()+" | "+A.get(i).getApellido()
                    +"\nCorreo:"+A.get(i).getCorreo() +" | Tel: "+A.get(i).getTelefono()+" | Carrera:"+A.get(i).getCarrera()
                    +" | Director:"+A.get(i).getDirector()+"\n--------------------------------------------------------------------");
            i++;
        }
    }

    public static List<Profesor> leerTxt(String Ruta) throws IOException {
        List<Profesor> Lista = new ArrayList<>();
           FileReader fr = null;
        try {
            fr = new FileReader(Ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String C[];

            while ((linea = br.readLine()) != null  ) {
                if(linea.equals(""))
                    break;

                C = linea.split(";");
                for(int x=1;x<7;x++)
                    C[x]= C[x].replaceAll("\\s","");
                
                Lista.add(new Profesor(Integer.valueOf(C[0]),C[1],C[2],C[3],C[4],C[5],C[6],Integer.valueOf(C[7])));
                //System.out.println(Arrays.toString(C));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("\n---Error al abrir archivo,\nDirección o Nombre del Archivo incorrecta---");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return Lista;
    }
}
