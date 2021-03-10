

import java.util.ArrayList;
public class Telemovel
{
    private String marca;
    private String modelo;
    private int displayX;
    private int displayY;
    private int dim_armazenamento_mensagens;
    private ArrayList<String> mensagens;
    private int dim_armazenamento_fotos;
    private int dim_armazenamento_apps;
    private int dim_armazenamento_fotos_apps = dim_armazenamento_fotos + dim_armazenamento_apps ;
    private int armazenamento_ocupado;
    private int num_fotos;
    private int num_apps;
    private ArrayList<String> apps;
    


public Telemovel(String marca, String modelo){
    this.marca = marca;
    this.modelo = modelo;
    this.displayX = 4;
    this.displayY = 4;
    this.dim_armazenamento_mensagens = 100;
    this.mensagens = new ArrayList<String> ();
    this.dim_armazenamento_fotos = 100;
    this.dim_armazenamento_apps = 100;
    this.armazenamento_ocupado = 0;
    this.num_fotos = 0;
    this.num_apps = 0;
    this.apps = new ArrayList<String>();
    
}



}
    