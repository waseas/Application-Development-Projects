/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Keshav
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String testResult;
    private PrimaryTestingKit primaryTestingKit;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public PrimaryTestingKit getPrimaryTestingKit() {
        return primaryTestingKit;
    }

    public void setPrimaryTestingKit(PrimaryTestingKit primaryTestingKit) {
        this.primaryTestingKit = primaryTestingKit;
    }

    
    
    
}
