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
public class WasteCollectorWorkRequest extends WorkRequest{
    private String wasteType;
    private double decomposingQuantity;

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public double getDecomposingQuantity() {
        return decomposingQuantity;
    }

    public void setDecomposingQuantity(double decomposingQuantity) {
        this.decomposingQuantity = decomposingQuantity;
    }
    
    
    
}
