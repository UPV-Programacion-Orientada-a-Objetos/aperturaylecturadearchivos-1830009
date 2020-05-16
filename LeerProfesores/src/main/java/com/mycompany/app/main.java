package com.mycompany.app;

import java.io.IOException;
import java.util.List;

public class main{

    public static void main(String[] args) throws IOException {
        String ruta= "/home/oten/Documentos/UPV/LeerProfesores/src/main/resources/BD_Profesores.txt";
        List<Profesor> BD_Profesores=LeerArchivo.leerTxt(ruta);
        LeerArchivo.printList(BD_Profesores);

        ruta= "/home/oten/Documentos/UPV/LeerProfesores/src/main/resources/Profesores.xlsx";
        BD_Profesores = LeerArchivo.LeerExcel(ruta);
        LeerArchivo.printList(BD_Profesores);

    }


}
/*

 */