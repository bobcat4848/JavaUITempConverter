import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TemperatureDriver {

		public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Window window = new Window("Converter", 300, 400);
		
		// Creates panel
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 400));
		panel.setLayout(null);
		window.getFrame().getContentPane().add(panel);

		window.addButton("button", panel, "Convert", 105, 125, 90, 30);
		window.addComboBox("tempType", panel, 75, 65, 150, 30, "Fahrenheit", "Celsius", "Kelvin");
		window.addTextField("tempInput", panel, 75, 30, 150, 30);
		window.addLabel("tempWhere", panel, "Insert degree below: ", 90, 0, 150, 30);
		window.addLabel("tempFahrenheit", panel, "Fahrenheit: ", 15, 160, 225, 30, new Font("Arial", Font.BOLD, 24));
		window.addLabel("tempCelsius", panel, "Celsius: ", 15, 190, 225, 30, new Font("Arial", Font.BOLD, 24));
		window.addLabel("tempKelvin", panel, "Kelvin: ", 15, 220, 225, 30, new Font("Arial", Font.BOLD, 24));
		
		URL url = TemperatureDriver.class.getResource("/images/donate.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel iconLabel = new JLabel(icon, JLabel.CENTER);
		iconLabel.setBounds(100, 250, 100, 105);
		panel.add(iconLabel);
		
		iconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					Runtime rt = Runtime.getRuntime();
					String url = "www.paypal.me/cuomo";
					try {
						rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// Basically a refresher
		window.getFrame().revalidate();
		window.getFrame().repaint();

		JComboBox<String> tempType = (JComboBox<String>) window.getComponent("tempType");
		JTextField tempInput = (JTextField) window.getComponent("tempInput");
		JLabel tempFahrenheit = (JLabel) window.getComponent("tempFahrenheit");
		JLabel tempCelsius = (JLabel) window.getComponent("tempCelsius");
		JLabel tempKelvin = (JLabel) window.getComponent("tempKelvin");
		JButton button = (JButton) window.getComponent("button");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempTypeResult = (String) tempType.getSelectedItem();
				if (tempTypeResult.equalsIgnoreCase("Fahrenheit")) {
					if (!isDouble(tempInput.getText())) {
						System.out.println("Not a number");
						return;
					}
					// Creates a double from the string from the tempInput
					// object
					double tempInputResult = Double.parseDouble(tempInput.getText());
					Temperature temp = new Temperature(tempInputResult, "F");

					DecimalFormat format = new DecimalFormat("#.##");
					tempFahrenheit.setText("Fahrenheit: " + format.format(temp.getDegreesFahrenheit()));
					tempCelsius.setText("Celsius: " + format.format(temp.getDegreesCelsius()));
					tempKelvin.setText("Kelvin: " + format.format(temp.getDegreesKelvin()));

				} else if (tempTypeResult.equalsIgnoreCase("Celsius")) {
					if (!isDouble(tempInput.getText())) {
						System.out.println("Not a number");
						return;
					}
					// Creates a double from the string from the tempInput
					// object
					double tempInputResult = Double.parseDouble(tempInput.getText());

					Temperature temp = new Temperature(tempInputResult, "C");

					DecimalFormat format = new DecimalFormat("#.##");
					tempFahrenheit.setText("Fahrenheit: " + format.format(temp.getDegreesFahrenheit()));
					tempCelsius.setText("Celsius: " + format.format(temp.getDegreesCelsius()));
					tempKelvin.setText("Kelvin: " + format.format(temp.getDegreesKelvin()));

				} else if (tempTypeResult.equalsIgnoreCase("Kelvin")) {
					if (!isDouble(tempInput.getText())) {
						System.out.println("Not a number");
						return;
					}
					// Creates a double from the string from the tempInput
					// object
					double tempInputResult = Double.parseDouble(tempInput.getText());

					Temperature temp = new Temperature(tempInputResult, "K");

					DecimalFormat format = new DecimalFormat("#.##");
					tempFahrenheit.setText("Fahrenheit: " + format.format(temp.getDegreesFahrenheit()));
					tempCelsius.setText("Celsius: " + format.format(temp.getDegreesCelsius()));
					tempKelvin.setText("Kelvin: " + format.format(temp.getDegreesKelvin()));

				}
			}
		});
	}

	public static boolean isDouble(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			// do stuff
			return false;
		}
	}
}
