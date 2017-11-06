package proyecto;

import java.io.*;
import java.util.*;

/**
 * Created by codehero on 06/11/17.
 */
public class Empleado {
    private Integer idEmpleado;
    private String nombre;
    private String direccion;
    private String telefono;

    public Scanner sc = new Scanner( System.in );
    public File path = new File("/Users/codehero/Desktop");
    public String categoryFile = "empleados.txt";
    public ArrayList<Empleado> empleadosAL = new ArrayList<Empleado>();

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void initApp(){
        this.cargaArchivoEmpleados();;
        this.menu();
    }

    // Menu Principal
    public void menu(){

        System.out.println("----- Menú -----");
        System.out.println("1.- Agregar Empleado");
        System.out.println("2.- Consultar Empleado");
        System.out.println("3.- Modificar datos de empleado");
        System.out.println("4.- Eliminar empleado");
        System.out.println("5.- Salir");

        System.out.print("\nSelecciona una opción: ");
        Integer opcion = sc.nextInt();
        Integer idSearch;

        switch (opcion){
            case 1:
                this.altaEmpleado();

                System.out.println("\n\n\n");
                this.menu();
                break;
            case 2:
                System.out.print("ID de Empleado a buscar: ");
                idSearch = sc.nextInt();
                sc.nextLine();
                Empleado empleadoEncontrado = this.buscaEmpleado( idSearch );
                if ( empleadoEncontrado != null ){
                    System.out.println("Empleado Encontrado, mostrando datos: ");
                    System.out.println("IdEmpleado: "+ empleadoEncontrado.getIdEmpleado() );
                    System.out.println("Nombre: "+ empleadoEncontrado.getNombre() );
                    System.out.println("Direccion: "+ empleadoEncontrado.getDireccion() );
                    System.out.println("Telefono: "+ empleadoEncontrado.getTelefono() );
                }else{
                    System.out.println("Empleado no encontrado");
                }

                System.out.println("\n\n\n");
                this.menu();
                break;
            case 3:
                System.out.print("ID de Empleado a buscar: ");
                idSearch = sc.nextInt();
                sc.nextLine();
                this.actualizaEmpleado( idSearch );

                System.out.println("\n\n\n");
                this.menu();
                break;
            case 4:
                System.out.print("ID de Empleado a buscar: ");
                idSearch = sc.nextInt();
                sc.nextLine();
                this.eliminaEmpleado( idSearch );

                System.out.println("\n\n\n");
                this.menu();
                break;
            default:
                System.out.println("Gracias por utilizar el sistema!!");

        }
    }

