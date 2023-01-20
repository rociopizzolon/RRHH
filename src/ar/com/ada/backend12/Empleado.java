package ar.com.ada.backend12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleado {

	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String fechaNacimiento;
	private String departamento;
	private String fechaContratacion;
	private int salario;
	
//----------------------------- CONSTRUCTOR -----------------------------
	public Empleado(int id, String nombre, String apellido, String direccion, String fechaNacimiento,
			String departamento, String fechaContratacion, int salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
		this.fechaContratacion = fechaContratacion;
		this.salario = salario;
	}
	
//----------------------------- METODO INSERT  -----------------------------
	public static void ingresarEmpleado(Empleado empleado, Connection conn) throws SQLException {
		
		Statement stmt = conn.createStatement();

		StringBuilder builder = new StringBuilder(
				"INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, DIRECCION, FECHA_DE_NACIMIENTO, DEPARTAMENTO, FECHA_CONTRATACION, SALARIO) VALUES (");
		builder.append("'" + ((Empleado)empleado).getId() + "'");
		builder.append(",'" + ((Empleado)empleado).getNombre() + "'");
		builder.append(",'" + ((Empleado)empleado).getApellido() + "'");
		builder.append(",'" + ((Empleado)empleado).getDireccion() + "'");
		builder.append(",'" + ((Empleado)empleado).getFechaNacimiento() + "'");
		builder.append(",'" + ((Empleado)empleado).getDepartamento() + "'");
		builder.append(",'" + ((Empleado)empleado).getFechaContratacion() + "'");
		builder.append(",'" + ((Empleado)empleado).getSalario() + "'");
		builder.append(")");
		String sql = builder.toString();
		
		stmt.executeUpdate(sql);

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}	
	}	
	
//----------------------------- METODO SELECT  -----------------------------	
	public static void consultarEmpleado(int inputId, Connection conn) throws SQLException {
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT ID, NOMBRE, APELLIDO, DIRECCION, FECHA_DE_NACIMIENTO, DEPARTAMENTO, FECHA_CONTRATACION, SALARIO FROM EMPLEADO WHERE ID = " + inputId;
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			String direccion = rs.getString("DIRECCION");
			String fechaNacimiento = rs.getString("FECHA_DE_NACIMIENTO");
			String departamento = rs.getString("DEPARTAMENTO");
			String fechaContratacion = rs.getString("FECHA_CONTRATACION");
			int salario = rs.getInt("SALARIO");

			System.out.println(id + ", " + nombre + ", " + apellido + ", " + direccion + ", " + fechaNacimiento + ", " + departamento + ", " + fechaContratacion + ", " + salario);
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
	}

//----------------------------- METODO UPDATE  -----------------------------		
	public static void actualizarEmpleado(String nombre, String apellido, String direccion, String fechaNacimiento,
			String departamento, String fechaContratacion, int salario, int inputId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "UPDATE EMPLEADO SET NOMBRE = ?, APELLIDO = ?, DIRECCION = ?, FECHA_DE_NACIMIENTO = ?, DEPARTAMENTO = ?, FECHA_CONTRATACION = ?, SALARIO = ? WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, nombre);
		pstmt.setString(2, apellido);
		pstmt.setString(3, direccion);
		pstmt.setString(4, fechaNacimiento);
		pstmt.setString(5, departamento);
		pstmt.setString(6, fechaContratacion);
		pstmt.setInt(7, salario);
		pstmt.setInt(8, inputId);

		pstmt.executeUpdate();
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
	}
	
//----------------------------- METODO DELETE  -----------------------------		
	public static void eliminarEmpleado(int inputId, Connection conn) throws SQLException {	
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM EMPLEADO WHERE ID = ?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, inputId);

		pstmt.executeUpdate();
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
	}
	
//----------------------------- GETTERS Y SETTERS -----------------------------		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}	
}
