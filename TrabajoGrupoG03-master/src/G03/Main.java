package G03;

public class Main {
    public static void main(String[] args) {
        Hub H=new Hub();
        Contenedores Cont=new Contenedores(12,23,"Alemania",true,1,"Asda".toCharArray(),"asd".toCharArray(),"asda".toCharArray());
        H.PlanoHub();
        H.ApilarContenedor(Cont);
        H.ApilarContenedor(Cont);
        H.ApilarContenedor(Cont);
        H.PlanoHub();
        H.desapila_contenedor(0);
        H.PlanoHub();
        H.mostrar_datos(12);
        H.contenedores_pais("Alemania");
    }
}