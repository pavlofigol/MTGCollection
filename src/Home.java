
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_2;
	private JTextField txtFgdfgfd;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("My MTG Collection");

		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Seach for cards");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickMe();
			}
		});
		btnNewButton_1.setBounds(264, 11, 132, 23);
		contentPane.add(btnNewButton_1);

		table = new JTable();
		table.setBounds(17, 171, 655, 325);
		contentPane.add(table);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(682, 171, 161, 212);
		contentPane.add(lblNewLabel);

		// Load the image from the URL and set it to the label
		try {
			ImageIcon imageIcon = new ImageIcon(new URL(
					"https://cards.scryfall.io/normal/front/d/9/d99a9a7d-d9ca-4c11-80ab-e39d5943a315.jpg?1632831210"));
			lblNewLabel.setIcon(imageIcon);

			JPanel panel = new JPanel();
			panel.setBorder(
					new TitledBorder(null, "Filter collection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(17, 49, 826, 106);
			contentPane.add(panel);
			panel.setLayout(null);

			btnNewButton_2 = new JButton("Filter");
			btnNewButton_2.setBounds(556, 77, 89, 23);
			panel.add(btnNewButton_2);

			txtFgdfgfd = new JTextField();
			txtFgdfgfd.setBounds(10, 45, 143, 20);
			panel.add(txtFgdfgfd);
			txtFgdfgfd.setToolTipText("Name");
			txtFgdfgfd.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Card name");
			lblNewLabel_1.setBounds(11, 30, 89, 14);
			panel.add(lblNewLabel_1);

			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(163, 43, 137, 22);
			panel.add(comboBox);
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "Creature", "Land", "Planeswalker", "Sorcery",
					"Instant", "Artifact", "Enchantment" }));
			comboBox.setSelectedIndex(0);

			JLabel lblNewLabel_1_1 = new JLabel("Card type");
			lblNewLabel_1_1.setBounds(163, 29, 89, 14);
			panel.add(lblNewLabel_1_1);

			JCheckBox chckbxNewCheckBox = new JCheckBox("White");
			chckbxNewCheckBox.setBounds(6, 77, 60, 23);
			panel.add(chckbxNewCheckBox);

			JCheckBox chckbxRed = new JCheckBox("Red");
			chckbxRed.setBounds(90, 77, 53, 23);
			panel.add(chckbxRed);

			JCheckBox chckbxBlue = new JCheckBox("Blue");
			chckbxBlue.setBounds(157, 77, 60, 23);
			panel.add(chckbxBlue);

			JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Black");
			chckbxNewCheckBox_2_1.setBounds(219, 77, 60, 23);
			panel.add(chckbxNewCheckBox_2_1);

			JCheckBox chckbxNewCheckBox_2_1_1 = new JCheckBox("Green");
			chckbxNewCheckBox_2_1_1.setBounds(281, 77, 67, 23);
			panel.add(chckbxNewCheckBox_2_1_1);

			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(370, 78, 176, 22);
			panel.add(comboBox_1);
			comboBox_1.setModel(new DefaultComboBoxModel(
					new String[] { "Exactly these colors", "Including these colors", "At most these colors" }));
			comboBox_1.setSelectedIndex(0);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			JButton btnNewButton_3 = new JButton("Edit");
			btnNewButton_3.setBounds(682, 440, 161, 23);
			contentPane.add(btnNewButton_3);

			JButton btnNewButton_3_1 = new JButton("Delete");
			btnNewButton_3_1.setBounds(682, 473, 161, 23);
			contentPane.add(btnNewButton_3_1);

			JButton btnNewButton_3_2 = new JButton("Open on Scryfall.com");
			btnNewButton_3_2.setBounds(682, 406, 161, 23);
			contentPane.add(btnNewButton_3_2);

			textField = new JTextField();
			textField.setBounds(17, 12, 237, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void clickMe() {
		System.out.println("I am clicked");
	}
}