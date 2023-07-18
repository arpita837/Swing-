import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Queue extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int q[];
	private int size;
	private int r = -1;
	private int f = 0;

	/**
	 * Launch the application.
	 */
	private static  void speech_Button_Action(String text)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(text);
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Queue ");
	}

	/**
	 * Create the frame.
	 */
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUEUE DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(118, 11, 222, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(33, 62, 139, 16);
		contentPane.add(lblNewLabel_1);
		
		sizefield = new JTextField();
		sizefield.setBounds(182, 59, 86, 20);
		contentPane.add(sizefield);
		sizefield.setColumns(10);
		
		JButton queue = new JButton("CREATE QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Queue creation
				size = Integer.valueOf(sizefield.getText());
				q = new int[size];
				String message = "Queue of size "+size+" created";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		queue.setForeground(new Color(0, 0, 160));
		queue.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		queue.setBounds(108, 89, 139, 23);
		contentPane.add(queue);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER AN ELEMENT");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(34, 120, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		element = new JTextField();
		element.setBounds(182, 123, 86, 20);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion to queue
				int elem;
				if(r==size-1)
				{
					JOptionPane.showMessageDialog(contentPane,"insertion not possible");
				}
				else
				{
					elem = Integer.valueOf(element.getText());
					++r;
					q[r] = elem;
					JOptionPane.showMessageDialog(contentPane, "Insertion Successfull");
					element.setText("");
				}
			}
			
		});
		insert.setBounds(295, 116, 89, 23);
		contentPane.add(insert);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deletion
				if(r==-1||f>r)
				{
					JOptionPane.showMessageDialog(contentPane, "Deletion not possible");
				}
				else
				{
					String message= "element deleted is"+q[f];
					JOptionPane.showMessageDialog(contentPane,message);
					++f;
					
				}
			}
		});
		delete.setBounds(144, 154, 89, 23);
		contentPane.add(delete);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display code
				String msg = "";
				if(r==-1||f>r)
				{
					JOptionPane.showMessageDialog(contentPane, "Display not possible");
				}
				else
				{
					for(int i= f;i<=r;i++)
					{
						msg=msg+" "+q[i];
					}
					
				}
				displaybox.setText(msg);
			}
		});
		display.setBounds(144, 188, 89, 23);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBounds(33, 221, 362, 20);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(295, 189, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\queue1.jpg"));
		lblNewLabel_3.setBounds(-78, -49, 594, 299);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
}