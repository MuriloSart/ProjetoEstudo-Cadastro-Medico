package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void Cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

        repository.save(new Medico(dados));
    }


//    @GetMapping
//    public List<DadosListagemMedico> listar(){
//        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//    }
//    Metodo que retorna uma Lista de todos os dados, nao so específicos

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//
//        repository.deleteById(id);
//    }
//    Metodo para exclusao fisica no banco de dados

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){

        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
