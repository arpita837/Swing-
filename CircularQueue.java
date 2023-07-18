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

public class CircularQueue extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int cq[];
	private int size;
	private int r = -1;
	private int f = 0;
	private int count =0;

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
					CircularQueue frame = new CircularQueue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Circular Queue ");
	}

	/**
	 * Create the frame.
	 */
	
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIRCULARQUEUE DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(70, 11, 302, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE :");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 50, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		sizefield = new JTextField();
		sizefield.setBounds(183, 47, 86, 20);
		contentPane.add(sizefield);
		sizefield.setColumns(10);
		
		JButton circularQueue = new JButton("CIRCULAR QUEUE");
		circularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Circular Queue code
				size = Integer.valueOf(sizefield.getText());
				cq = new int [size];
				String message = "CiricularQueue of size "+size+" created";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		circularQueue.setForeground(new Color(0, 0, 255));
		circularQueue.setFont(new Font("Times New Roman", Font.BOLD, 13));
		circularQueue.setBounds(104, 85, 186, 25);
		contentPane.add(circularQueue);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER AN ELEMENT :");
		lblNewLabel_2.setForeground(new Color(255, 128, 64));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 123, 152, 16);
		contentPane.add(lblNewLabel_2);
		
		element = new JTextField();
		element.setBounds(183, 121, 86, 20);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Insertion code
				int elem;
				if(count == size)
				{
					JOptionPane.showMessageDialog(contentPane,"insertion not possible");
				}
				else
				{
					
					elem = Integer.valueOf(element.getText());
					r = (r+1)%size;
					cq[r]=elem;
					count++;
					JOptionPane.showMessageDialog(contentPane, "Insertion Successfull");
					element.setText("");
				}
			}
		});
		insert.setForeground(new Color(0, 0, 255));
		insert.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		insert.setBounds(301, 120, 89, 23);
		contentPane.add(insert);
		
		JButton DELETE = new JButton("DELETE");
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code delete
				if(count==0)
				{
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible");
				}
				else
				{
					String message = "element deleted is "+cq[f];
					JOptionPane.showMessageDialog(contentPane, message);
					f=(f+1)%size;
					count--;
					
				}
			}
		});
		DELETE.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		DELETE.setForeground(new Color(0, 0, 255));
		DELETE.setBounds(142, 159, 89, 23);
		contentPane.add(DELETE);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code display
				String msg = "";
				int f1 = f;
				if(count==0)
				{
					JOptionPane.showConfirmDialog(contentPane, "not possible");
				}
				else
				{
					for(int i=1;i<=count;i++)
					{
						msg=msg+" "+cq[f1];
						f1 = (f+1)%size;
					}
				}
				displaybox.setText(msg);
			}
		});
		display.setForeground(Color.BLUE);
		display.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		display.setBounds(142, 191, 89, 23);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBounds(10, 230, 362, 20);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(301, 192, 25, -3);
		contentPane.add(btnNewButton);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 0, 0));
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setBounds(301, 192, 85, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Circular-queue-Java.jpg"));
		lblNewLabel_3.setBounds(-35, 10, 628, 313);
		contentPane.add(lblNewLabel_3);
	}

}