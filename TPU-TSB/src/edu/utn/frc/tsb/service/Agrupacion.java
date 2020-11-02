package edu.utn.frc.tsb.service;

public class Agrupacion {

    private String code;
    private String name;
    private int votos;

    public Agrupacion(String code, String name) {
        this.code = code;
        this.name = name;
        votos = 0;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void sumarVotos(int cantidad){

        votos += cantidad;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Agrupacion{");
        sb.append("code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", votos=").append(votos);
        sb.append('}');
        return sb.toString();
    }
}
