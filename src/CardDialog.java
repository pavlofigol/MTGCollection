import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardDialog extends JDialog {

    private Card selectedCard;

    public CardDialog(Frame parent, ArrayList<Card> cards) {
        super(parent, "Card Selection", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(parent);

        DefaultListModel<Card> cardListModel = new DefaultListModel<>();
        JList<Card> cardList = new JList<>(cardListModel);
        cardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cardList.setCellRenderer(new CardListCellRenderer());

        // Add cards to the list model
        for (Card card : cards) {
            cardListModel.addElement(card);
        }

        // Add the list to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(cardList);

        // Add the JScrollPane to the content pane
        getContentPane().add(scrollPane);

        // Button to close the dialog
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        // Button to simulate adding the selected card to the collection
        JButton addButton = new JButton("Add to Collection");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCard = cardList.getSelectedValue();
                if (selectedCard != null) {
                    dispose(); // Close the dialog
                }
            }
        });

        // Add the buttons to the content pane
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(closeButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public Card getSelectedCard() {
        return selectedCard;
    }
}
