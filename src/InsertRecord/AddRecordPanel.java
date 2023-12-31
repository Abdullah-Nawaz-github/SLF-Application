package insertRecord;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import utility.Utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("serial")
public class AddRecordPanel extends JPanel {

	private JPanel contentPanel;
	private JTextField bName_TF;
	private JTextField fName_TF;
	private JLabel lblNewLabel_1_2;
	private JPanel currentPanel = new JPanel(); // New variable to keep track of the currently displayed panel

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddRecordPanel() {

		Utility ut = new Utility();

		setBorder(new MatteBorder(0, 1, 1, 1, (Color) Color.WHITE));
		setBackground(new Color(254, 255, 255));
		setPreferredSize(new Dimension(882, 751));
		setLayout(null);
		setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(260, 507, 480, 240);

		contentPanel.setBorder(null);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(currentPanel);
		add(contentPanel);

		bName_TF = new JTextField();
		bName_TF.setBounds(432, 123, 249, 26);
		add(bName_TF);
		bName_TF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel.setBounds(294, 128, 130, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Father Name");
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(294, 160, 118, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Year");
		lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(294, 228, 61, 16);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vaccinater Name");
		lblNewLabel_1_1_1.setBounds(294, 347, 129, 16);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Donor");
		lblNewLabel_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(294, 385, 61, 16);
		add(lblNewLabel_1_1_1_1);

		fName_TF = new JTextField();
		fName_TF.setColumns(10);
		fName_TF.setBounds(432, 155, 249, 26);
		add(fName_TF);



		JLabel lblNewLabel_1_1_2 = new JLabel("Record Type");
		lblNewLabel_1_1_2.setBounds(341, 459, 83, 16);
		add(lblNewLabel_1_1_2);

		/*
		 * Change the type of record being inserted
		 */

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(118, 179, 220));
		panel.setBounds(260, 47, 480, 388);
		add(panel);

		JLabel lblNewLabel_2 = new JLabel("Insert Record");
		lblNewLabel_2.setFont(new Font("Songti TC", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(207, 25, 134, 16);
		panel.add(lblNewLabel_2);

		JButton btnNewBeneficiary = new JButton("new");
		btnNewBeneficiary.setBounds(419, 90, 61, 29);
		panel.add(btnNewBeneficiary);

		JComboBox Vaccinater_CB = new JComboBox();
		Vaccinater_CB.setBounds(168, 299, 254, 27);
		List<String> vaccinaterNames = ut.getUniqueVaccinaters();
		for (String vacc : vaccinaterNames) {
			Vaccinater_CB.addItem(vacc);
		}
		panel.add(Vaccinater_CB);

		JComboBox Donor_CB = new JComboBox();
		Donor_CB.setBounds(168, 338, 254, 27);
		List<String> donorNames = ut.getUniqueDonors();
		for (String donor : donorNames) {
			Donor_CB.addItem(donor);
		}
		panel.add(Donor_CB);

		JButton btnNewVaccinater = new JButton("new");
		btnNewVaccinater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVaccinaterFrame addVaccinaterFrame = new AddVaccinaterFrame(Vaccinater_CB);
				addVaccinaterFrame.setVisible(true);
			}
		});
		btnNewVaccinater.setBounds(419, 298, 61, 29);
		panel.add(btnNewVaccinater);

		JButton btnNewDonor = new JButton("new");
		btnNewDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDonorFrame addDonorFrame = new AddDonorFrame(Donor_CB);
				addDonorFrame.setVisible(true);

			}
		});
		btnNewDonor.setBounds(419, 337, 61, 29);
		panel.add(btnNewDonor);

		// Populate Year Combo Box
		JComboBox year_CB = new JComboBox();
		year_CB.setBounds(76, 176, 109, 27);
		panel.add(year_CB);

		JLabel lblNewLabel_1_1_3 = new JLabel("Month");
		lblNewLabel_1_1_3.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(186, 181, 61, 16);
		panel.add(lblNewLabel_1_1_3);

		JComboBox month_CB= new JComboBox();
		month_CB.setBounds(228, 176, 101, 27);
		 for (int month = 1; month <= 12; month++) {
			 month_CB.addItem(String.format("%02d", month));
	        }
		panel.add(month_CB);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Day");
		lblNewLabel_1_1_3_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_1_3_1.setBounds(329, 181, 61, 16);
		panel.add(lblNewLabel_1_1_3_1);

		JComboBox day_CB = new JComboBox();
		day_CB.setBounds(357, 176, 117, 27);
		for (int day = 1; day <= 31; day++) {
			day_CB.addItem(String.format("%02d", day));
        }
		panel.add(day_CB);

		// Populate season Combo Box
		JComboBox season_CB = new JComboBox();
		season_CB.setBounds(228, 234, 161, 27);
		panel.add(season_CB);
		
		String[] seasons = { "Summer", "Winter" };
		for (int i = 0; i < seasons.length; i++) {
			season_CB.addItem(seasons[i]);
		}
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = currentYear; year <= currentYear + 10; year++) {
			year_CB.addItem(year);
		}

		lblNewLabel_1_2 = new JLabel("Season");
		lblNewLabel_1_2.setBounds(168, 239, 61, 16);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnNewBeneficiary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBeneficiaryFrame.main(null);
			}
		});

		JComboBox record_CB = new JComboBox();
		String[] recordsArr = { "", "Vaccination", "Predation", "Disease", "Slaughter", "Sales" };
		for (int i = 0; i < recordsArr.length; i++) {
			record_CB.addItem(recordsArr[i]);
		}

		record_CB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (record_CB.getSelectedItem().equals("Vaccination")) {
					removeCurrentPanel();
					InsertVaccinationPanel vpanel = new InsertVaccinationPanel(bName_TF, fName_TF, year_CB, season_CB,
							month_CB,day_CB, Vaccinater_CB, Donor_CB);
					currentPanel = vpanel;
					contentPanel.add(vpanel);
				} else if (record_CB.getSelectedItem().equals("Predation")) {
					removeCurrentPanel();
					InsertPredationPanel ppanel = new InsertPredationPanel(bName_TF, fName_TF, year_CB, season_CB,
							month_CB,day_CB, Vaccinater_CB, Donor_CB);
					currentPanel = ppanel;
					contentPanel.add(ppanel);
				} else if (record_CB.getSelectedItem().equals("Disease")) {
					removeCurrentPanel();
					InsertDiseasePanel dpanel = new InsertDiseasePanel(bName_TF, fName_TF, year_CB, season_CB, month_CB,day_CB,
							Vaccinater_CB, Donor_CB);
					currentPanel = dpanel;
					contentPanel.add(dpanel);
				} else if (record_CB.getSelectedItem().equals("Slaughter")) {
					removeCurrentPanel();
					InsertSlaughterPanel slpanel = new InsertSlaughterPanel(bName_TF, fName_TF, year_CB, season_CB,
							month_CB,day_CB, Vaccinater_CB, Donor_CB);
					currentPanel = slpanel;
					contentPanel.add(slpanel);
				} else if (record_CB.getSelectedItem().equals("Sales")) {
					removeCurrentPanel();
					InsertSalesPanel spanel = new InsertSalesPanel(bName_TF, fName_TF, year_CB, season_CB, month_CB,day_CB,
							Vaccinater_CB, Donor_CB);
					currentPanel = spanel;
					contentPanel.add(spanel);
				} else {
					removeCurrentPanel();
				}
			}
		});
		record_CB.setBounds(436, 455, 245, 27);
		add(record_CB);

	}

	private void removeCurrentPanel() {
		if (currentPanel != null) {
			contentPanel.remove(currentPanel);
			contentPanel.revalidate();
			contentPanel.repaint();
		}
	}
}
