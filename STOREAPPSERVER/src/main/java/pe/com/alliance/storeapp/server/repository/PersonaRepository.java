package pe.com.alliance.storeapp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.alliance.storeapp.server.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
