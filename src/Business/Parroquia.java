/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class Parroquia {
private ArrayList<Fiel>listaFieles;
private ArrayList<Fiel>listaFielesEliminados;
private ArrayList<Diezmo>listaDiezmos;

    public Parroquia() {
        this.listaFieles=new ArrayList<>();
        this.listaDiezmos=new ArrayList<>();
        this.listaFielesEliminados=new ArrayList<>();
    }


    
    public  String   registrarFiel(String cedula  ,String  nombre,
            String telefono, String  direccion, String   estrato){
    String c="El fiel ya se encuentra registrado";
             Fiel   f=this.buscarFiel(cedula);
             if(f==null){
                 f=new Fiel(cedula,nombre,direccion,telefono,Integer.parseInt(estrato));
                 this.listaFieles.add(f);
                 c="Fiel registrado";
             }
        return c;
    }
    
    private Fiel buscarFiel(String   cedula){
    Fiel c=null;
        for(int i=0;i<this.listaFieles.size();i++){
            if(this.listaFieles.get(i).getCedula().equals(cedula)){
                c=this.listaFieles.get(i);
            }
        }
        return c;
    }
    
    public   String   consultarFiel(String   cedula){
    String c = "Fiel no existe";
    Fiel   f=this.buscarFiel(cedula);
             if(f!=null){
                 c=f.getCedula()+"-"+f.getNombre()+"-"+f.getDireccion()+
                         "-"+f.getTelefono()+"-"+f.getEstrato()+"-"+f.getEstado();
             }
    
        return c;
    }
    
    public   String   modificarFiel(String cedula  ,String  nombre,
            String telefono,String  direccion,String   estrato){
    String c = "Fiel no existe";
    Fiel   f=this.buscarFiel(cedula);
             if(f!=null){
                 if(!"".equals(nombre)){
                     f.setNombre(nombre);
                 }
                 if(!"".equals(telefono)){
                     f.setTelefono(telefono);
                 }
                 if(!"".equals(direccion)){
                     f.setDireccion(direccion);
                 }
                 if(!"Seleccione".equals(estrato)){
                     f.setEstrato(Integer.parseInt(estrato));
                 }
                 c = "Fiel actualizado";
             }
    
        return c;
    }
    
    public String eliminarFiel(String cedula) {
    String c="Fallo la eliminacion";
    
    Fiel   f=this.buscarFiel(cedula);
             if(f!=null){
                this.listaFielesEliminados.add(f);
                this.listaFieles.remove(f);
                c="Fiel Eliminado";
             }
    
       return c;
    }
    
    public String totalizarDiezmos() {
    String c = "total diezmos pagados: ";
    Double n = 0d;
    for(int i=0;i<this.listaDiezmos.size();i++){
        n=n+this.listaDiezmos.get(i).getValorDiezmo();
    }
        return c+n;
    }

    
    
    public String consultarDiezmo(String cedula) {
    String c="Fiel no existe";
        Fiel   f=this.buscarFiel(cedula);
             if(f!=null){
                 if(f.getEstrato()==1){
                     c="250000";
                 }else if(f.getEstrato()>1&&f.getEstrato()<4){
                     c="500000";
                 }else if(f.getEstrato()>3){
                     c="1000000";
                 }
             }
        
    return c;
       
    }

    
    public String pagarDiezmo(String cedula, String valorDiezmo) {
       String c="No se pago el diezmo";
         Fiel   f=this.buscarFiel(cedula);
         if(f!=null){
             Diezmo d=new Diezmo(cedula,Double.valueOf(valorDiezmo));
             this.listaDiezmos.add(d);
             f.setEstado("Cumplido");
             c="Pago realizado";
         }else{
             c="Fiel no existe, registrese para poder realizar el pago";
         }
        return c;
    }
    
 /*
    public static void main(String[] args) {
        // TODO code application logic here
    }

  */




    
}
