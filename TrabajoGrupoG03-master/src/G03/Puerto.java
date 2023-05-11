package G03;

public class Puerto {
    Hub Puerto []=new Hub[3];

    public Puerto(){
        for(int i=0;i< Puerto.length;i++){
            Puerto[i]=new Hub();
        }
    }

    public void Apilar(Contenedores cont) {
        for (int i = 0; i < 3; i++) {
            if (Puerto[i].ApilarContenedor(cont) == 1) {
                System.out.println("Se ha apilado correctamente");
                break;
            }
        }
    }
    public void Desapilar(int columna) {
        for (int i = 0; i < 3; i++) {
            if (Puerto[i].desapila_contenedor(columna)== 1) {
                System.out.println("Se ha desapilado correctamente");
                break;
            }
        }
    }
    public String Plano() {
        StringBuilder constructor = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            constructor.append(Puerto[i].PlanoHub());
            }
        return constructor.toString();
        }
    public String Datos(int id) {
        StringBuilder constructor = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            constructor.append(Puerto[i].mostrar_datos(id));
        }
        return constructor.toString();
    }
    public String Pais(String Pais) {
        StringBuilder constructor = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            constructor.append(Puerto[i].contenedores_pais(Pais));
        }
        return constructor.toString();
    }
    /*AÑADIDO EN EXAMEN:*/
    public String BuscaPorPrioridad(int prior){
        String aux=new String("");
        for(int i=0;i<3;i++){//FOR PARA RECORRER LOS TRES HUBS
            aux=aux+ Puerto[i].BusquedaPorPrioridadEnHub(prior,i+1)+"\n";
        }
        return aux;
    }
}

