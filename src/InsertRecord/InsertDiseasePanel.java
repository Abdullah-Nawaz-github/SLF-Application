package InsertRecord;

import javax.swing.JPanel;
import javax.swing.JTextField;

import utility.Utility;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertDiseasePanel extends JPanel {
	
//	private JTextField bName_TF;

	/**
	 * Create the panel.
	 * @param donor_CB 
	 * @param vaccinater_CB 
	 * @param date_TF 
	 * @param season_CB 
	 * @param year_CB 
	 * @param fName_TF 
	 */
	public InsertDiseasePanel(JTextField bName_TF, JTextField fName_TF, JComboBox year_CB, JComboBox season_CB, JTextField date_TF, JComboBox vaccinater_CB, JComboBox donor_CB) {
		
//		this.bName_TF=bName_TF;
		
		
		setLayout(null);
		
		JComboBox goatCB = new JComboBox();
		goatCB.setBounds(21, 160, 83, 27);
		for (int i = 0; i < 99; i++) {
			goatCB.addItem(i);
		}
		add(goatCB);
		
		JLabel lblNewLabel_2_1 = new JLabel("Disease Record");
		lblNewLabel_2_1.setBounds(185, 6, 167, 16);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Disease");
		lblNewLabel_1_1_2.setBounds(58, 50, 61, 16);
		add(lblNewLabel_1_1_2);
		
		JComboBox type_CB = new JComboBox();
		type_CB.setBounds(122, 46, 286, 27);
		add(type_CB);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sheep");
		lblNewLabel_1_1_1_1_1.setBounds(317, 132, 37, 16);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Goat");
		lblNewLabel_1_1_1_1_1_1.setBounds(43, 132, 61, 16);
		add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Cattle");
		lblNewLabel_1_1_1_1_1_2.setBounds(124, 132, 61, 16);
		add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Dozoo or Yak");
		lblNewLabel_1_1_1_1_1_3.setBounds(197, 132, 85, 16);
		add(lblNewLabel_1_1_1_1_1_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("# Livestock dead due to this disease");
		lblNewLabel_2_1_1.setBounds(136, 106, 237, 16);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Other");
		lblNewLabel_1_1_1_1_1_4.setBounds(389, 132, 61, 16);
		add(lblNewLabel_1_1_1_1_1_4);
		
		JComboBox cattleCB = new JComboBox();
		cattleCB.setBounds(102, 160, 83, 27);
		for (int i = 0; i < 99; i++) {
			cattleCB.addItem(i);
		}
		add(cattleCB);
		
		JComboBox yakCB = new JComboBox();
		yakCB.setBounds(197, 160, 83, 27);
		for (int i = 0; i < 99; i++) {
			yakCB.addItem(i);
		}
		add(yakCB);
		
		JComboBox sheepCB = new JComboBox();
		sheepCB.setBounds(292, 160, 83, 27);
		for (int i = 0; i < 99; i++) {
			sheepCB.addItem(i);
		}
		add(sheepCB);
		
		JComboBox otherCB = new JComboBox();
		otherCB.setBounds(377, 160, 83, 27);
		for (int i = 0; i < 99; i++) {
			otherCB.addItem(i);
		}
		add(otherCB);
		
		JButton submitButton = new JButton("Submit Disease Record"); 
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text= bName_TF.getText();
				System.out.println(text);
				
			}
		});
		submitButton.setBounds(136, 199, 204, 29);
		/*
		  try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);

					// get the BID using bname and fathername
					String bid = null;
					String sql = "SELECT BID FROM BENEFICIARY WHERE BNAME=? AND FATHERNAME=?";
					ut.pstmt = ut.conn.prepareStatement(sql);

					ut.pstmt.setString(1, bName_TF.getText());
					ut.pstmt.setString(2, fName_TF.getText());

					try {
						ut.rs = ut.pstmt.executeQuery();
						while (ut.rs.next()) {
							bid = ut.rs.getString(1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Problem with Beneficiary Name or Father Name. Try adding a new Beneficiary if this one doesn't exist");
						
					}
					

					// Add a new RECORD if record doesn't already exist
					sql = "SELECT * FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
					ut.pstmt.setString(3, bid);

					ut.rs = ut.pstmt.executeQuery();
					if (!ut.rs.next()) {
						sql = "INSERT INTO VACCINATION_RECORD (VYEAR,QUATER,VDATE,VACCINATER,DONOR,BID,BANIMALSLAUGHTERED,\n"
								+ "SANIMALSLAUGHTERED,\n" + "SHEEPSOLD,\n" + "CATTLESOLD,\n" + "GOATSOLD,\n"
								+ "PERANIMALCOST) VALUES (?,?,?,?,?,?,0,0,0,0,0,0)";
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
						ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
						ut.pstmt.setString(3, date_TF.getText());
						ut.pstmt.setString(4, Vaccinater_CB.getSelectedItem().toString());
						ut.pstmt.setString(5, Donor_CB.getSelectedItem().toString());
						ut.pstmt.setString(6, bid);
						ut.pstmt.executeUpdate();

						int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new RECORD",
								"Press Yes or No", JOptionPane.YES_NO_OPTION);

						if (x == JOptionPane.YES_OPTION) {
							ut.conn.commit();
							JOptionPane.showMessageDialog(null, "Transaction is Succesful");
						} else {
							ut.conn.rollback();
							JOptionPane.showMessageDialog(null, "Transaction not Saved");
						}
					}

					// GET new RID

					String rid = null;
					sql = "SELECT RID FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
					ut.pstmt.setString(3, bid);
					ut.rs = ut.pstmt.executeQuery();
					while (ut.rs.next()) {
						rid = ut.rs.getString(1);
					}

					// Add a new Vaccination_Record
					sql = "INSERT INTO VRECORD (VSHEEP,\n" + "VGOAT,\n" + "VCATTLE,\n" + "VDOZOO_YAK,\n" + "VOTHERS,\n"
							+ "VACCINATIONTYPE,\n" + "RID) VALUES (?,?,?,?,?,?,?)";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, sheepCB.getSelectedItem().toString());
					ut.pstmt.setString(2, goatCB.getSelectedItem().toString());
					ut.pstmt.setString(3, cattleCB.getSelectedItem().toString());
					ut.pstmt.setString(4, yakCB.getSelectedItem().toString());
					ut.pstmt.setString(5, otherCB.getSelectedItem().toString());
					ut.pstmt.setString(6, type_CB.getSelectedItem().toString());
					ut.pstmt.setString(7, rid);
					ut.pstmt.executeUpdate();
					int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new Vaccination Record",
							"Press Yes or No", JOptionPane.YES_NO_OPTION);

					if (x == JOptionPane.YES_OPTION) {
						ut.conn.commit();
						JOptionPane.showMessageDialog(null, "Transaction is Succesful");
					} else {
						ut.conn.rollback();
						JOptionPane.showMessageDialog(null, "Transaction not Saved");
					}

				} catch (SQLException e1) {
//					JOptionPane.showMessageDialog(null, "error");

					e1.printStackTrace();
				}

			}
		 */
		add(submitButton);
		
		JButton btnNewButton = new JButton("new");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDiseaseTypeFrame addDiseaseTypeFrame = new AddDiseaseTypeFrame(type_CB);
				addDiseaseTypeFrame.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(404, 45, 70, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("view Disease Symptoms");
		btnNewButton_1.setBounds(171, 74, 175, 29);
		add(btnNewButton_1);

	}

}
