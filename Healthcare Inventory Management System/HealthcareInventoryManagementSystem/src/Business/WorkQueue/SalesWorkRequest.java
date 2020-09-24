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
public class SalesWorkRequest extends WorkRequest{
     private double decomposableQuantity;
     private SecondaryTestingKit secondaryTestingKit;
     private PrimaryTestingKit primaryTestingKit;
     private String kitType;

    public double getDecomposableQuantity() {
        return decomposableQuantity;
    }

    public void setDecomposableQuantity(double decomposableQuantity) {
        this.decomposableQuantity = decomposableQuantity;
    }

    public SecondaryTestingKit getSecondaryTestingKit() {
        return secondaryTestingKit;
    }

    public void setSecondaryTestingKit(SecondaryTestingKit secondaryTestingKit) {
        this.secondaryTestingKit = secondaryTestingKit;
    }

    public PrimaryTestingKit getPrimaryTestingKit() {
        return primaryTestingKit;
    }

    public void setPrimaryTestingKit(PrimaryTestingKit primaryTestingKit) {
        this.primaryTestingKit = primaryTestingKit;
    }

    public String getKitType() {
        return kitType;
    }

    public void setKitType(String kitType) {
        this.kitType = kitType;
    }

    
     
     
     
}
