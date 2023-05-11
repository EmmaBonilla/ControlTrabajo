/*Emma Bonilla González 1ºA
 * DNI:47445317C*/
package G03;

import java.util.Objects;

public class Hub {
    private Contenedores[][] c;

    public Hub() {
        c = new Contenedores[10][12];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                this.c[i][j] = null;
            }
        }
    }

    public String PlanoHub() {
        StringBuilder constructor = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.c[i][j] == null) {
                    constructor.append("|" + "Libre" + "|");
                } else {
                    constructor.append("|" + "Ocupado" + "|");
                }
            }
            constructor.append("\n");
        }
        constructor.append("\n");
        System.out.println(constructor);
        return constructor.toString();
    }

    public String mostrar_datos(int id) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.c[i][j] != null) {
                    if (this.c[i][j].getIdentificador() == id) {
                        System.out.println(this.c[i][j].toString());
                        return this.c[i][j].toString();
                    }
                }
            }
        }
        System.out.println("Este contenedor no esta en el hub");
        return "Ese contenedor no esta en el hub";
    }

    public String contenedores_pais(String pais) {
        int num_pais = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.c[i][j] != null && this.c[i][j].getPais_procedencia().equals(pais)) {
                    num_pais++;
                }
            }
        }
        System.out.println("El número de contenedores de " + pais + " es de " + num_pais);
        return "El número de contenedores de " + pais + " es de " + num_pais;
    }

    public int desapila_contenedor(int columna) {
        for (int i = 0; i < 10; i++) {
            if (this.c[i][columna] != null) {
                this.c[i][columna] = null;
                System.out.println("Se ha desapilado correctamente");
                return 1;
            } else {
                System.out.println("En la posicion " + (i + 1) + ", " + (columna + 1) + " no hay contenedor");
            }
        }
        return 0;
    }

    public int ApilarContenedor(Contenedores contenedores) {
        if (contenedores.getPrioridad() == 1) {
            for (int i = 9; i >= 0; i--) {
                if (this.c[i][0] == null) {
                    this.c[i][0] = contenedores;
                    return 1;
                } else {
                    System.out.println("La columna " + 1 + " se encuentra llena");
                }
            }
        } else if (contenedores.getPrioridad() == 2) {
            for (int i = 9; i >= 0; i--) {
                if (this.c[i][1] == null) {
                    this.c[i][1] = contenedores;
                    return 1;
                } else {
                    System.out.println("La columna " + 2 + " se encuentra llena");
                }
            }
        } else if (contenedores.getPrioridad() == 3) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 11; j > 1; j--) {
                    if (this.c[i][j] == null) {
                        this.c[i][j] = contenedores;
                        return 1;
                    } else {
                        System.out.println("La columna " + j + " se encuentra llena");
                    }
                }
            }
        }
        return 0;
    }
    /*AÑADIDO EN EXAMEN:*/
    /*public String BusquedaPorPrioridadEnHub(int prioridad,int hub){
        String resultado=new String("");
        for(int columna=0;columna<11;columna++){
            if(this.c[8][columna]!=null){
                if(this.c[8][columna].getPrioridad()==prioridad){
                    resultado=resultado+ "Los datos del contenedor "+ (columna+1)+" en la ultima fila del hub "+hub+" es:\n" +"identificador:"+ this.c[8][columna].getIdentificador()+"\n +empresa remitente:"+this.c[8][columna].getEmpresa_envio()+ "\n -peso:"+this.c[8][columna].getPeso()+"-¿ADUANAS?:"+this.c[8][columna].isInspeccion()+"\n";
                }
            }
    }
        return resultado;
    }*/
    public String BusquedaPorPrioridadEnHub(int prioridad,int hub){
        String resultado=new String("");
        if(prioridad==1){//SI LA PRIORIDAD ES 1 VOY DIRECTAMENTE A LA COLUMNA 1 DEL HUB PORQUE SE COLOCAN ESOS CONTENEDORES AHÍ
            if(this.c[8][0]!=null){//SI EXISTE, GUARDO EN RESULTADO LA INFORMACION DEL CONTENEDOR
                resultado="Los datos del contenedor con prioridad 1 en la ultima fila del hub "+hub+" es:\n" +"identificador:"+ this.c[8][0].getIdentificador()+
                        "\n +empresa remitente:"+this.c[8][0].getEmpresa_envio()+ "\n -peso:"+
                        this.c[8][0].getPeso()+"-¿ADUANAS?:"+this.c[8][0].isInspeccion()+"\n";
                return resultado;
            }else{//SI NO HAY NINGUNO, MUESTRO ESTE MENSAJE
                resultado="No hay contenedor de prioridad 1 en el hub"+hub;
                return resultado;
            }
        }if(prioridad==2){//SI LA PRIORIDAD ES 2 VOY DIRECTAMENTE A LA COLUMNA 2 DEL HUB PORQUE SE COLOCAN ESOS CONTENEDORES AHÍ
            if(this.c[8][1]!=null){//SI EXISTE, GUARDO EN RESULTADO LA INFORMACION DEL CONTENEDOR
                resultado="Los datos del contenedor con prioridad 1 en la ultima fila del hub "+hub+" es:\n" +"identificador:"+ this.c[8][1].getIdentificador()+
                        "\n +empresa remitente:"+this.c[8][1].getEmpresa_envio()+ "\n -peso:"+
                        this.c[8][1].getPeso()+"-¿ADUANAS?:"+this.c[8][1].isInspeccion()+"\n";
                return resultado;
            }else{//SI NO EXISTE, MUESTRO ESTE MENSAJE
                resultado="No hay contenedor de prioridad 2 en el hub"+hub;
                return resultado;
            }
        }if(prioridad>=3){//SI LA PRIORIDAD ES 3 MIRO LAS DEMAS COLUMNAS DEL HUB PORQUE SE COLOCAN ESOS CONTENEDORES AHÍ
            for(int i=2;i<11;i++){
                if(this.c[8][i]!=null){//SI EXISTE, GUARDO EN RESULTADO LA INFORMACION DEL CONTENEDOR
                    resultado=resultado+"Los datos del contenedor con prioridad 1 en la fila"+(i+1)+ "del hub "+hub+" es:\n" +"identificador:"+ this.c[8][i].getIdentificador()+
                            "\n +empresa remitente:"+this.c[8][i].getEmpresa_envio()+ "\n -peso:"+
                            this.c[8][i].getPeso()+"-¿ADUANAS?:"+this.c[8][i].isInspeccion()+"\n";
                }else{//SI NO EXISTE MUESTRO ESTE MENSAJE
                    resultado="No hay contenedor de prioridad 3 en la posicion"+ (i+1)+" del hub "+hub;
                    return resultado;
                }
            }
            return "No hay contenedor de prioridad 3 en ninguno de los hubs";
        }
        return "Introduce una prioridad del 1 al 3";//SI NO ENTRA EN NINGUNO DE LOS BUCLES, LA PRIORIDAD SE HA METIDO MAL
    }
}