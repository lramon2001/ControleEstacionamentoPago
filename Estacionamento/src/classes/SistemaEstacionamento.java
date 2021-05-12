
public class SistemaEstacionamento {
	private CadastroVeiculos veiculos;
	private CadastroProprietarios proprietarios;
	private CadastroAcessos acessos;

    public boolean cadastraVeiculo(String marca, String modelo, String numeroPlaca) {
        veiculos.cadastrar(marca,modelo,numeroPlaca);
        return true;
    }
    public boolean cadastraVeiculoMensalista(String marca, String modelo, String numeroPlaca, String cnh) {
    	Proprietario dono;
    	dono=proprietarios.buscarProprietarios(cnh);
    	if(dono==null) {
    		return false;
    	}
        veiculos.cadastrarMensal(marca,modelo,numeroPlaca, dono);
        return true;
    }
    public boolean cadastraMensalista(String nome, String endereco, String nCelular, String nResidencial, String cnh) {
        proprietarios.cadastrar(nome,endereco,nCelular,nResidencial,cnh);
        return true;
    }
    public boolean cadastraAcesso(Date data, LocalDateTime horaEntrada, LocalDateTime horaSaida, String numeroPlaca) {
    	Veiculo veiculo;
    	veiculo=veiculos.buscarVeiculos(numeroPlaca);
    	if(veiculo==null) {
    		return false;
    	}
        acessos.cadastrar(data,horaEntrada,horaSaida,veiculo);
        return true;
    }
    public ArrayList<Acesso> listarAcessos(){
    	return acessos.listar();
    }
    public ArrayList<Veiculo> listarVeiculos(){
    	return veiculos.listar();
    }
    public ArrayList<Proprietario> listarProprietarios(){
    	return proprietarios.listar();
    }
    public Proprietario buscarProprietario(String cnh) {
    	return proprietarios.buscar(cnh);
    }
    public Veiculo buscarVeiculo(String numeroPlaca) {
    	return veiculos.buscar(numeroPlaca);
    }
    public ArrayList<Acesso> buscarAcessos(String numeroPlaca) {
    	return acessos.buscar(numeroPlaca);
    }
}
