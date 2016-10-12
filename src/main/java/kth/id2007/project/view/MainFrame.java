package kth.id2007.project.view;

import kth.id2007.project.model.*;
import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Main frame of the system
 * <p>
 * Created by kim on 2016-10-06.
 */
public class MainFrame extends JFrame {

    private GUI gui;
    private User user;
    private Container container;

    /**
     * Class constructor. Initializes the frame
     *
     * @param gui  controller
     * @param user logged in user
     */
    public MainFrame(GUI gui, User user) {
        setName("main_frame");
        this.gui = gui;
        this.user = user;
        setLayout(new MigLayout());
        setTitle("SEP System");
        container = new Container();
        container.setName("container_pane");
        setContentPane(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); //center on screen
        setVisible(true);
    }

    public void update() {
        SwingUtilities.invokeLater(() ->
        {
            container.update();
        });
    }

    //Container that holds tabs
    private class Container extends JTabbedPane {
        private HomePanel homePanel;
        private EventApplicationsPanel eventApplicationsPanel;
        private ClientsPanel clientsPanel;
        private EmployeesPanel employeesPanel;
        private HrRequestPanel hrRequestPanel;
        private BudgetIssueRequestPanel budgetIssueRequestPanel;
        private SubTasksPanel subTasksPanel;

        public Container() {
            homePanel = new HomePanel();
            if (homePanel.access())
                addTab("Home", homePanel);
            eventApplicationsPanel = new EventApplicationsPanel();
            if (eventApplicationsPanel.access())
                addTab("Event Applications", eventApplicationsPanel);
            clientsPanel = new ClientsPanel();
            if (clientsPanel.access())
                addTab("Clients", clientsPanel);
            employeesPanel = new EmployeesPanel();
            if (employeesPanel.access())
                addTab("Employees", employeesPanel);
            hrRequestPanel = new HrRequestPanel();
            if (hrRequestPanel.access()) {
                addTab("HR Request", hrRequestPanel);
            }
            budgetIssueRequestPanel = new BudgetIssueRequestPanel();
            if (budgetIssueRequestPanel.access()) {
                addTab("Budget Issue", budgetIssueRequestPanel);
            }
            subTasksPanel = new SubTasksPanel();
            if (subTasksPanel.access()) {
                addTab("Sub-team Tasks", subTasksPanel);
            }

        }

        public void update() {
            clientsPanel.update();
            employeesPanel.update();
            eventApplicationsPanel.update();
            hrRequestPanel.update();
            budgetIssueRequestPanel.update();
            subTasksPanel.update();
            homePanel.update();
        }
    }

    //Home-panel/tab
    private class HomePanel extends JPanel {
        String[] accessList = Roles.roles();
        ApproveApplicationsPanel approveApplicationsPanel;

        private HomePanel() {
            setLayout(new MigLayout("wrap 2"));
            JLabel lbl = new JLabel("Home");
            lbl.setName("home_title");
            add(lbl, "span 2, center");
            lbl = new JLabel("User:");
            lbl.setName("user_label");
            add(lbl, "span 1");
            lbl = new JLabel(user.getUsername());
            lbl.setName("username");
            add(lbl, "span 1");
            lbl = new JLabel("Role:");
            lbl.setName("role_label");
            add(lbl, "span 1");
            lbl = new JLabel(user.getRole());
            lbl.setName("role");
            add(lbl, "span 1");
            lbl = new JLabel("Team:");
            lbl.setName("team_label");
            add(lbl, "span 1");
            lbl = new JLabel(user.getTeam());
            lbl.setName("team");
            add(lbl, "span 1");
            approveApplicationsPanel = new ApproveApplicationsPanel();
            add(approveApplicationsPanel, "span 2");
        }

