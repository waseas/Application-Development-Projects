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
public class ManufactureringTestWorkrequest extends WorkRequest{
    private String kitType;
    private double decomposableQuantity;
    private PrimaryTestingKit primaryTestingKit;    
    private SecondaryTestingKit secondaryTestingKit;

    public String getKitType() {
        return kitType;
    }

    public void setKitType(String kitType) {
        this.kitType = kitType;
    }
    
    public double getDecomposableQuantity() {
        return decomposableQuantity;
    }

    public void setDecomposableQuantity(double decomposableQuantity) {
        this.decomposableQuantity = decomposableQuantity;
    }

    public PrimaryTestingKit getPrimaryTestingKit() {
        return primaryTestingKit;
    }

    public void setPrimaryTestingKit(PrimaryTestingKit primaryTestingKit) {
        this.primaryTestingKit = primaryTestingKit;
    }

    public SecondaryTestingKit getSecondaryTestingKit() {
        return secondaryTestingKit;
    }

    public void setSecondaryTestingKit(SecondaryTestingKit secondaryTestingKit) {
        this.secondaryTestingKit = secondaryTestingKit;
    }

    
    @Override
    public String toString() {
        return  kitType ;
    }
    
    
    
}
