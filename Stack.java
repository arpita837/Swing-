import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Stack extends JFrame {

	private JPanel contentPane;
	private JTextField sizefield;
	private JTextField element;
	private JTextField displaybox;
	private int s[];
	private int size;
	private int top=-1;

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
					Stack frame = new Stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Welcome To Stack ");
	
	}

	/**
	 * Create the frame.
	 */
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel StackDataStructure = new JLabel("STACK DATA STRUCTURE");
		StackDataStructure.setForeground(new Color(255, 0, 0));
		StackDataStructure.setFont(new Font("Arial Black", Font.BOLD, 15));
		StackDataStructure.setBounds(107, 22, 231, 22);
		contentPane.add(StackDataStructure);
		
		JLabel stacksize = new JLabel("ENTER STACK SIZE");
		stacksize.setForeground(new Color(255, 128, 128));
		stacksize.setFont(new Font("Constantia", Font.BOLD, 14));
		stacksize.setBounds(10, 54, 132, 18);
		contentPane.add(stacksize);
		
		sizefield = new JTextField();
		sizefield.setBounds(173, 54, 96, 20);
		contentPane.add(sizefield);
		sizefield.setColumns(10);
		
		JButton stack = new JButton("CREATE STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//stack creation code
				size=Integer.valueOf(sizefield.getText());
				s=new int[size];
				String message="Stack of size"+size+"Created";
				JOptionPane.showMessageDialog(contentPane, message);
				
				
			}
		});
		stack.setForeground(new Color(255, 128, 0));
		stack.setFont(new Font("Constantia", Font.BOLD, 15));
		stack.setBounds(183, 85, 145, 27);
		contentPane.add(stack);
		
		JLabel enterelement = new JLabel("ENTER AN ELEMENT");
		enterelement.setForeground(new Color(255, 128, 0));
		enterelement.setFont(new Font("Constantia", Font.BOLD, 14));
		enterelement.setBounds(10, 129, 143, 18);
		contentPane.add(enterelement);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(173, 126, 96, 20);
		contentPane.add(element);
		
		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PUSH CODE 
				int elem;
				if(top==size-1)
				{
					JOptionPane.showMessageDialog(contentPane,"Pushing not Possible");
					}
				else
				{
					elem=Integer.valueOf(element.getText());
					++top;
					s[top]=elem;
					JOptionPane.showMessageDialog(contentPane,"Push Successful");
					element.setText("");
					
					
				}
			}
		});
		push.setForeground(new Color(128, 128, 64));
		push.setFont(new Font("Constantia", Font.BOLD, 15));
		push.setBounds(283, 125, 106, 21);
		contentPane.add(push);
		
		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//POP CODE 
				if(top==-1) 
				{
					JOptionPane.showMessageDialog(contentPane,"Pop not Possible");
				}
				else
				{
				String message="Element deleted is:"+s[top];
				JOptionPane.showMessageDialog(contentPane, message);
				
					--top;
				}
			}
		});
		pop.setForeground(new Color(128, 128, 64));
		pop.setFont(new Font("Constantia", Font.BOLD, 15));
		pop.setBounds(173, 170, 106, 21);
		contentPane.add(pop);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPALY CODE 
				String msg="";
				if(top==-1)
				{
					JOptionPane.showMessageDialog(contentPane,"dispaly not possible");
					}
				else
				{
					for(int i=top;i>=0;i--) {
						msg=msg+" "+s[i];
					}
				}
				displaybox.setText(msg);
			}
		});
		display.setForeground(new Color(128, 128, 64));
		display.setFont(new Font("Constantia", Font.BOLD, 15));
		display.setBounds(173, 202, 106, 21);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(255, 128, 255));
		displaybox.setFont(new Font("Constantia", Font.BOLD, 14));
		displaybox.setColumns(10);
		displaybox.setBounds(67, 232, 291, 20);
		contentPane.add(displaybox);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Home h=new Home();
				 h.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(341, 201, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\stack.png"));
		lblNewLabel.setBounds(-70, -31, 543, 304);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Stack.jpg"));
		lblNewLabel_1.setBounds(-10, 10, 436, 263);
		contentPane.add(lblNewLabel_1);
	}
}