package edu.mum.cs.asd.framework.view;

import edu.mum.cs.asd.framework.controller.ExitHandler;
import edu.mum.cs.asd.framework.controller.FinancialCompany;
import edu.mum.cs.asd.framework.controller.TransactionHandler;
import edu.mum.cs.asd.framework.model.Account;
import edu.mum.cs.asd.framework.model.ApplicationNatureEnum;
import edu.mum.cs.asd.framework.model.Customer;
import edu.mum.cs.asd.framework.model.Factory;
import edu.mum.cs.asd.framework.model.FinancialProperties;
import edu.mum.cs.asd.framework.model.PropertiesEnum;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public abstract class GUI extends JFrame {

    protected JPanel topActionsPanel;
    protected JScrollPane scroller;

    protected JTable datatable;
    protected ActionButton depositBtn;
    protected ActionButton withdrawBtn;
    protected ActionButton exitBtn;
    protected ActionButton undoBtn;
    protected ActionButton redoBtn;
    protected Factory factory;
    protected FinancialCompany controller;
    protected FinancialProperties properties;

    public GUI(FinancialCompany controller, String title, ApplicationNatureEnum nature) {
        super(title);
        this.controller = controller;
//        properties = new FinancialProperties();
        
        initComponents(nature);
    }

    private void initComponents(ApplicationNatureEnum nature) {
        topActionsPanel = createActionButtons();
        scroller = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 320);
        setVisible(false);
        
        datatable = new JTable();
        datatable.setModel(createModel());
        datatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroller.setViewportView(datatable);

        depositBtn = new ActionButton("Deposit", new TransactionHandler());
        depositBtn.addActionListener(controller);
//        String appNature = properties.getProperty(PropertiesEnum.APP_NATURE.getVal());
        if (nature.equals(ApplicationNatureEnum.DEBIT)) {
            withdrawBtn = new ActionButton(PropertiesEnum.WITHDRAW.getVal(), new TransactionHandler());
        }else{
            withdrawBtn = new ActionButton(PropertiesEnum.CHARGE.getVal(), new TransactionHandler());
        }
        withdrawBtn.addActionListener(controller);
        exitBtn = new ActionButton("Exit", new ExitHandler());
        exitBtn.addActionListener(controller);
        
        getContentPane().add(getEastActionsPanel(), BorderLayout.EAST);
        getContentPane().add(scroller, BorderLayout.CENTER);
        getContentPane().add(topActionsPanel, BorderLayout.NORTH);

    }

    public JPanel getEastActionsPanel(){
        JPanel eastActionsPanel = new JPanel();
        
        eastActionsPanel.setLayout(new BoxLayout(eastActionsPanel, BoxLayout.Y_AXIS));
        eastActionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        depositBtn.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        withdrawBtn.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        exitBtn.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        
        eastActionsPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        eastActionsPanel.add(depositBtn);
        eastActionsPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        eastActionsPanel.add(withdrawBtn);
        eastActionsPanel.add(Box.createRigidArea(new Dimension(10, 40)));
        eastActionsPanel.add(exitBtn);
        
        return eastActionsPanel;
    }
    
    public void updateData(Customer customer, Account account) {
        addToDataModel(customer, account, getModel());
    }

    public void updateCell(Object obj, int id) {
        datatable.setValueAt(obj, datatable.getSelectedRow(), id);
    }

    protected DefaultTableModel getModel() {
        return (DefaultTableModel) datatable.getModel();
    }

    public FinancialCompany getController() {
        return controller;
    }

    public abstract JPanel createActionButtons();

    public abstract DefaultTableModel createModel();

    public abstract void addToDataModel(Customer customer, Account account, DefaultTableModel model);

    public abstract void updateModel();
}
