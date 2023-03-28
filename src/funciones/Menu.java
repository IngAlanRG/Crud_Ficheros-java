package funciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import patrones.dto.ArticuloDTO;

public class Menu {

    public void menuOpciones(int opc) {
        FileReader frLeer = null;
        String Status;
        try {
            Captura objC = new Captura();
            ArticuloDTO dto = new ArticuloDTO();
            switch (opc) {
                case 1:
                    System.out.println("Registrar Articulo:");
                    System.out.println("Introduce clave del articulo:");
                    dto.setClaveArt(objC.getString());
                    System.out.println("Introduce descripcion:");
                    dto.setDescripcion(objC.getString());
                    System.out.println("Introduce precio:");
                    dto.setPrecio(Float.parseFloat(objC.getString()));
                    System.out.println("Introduce existencia:");
                    dto.setExistencia(Integer.parseInt(objC.getString()));
                    System.out.println("Estado del articulo se encuentra activo [si/no]:");
                    dto.StatusStock(objC.getString());

                    //Negocio para guardar la información en un archivo
                    try {
                        File archivo = new File(dto.path);
                        FileWriter fw = new FileWriter(archivo, true);
                        PrintWriter pw = new PrintWriter(fw);
                        pw.println(dto.getClaveArt());
                        pw.println(dto.getDescripcion());
                        pw.println(dto.getPrecio());
                        pw.println(dto.getExistencia());
                        pw.print(dto.GetStatusStock());
                        pw.close();
                        System.out.println("simon!");
                    } catch (Exception e) {
                        System.out.println("no simon!");
                    }
                    break;
                case 2:
                    System.out.println("Listar Articulos");
                    try {
                        File archL = new File("C:\\Users\\alan_\\Documents\\ArchArticulo.txt");
                        FileReader fr = new FileReader(archL);
                        BufferedReader br = new BufferedReader(fr);
//                    System.out.println( br.readLine() + "\n" +
//                    br.readLine()+ "\n" +
//                    br.readLine()+ "\n" +
//                    br.readLine()+ "\n" +
//                    br.readLine());
                        String dato = "";
                        while ((dato = br.readLine()) != null) {
                            System.out.println(dato);
                        }
                    } catch (Exception e) {

                    }
                    break;
                case 3:
                    try {
                    ArticuloDTO articuloDTO = new ArticuloDTO();
                    Captura capturar = new Captura();

                    System.out.println("Buscar Articulo");
                    System.out.println("Introduce Clave articulo a buscar:");
                    articuloDTO.setClaveArt(capturar.getString());

                    File archLeer = new File("C:\\Users\\alan_\\Documents\\ArchArticulo.txt");
                    frLeer = new FileReader(archLeer);
                    BufferedReader brLeer = new BufferedReader(frLeer);
                    String dato = "";
                    while ((dato = brLeer.readLine()) != null) {
                        if (articuloDTO.getClaveArt().equals(dato)) {
                            articuloDTO.setClaveArt(dato);
                            articuloDTO.setDescripcion(brLeer.readLine());
                            articuloDTO.setPrecio(Float.parseFloat(brLeer.readLine()));
                            articuloDTO.setExistencia(Integer.parseInt(brLeer.readLine()));
                            System.out.println(articuloDTO.getClaveArt() + "\n"
                                    + articuloDTO.getDescripcion() + "\n"
                                    + articuloDTO.getPrecio() + "\n"
                                    + articuloDTO.getExistencia()
                            );
                        } else {

                        }

                    }
                } catch (Exception e) {

                }
                break;
                case 4:
                    Captura cc = new Captura();
                    ArticuloDTO dd = new ArticuloDTO();

                    System.out.println("Introduce clave articulo a eliminar:");
                    dd.setClaveArt(cc.getString());

                    ArrayList<ArticuloDTO> articulos = new ArrayList<>();
                    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alan_\\Documents\\ArchArticulo.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
//                            String[] parts = line;
                            if (!line.equals(dd.getClaveArt())) {
                                dd.setClaveArt(line);
                                dd.setDescripcion(br.readLine());
                                dd.setPrecio(Float.parseFloat(br.readLine()));
                                dd.setExistencia(Integer.parseInt(br.readLine()));
                                articulos.add(dd);
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo: " + e.getMessage());
                    }

                    try (FileWriter fw = new FileWriter("C:\\Users\\alan_\\Documents\\ArchArticulo.txt"); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
                        for (ArticuloDTO a : articulos) {
                            out.println(a.getClaveArt() + "," + a.getDescripcion() + "," + a.getPrecio() + "," + a.getExistencia());
                        }
                    } catch (IOException e) {
                        System.err.println("Error al escribir el archivo: " + e.getMessage());
                    }

                    break;
                case 5:
                    Captura cm = new Captura();
                    String artMod = "";
                    ArticuloDTO ddm = new ArticuloDTO();
                    System.out.println("Introduce clave del articulo a modificar:");
                    ddm.setClaveArt(cm.getString());
                    artMod = ddm.getClaveArt();
                    ArrayList<ArticuloDTO> articulosM = new ArrayList<>();
                    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alan_\\Documents\\ArchArticulo.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            ddm.setClaveArt(line);
                            ddm.setDescripcion(br.readLine());
                            ddm.setPrecio(Float.parseFloat(br.readLine()));
                            ddm.setExistencia(Integer.parseInt(br.readLine()));
                            articulosM.add(ddm);
                        }

                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo: " + e.getMessage());
                    }
                    try {
                        FileWriter fwm = new FileWriter("C:\\Users\\alan_\\Documents\\ArchArticulo.txt");
                        BufferedWriter bwm = new BufferedWriter(fwm);
                        bwm.write("");
                        bwm.close();

                    } catch (Exception e) {
                        System.err.println("Error al escribir el archivo: " + e.getMessage());
                    }
                    try {
                        for (int i = 0; i < articulosM.size(); i++) {
                            File archivo = new File("C:\\Users\\alan_\\Documents\\ArchArticulo.txt");
                            FileWriter fw = new FileWriter(archivo, true);
                            PrintWriter pw = new PrintWriter(fw);
                            if (articulosM.get(i).getClaveArt().equals(artMod)) {
                                System.out.println(artMod);
                                System.out.println("Introduce nueva clave articulo:");
                                ddm.setClaveArt(cm.getString());
                                System.out.println("Introduce nueva descripción del articulo:");
                                ddm.setDescripcion(cm.getString());
                                System.out.println("Introduce nuevo precio del articulo:");
                                ddm.setPrecio(Float.parseFloat(cm.getString()));
                                System.out.println("Introduce nueva existencia del producto:");
                                ddm.setExistencia(Integer.parseInt(cm.getString()));

                                pw.println(ddm.getClaveArt());
                                pw.println(ddm.getDescripcion());
                                pw.println(ddm.getPrecio());
                                pw.println(ddm.getExistencia());
                            } else {
                                System.out.println(articulosM.get(i).getClaveArt());
                                pw.println(articulosM.get(i).getClaveArt());
                                pw.println(articulosM.get(i).getDescripcion());
                                pw.println(articulosM.get(i).getPrecio());
                                pw.println(articulosM.get(i).getExistencia());
                            }

                            pw.close();
                            System.out.println("simon!");
                        }
                    } catch (Exception e) {
                        System.out.println("no simon!");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } catch (Exception e) {
        }
    }

}
