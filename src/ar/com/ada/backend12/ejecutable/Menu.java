package ar.com.ada.backend12.ejecutable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import ar.com.ada.backend12.Empleado; 

public class Menu {

	private static final String URL = "jdbc:mysql://localhost:3306/rrhh";
	private static final String USER = "root";
	private static final String PASS = "aconcagua6961";
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Connection conn = null;
		
		System.out.println("Introduzca '1' para crear un empleado en la base de datos");
		System.out.println("Introduzca'2' para consultar un empleado de la base de datos");
		System.out.println("Introduzca '3' para actualizar un empleado de la base de datos");
		System.out.println("Introduzca '4' para eliminar un empleado de la base de datos ");
		System.out.println("----------------------------------------------------------------");
		System.out.print("Introduzca el número de la opción elegida: ");
		int input = s.nextInt();
		
		switch (input) {
			case 1: //CREAR EMPLEADO
				try {
					conn = DriverManager.getConnection(URL, USER, PASS);
					
					System.out.print("Ingrese el ID del nuevo empleado: ");
					int id = s.nextInt();
					System.out.print("Ingrese el nombre del nuevo empleado: ");
					String nombre = s.next();
					System.out.print("Ingrese el apellido del nuevo empleado: ");
					String apellido = s.next();
					System.out.print("Ingrese la provincia del nuevo empleado: "); //Ingresa un solo String porque no puedo utilizar nextLine sin que largue error
					String direccion = s.next();
					System.out.print("Ingrese la fecha de nacimiento del nuevo empleado (yyyy-mm-dd): ");
					String fechaNacimiento = s.next();
					System.out.print("Ingrese el departamento del nuevo empleado: ");
					String departamento = s.next();
					System.out.print("Ingrese la fecha de contratacion del nuevo empleado (yyyy-mm-dd): ");
					String fechaContratacion = s.next();
					System.out.print("Ingrese el salario del nuevo empleado: ");
					int salario = s.nextInt();
					
					Empleado empleado = new Empleado(id, nombre, apellido, direccion, fechaNacimiento, departamento, fechaContratacion, salario);
					
					Empleado.ingresarEmpleado(empleado, conn);

					System.out.println("Fin del programa.");

				} catch (SQLException e) {
					System.out.println("Error en el programa");
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException f) {
							f.printStackTrace();
						}
					}
				}
				break;
			case 2: //CONSULTAR EMPLEADO
				try {
					conn = DriverManager.getConnection(URL, USER, PASS);
					
					System.out.print("Ingrese el ID del empleado a consultar: ");
					int id = s.nextInt();
					
					Empleado.consultarEmpleado(id, conn);

					System.out.println("Fin del programa.");

				} catch (SQLException e) {
					System.out.println("Error en el programa");
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException f) {
							f.printStackTrace();
						}
					}
				}
				break;
			case 3: //ACTUALIZAR EMPLEADO
				try {
					conn = DriverManager.getConnection(URL, USER, PASS);

					System.out.print("Ingrese el id del empleado a actualizar: ");
					int id = s.nextInt();
					
					System.out.print("Ingrese el nuevo nombre: ");
					String nombre = s.next();
					System.out.print("Ingrese el nuevo apellido: ");
					String apellido = s.next();
					System.out.print("Ingrese la nueva direccion: ");
					String direccion = s.next();
					System.out.print("Ingrese la nueva fecha de nacimiento (yyyy-mm-dd): ");
					String fechaNacimiento = s.next();
					System.out.print("Ingrese el nuevo departamento: ");
					String departamento = s.next();
					System.out.print("Ingrese la nueva fecha de contratacion (yyyy-mm-dd): ");
					String fechaContratacion = s.next();
					System.out.print("Ingrese el nuevo salario: ");
					int salario = s.nextInt();		
					
					Empleado.actualizarEmpleado(nombre, apellido, direccion, fechaNacimiento, departamento, fechaContratacion, salario, id, conn);

					System.out.println("Fin del programa.");

				} catch (SQLException e) {
					System.out.println("Error en el programa");
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException f) {
							f.printStackTrace();
						}
					}
				}
				break;
			case 4: //ELIMINAR EMPLEADO
				try {
					conn = DriverManager.getConnection(URL, USER, PASS);
					
					System.out.print("Ingrese el ID del empleado a eliminar: ");
					int id = s.nextInt();
					
					Empleado.eliminarEmpleado(id, conn);

					System.out.println("Fin del programa.");

				} catch (SQLException e) {
					System.out.println("Error en el programa");
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException f) {
							f.printStackTrace();
						}
					}
				}
				break;
			default:
				System.out.println("El valor ingresado no es correcto");
				break;
			}
			
		s.close();
	}
}

