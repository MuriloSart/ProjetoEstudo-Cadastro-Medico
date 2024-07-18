package med.vol.api.paciente;

import med.vol.api.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> { }