
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.components.JSpinField;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnFilter;
	private JTextField textFieldNameFilter;
	private JTextField textFieldName;
	private JComboBox comboBoxColors;

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

		ArrayList<Card> collection = new ArrayList<Card>();
		collection.add(new Card("id", "Ancient Copper Dragon", "Creature", new ArrayList<>(Arrays.asList("R")),
				"4{R}{R}",
				"https://cards.scryfall.io/normal/front/3/8/3836dddd-a7e4-499f-ad49-ce298aa65720.jpg?1674136426",
				"https://scryfall.com/card/clb/161/ancient-copper-dragon?utm_source=api", "R", 2));

		collection.add(new Card("id2", "Ancient Copper Dragon 2", "Creature", new ArrayList<>(Arrays.asList("R")),
				"4{R}{R}",
				"https://cards.scryfall.io/normal/front/3/8/3836dddd-a7e4-499f-ad49-ce298aa65720.jpg?1674136426",
				"https://scryfall.com/card/clb/161/ancient-copper-dragon?utm_source=api", "R", 2));

		collection.add(new Card("id3", "Ancient Copper Dragon 3", "Creature", new ArrayList<>(Arrays.asList("R")),
				"4{R}{R}",
				"https://cards.scryfall.io/normal/front/3/8/3836dddd-a7e4-499f-ad49-ce298aa65720.jpg?1674136426",
				"https://scryfall.com/card/clb/161/ancient-copper-dragon?utm_source=api", "R", 2));

		setTitle("MTG Collection");

		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSearchCards = new JButton("Seach for cards");
		btnSearchCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSearchResults(collection);
			}
		});
		btnSearchCards.setBounds(264, 11, 132, 23);
		contentPane.add(btnSearchCards);

		// Create a DefaultTableModel
		DefaultTableModel tableModel = new DefaultTableModel();

		// Add columns to the model
		tableModel.addColumn("Name");
		tableModel.addColumn("Type");
		tableModel.addColumn("Rarity");
		tableModel.addColumn("Colors");
		tableModel.addColumn("Mana Cost");
		tableModel.addColumn("Quantity");

		// Add data to the model
		for (Card card : collection) {
			tableModel.addRow(
					new Object[] { card.name, card.type, card.rarity, card.colors, card.manaCost, card.quantity });
		}

		table = new JTable(tableModel);

		// Create a JScrollPane to hold the JTable
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(17, 171, 655, 325);
		// Add the JScrollPane to the JFrame
		contentPane.add(jScrollPane);

		JLabel lblCardImage = new JLabel("");
		lblCardImage.setBounds(682, 171, 161, 212);
		contentPane.add(lblCardImage);

		// Load the image from the URL and set it to the label
		try {
			ImageIcon imageIcon = new ImageIcon(new URL(
					"https://cards.scryfall.io/normal/front/d/9/d99a9a7d-d9ca-4c11-80ab-e39d5943a315.jpg?1632831210"));
			lblCardImage.setIcon(imageIcon);

			JPanel panel = new JPanel();
			panel.setBorder(
					new TitledBorder(null, "Filter collection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(17, 49, 826, 106);
			contentPane.add(panel);
			panel.setLayout(null);

			btnFilter = new JButton("Filter");
			btnFilter.setBounds(518, 77, 89, 23);
			panel.add(btnFilter);

			textFieldNameFilter = new JTextField();
			textFieldNameFilter.setBounds(10, 45, 143, 20);
			panel.add(textFieldNameFilter);
			textFieldNameFilter.setToolTipText("Name");
			textFieldNameFilter.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Card name");
			lblNewLabel_1.setBounds(11, 30, 89, 14);
			panel.add(lblNewLabel_1);

			JComboBox comboBoxTypeFilter = new JComboBox();
			comboBoxTypeFilter.setBounds(163, 43, 137, 22);
			panel.add(comboBoxTypeFilter);
			comboBoxTypeFilter.setModel(new DefaultComboBoxModel(new String[] { "Creature", "Land", "Planeswalker", "Sorcery",
					"Instant", "Artifact", "Enchantment" }));
			comboBoxTypeFilter.setSelectedIndex(0);

			JLabel lblNewLabel_1_1 = new JLabel("Card type");
			lblNewLabel_1_1.setBounds(163, 29, 89, 14);
			panel.add(lblNewLabel_1_1);

			JCheckBox chckbxWhiteFilters = new JCheckBox("White");
			chckbxWhiteFilters.setBounds(6, 77, 60, 23);
			panel.add(chckbxWhiteFilters);

			JCheckBox chckbxRedFilter = new JCheckBox("Red");
			chckbxRedFilter.setBounds(68, 77, 53, 23);
			panel.add(chckbxRedFilter);

			JCheckBox chckbxBlueFilter = new JCheckBox("Blue");
			chckbxBlueFilter.setBounds(123, 77, 60, 23);
			panel.add(chckbxBlueFilter);

			JCheckBox chckbxBlackFilter = new JCheckBox("Black");
			chckbxBlackFilter.setBounds(185, 77, 60, 23);
			panel.add(chckbxBlackFilter);

			JCheckBox chckbxGreenFilter = new JCheckBox("Green");
			chckbxGreenFilter.setBounds(247, 77, 67, 23);
			panel.add(chckbxGreenFilter);

			comboBoxColors = new JComboBox();
			comboBoxColors.setBounds(332, 78, 176, 22);
			panel.add(comboBoxColors);
			comboBoxColors.setModel(new DefaultComboBoxModel(
					new String[] { "Exactly these colors", "Including these colors", "At most these colors" }));
			comboBoxColors.setSelectedIndex(0);
			
			JButton btnResetAllFilter = new JButton("Reset all Filter");
			btnResetAllFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnResetAllFilter.setBounds(640, 11, 176, 23);
			panel.add(btnResetAllFilter);

			btnFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});

			JButton btnDelete = new JButton("Delete");
			btnDelete.setBounds(682, 473, 161, 23);
			contentPane.add(btnDelete);

			JButton btnScryfallLink = new JButton("Open on Scryfall.com");
			btnScryfallLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnScryfallLink.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                openUrlLink(collection.get(0).scryfallUrl);
	            }
	        });
			btnScryfallLink.setBounds(682, 406, 161, 23);
			contentPane.add(btnScryfallLink);

			textFieldName = new JTextField();
			textFieldName.setBounds(17, 12, 237, 20);
			contentPane.add(textFieldName);
			textFieldName.setColumns(10);

			JButton btnSetQuantity = new JButton("Update");
			btnSetQuantity.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSetQuantity.setBounds(722, 440, 121, 23);
			contentPane.add(btnSetQuantity);

			JSpinField spinFieldQuantity = new JSpinField();
			spinFieldQuantity.setBounds(682, 442, 30, 20);
			contentPane.add(spinFieldQuantity);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void openSearchResults(ArrayList<Card> collection) {

		// Open the CardDialog
		CardDialog cardDialog = new CardDialog(this, collection);
		cardDialog.setVisible(true);

		// Retrieve the selected card
		Card selectedCard = cardDialog.getSelectedCard();
		if (selectedCard != null) {
			// Do something with the selected card, e.g., add it to the collection
			System.out.println("Added card to collection: " + selectedCard.getName());
		}
	}
	
	public void openUrlLink(String url) {
		try {
			String encodedUrl = URLEncoder.encode(url, "UTF-8");
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
	}
}
