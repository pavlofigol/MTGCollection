import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

class CardListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Card) {
            Card card = (Card) value;
            ImageIcon icon = new ImageIcon(card.getImage());
            setIcon(icon);
            setText(card.getName());
        }
        return this;
    }
}