        void update() {
            approveApplicationsPanel.updateApplicationsModel();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

        private class ApproveApplicationsPanel extends JPanel {
            private DefaultTableModel model = new DefaultTableModel();
            private Object[] columnNames = new String[]{"projectRef", "approve"};
            private JTable table;

            private ApproveApplicationsPanel() {
                setLayout(new MigLayout("wrap 1"));

                add(new JLabel("Event Applications Waiting for approval"), "span 1, center");
                Object rowData[][] = new Object[0][0];
                model = new DefaultTableModel(rowData, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        if (column == 1)
                            return true;
                        else
                            return false;
                    }

                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return String.class;
                            case 1:
                                return Boolean.class;
                            default:
                                return Boolean.class;
                        }
                    }
                };
                updateApplicationsModel();
                table = new JTable(model);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension dim = new Dimension(800, 400);
                int rowsDisplayed = 15;
                scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
                add(scrollPane, "span 1");
            }

            private void updateApplicationsModel() {
                ArrayList<EventApplication> applications = gui.getApplications().stream().filter(app -> !app.isApproved())
                        .collect(Collectors.toCollection(ArrayList::new));
                Object[][] rowData = new Object[applications.size()][2];
                for (int i = 0; i < applications.size(); i++) {
                    EventApplication application = applications.get(i);
                    rowData[i][0] = Long.toString(application.getProjectRefrenceId());
                    rowData[i][1] = false;
                }
                model.setDataVector(rowData, columnNames);
                repaint();
                revalidate();
            }
        }
    }

    //EventApplications-panel/tab
    private class EventApplicationsPanel extends JPanel {
        private ViewEventApplicationPanel viewEventApplicationPanel;
        private String[] accessList = new String[]{
                Roles.SENIOR_CUSTOMER_SERVICE_OFFICER,
                Roles.FINANCIAL_MANAGER, Roles.ADMINISTRATION_MANAGER, Roles.PRODUCTION_MANAGER, Roles.SERVICE_MANAGER,
                Roles.PHOTOGRAPHER_TEAM, Roles.AUDIO_TEAM, Roles.GRAPHIC_TEAM, Roles.IT_TEAM, Roles.DECORATING_TEAM,
                Roles.COOKING_TEAM, Roles.RESTAURANT_SERVICES_TEAM, Roles.ADMINISTRATOR
        };

        private EventApplicationsPanel() {
            setLayout(new MigLayout("wrap 1"));
            CreateEventApplicationPanel createEventApplicationPanel = new CreateEventApplicationPanel();
            if (createEventApplicationPanel.access())
                add(createEventApplicationPanel, "span 1");
            viewEventApplicationPanel = new ViewEventApplicationPanel();
            add(viewEventApplicationPanel, "span 1");
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

        void update() {
            viewEventApplicationPanel.updateApplicationsModel();
        }

        private class CreateEventApplicationPanel extends JPanel {
            private String[] accessList = new String[]{
                    Roles.SENIOR_CUSTOMER_SERVICE_OFFICER, Roles.ADMINISTRATOR
            };

            public CreateEventApplicationPanel() {
                setLayout(new MigLayout("wrap 2"));
                add(new JLabel("Create Event Application"), "span 2, center");
                JTextField budgetField = new JTextField(25);
                JTextField discountField = new JTextField(25);
                JTextField eventTypeField = new JTextField(25);
                JTextField preferencesField = new JTextField(25);
                JTextField descriptionField = new JTextField(25);
                JTextField expectedAttendeesField = new JTextField(25);
                JTextField budgetCommentsField = new JTextField(25);
                JComboBox eventStatusComboBox = new JComboBox(EventStatus.getAllStatuses());
                JButton createEventApplicationButton = new JButton("Create");
                UtilDateModel fromModel = new UtilDateModel();
                JDatePanelImpl fromDatePanel = new JDatePanelImpl(fromModel);
                JDatePickerImpl fromDatePicker = new JDatePickerImpl(fromDatePanel);
                UtilDateModel toModel = new UtilDateModel();
                JDatePanelImpl toDatePanel = new JDatePanelImpl(toModel);
                JDatePickerImpl toDatePicker = new JDatePickerImpl(toDatePanel);
                createEventApplicationButton.addActionListener(gui.new EventApplicationListener(budgetField, discountField,
                        eventTypeField, preferencesField, descriptionField, expectedAttendeesField, fromDatePicker, toDatePicker,
                        budgetCommentsField, eventStatusComboBox));
                add(new JLabel("Budget:"), "span 1");
                add(budgetField, "span 1");
                add(new JLabel("Discount:"), "span 1");
                add(discountField, "span 1");
                add(new JLabel("Event Type:"), "span 1");
                add(eventTypeField, "span 1");
                add(new JLabel("Preferences:"), "span 1");
                add(preferencesField, "span 1");
                add(new JLabel("Description:"), "span 1");
                add(descriptionField, "span 1");
                add(new JLabel("From:"), "span 1");
                add(fromDatePicker, "span 1");
                add(new JLabel("To:"), "span 1");
                add(toDatePicker, "span 1");
                add(new JLabel("Expected Attendees:"), "span 1");
                add(expectedAttendeesField, "span 1");
                add(new JLabel("Budget Comments:"), "span 1");
                add(budgetCommentsField, "span 1");
                add(new JLabel("Status:"), "span 1");
                add(eventStatusComboBox, "span 1");
                add(createEventApplicationButton, "span 2");
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }
        }

        private class ViewEventApplicationPanel extends JPanel {
            private DefaultTableModel model = new DefaultTableModel();
            private String[] columnNames = new String[]{"projectRef", "budget", "discount", "eventType", "preferences",
                    "description", "from", "to", "expected attendees", "status", "budget comments"};

            public ViewEventApplicationPanel() {
                setLayout(new MigLayout("wrap 1"));
                add(new JLabel("Event Applications"), "span 1, center");
                String rowData[][] = new String[0][0];
                model = new DefaultTableModel(rowData, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        String[] accessList = new String[]{
                                Roles.ADMINISTRATION_MANAGER, Roles.PRODUCTION_MANAGER,
                                Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
                        };
                        return access();
                    }
                };
                updateApplicationsModel();
                JTable table = new JTable(model);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension dim = new Dimension(800, 400);
                int rowsDisplayed = 15;
                scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
                add(scrollPane, "span 1");
                JButton saveEdits = new JButton("Save Edits");
                saveEdits.addActionListener(gui.new EventEditListener(model, user));
                if (access())
                    add(saveEdits, "span 1");
            }

            private void updateApplicationsModel() {
                ArrayList<EventApplication> applications = gui.getApplications();
                String[][] rowData = new String[applications.size()][11];
                for (int i = 0; i < applications.size(); i++) {
                    EventApplication application = applications.get(i);
                    rowData[i][0] = Long.toString(application.getProjectRefrenceId());
                    rowData[i][1] = Long.toString(application.getBudget());
                    rowData[i][2] = Long.toString(application.getDiscount());
                    rowData[i][3] = application.getEventType();
                    rowData[i][4] = application.getPreferences();
                    rowData[i][5] = application.getDescription();
                    rowData[i][6] = application.getFrom();
                    rowData[i][7] = application.getTo();
                    rowData[i][8] = Integer.toString(application.getExpectedAttendees());
                    rowData[i][9] = application.getBudgetComments();
                    rowData[i][10] = application.getStatus();
                }
                model.setDataVector(rowData, columnNames);
                repaint();
                revalidate();
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }
        }
    }

    //Clients-panel/tab
    private class ClientsPanel extends JPanel {
        private CreateClientPanel createClientPanel;
        private ViewClientsPanel viewClientsPanel;
        private String[] accessList = new String[]{
                Roles.SENIOR_CUSTOMER_SERVICE_OFFICER, Roles.FINANCIAL_MANAGER,
                Roles.MARKETING_OFFICER, Roles.MARKETING_ASSISTANT, Roles.ADMINISTRATOR
        };

        private ClientsPanel() {
            setLayout(new MigLayout("wrap 1"));
            createClientPanel = new CreateClientPanel();
            viewClientsPanel = new ViewClientsPanel();
            if (createClientPanel.access())
                add(createClientPanel, "span 1");
            add(viewClientsPanel);
        }

        void update() {
            viewClientsPanel.updateClientsModel();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

        private class CreateClientPanel extends JPanel {
            private String[] accessList = new String[]{
                    Roles.SENIOR_CUSTOMER_SERVICE_OFFICER, Roles.ADMINISTRATOR
            };

            private CreateClientPanel() {
                setLayout(new MigLayout("wrap 2"));
                add(new JLabel("Create New Client"), "span 2, center");
                JTextField clientNameField = new JTextField(25);
                JTextField clientEmailField = new JTextField(25);
                JTextField clientPhoneNumberField = new JTextField(25);

                JButton saveButton = new JButton("Save Record");
                saveButton.addActionListener(gui.new ClientRecordListener(clientNameField, clientEmailField, clientPhoneNumberField));

                add(new JLabel("Client Name"), "span 1");
                add(clientNameField, "span 1");

                add(new JLabel("Email"), "span 1");
                add(clientEmailField, "span 1");

                add(new JLabel("Phone Number"), "span 1");
                add(clientPhoneNumberField, "span 1");

                add(saveButton, "span 1");
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }
        }

        private class ViewClientsPanel extends JPanel {
            private SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd/hh/mm");
            private DefaultTableModel model;
            private String[] columnNames = new String[]{"name", "email", "phonenumber", "created"};

            public ViewClientsPanel() {
                setLayout(new MigLayout("wrap 1"));
                add(new JLabel("Clients"), "span 1, center");
                String rowData[][] = new String[0][0];
                model = new DefaultTableModel(rowData, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                updateClientsModel();
                JTable table = new JTable(model);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension dim = new Dimension(800, 400);
                int rowsDisplayed = 15;
                scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
                add(scrollPane, "span 1");
            }

            private void updateClientsModel() {
                ArrayList<ClientRecord> clients = gui.getClients();
                String[][] rowData = new String[clients.size()][4];
                for (int i = 0; i < clients.size(); i++) {
                    ClientRecord clientRecord = clients.get(i);
                    rowData[i][0] = clientRecord.getClientName();
                    rowData[i][1] = clientRecord.getClientEmail();
                    rowData[i][2] = clientRecord.getClientPhoneNumber();
                    rowData[i][3] = format.format(clientRecord.getCreationDate());
                }
                model.setDataVector(rowData, columnNames);
                repaint();
                revalidate();
            }
        }
    }

    //Employees-panel/tab
    private class EmployeesPanel extends JPanel {
        private DefaultTableModel model;
        private String[] columnNames = new String[]{"username", "role", "team"};
        private String[] accessList = new String[]{
                Roles.FINANCIAL_MANAGER, Roles.SENIOR_HR_MANAGER, Roles.HR_ASSISTANT,
                Roles.ADMINISTRATION_MANAGER, Roles.ADMINISTRATOR
        };

        private EmployeesPanel() {
            setLayout(new MigLayout("wrap 1"));
            add(new JLabel("Employees"), "span 1, center");
            String rowData[][] = new String[0][0];
            model = new DefaultTableModel(rowData, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            updateEmployeesModel();
            JTable table = new JTable(model);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            Dimension dim = new Dimension(800, 400);
            int rowsDisplayed = 15;
            scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
            add(scrollPane, "span 1");
        }

        void update() {
            updateEmployeesModel();
        }

        private void updateEmployeesModel() {
            ArrayList<User> users = gui.getUsers();
            String[][] rowData = new String[users.size()][3];
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);
                rowData[i][0] = u.getUsername();
                rowData[i][1] = u.getRole();
                rowData[i][2] = u.getTeam();
            }
            model.setDataVector(rowData, columnNames);
            repaint();
            revalidate();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }
    }


    //Employees-panel/tab
    private class HrRequestPanel extends JPanel {
        private CreateHrRequestPanel createHrRequestPanel;
        private ViewHrRequestPanel viewHrRequestPanel;
        private String[] accessList = new String[]{
                Roles.SENIOR_HR_MANAGER, Roles.HR_ASSISTANT,
                Roles.ADMINISTRATOR
        };

        private HrRequestPanel() {
            setLayout(new MigLayout("wrap 1"));

            createHrRequestPanel = new CreateHrRequestPanel();
            if (createHrRequestPanel.access())
                add(createHrRequestPanel, "span 2, center, gaptop 30");

            viewHrRequestPanel = new ViewHrRequestPanel();
            if (viewHrRequestPanel.access())
                add(viewHrRequestPanel, "span 2, center, gaptop 30");


        }

        void update() {
            viewHrRequestPanel.updateHrRequestModel();
            createHrRequestPanel.updateProjects();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

        private class CreateHrRequestPanel extends JPanel {
            private String[] accessList = new String[]{
                    Roles.PRODUCTION_MANAGER, Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
            };
            private JComboBox projectComboBox;
            private DefaultComboBoxModel model;

            private CreateHrRequestPanel() {
                setLayout(new MigLayout("wrap 2"));
                add(new JLabel("Create Human Resources Request"), "span 2, center");
                JTextField jobTitleField = new JTextField(25);
                JTextField jobDescriptionField = new JTextField(25);
                JComboBox contractTypeComboBox = new JComboBox(HrRequest.JOB_TYPES);
                JComboBox requestingDepartmentComboBox = new JComboBox(Roles.getDeparments());
                model = new DefaultComboBoxModel();
                projectComboBox = new JComboBox(model);
                updateProjects();
                JButton saveButton = new JButton("Save Request");
                saveButton.addActionListener(gui.new HrRequestListener(contractTypeComboBox,
                        requestingDepartmentComboBox, projectComboBox, jobTitleField, jobDescriptionField));

                add(new JLabel("Project Reference"), "span 1");
                add(projectComboBox, "span 1");

                add(new JLabel("Contract Type"), "span 1");
                add(contractTypeComboBox, "span 1");

                add(new JLabel("Requesting Department"), "span 1");
                add(requestingDepartmentComboBox, "span 1");

                add(new JLabel("Job Title"), "span 1");
                add(jobTitleField, "span 1");

                add(new JLabel("Job Description"), "span 1");
                add(jobDescriptionField, "span 1");

                add(saveButton, "span 1");
            }

            private void updateProjects() {
                String projects[] = new String[gui.getApplications().size()];
                for (int i = 0; i < gui.getApplications().size(); i++) {
                    projects[i] = "" + gui.getApplications().get(i).getProjectRefrenceId();
                }
                projectComboBox.setModel(new DefaultComboBoxModel(projects));
                repaint();
                revalidate();
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }
        }

    }

    //Employees-panel/tab
    private class ViewHrRequestPanel extends JPanel {
        private DefaultTableModel model;
        String[] columnNames = new String[]{"Project-ref, Contract type", "Requesting Department", "Job Title", "Job Description"};
        private String[] accessList = new String[]{
                Roles.SENIOR_HR_MANAGER, Roles.HR_ASSISTANT, Roles.PRODUCTION_MANAGER, Roles.SERVICE_MANAGER,
                Roles.ADMINISTRATOR
        };

        private ViewHrRequestPanel() {
            setLayout(new MigLayout("wrap 1"));
            add(new JLabel("Human Resources Request"), "span 1, center");
            String rowData[][] = new String[0][0];
            model = new DefaultTableModel(rowData, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            updateHrRequestModel();
            JTable table = new JTable(model);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            Dimension dim = new Dimension(800, 400);
            int rowsDisplayed = 15;
            scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
            add(scrollPane, "span 1");


        }

        private void updateHrRequestModel() {
            ArrayList<HrRequest> r = gui.getHrRequests();
            String rowData[][] = new String[r.size()][5];
            for (int i = 0; i < r.size(); i++) {
                rowData[i][0] = Long.toString(r.get(i).getProjectReferenceId());
                rowData[i][1] = HrRequest.JOB_TYPES[r.get(i).getContractType()];
                rowData[i][2] = Roles.getDeparments()[r.get(i).getContractType()];
                rowData[i][3] = r.get(i).getJobTitle();
                rowData[i][4] = r.get(i).getJobDescription();
            }
            model.setDataVector(rowData, columnNames);
            repaint();
            revalidate();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

    }

    private class BudgetIssueRequestPanel extends JPanel {
        private ViewBudgetIssuePanel viewBudgetIssuePanel;
        private CreateBudgetIssuePanel createBudgetIssuePanel;
        private String[] accessList = new String[]{
                Roles.FINANCIAL_MANAGER, Roles.PRODUCTION_MANAGER,
                Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
        };

        public BudgetIssueRequestPanel() {
            setLayout(new MigLayout("wrap 1"));
            add(new JLabel("Budget Issue Request"), "span 1, center");

            //Create         
            createBudgetIssuePanel = new CreateBudgetIssuePanel();

            if (createBudgetIssuePanel.access()) {
                add(createBudgetIssuePanel, "span 2");
            }
            //View
            viewBudgetIssuePanel = new ViewBudgetIssuePanel();
            if (viewBudgetIssuePanel.access()) {
                add(viewBudgetIssuePanel, "span 2");
            }
        }

        void update() {
            viewBudgetIssuePanel.updateBudgetIssueRequestModel();
            createBudgetIssuePanel.updateProjects();
        }

        private class ViewBudgetIssuePanel extends JPanel {
            private DefaultTableModel model;
            private String[] columnNames = new String[]{"Project-ref", "Contract type", "Requesting Department", "Job Title", "Job Description"};
            private String[] accessList = new String[]{
                    Roles.FINANCIAL_MANAGER, Roles.PRODUCTION_MANAGER,
                    Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
            };

            private ViewBudgetIssuePanel() {
                setLayout(new MigLayout("wrap 1"));


                add(new JLabel("Budget issue requests"), "span 1, center");
                String rowData[][] = new String[0][0];

                model = new DefaultTableModel(rowData, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                JTable table = new JTable(model);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension dim = new Dimension(800, 400);
                int rowsDisplayed = 15;
                scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
                add(scrollPane, "span 1");


            }

            private void updateBudgetIssueRequestModel() {
                ArrayList<BudgetIssueRequest> r = gui.getBudgetIssueRequests();
                String rowData[][] = new String[r.size()][5];
                for (int i = 0; i < r.size(); i++) {
                    rowData[i][0] = Long.toString(r.get(i).getProjectRefrenceId());
                    rowData[i][1] = Roles.getDeparments()[r.get(i).getRequestingDepartment()];
                    rowData[i][2] = r.get(i).getProjectRefrenceId() + "";
                    rowData[i][3] = r.get(i).getAmount() + "";
                    rowData[i][4] = r.get(i).getReason();
                }
                model.setDataVector(rowData, columnNames);
                repaint();
                revalidate();
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }


        }

        private class CreateBudgetIssuePanel extends JPanel {
            private JTextField amountField, reasonField;
            private JComboBox requestingDepartmentComboBox, projectComboBox;
            private JButton saveButton;
            private DefaultComboBoxModel model;

            private String[] accessList = new String[]{
                    Roles.PRODUCTION_MANAGER,
                    Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
            };

            private CreateBudgetIssuePanel() {
                setLayout(new MigLayout("wrap 2"));
                requestingDepartmentComboBox = new JComboBox(Roles.getDeparments());
                model = new DefaultComboBoxModel();
                projectComboBox = new JComboBox(model);
                updateProjects();
                amountField = new JTextField(25);
                reasonField = new JTextField(25);
                saveButton = new JButton("Submit Request");
                add(new JLabel("Requesting Department"), "span 1");
                add(requestingDepartmentComboBox, "span 1");
                add(new JLabel("Project Reference"), "span 1");
                add(projectComboBox, "span 1");
                add(new JLabel("Amount"), "span 1");
                add(amountField, "span 1");
                add(new JLabel("Reason"), "span 1");
                add(reasonField, "span 1");

                add(saveButton, "span 2");
                saveButton.addActionListener(gui.new BudgetIssueListener(amountField, reasonField, requestingDepartmentComboBox, projectComboBox));
            }

            private void updateProjects() {
                String projects[] = new String[gui.getApplications().size()];
                for (int i = 0; i < gui.getApplications().size(); i++) {
                    projects[i] = "" + gui.getApplications().get(i).getProjectRefrenceId();
                }
                projectComboBox.setModel(new DefaultComboBoxModel(projects));
                repaint();
                revalidate();
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }

        }


        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }
    }

    private class SubTasksPanel extends JPanel {
        private DefaultTableModel model;
        private String[] columnNames = new String[]{"Project-ref", "Description", "Assigned To", "Priority"};
        private String[] accessList = new String[]{
                Roles.SENIOR_CUSTOMER_SERVICE_OFFICER,
                Roles.FINANCIAL_MANAGER, Roles.ADMINISTRATION_MANAGER, Roles.PRODUCTION_MANAGER, Roles.SERVICE_MANAGER,
                Roles.PHOTOGRAPHER_TEAM, Roles.AUDIO_TEAM, Roles.GRAPHIC_TEAM, Roles.IT_TEAM, Roles.DECORATING_TEAM,
                Roles.COOKING_TEAM, Roles.RESTAURANT_SERVICES_TEAM, Roles.ADMINISTRATOR
        };
        private CreateSubTaskPanel createSubTaskPanel;
        private ViewSubTasksPanel viewSubTasksPanel;

        private SubTasksPanel() {
            setLayout(new MigLayout("wrap 1"));
            createSubTaskPanel = new CreateSubTaskPanel();
            if (createSubTaskPanel.access()) {
                add(createSubTaskPanel, "span 1");
            }
            viewSubTasksPanel = new ViewSubTasksPanel();
            add(viewSubTasksPanel, "span 1");
        }

        void update() {
            viewSubTasksPanel.updateSubTasksModel();
            createSubTaskPanel.updateProjects();
        }

        private boolean access() {
            return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
        }

        private class ViewSubTasksPanel extends JPanel {
            private ViewSubTasksPanel() {
                setLayout(new MigLayout("wrap 1"));
                add(new JLabel("Sub-team tasks"), "span 1, center");
                String rowData[][] = new String[0][0];
                model = new DefaultTableModel(rowData, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                updateSubTasksModel();
                JTable table = new JTable(model);
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension dim = new Dimension(800, 400);
                int rowsDisplayed = 15;
                scrollPane.setPreferredSize(new Dimension(dim.width, table.getRowHeight() * rowsDisplayed));
                add(scrollPane, "span 1");
            }

            private void updateSubTasksModel() {
                ArrayList<SubTeamTask> tasks = gui.getTasks();
                String[][] rowData = new String[tasks.size()][4];
                for (int i = 0; i < tasks.size(); i++) {
                    SubTeamTask t = tasks.get(i);
                    rowData[i][0] = Long.toString(t.getProjectReferenceId());
                    rowData[i][1] = t.getDescription();
                    rowData[i][2] = t.getAssignedTo();
                    rowData[i][3] = Integer.toString(t.getPriority());
                }
                model.setDataVector(rowData, columnNames);
                repaint();
                revalidate();
            }
        }

        private class CreateSubTaskPanel extends JPanel {
            private JTextField descriptionField, assignedToField, priorityField;
            private JComboBox projectComboBox;
            private JButton saveButton;
            private DefaultComboBoxModel model;

            private String[] accessList = new String[]{
                    Roles.PRODUCTION_MANAGER,
                    Roles.SERVICE_MANAGER, Roles.ADMINISTRATOR
            };

            private CreateSubTaskPanel() {
                setLayout(new MigLayout("wrap 2"));
                model = new DefaultComboBoxModel();
                projectComboBox = new JComboBox(model);
                updateProjects();
                descriptionField = new JTextField(25);
                assignedToField = new JTextField(25);
                priorityField = new JTextField(25);
                saveButton = new JButton("Create Sub task");
                add(new JLabel("Project Reference"), "span 1");
                add(projectComboBox, "span 1");
                add(new JLabel("Description"), "span 1");
                add(descriptionField, "span 1");
                add(new JLabel("Assigned to"), "span 1");
                add(assignedToField, "span 1");
                add(new JLabel("Priority"), "span 1");
                add(priorityField, "span 1");
                add(saveButton, "span 2");
                saveButton.addActionListener(gui.new SubTeamTasksListener(descriptionField, assignedToField, priorityField, projectComboBox));
            }

            private void updateProjects() {
                String projects[] = new String[gui.getApplications().size()];
                for (int i = 0; i < gui.getApplications().size(); i++) {
                    projects[i] = "" + gui.getApplications().get(i).getProjectRefrenceId();
                }
                projectComboBox.setModel(new DefaultComboBoxModel(projects));
                repaint();
                revalidate();
            }

            private boolean access() {
                return Arrays.stream(accessList).anyMatch(accessRole -> accessRole.equals(user.getRole()) | accessRole.equals(user.getTeam()));
            }

        }
    }

}

