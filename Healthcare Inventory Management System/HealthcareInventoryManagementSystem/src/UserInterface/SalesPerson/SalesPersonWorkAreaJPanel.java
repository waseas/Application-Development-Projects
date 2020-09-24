/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SalesPerson;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HospitalOrganization;
import Business.Organization.NGOOrganization;
import Business.Organization.SalesOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SecondaryTestingKit;
import Business.WorkQueue.HospitalWorkRequest;
import Business.WorkQueue.NGOWorkRequest;
import Business.WorkQueue.PrimaryTestingKit;
import Business.WorkQueue.SalesWorkRequest;
import Business.WorkQueue.ManufactureringTestWorkrequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ajith
 */
public class SalesPersonWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesPersonWorkAreaJPanel
     */
    JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private SalesOrganization salesOrganization;
    private SalesWorkRequest request;
    ArrayList<WorkRequest> result = new ArrayList<>();

    public SalesPersonWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, SalesWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.request = request;
        this.salesOrganization = (SalesOrganization) organization;
        result = business.getWorkQueue().getWorkRequestList();
        populateTable();
    }

    public void populateTable() {

        String kitType = request.getKitType();
        jLabel2.setText(kitType);
        for (int i = 0; i < result.size(); i++) {
            ManufactureringTestWorkrequest manufactureringTestWorkrequest = (ManufactureringTestWorkrequest) result.get(i);
            if ("Secondary Testing Kit".equalsIgnoreCase(kitType)) {

                DefaultTableModel defaultTableModel = (DefaultTableModel) kitsJTable.getModel();
                defaultTableModel.setRowCount(0);
                SecondaryTestingKit secondaryTestingKit = manufactureringTestWorkrequest.getSecondaryTestingKit();
                if (secondaryTestingKit != null) {
                    for (int j = 0; j < 5; j++) {
                        Object row[] = new Object[2];
                        if (j == 0) {
                            row[0] = "Number Of Thermometers";
                            row[1] = String.valueOf(secondaryTestingKit.getNumberOfThermometers()) == null ? 0 : secondaryTestingKit.getNumberOfThermometers();
                        } else if (j == 1) {
                            row[0] = "Number Of Sphygmomanometer";
                            row[1] = String.valueOf(secondaryTestingKit.getNumberOfSphygmomanometer()) == null ? 0 : secondaryTestingKit.getNumberOfSphygmomanometer();
                        } else if (j == 2) {
                            row[0] = "Number Of Glucosemeter";
                            row[1] = String.valueOf(secondaryTestingKit.getNumberOfGlucoseMeter()) == null ? 0 : secondaryTestingKit.getNumberOfGlucoseMeter();
                        } else if (j == 3) {
                            row[0] = "Number Of Stethoscopes";
                            row[1] = String.valueOf(secondaryTestingKit.getNumberOfStethoscopes()) == null ? 0 : secondaryTestingKit.getNumberOfStethoscopes();;
                        } else if (j == 4) {
                            row[0] = "Number Of Masks";
                            row[1] = String.valueOf(secondaryTestingKit.getNumberOfMasks()) == null ? 0 : secondaryTestingKit.getNumberOfMasks();;
                        }
                        defaultTableModel.addRow(row);
                    }
                }
            } else if ("Primary Testing Kit".equalsIgnoreCase(kitType)) {
                DefaultTableModel model = (DefaultTableModel) kitsJTable.getModel();
                model.setRowCount(0);
                PrimaryTestingKit primaryTestingKit = manufactureringTestWorkrequest.getPrimaryTestingKit();
                if (primaryTestingKit != null) {
                    for (int j = 0; j < 5; j++) {
                        Object row[] = new Object[2];
                        if (j == 0) {
                            row[0] = "Number Of Throat Swab";
                            row[1] = (String.valueOf(primaryTestingKit.getNumberOfThroatSwab())) == null ? 0 : primaryTestingKit.getNumberOfThroatSwab();
                        } else if (j == 1) {
                            row[0] = "Number Of Nasopharyngeal Swab";
                            row[1] = (String.valueOf(primaryTestingKit.getNumberOfNasopharyngealSwab())) == null ? 0 : primaryTestingKit.getNumberOfNasopharyngealSwab();
                        } else if (j == 2) {
                            row[0] = "Number Of PCR Machine";
                            row[1] = (String.valueOf(primaryTestingKit.getNumberOfPCRMachine())) == null ? 0 : primaryTestingKit.getNumberOfPCRMachine();
                        } else if (j == 3) {
                            row[0] = "Number Of ECG Machine";
                            row[1] = (String.valueOf(primaryTestingKit.getNumberOfECGMachine())) == null ? 0 : primaryTestingKit.getNumberOfECGMachine();
                        }
                        model.addRow(row);
                    }
                }
            }
        }
        if ("Primary Testing Kit".equals(kitType)) {
            jLabel7.setText("Number Of Throat Swab");
            jLabel8.setText("Number Of Nasopharyngeal Swab");
            jLabel6.setText("Number Of PCR Machine");
            jLabel5.setText("Number Of ECG Machine");
            jLabel9.setVisible(false);
            JText5.setVisible(false);

            JText1.setText(String.valueOf(request.getPrimaryTestingKit().getNumberOfThroatSwab()));
            JText2.setText(String.valueOf(request.getPrimaryTestingKit().getNumberOfNasopharyngealSwab()));
            JText3.setText(String.valueOf(request.getPrimaryTestingKit().getNumberOfPCRMachine()));
            JText4.setText(String.valueOf(request.getPrimaryTestingKit().getNumberOfECGMachine()));
        } else if ("Secondary Testing Kit".equals(kitType)) {
            jLabel7.setText("Number Of Thermometers");
            jLabel8.setText("Number Of Sphygmomanometer");
            jLabel6.setText("Number Of Glucosemeter");
            jLabel5.setText("Number Of Stethoscopes");
            jLabel9.setVisible(true);
            jLabel9.setText("Number Of Masks");

            JText1.setText(String.valueOf(request.getSecondaryTestingKit().getNumberOfThermometers()));
            JText2.setText(String.valueOf(request.getSecondaryTestingKit().getNumberOfSphygmomanometer()));
            JText3.setText(String.valueOf(request.getSecondaryTestingKit().getNumberOfGlucoseMeter()));
            JText4.setText(String.valueOf(request.getSecondaryTestingKit().getNumberOfStethoscopes()));
            JText5.setVisible(true);
            JText5.setText(String.valueOf(request.getSecondaryTestingKit().getNumberOfMasks()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        kitsJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JText1 = new javax.swing.JTextField();
        JText2 = new javax.swing.JTextField();
        JText3 = new javax.swing.JTextField();
        JText4 = new javax.swing.JTextField();
        processJButton = new javax.swing.JButton();
        JText5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        kitsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kit Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(kitsJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Requested Quantity : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("jLabel1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("jLabel3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("jLabel4");

        JText1.setEnabled(false);

        JText2.setEnabled(false);

        JText3.setEnabled(false);

        JText4.setEnabled(false);
        JText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText4ActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 102, 204));
        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        JText5.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("jLabel5");

        backJButton.setBackground(new java.awt.Color(0, 102, 204));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText(" x");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MANAGE SALES REQUESTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JText1)
                                    .addComponent(JText2)
                                    .addComponent(JText3)
                                    .addComponent(JText4)
                                    .addComponent(JText5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(processJButton)))
                        .addGap(144, 144, 144)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(210, 210, 210)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(backJButton))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 405, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(JText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(processJButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int count = kitsJTable.getRowCount();
        if (count == 0) {
            if (jLabel2.getText().equals("Primary Testing Kit")) {
                Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof HospitalOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }
                HospitalWorkRequest hospitalWorkRequest = new HospitalWorkRequest();
                hospitalWorkRequest.setSender(userAccount);
                hospitalWorkRequest.setStatus("Sent");
                hospitalWorkRequest.setTestResult("Request cannot be processed as there are no items.");
                hospitalWorkRequest.setAmount(0.0);
                hospitalWorkRequest.setMessage("Request cannot be processed as there are no items.");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                }
            } else if (jLabel2.getText().equals("Secondary Testing Kit")) {
                Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof NGOOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }
                NGOWorkRequest ngorequest = new NGOWorkRequest();
                ngorequest.setSender(userAccount);
                ngorequest.setStatus("Sent");
                ngorequest.setTestResult("Request cannot be processed as there are no items.");
                ngorequest.setAmount(0.0);
                ngorequest.setMessage("Request cannot be processed as there are no items.");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                }
            }
            request.setStatus("completed");
            JOptionPane.showMessageDialog(null, "Request cannot be processed as there are no items");
            return;
        }
        if (jLabel2.getText().equals("Primary Testing Kit")) {
            int throatSwab = (int) kitsJTable.getValueAt(0, 1);
            int nasopharyngealSwab = (int) kitsJTable.getValueAt(1, 1);
            int pcrMachine = (int) kitsJTable.getValueAt(2, 1);
            int ecgMachine = (int) kitsJTable.getValueAt(3, 1);

            int approvedThroatSwab = Integer.parseInt(JText1.getText());
            int approvedNasopharyngealSwab = Integer.parseInt(JText2.getText());
            int approvedPcrMachine = Integer.parseInt(JText3.getText());
            int approvedEcgMachine = Integer.parseInt(JText4.getText());

            HospitalWorkRequest hospitalWorkRequest = new HospitalWorkRequest();
            hospitalWorkRequest.setSender(userAccount);
            hospitalWorkRequest.setStatus("Sent");
            String testResult = "";
            int lesserThroatSwab = 0;
            int lesserNasopharyngealSwab = 0;
            int lesserPcrMachine = 0;
            int lesserEcgMachine = 0;

            Organization org = null;
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof HospitalOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            double amount = 0.0;
            if (approvedThroatSwab <= throatSwab && approvedNasopharyngealSwab <= nasopharyngealSwab && approvedPcrMachine <= pcrMachine && approvedEcgMachine <= ecgMachine) {
                JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to Hospitals for Payment Details");
                hospitalWorkRequest.setTestResult("Completed");

                amount = (throatSwab * 0.75) + (nasopharyngealSwab * 1) + (pcrMachine * 30) + (ecgMachine * 10);
                hospitalWorkRequest.setAmount(amount);
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                }
                hospitalWorkRequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedThroatSwab > throatSwab || approvedNasopharyngealSwab > nasopharyngealSwab || approvedPcrMachine > pcrMachine || approvedEcgMachine > ecgMachine) {
                if (approvedThroatSwab > throatSwab) {
                    amount = amount + (throatSwab * 0.75);
                    lesserThroatSwab = approvedThroatSwab - throatSwab;
                    testResult = lesserThroatSwab + " " + "Throat Swab are lesser in quantity. ";
                } else {
                    amount = amount + (approvedThroatSwab * 0.75);
                }
                if (approvedNasopharyngealSwab > nasopharyngealSwab) {
                    amount = amount + (nasopharyngealSwab * 1);
                    lesserNasopharyngealSwab = approvedNasopharyngealSwab - nasopharyngealSwab;
                    testResult = testResult + lesserNasopharyngealSwab + " " + "Nasopharyngeal Swab are lesser in quantity. ";
                } else {
                    amount = amount + (approvedNasopharyngealSwab * 1);
                }
                if (approvedPcrMachine > pcrMachine) {
                    amount = amount + (pcrMachine * 30);
                    lesserPcrMachine = approvedPcrMachine - pcrMachine;
                    testResult = testResult + lesserPcrMachine + " " + "PCR Machines are lesser in quantity. ";
                } else {
                    amount = amount + (approvedPcrMachine * 30);
                }
                if (approvedEcgMachine > ecgMachine) {
                    amount = amount + (ecgMachine * 10);
                    lesserEcgMachine = approvedEcgMachine - ecgMachine;
                    testResult = testResult + lesserEcgMachine + " " + "ECG Machines are lesser in quantity. ";
                } else {
                    amount = amount + (approvedEcgMachine * 10);
                }
                hospitalWorkRequest.setAmount(amount);
                hospitalWorkRequest.setTestResult(testResult);

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
                    JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to Hospital as requested quantity is not available. ");
                }
                hospitalWorkRequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedThroatSwab > throatSwab && approvedNasopharyngealSwab > nasopharyngealSwab && approvedPcrMachine > pcrMachine && approvedEcgMachine > ecgMachine) {
                hospitalWorkRequest.setMessage("Request Cannot be Processed.");
                hospitalWorkRequest.setAmount(0.0);
                hospitalWorkRequest.setTestResult("All the requested quantities are not available.");
            }

            for (int i = 0; i < result.size(); i++) {
                ManufactureringTestWorkrequest manufactureringTestWorkrequest = (ManufactureringTestWorkrequest) result.get(i);
                PrimaryTestingKit primaryTestingKit = manufactureringTestWorkrequest.getPrimaryTestingKit();
                if (lesserThroatSwab == 0) {
                    primaryTestingKit.setNumberOfThroatSwab(throatSwab - approvedThroatSwab);
                }
                if (lesserNasopharyngealSwab == 0) {
                    primaryTestingKit.setNumberOfNasopharyngealSwab(nasopharyngealSwab - approvedNasopharyngealSwab);
                }
                if (lesserPcrMachine == 0) {
                    primaryTestingKit.setNumberOfPCRMachine(pcrMachine - approvedPcrMachine);
                }
                if (lesserEcgMachine == 0) {
                    primaryTestingKit.setNumberOfECGMachine(ecgMachine - approvedEcgMachine);
                }
            }
            populateTable();
            request.setStatus("completed");
        } else if (jLabel2.getText().equals("Secondary Testing Kit")) {
            int thermometers = (int) kitsJTable.getValueAt(0, 1);
            int sphygmomanometer = (int) kitsJTable.getValueAt(1, 1);
            int glucoseMeter = (int) kitsJTable.getValueAt(2, 1);
            int stethoscopes = (int) kitsJTable.getValueAt(3, 1);
            int masks = (int) kitsJTable.getValueAt(4, 1);

            int approvedThermometers = Integer.parseInt(JText3.getText());
            int approvedSphygmomanometer = Integer.parseInt(JText4.getText());
            int approvedGlucoseMeter = Integer.parseInt(JText2.getText());
            int approvedStethoscopes = Integer.parseInt(JText1.getText());
            int approvedMasks = Integer.parseInt(JText5.getText());

            NGOWorkRequest ngorequest = new NGOWorkRequest();
            ngorequest.setSender(userAccount);
            ngorequest.setStatus("Sent");
            String testResult = "";
            int lesserThermometers = 0;
            int lesserSphygmomanometer = 0;
            int lesserGlucoseMeter = 0;
            int lesserStethoscopes = 0;
            int lesserMasks = 0;

            Organization org = null;
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof NGOOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            double amount = 0.0;
            if (approvedThermometers <= thermometers && approvedSphygmomanometer <= sphygmomanometer && approvedGlucoseMeter <= glucoseMeter && approvedStethoscopes <= stethoscopes && approvedMasks <= masks) {
                JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to NGO for payment details. ");
                ngorequest.setTestResult("Completed");

                amount = (approvedThermometers * 30) + (approvedSphygmomanometer * 25) + (approvedGlucoseMeter * 1) + (approvedStethoscopes * 10) + (approvedMasks * 25);
                ngorequest.setAmount(amount);
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                }
                ngorequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedThermometers > thermometers || approvedSphygmomanometer > sphygmomanometer || approvedGlucoseMeter > glucoseMeter || approvedStethoscopes > stethoscopes || approvedMasks > masks) {
                if (approvedThermometers > thermometers) {
                    amount = amount + (thermometers * 30);
                    lesserThermometers = approvedThermometers - thermometers;
                    testResult = lesserThermometers + " " + "Thermometers are lesser in quantity. ";
                } else {
                    amount = amount + (approvedThermometers * 30);
                }
                if (approvedSphygmomanometer > sphygmomanometer) {
                    amount = amount + (sphygmomanometer * 25);
                    lesserSphygmomanometer = approvedSphygmomanometer - sphygmomanometer;
                    testResult = testResult + lesserSphygmomanometer + " " + "Sphygmomanometer are lesser in quantity. ";
                } else {
                    amount = amount + (sphygmomanometer * 20);
                }
                if (approvedGlucoseMeter > glucoseMeter) {
                    amount = amount + (glucoseMeter * 1);
                    lesserGlucoseMeter = approvedGlucoseMeter - glucoseMeter;
                    testResult = testResult + lesserGlucoseMeter + " " + "GlucoseMeter are lesser in quantity. ";
                } else {
                    amount = amount + (glucoseMeter * 1);
                }
                if (approvedStethoscopes > stethoscopes) {
                    amount = amount + (stethoscopes * 25);
                    lesserStethoscopes = approvedStethoscopes - stethoscopes;
                    testResult = testResult + lesserStethoscopes + " " + "Stethoscopes are lesser in quantity. ";
                } else {
                    amount = amount + (stethoscopes * 25);
                }
                if (approvedMasks > masks) {
                    amount = amount + (masks * 10);
                    lesserMasks = approvedMasks - masks;
                    testResult = testResult + lesserMasks + " " + "Masks are lesser in quantity. ";
                } else {
                    amount = amount + (masks * 10);
                }
                ngorequest.setAmount(amount);
                ngorequest.setTestResult(testResult);
                ngorequest.setMessage("Request Processed.Please complete the payment");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                    JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to NGO as requested quantity is not available.");
                }
            } else if (approvedThermometers > thermometers || approvedSphygmomanometer > sphygmomanometer || approvedGlucoseMeter > glucoseMeter || approvedStethoscopes > stethoscopes || approvedMasks > masks) {
                ngorequest.setMessage("Request Cannot be Processed.");
                ngorequest.setAmount(0.0);
                ngorequest.setTestResult("All the requested quantities are not available.");

            }
            for (int i = 0; i < result.size(); i++) {
                ManufactureringTestWorkrequest manufactureringTestWorkrequest = (ManufactureringTestWorkrequest) result.get(i);
                SecondaryTestingKit secondaryTestingKit = manufactureringTestWorkrequest.getSecondaryTestingKit();
                if (lesserThermometers == 0) {
                    secondaryTestingKit.setNumberOfThermometers(thermometers - approvedThermometers);
                }
                if (lesserSphygmomanometer == 0) {
                    secondaryTestingKit.setNumberOfSphygmomanometer(sphygmomanometer - approvedSphygmomanometer);
                }
                if (lesserGlucoseMeter == 0) {
                    secondaryTestingKit.setNumberOfGlucoseMeter(glucoseMeter - approvedGlucoseMeter);
                }
                if (lesserStethoscopes == 0) {
                    secondaryTestingKit.setNumberOfStethoscopes(stethoscopes - approvedStethoscopes);
                }
                if (lesserMasks == 0) {
                    secondaryTestingKit.setNumberOfMasks(masks - approvedMasks);
                }
            }
            populateTable();
            request.setStatus("completed");
        }
        JText1.setText("");
        JText2.setText("");
        JText3.setText("");
        JText4.setText("");
        JText5.setText("");
    }//GEN-LAST:event_processJButtonActionPerformed

    private void JText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText4ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JText1;
    private javax.swing.JTextField JText2;
    private javax.swing.JTextField JText3;
    private javax.swing.JTextField JText4;
    private javax.swing.JTextField JText5;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable kitsJTable;
    private javax.swing.JButton processJButton;
    // End of variables declaration//GEN-END:variables
}
