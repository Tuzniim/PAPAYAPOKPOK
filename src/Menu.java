import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Menu extends JPanel {
    private HashMap<String, FoodMenu[]> categoryItems;
    private JLabel totalLabel;
    private JTextArea additionalInfoTextArea;

    public Menu(JLabel totalLabel) {
        this.totalLabel = totalLabel;
        categoryItems = new HashMap<>();
        setLayout(new BorderLayout());


        initializeMenuItems();


        UIManager.put("TabbedPane.selected", new Color(255, 105, 180));
        UIManager.put("TabbedPane.unselectedBackground", new Color(255, 182, 193));
        UIManager.put("TabbedPane.foreground", new Color(148, 0, 211));
        UIManager.put("TabbedPane.selectedForeground", new Color(148, 0, 211));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setOpaque(true);
        tabbedPane.setBackground(new Color(255, 182, 193));

        String[] categories = {"Papaya", "Drink", "Side Dishes"};
        for (String category : categories) {
            JPanel panel = createItemsPanel(category);
            panel.setOpaque(false);
            tabbedPane.addTab(category, null, panel, category);
        }

        add(tabbedPane, BorderLayout.CENTER);



        // Add next button and additional info input area
        JPanel bottomPanel = new JPanel(new BorderLayout());
        additionalInfoTextArea = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(additionalInfoTextArea);
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(255, 105, 180));
        nextButton.setForeground(new Color(255, 0, 128));
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setPreferredSize(new Dimension(200, 6));


        additionalInfoTextArea.setBackground(Color.LIGHT_GRAY);
        additionalInfoTextArea.setForeground(Color.BLACK);
        additionalInfoTextArea.setPreferredSize(new Dimension(200, 80));



        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        bottomPanel.add(nextButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);


        totalLabel.setForeground(Color.RED);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setPreferredSize(new Dimension(200, 40));




        nextButton.addActionListener(e -> {

            String additionalInfo = additionalInfoTextArea.getText();
            int currentTotal = Integer.parseInt(totalLabel.getText().replace("Total: ", "").replace(" THB", ""));

            totalLabel.setText("Total: 0 THB");
            additionalInfoTextArea.setText("");
            JOptionPane.showMessageDialog(null, "Order Sent to Kitchen!\nAdditional Info:\n" + additionalInfo + "\nTotal: " + currentTotal + " THB");
        });
    }


    private void initializeMenuItems() {
        categoryItems.put("Papaya", new FoodMenu[]{
                new FoodMenu("Blue Crab Somtam", 60, "D:/Project/PAPAYAPOKPOK/Papaya_image/BlueCrabSomtam.jpeg"),
                new FoodMenu("Papaya salad with crab and fermented fish", 50, "D:/Project/PAPAYAPOKPOK/Papaya_image/PapayaSalad_CrabFermented_Fish.jpeg"),
                new FoodMenu("Pickled clam papaya salad", 60, "D:/Project/PAPAYAPOKPOK/Papaya_image/PickledClam_PapayaSalad.jpeg"),
                new FoodMenu("THAI SOMTAM", 50, "D:/Project/PAPAYAPOKPOK/Papaya_image/ThaiSomtam.jpeg")
        });

        categoryItems.put("Drink", new FoodMenu[]{
                new FoodMenu("Coke", 20, "D:/Project/PAPAYAPOKPOK/Drink_image/Coke.jpg"),
                new FoodMenu("Fanta", 20, "D:/Project/PAPAYAPOKPOK/Drink_image/Fanta.jpg"),
                new FoodMenu("Sprite", 20, "D:/Project/PAPAYAPOKPOK/Drink_image/Sprite.jpg"),
                new FoodMenu("NAM THIP", 15, "D:/Project/PAPAYAPOKPOK/Drink_image/NAM_THIP.jpg")
        });

        categoryItems.put("Side Dishes", new FoodMenu[]{
                new FoodMenu("Sticky Rice", 10, "D:/Project/PAPAYAPOKPOK/Side_Dishes/Sticky_Rice.jpeg"),
                new FoodMenu("Khanom Jeen", 10, "D:/Project/PAPAYAPOKPOK/Side_Dishes/Khanom_Jeen.jpg"),
                new FoodMenu("Rice", 10, "D:/Project/PAPAYAPOKPOK/Side_Dishes/Rice.jpg"),
                new FoodMenu("White Rice Noodles", 10, "D:/Project/PAPAYAPOKPOK/Side_Dishes/Whit_Rice_Noodles.jpeg")
        });
    }

    private JPanel createItemsPanel(String category) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(Color.PINK);

        FoodMenu[] menus = categoryItems.getOrDefault(category, new FoodMenu[0]);
        for (FoodMenu menu : menus) {
            JPanel itemPanel = createItemPanel(menu);
            itemPanel.setBackground(Color.PINK);
            panel.add(itemPanel);
        }
        return panel;
    }

    private JPanel createItemPanel(FoodMenu menu) {

        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(Color.PINK);

        JLabel nameLabel = new JLabel(menu.getName());
        nameLabel.setForeground(new Color(148, 0, 211));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.PINK);

        JLabel priceLabel = new JLabel("Price: " + menu.getPrice() + " THB");
        priceLabel.setForeground(Color.BLUE); // Set text color to blue
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.PINK);

        JLabel imageLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(menu.getImagePath());
            Image scaledImage = icon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel quantityLabel = new JLabel("0");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JButton addButton = new JButton("+");
        JButton removeButton = new JButton("-");
        addButton.setBackground(new Color(255, 0, 128));
        addButton.setForeground(Color.WHITE);
        removeButton.setBackground(new Color(255, 0, 128));
        removeButton.setForeground(Color.WHITE);

        addButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            quantityLabel.setText(String.valueOf(quantity + 1));
            updateTotal(menu.getPrice());
        });

        removeButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            if (quantity > 0) {
                quantityLabel.setText(String.valueOf(quantity - 1));
                updateTotal(-menu.getPrice());
            }
        });


        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(nameLabel);
        textPanel.add(priceLabel);
        textPanel.setBackground(Color.PINK);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(quantityLabel);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.setBackground(Color.PINK);

        itemPanel.add(imageLabel, BorderLayout.WEST);
        itemPanel.add(textPanel, BorderLayout.CENTER);
        itemPanel.add(buttonPanel, BorderLayout.EAST);

        return itemPanel;
    }



    private void updateTotal(int amount) {
        String currentTotalStr = totalLabel.getText().replace("Total: ", "").replace(" THB", "");
        int currentTotal = Integer.parseInt(currentTotalStr);
        totalLabel.setText("Total: " + (currentTotal + amount) + " THB");
    }
}

class FoodMenu extends MenuItem {
    private String imagePath;

    public FoodMenu(String name, int price, String imagePath) {
        super(name, price);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