    public void cargaArchivoEmpleados(){
        File archivo = new File(this.path, this.categoryFile);
        Integer line = 0;
        try{
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream(archivo);
                Scanner sc = new Scanner(fis);

                while(sc.hasNext()){
                    String parts[] = sc.nextLine().split("\t");
                    //System.out.println( Arrays.toString(parts) );
                    if(parts.length == 4 && line >= 2){

                        Empleado newEmp = new Empleado();
                        newEmp.setIdEmpleado( Integer.parseInt( parts[0]) );
                        newEmp.setNombre( parts[1] );
                        newEmp.setDireccion( parts[2] );
                        newEmp.setTelefono( parts[3] );
                        this.empleadosAL.add( newEmp );
                    }
                    line++;
                }
                sc.close();
                System.out.println("Empleados cargadas correctamente");
            }
        }catch(IOException ex){
            System.out.printf("Error: %s", ex.toString());
        }
    }

    // Se realiaza un ordenamiento del arrayList empleadosAL
    public void ordenaEmpleados(){
        Collections.sort( this.empleadosAL, new Comparator<Empleado>()
        {
            public int compare(Empleado c1, Empleado c2){
                return Integer.valueOf(c1.getIdEmpleado()).compareTo(c2.getIdEmpleado());
            }
        });
    }

    // Agregamos las categorias al ArrayList categoriaAL
    public void altaEmpleado(){

        try {
            String respuesta;

            // Insertamos empleados hasta que el usuario teclee N
            do{

                Empleado emp = new Empleado();

                System.out.print("idEmpleado: ");
                emp.setIdEmpleado( sc.nextInt() );
                sc.nextLine();

                System.out.print("Nombre: ");
                emp.setNombre( sc.nextLine() );

                System.out.print("Direccion: ");
                emp.setDireccion( sc.nextLine() );

                System.out.print("Telefono: ");
                emp.setTelefono( sc.nextLine() );

                // Agregamos la nueva categoria al array List de categorias
                this.empleadosAL.add( emp );

                System.out.println("\nAgregar un empleado? S/N");
                respuesta = sc.nextLine();

            } while( !respuesta.toUpperCase().equals("N") );

            // Guardamos la categoria en el archivo categoria.txt
            this.guardarEmpleados();
            // Listamos nuevamente los empleados
            this.mostrarEmpleados();

        } catch (Exception e) {
            System.out.println( e.getLocalizedMessage() );
        }
    }

    // Guarda las categorias, en realidad guarda el arrayList categoriaAL
    public void guardarEmpleados(){
        PrintStream ps = null;
        FileOutputStream fos = null;

        File archivo = new File(this.path, this.categoryFile);

        try{
            // Borramos el archivo
            archivo.delete();

            // Ordenamos las categorias
            this.ordenaEmpleados();

            // Guardamos categorias en el archivo
            fos = new FileOutputStream( archivo,true );
            ps = new PrintStream( fos );
            ps.println("idEmpleado\tNombre\tDireccion\tTelefono");
            ps.println("--------------------------------------------------------");

            for(Empleado item : this.empleadosAL){
                ps.println( item.getIdEmpleado()
                        +"\t"+ item.getNombre()
                        +"\t"+ item.getDireccion()
                        +"\t"+ item.getTelefono() );
            }

        }catch(IOException ex){
            System.out.printf("\nHa ocurrido un error: %s", ex.toString() );
        }finally{
            try{
                System.out.println("Los datos han sido guardados");
                ps.close();
            }catch(Exception ex){
                System.out.printf("Error al cerrar el flujo: %s", ex.toString());
            }
        }
    }

    // Agregamos las Mostramos la información de nuestro Array Lista de Empleados
    public void mostrarEmpleados(){
        // Ordenamos las categorias
        this.ordenaEmpleados();

        System.out.println("idEmpleado\tNombre\tDireccion\tTelefono");
        System.out.println("--------------------------------------------------------");
        for(Empleado item : this.empleadosAL){
            System.out.println( item.idEmpleado
                                +"\t"+ item.nombre
                                +"\t"+ item.direccion
                                +"\t"+ item.telefono );
        }
        System.out.println("\n\n\n");

    }

    // Se busca la categoria dependiendo del ID
    public Empleado buscaEmpleado(Integer id){

        for(Empleado item : this.empleadosAL){
            if( item.getIdEmpleado().equals(id) ){
                return item;
            }
        }
        return null;
    }

    // Actualizamos la categoria, dependiendo del ID buscado
    public void actualizaEmpleado(Integer idEmpleado){
        try {

            Empleado empleadoEncontrado = this.buscaEmpleado(idEmpleado);

            if ( empleadoEncontrado != null){

                // Actualizando ID Empleado
                System.out.print("idEmpleado: ");
                String newIdEmpleado = sc.nextLine();

                if( !newIdEmpleado.equals("") ){
                    empleadoEncontrado.setIdEmpleado( Integer.parseInt( newIdEmpleado ) );
                }

                // Actualizando Nombre
                System.out.print("Nombre: ");
                String newNombre = sc.nextLine();

                if( !newNombre.equals("") ){
                    empleadoEncontrado.setNombre( newNombre );
                }

                // Actualizando Direccion
                System.out.print("Dirección: ");
                String newDireccion = sc.nextLine();

                if( !newDireccion.equals("") ){
                    empleadoEncontrado.setDireccion( newDireccion );
                }

                // Actualizando Telefono
                System.out.print("Telefono: ");
                String newTelefono = sc.nextLine();

                if( !newTelefono.equals("") ){
                    empleadoEncontrado.setTelefono( newTelefono );
                }

                // Guardamos la categoria en el archivo categoria.txt
                this.guardarEmpleados();
                // Listamos nuevamente las categorias
                this.mostrarEmpleados();

            }else{
                System.out.println("Empleado no encontrado");
            }

        } catch (Exception e) {
            System.out.println( e.getLocalizedMessage() );
        }
    }

    public void eliminaEmpleado(Integer idEmpleado){

        Boolean itemDeleted = false;

        for (int i = 0; i < this.empleadosAL.size(); i++) {
            if( this.empleadosAL.get(i).getIdEmpleado().equals(idEmpleado) ){
                this.empleadosAL.remove(i);
                itemDeleted = true;
            }
        }

        if (itemDeleted) {

            // Guardamos la categoria en el archivo categoria.txt
            this.guardarEmpleados();
            // Listamos nuevamente las categorias
            this.mostrarEmpleados();

        }else{
            System.out.println("Empleado no encontrado");
        }
    }


}
