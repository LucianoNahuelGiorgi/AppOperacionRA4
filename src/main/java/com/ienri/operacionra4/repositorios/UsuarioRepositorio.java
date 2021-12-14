package com.ienri.operacionra4.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ienri.operacionra4.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

	@Query(value="SELECT u FROM Usuario u WHERE u.correo LIKE :correo")
	public Usuario buscarPorCorreo(@Param("correo") String correo);
	
	@Query(value="SELECT u FROM Usuario u WHERE u.correo LIKE :nombreUsuario")
	public Usuario buscarPorNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

	@Query(value="SELECT u FROM Usuario u WHERE u.puesto LIKE 'Jefe de Reactor' AND u.alta = TRUE")
	public List<Usuario> buscarJefeReactorActivo();
	
	@Query(value="SELECT u.nombre, u.apellido FROM Usuario u WHERE u.puesto LIKE 'Jefe de Reactor' AND u.alta = TRUE")
	public List<String> buscarNombreJefeReactorActivo();
	
	@Query(value="SELECT u FROM Usuario u WHERE u.puesto LIKE 'Operador' AND u.alta = TRUE")
	public List<Usuario> buscarOperadorActivo();
	
	@Query(value="SELECT u.nombre, u.apellido FROM Usuario u WHERE u.puesto LIKE 'Operador' AND u.alta = TRUE")
	public List<String> buscarNombreOperadorActivo();	
	
	@Query(value="SELECT u FROM Usuario u WHERE u.puesto LIKE 'Oficial de RP' AND u.alta = TRUE")
	public List<Usuario> buscarOficialRPActivo();
	
	@Query(value="SELECT u.nombre, u.apellido FROM Usuario u WHERE u.puesto LIKE 'Oficial de RP' AND u.alta = TRUE")
	public List<String> buscarNombreOficialRPActivo();
	
	/*
	@Query("SELECT a FROM Administrador a WHERE a.alta = TRUE")
	public List<Administrador> listarActivos();
	
	@Query("SELECT a FROM Administrador a WHERE a.nombre LIKE %:nombre%")
	public List<Administrador> buscarPorNombre(@Param("nombre") String nombre);
	*/
}