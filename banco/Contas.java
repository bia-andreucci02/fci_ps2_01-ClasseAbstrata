package banco;

public abstract class Contas {
    public Contas(){

    }

   public abstract double consultarLimite();

   public abstract void alterarLimite(double Limite);

}
