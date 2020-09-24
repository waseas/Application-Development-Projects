/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Keshav
 */
public class PrimaryTestingKit {
    private int numberOfThroatSwab = 0;
    private int numberOfNasopharyngealSwab = 0;
    private int numberOfPCRMachine = 0;
    private int numberOfECGMachine = 0;
    private String status;

    public int getNumberOfThroatSwab() {
        return numberOfThroatSwab;
    }

    public void setNumberOfThroatSwab(int numberOfThroatSwab) {
        this.numberOfThroatSwab = numberOfThroatSwab;
    }

    public int getNumberOfNasopharyngealSwab() {
        return numberOfNasopharyngealSwab;
    }

    public void setNumberOfNasopharyngealSwab(int numberOfNasopharyngealSwab) {
        this.numberOfNasopharyngealSwab = numberOfNasopharyngealSwab;
    }

    public int getNumberOfPCRMachine() {
        return numberOfPCRMachine;
    }

    public void setNumberOfPCRMachine(int numberOfPCRMachine) {
        this.numberOfPCRMachine = numberOfPCRMachine;
    }

    public int getNumberOfECGMachine() {
        return numberOfECGMachine;
    }

    public void setNumberOfECGMachine(int numberOfECGMachine) {
        this.numberOfECGMachine = numberOfECGMachine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
