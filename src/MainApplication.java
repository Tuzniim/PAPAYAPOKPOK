import javax.swing.*;
import java.awt.*;

public class MainApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Initialize the main application frame (LOGO)
            LOGO logoFrame = new LOGO();
            logoFrame.setTitle("PAPAYAPOKPOK");
            logoFrame.setSize(800, 600); // Adjust the size for better menu visibility

            // Create a JLabel for displaying the total price
            JLabel totalLabel = new JLabel("Total: 0 THB", SwingConstants.CENTER);

            // Initialize the menu panel with the total label
            Menu menuPanel = new Menu(totalLabel);

            // Adjust the LOGO frame to include the menu and total price label
            logoFrame.setLayout(new BorderLayout()); // Set layout to manage components
            logoFrame.add(menuPanel, BorderLayout.CENTER); // Add menu panel at the center
            logoFrame.add(totalLabel, BorderLayout.SOUTH); // Display total price at the bottom

            logoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logoFrame.setLocationRelativeTo(null); // Center on screen
            logoFrame.setVisible(true); // Show the frame
        });
    }
}
