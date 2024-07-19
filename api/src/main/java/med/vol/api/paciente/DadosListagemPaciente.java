package med.vol.api.paciente;

import med.vol.api.medico.Medico;

public record DadosListagemPaciente(String nome, String email, String telefone) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
