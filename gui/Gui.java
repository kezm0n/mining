package mining.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import mining.BasicMiner;
import mining.Information;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JPanel {

	public Gui() {
		super(new GridLayout(1, 0));
		final JComboBox<Rock> rocks = new JComboBox<Rock>(Rock.values()) {
			{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						final Rock selected = (Rock) getSelectedItem();
						Information.rockIds = selected.getRockId();
						Information.oreIds = selected.getOreId();
					}
				});
			}
	};

		this.add(rocks);

		final JPanel stuff = this;
		new JFrame("Select your rock") {
			{
				setContentPane(stuff);
				setLocationRelativeTo(null);
				setSize(180, 120);
				setVisible(true);
				setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			}
		};

	}

}
