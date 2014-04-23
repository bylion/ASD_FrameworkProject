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
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public abstract class GUI extends JFrame {

    private JPanel topActionsPanel;
    private JScrollPane scroller;

    private JTable datatable;
    private ActionButton depositBtn;
    private ActionButton withdrawBtn;
    private ActionButton exitBtn;
    public Factory factory;
    private FinancialCompany controller;
    private FinancialProperties properties;

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
        JPanel eastActionsPanel = new JPanel();

        depositBtn = new ActionButton("Deposit", new TransactionHandler());
//        String appNature = properties.getProperty(PropertiesEnum.APP_NATURE.getVal());
        if (nature.equals(ApplicationNatureEnum.DEBIT)) {
            withdrawBtn = new ActionButton(PropertiesEnum.WITHDRAW.getVal(), new TransactionHandler());
        }else{
            withdrawBtn = new ActionButton(PropertiesEnum.CHARGE.getVal(), new TransactionHandler());
        }
        exitBtn = new ActionButton("Exit", new ExitHandler());
        
        eastActionsPanel.setLayout(new GridLayout(3, 1));
        eastActionsPanel.add(depositBtn);
        eastActionsPanel.add(withdrawBtn);
        eastActionsPanel.add(exitBtn);

        getContentPane().add(eastActionsPanel, BorderLayout.EAST);
        getContentPane().add(scroller, BorderLayout.CENTER);
        getContentPane().add(topActionsPanel, BorderLayout.NORTH);

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
