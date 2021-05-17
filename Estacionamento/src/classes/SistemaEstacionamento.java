package classes;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SistemaEstacionamento {
	private CadastroVeiculos veiculos = new CadastroVeiculos();
	private CadastroProprietarios proprietarios = new CadastroProprietarios();
	private CadastroAcessos acessos = new CadastroAcessos();

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.cadastrar(veiculo);
    }
    public void cadastrarProprietario(Proprietario proprietario) {
        proprietarios.cadastrar(proprietario);
    }
    public void cadastrarAcesso(Acesso acesso) {
        acessos.cadastrar(acesso);
    }
    public void listarAcessos(){
    	veiculos.listarAcessos();
    }
    public void listarVeiculos(){
    	veiculos.listar();
    }
    public void listarProprietarios(){
    	proprietarios.listar();
    }
    public Proprietario buscarProprietario(String cnh) {
    	return proprietarios.buscar(cnh);
    }
    public Veiculo buscarVeiculo(String numeroPlaca) {
    	return veiculos.buscar(numeroPlaca);
    }

    public List<Acesso> getAcessos() {
        return acessos.getAcessos();
    }
    public List<Proprietario> getProprietarios() {
        return proprietarios.getProprietarios();
    }
    public List<Veiculo> getVeiculos() {
        return veiculos.getVeiculos();
    }
}
