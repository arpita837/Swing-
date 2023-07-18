import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Array extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField insertposition;
	private JTextField deleteposition;
	private JTextField displaybox;
	private int arr[];

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
					Array frame = new Array();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Array");
	}

	/**
	 * Create the frame.
	 */
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARRAY DATASTRUCTURE");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setBounds(124, 11, 265, 23);
		contentPane.add(lblNewLabel);
		
		length = new JTextField();
		length.setBounds(247, 71, 96, 20);
		contentPane.add(length);
		length.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ARRAY LENGTH");
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 128));
		lblNewLabel_1.setBounds(33, 74, 179, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for insertion
				int elem=Integer.valueOf(element.getText());
				int pos=Integer.valueOf(insertposition.getText());
				arr[pos]=elem;
				String message="Element"+elem+"Inserted @ position"+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				element.setText("");
				insertposition.setText("");
			
			}
		});
		insert.setFont(new Font("Constantia", Font.BOLD, 12));
		insert.setBounds(351, 135, 83, 23);
		contentPane.add(insert);
		
		JLabel lblNewLabel_2 = new JLabel("INSERT AN INTEGER ELEMENT");
		lblNewLabel_2.setForeground(new Color(255, 255, 128));
		lblNewLabel_2.setFont(new Font("Constantia", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 135, 156, 18);
		contentPane.add(lblNewLabel_2);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(169, 135, 51, 20);
		contentPane.add(element);
		
		JLabel position = new JLabel("POSITION");
		position.setForeground(new Color(255, 255, 128));
		position.setFont(new Font("Constantia", Font.BOLD, 12));
		position.setBounds(230, 135, 61, 23);
		contentPane.add(position);
		
		insertposition = new JTextField();
		insertposition.setColumns(10);
		insertposition.setBounds(292, 135, 51, 18);
		contentPane.add(insertposition);
		
		JButton create = new JButton("CREATE ARRAY");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code creating for array
				int len=Integer.valueOf(length.getText());
				arr=new int[len];
				String message="Array of length"+len+"Created";
				JOptionPane.showMessageDialog(contentPane, message);
				
			}
		});
		create.setFont(new Font("Constantia", Font.BOLD, 12));
		create.setBounds(221, 105, 141, 23);
		contentPane.add(create);
		
		JLabel deletepos = new JLabel("DELETE POSITION");
		deletepos.setForeground(new Color(255, 255, 128));
		deletepos.setFont(new Font("Constantia", Font.BOLD, 12));
		deletepos.setBounds(10, 170, 99, 18);
		contentPane.add(deletepos);
		
		deleteposition = new JTextField();
		deleteposition.setColumns(10);
		deleteposition.setBounds(115, 169, 82, 17);
		contentPane.add(deleteposition);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deletion
				int pos=Integer.valueOf(deleteposition.getText());
				arr[pos]=0;
				String message="Element Deleted @ the position "+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				deleteposition.setText("");
				
			}
		});
		delete.setFont(new Font("Constantia", Font.BOLD, 12));
		delete.setBounds(220, 168, 85, 23);
		contentPane.add(delete);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for display
				String msg="";
				for(int i=0;i<=arr.length-1;i++) 
				{
					msg=msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 12));
		display.setBounds(186, 197, 89, 23);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(192, 192, 192));
		displaybox.setForeground(new Color(0, 0, 0));
		displaybox.setFont(new Font("Constantia", Font.BOLD, 16));
		displaybox.setColumns(10);
		displaybox.setBounds(108, 231, 235, 21);
		contentPane.add(displaybox);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		btnNewButton.setBounds(351, 230, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\array.jpg"));
		lblNewLabel_3.setForeground(new Color(255, 255, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(0, 10, 523, 283);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Array.jpg"));
		lblNewLabel_4.setBounds(0, 0, 450, 272);
		contentPane.add(lblNewLabel_4);
	}
}