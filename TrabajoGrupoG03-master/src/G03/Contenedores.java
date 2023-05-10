package G03;

public class Contenedores{
    private int identificador;
    private int peso;
    private String pais_procedencia;
    private boolean inspeccion;
    private int prioridad;
    private char [] descripcion=new char [100];
    private char [] empresa_envio=new char [20];
    private char [] empresa_recibe=new char [20];

    public Contenedores(int identificador, int peso, String pais_procedencia, boolean inspeccion, int prioridad, char [] descripcion, char [] empresa_envio, char [] empresa_recibe){
        this.identificador=identificador;
        this.peso=peso;
        this.pais_procedencia=pais_procedencia;
        this.inspeccion=inspeccion;
        if(prioridad<1 || prioridad>3){
        }
        else {
            this.prioridad = prioridad;
        }
        this.descripcion=descripcion;
        this.empresa_envio=empresa_envio;
        this.empresa_recibe=empresa_recibe;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setPais_procedencia(String pais_procedencia) {
        this.pais_procedencia = pais_procedencia;
    }

    public void setInspeccion(boolean inspeccion) {
        this.inspeccion = inspeccion;
    }

    public void setPrioridad(int prioridad) {
        if(prioridad<1 || prioridad>3){
        }
        else {
            this.prioridad = prioridad;
        }
    }

    public void setDescripcion(char[] descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpresa_envio(char[] empresa_envio) {
        this.empresa_envio = empresa_envio;
    }

    public void setEmpresa_recibe(char[] empresa_recibe) {
        this.empresa_recibe = empresa_recibe;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getPeso() {
        return peso;
    }

    public String getPais_procedencia() {
        return pais_procedencia;
    }

    public boolean isInspeccion() {
        return inspeccion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public char[] getDescripcion() {
        return descripcion;
    }

    public char[] getEmpresa_envio() {
        return empresa_envio;
    }

    public char[] getEmpresa_recibe() {
        return empresa_recibe;
    }
    public String toString(){
        return "La información de este contenedor es:\n"+"-identificador: "+identificador+
                "\n -peso: "+peso+"\n -pais:"+pais_procedencia+"\n -¿ha sido inspeccionado? "+inspeccion+"\n-descripcion: "
                +descripcion +"\n-empresa que lo envia: "+empresa_envio
                +"\n -empresa que lo va a recibir:"+empresa_recibe;
    }
}
