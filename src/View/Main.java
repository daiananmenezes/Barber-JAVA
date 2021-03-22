
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author Daiana
 */
public class Main {
    
    public static void main(String[] args) {
        String nome = "Thiago";
        System.out.println(nome);
        
        Servico servico = new Servico(1,"Barba", 30);
        
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Thiago", "Rua Teste", "84975630");
        System.out.println(cliente);
        
        Usuario usuario = new Usuario(1,"barbeiro", "senha");
        System.out.println(usuario);
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "09/05/2020 10:20");
        System.out.println(agendamento.getCliente().getNome());
    }
    
}
