package med.vol.api.paciente;

import med.vol.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(Long id,
                                       String email,
                                       String telefone,
                                       DadosEndereco endereco) {
}
