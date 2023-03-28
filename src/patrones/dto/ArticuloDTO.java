package patrones.dto;

public class ArticuloDTO {

    private String claveArt;
    private String descripcion;
    private float precio;
    private int existencia;
    public String path = "C:\\Users\\alan_\\Documents\\ArchArticulo.txt";
    private String Status = "";
    private String valor;
  

    /**
     * @return the claveArt
     */
    public String getClaveArt() {
        return claveArt;
    }

    /**
     * @param claveArt the claveArt to set
     */
    public void setClaveArt(String claveArt) {
        this.claveArt = claveArt;

    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the existencia
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void StatusStock(String CantidadStock) { 
        if (CantidadStock.equals("si")) {
            System.out.println("Feliz felicius Tu producto si lo topo");
            valor = "su valor es ( 0 ) Stock activo";
        } else {
            System.out.println("Tu producto ni lo topo");
            valor = "su valor es ( 1 ) Stock inactivo";
        }
    }
    public String GetStatusStock(){
        return valor;
    }
    
    

}
