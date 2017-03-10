package pe.com.alliance.storeapp.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.alliance.storeapp.server.domain.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	@Query("SELECT em FROM Empleado em INNER JOIN em.persona")
	public Page<Empleado> buscarPaginacionEmpleados(Pageable pageable);
}
