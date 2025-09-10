/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.underfloorheatingapp;

import com.mycompany.underfloorheatingapp.Fourniture.GenericFourniture;
import com.mycompany.underfloorheatingapp.rendering.Renderable;
import com.mycompany.underfloorheatingapp.utils.transform.Transform;
import com.mycompany.underfloorheatingapp.utils.transform.Unit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A Java Swing application for a smart underfloor heating system.
 * This class has been updated to include a room designer for modeling the heating cable.
 */
public class UnderfloorHeatingApp extends JFrame {

    private JTabbedPane tabbedPane;

    public UnderfloorHeatingApp() {
        super("Smart Underfloor Heating System");

        // Set up the main window properties
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create the main tabbed panel
        tabbedPane = new JTabbedPane();

        // Add the different tabs to the application
        tabbedPane.addTab("Dashboard", createDashboardPanel());
        tabbedPane.addTab("Graphs", createGraphsPanel());
        tabbedPane.addTab("Schedules", createSchedulesPanel());
        tabbedPane.addTab("Room Designer", createRoomDesignerPanel());

        // Add the tabbed panel to the main frame
        add(tabbedPane);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Creates the dashboard panel for real-time monitoring and control.
     * @return A JPanel representing the dashboard.
     */
    private JPanel createDashboardPanel() {
        JPanel dashboardPanel = new JPanel(new BorderLayout(10, 10));
        dashboardPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("System Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.NORTH);

        // Placeholder for zone-specific controls and data
        JPanel zonesPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        zonesPanel.setBorder(BorderFactory.createTitledBorder("Zone Status"));

        // This is a dummy example. In a real app, this would be dynamic.
        for (int i = 1; i <= 3; i++) {
            JPanel zone = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel zoneLabel = new JLabel("Zone " + i + ": ");
            JLabel tempLabel = new JLabel("Current Temp: " + (new Random().nextInt(10) + 18) + "°C");
            JButton controlButton = new JButton("Adjust");

            zone.add(zoneLabel);
            zone.add(tempLabel);
            zone.add(controlButton);
            zonesPanel.add(zone);
        }

        dashboardPanel.add(zonesPanel, BorderLayout.CENTER);

        return dashboardPanel;
    }

    /**
     * Creates the graphs panel for data visualization.
     * @return A JPanel representing the graphs view.
     */
    private JPanel createGraphsPanel() {
        JPanel graphsPanel = new JPanel(new BorderLayout());
        graphsPanel.setBorder(BorderFactory.createTitledBorder("Temperature Trends"));

        // TODO: This is where you would integrate a professional charting library like JFreeChart.
        // For demonstration, we'll use a simple placeholder panel.

        JLabel instructionLabel = new JLabel("Graphing functionality will be implemented here.", SwingConstants.CENTER);
        graphsPanel.add(instructionLabel, BorderLayout.CENTER);

        return graphsPanel;
    }

    /**
     * Creates the schedules panel for setting heating schedules.
     * @return A JPanel representing the schedules view.
     */
    private JPanel createSchedulesPanel() {
        JPanel schedulesPanel = new JPanel(new BorderLayout());
        schedulesPanel.setBorder(BorderFactory.createTitledBorder("Weekly Schedules"));

        JLabel instructionLabel = new JLabel("Schedule management will be implemented here.", SwingConstants.CENTER);
        schedulesPanel.add(instructionLabel, BorderLayout.CENTER);

        return schedulesPanel;
    }

    /**
     * Creates the room designer panel.
     * This panel contains a canvas for drawing the room and controls for placing furniture and generating the cable path.
     * @return A JPanel representing the room designer.
     */
    private JPanel createRoomDesignerPanel() {
        JPanel designerPanel = new JPanel(new BorderLayout());
        designerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create the custom drawing canvas
        RoomDesignerCanvas canvas = new RoomDesignerCanvas();
        designerPanel.add(canvas, BorderLayout.CENTER);

        // Create a control panel with buttons
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addFurnitureButton = new JButton("Add Furniture");
        JButton generatePathButton = new JButton("Generate Cable Path");
        JButton clearButton = new JButton("Clear All");

        addFurnitureButton.addActionListener(e -> canvas.setMode("ADD_FURNITURE"));
        generatePathButton.addActionListener(e -> canvas.generateCablePath());
        clearButton.addActionListener(e -> canvas.clearAll());

        controls.add(addFurnitureButton);
        controls.add(generatePathButton);
        controls.add(clearButton);

        designerPanel.add(controls, BorderLayout.SOUTH);

        return designerPanel;
    }

    /**
     * The main method to start the application.
     * All Swing UI creation should be done on the Event Dispatch Thread (EDT).
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnderfloorHeatingApp());
    }
}

/**
 * A custom JPanel for drawing the 2D room plan, furniture, and heating cable.
 */
class RoomDesignerCanvas extends JPanel {

    private final Rectangle room;
    private final List<Renderable> renderables;
    private final List<Point> cablePath;
    private String mode = "IDLE";
    private static final int FURNITURE_WIDTH = 100;
    private static final int FURNITURE_HEIGHT = 80;

    public RoomDesignerCanvas() {
        // Set a preferred size for the drawing canvas
        setPreferredSize(new Dimension(800, 500));
        setBackground(new Color(240, 240, 240)); // Light gray for the floor

        // Initialize data structures
        this.room = new Rectangle(50, 50, 700, 400); // Default room size
        this.renderables = new ArrayList<>();
        this.cablePath = new ArrayList<>();

        // Add a mouse listener to handle user interactions
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ("ADD_FURNITURE".equals(mode)) {

			// First, get the object position
			Transform transform = new Transform(
				Unit.fromInch(Math.random() * 500), 
				Unit.fromInch(Math.random() * 500), 
				Math.random()*2*Math.PI);
			
			// Second, create the fourniture
			GenericFourniture genericFourniture = new GenericFourniture(
				Unit.fromInch(Math.random() * 50), 
				Unit.fromInch(Math.random() * 50), 
				transform);
			
			renderables.add(genericFourniture);
			
                        repaint();
                }
            }
        });
    }

