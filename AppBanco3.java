import static utils.ES.*;
import banco.ContaEspecial;
import banco.ContaBancaria;

public class AppBanco3{
   private static ContaBancaria [] contas =
    { new ContaEspecial("Luisa",15000, 5000),
      new ContaEspecial("Pedro",10000,2000 ),
      new ContaBancaria("Bob", 100.00)
    };



    public static void main (String[] args){
        print("## BANCO v3");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Mostrar informações das contas");
            print("(2) Depositar em todas");
            print("(3) Sacar em todas");
            print("(4) aumentar limite das especiais");
            print("(5) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoMostrarInfo();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            } 
            else if (opcao == 4){
                opcaoAlterarLimite();
            }
            else if (opcao == 5) {
                sair = true;
            } 
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    }

    private static void opcaoMostrarInfo() {
        print("\n## Informações das contas:");
        for (int i=0; i<contas.length; i++) {
            print(contas[i].toString());
        }
    }

    private static void opcaoDepositar(){
        double valor = inputDouble("\n## Valor para depósito:");
        for (int i= 0; i<contas.length; i++){
            contas[i].depositar(valor);
            print("\n## Depósito efetuado na conta de " 
            + contas[i].getNomeCorrentista() + "!");
        }
    }

    private static void opcaoSacar(){
        double valor = inputDouble("\n## Valor para saque:");
        for(int i = 0 ; i<contas.length; i++){ 
          if(contas[i].sacar(valor)){
            contas[i].sacar(valor);
            print("\n## Saque efetuado na conta de "
            + contas[i].getNomeCorrentista() + "!");
          }
          else{
            print("\n## Saldo insuficiente para efetuar o saque na conta de"
            + contas[i].getNomeCorrentista() + "!");
          }
    }
        
    }

    private static void opcaoAlterarLimite(){
      double valor = inputDouble("## Valor a ser adicionado ao limite das especias:");
        for (int i =0; i<contas.length; i++){
            contas[i].alterarLimite(valor + contas[i].consultarLimite());
            print("\n## O limite foi alterado na conta de " 
            + contas[i].getNomeCorrentista() + "!");
        }
    } 

    

    


}