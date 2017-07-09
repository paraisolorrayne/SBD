/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author eder
 */
public class ContaCorrente extends Conta{
    private double tarifaMensal;
    
    /**
     * @return the tarifaMensal
     */
    public double getTarifaMensal() {
        return tarifaMensal;
    }

    /**
     * @param tarifaMensal the tarifaMensal to set
     */
    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }
}