    /**
     * Sets the current mode of the canvas (e.g., "ADD_FURNITURE").
     * @param mode The new mode string.
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Generates a simple serpentine heating cable path, avoiding furniture.
     * This is a simplified algorithm for demonstration purposes.
     */
    public void generateCablePath() {
        cablePath.clear();
        int cableSpacing = 20; // Distance between cable lines
        int margin = 30; // Margin from the wall

        // Start the path from a point inside the room
        int startX = room.x + margin;
        int startY = room.y + margin;
        cablePath.add(new Point(startX, startY));

        // Simple serpentine algorithm
        int currentX = startX;
        int currentY = startY;
        boolean movingRight = true;

        while (currentY < room.y + room.height - margin) {
            if (movingRight) {
                // Move right until hitting a wall or furniture
                while (currentX < room.x + room.width - margin) {
                    currentX += 1;
                    if (isObstructed(currentX, currentY)) {
                        // Obstacle detected, stop and turn
                        currentX -= 1; // back up one step
                        break;
                    }
                }
            } else { // moving left
                // Move left until hitting a wall or furniture
                while (currentX > room.x + margin) {
                    currentX -= 1;
                    if (isObstructed(currentX, currentY)) {
                        // Obstacle detected, stop and turn
                        currentX += 1; // back up one step
                        break;
                    }
                }
            }
            // Add the end of the line
            cablePath.add(new Point(currentX, currentY));

            // Move down for the turn
            currentY += cableSpacing;
            if (currentY > room.y + room.height - margin) {
                break;
            }
            cablePath.add(new Point(currentX, currentY));
            movingRight = !movingRight; // Change direction
        }

        // Add final point
        cablePath.add(new Point(currentX, currentY));
        repaint();
    }

    /**
     * Checks if a given point is within any furniture rectangle.
     * This method is a key part of the simplified pathfinding.
     */
    private boolean isObstructed(int x, int y) {
    //    for (Rectangle rect : furniture) {
    //        if (rect.contains(x, y)) {
    //            return true;
    //        }
    //    }
        return false;
    }

    /**
     * Clears all furniture and the generated cable path.
     */
    public void clearAll() {
        renderables.clear();
        cablePath.clear();
        repaint();
    }

    /**
     * The main drawing method. It gets called automatically when repaint() is requested.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Draw the floor area
        g2d.setColor(new Color(240, 240, 240)); // Light gray for the floor
        g2d.fillRect(room.x, room.y, room.width, room.height);

        // 2. Draw the room boundary
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(room);


	// Draw call
	for (Renderable renderable: renderables){
            renderable.render(g2d);
        }	

        // 4. Draw the heating cable path
        if (!cablePath.isEmpty()) {
            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(3)); // Thicker line for the cable
            for (int i = 0; i < cablePath.size() - 1; i++) {
                Point p1 = cablePath.get(i);
                Point p2 = cablePath.get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}

