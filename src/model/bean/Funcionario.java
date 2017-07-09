/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Array;
import java.sql.Date;

/**
 *
 * @author eder
 */
public class Funcionario {
    private int numF;
    private String nome;
    private String telefone;
    private Date dataAdmissao;
    private Array nomeDependentes;
    private String tempoDeServico;

    public int getNumF() {
        return numF;
    }

    public void setNumF(int numF) {
        this.numF = numF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Array getNomeDependentes() {
        return nomeDependentes;
    }

    public void setNomeDependentes(Array nomeDependentes) {
        this.nomeDependentes = nomeDependentes;
    }

    public String getTempoDeServico() {
        return tempoDeServico;
    }

    public void setTempoDeServico(String tempoDeServico) {
        this.tempoDeServico = tempoDeServico;
    }
    
    
    
    
}
