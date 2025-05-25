package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Pasquale Adriano
 */
public class Recepcionista extends Pessoa {
    private int regFunc;
    private String turno;
    private ArrayList<Registro> registros; // ponteiro multiplicidade 1..*
    
    public Recepcionista(String nome, int regFunc) {
        super(nome);
        this.regFunc = regFunc;
        registros = new ArrayList<>();
    }

    public int getRegFunc() {
        return regFunc;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void addRegistro(Registro registro) {
        registros.add(registro);
    }

}
