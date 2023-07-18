import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

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
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("Data Structures and algorithms in java");
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 670);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 128, 255));
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A DATA STRUCTURE");
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setForeground(new Color(128, 64, 64));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(200, 27, 243, 21);
		contentPane.add(lblNewLabel);
		
		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE ARRAY WINDOW OPENING CODE HERE
				new Array().setVisible(true);
			}
		});
		array.setForeground(new Color(255, 0, 0));
		array.setFont(new Font("Constantia", Font.BOLD, 12));
		array.setBounds(281, 65, 118, 32);
		contentPane.add(array);
		
		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE STACK WINDOW OPENING CODE HERE
				new Stack().setVisible(true);
			}
		});
		stack.setForeground(new Color(128, 0, 128));
		stack.setFont(new Font("Constantia", Font.BOLD, 12));
		stack.setBounds(113, 155, 96, 42);
		contentPane.add(stack);
		
		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE QUEUE WINDOW OPENING CODE HERE
				new Queue().setVisible(true);
			}
		});
		queue.setForeground(new Color(128, 0, 0));
		queue.setFont(new Font("Constantia", Font.BOLD, 12));
		queue.setBounds(503, 155, 96, 42);
		contentPane.add(queue);
		
		JButton circularqueue = new JButton("CIRCULAR QUEUE");
		circularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE CIRCULAR QUEUE WINDOW OPENING CODE HERE
				new CircularQueue().setVisible(true);
			}
		});
		circularqueue.setForeground(new Color(0, 0, 255));
		circularqueue.setFont(new Font("Constantia", Font.BOLD, 12));
		circularqueue.setBounds(500, 267, 155, 33);
		contentPane.add(circularqueue);
		
		JButton sll = new JButton("SINGLYLINKEDLIST");
		sll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE SINGLYLINKEDLUST WINDOW OPENING CODE HERE
				new SinglyLinkedList().setVisible(true);
			}
		});
		sll.setFont(new Font("Constantia", Font.BOLD, 12));
		sll.setForeground(new Color(64, 128, 128));
		sll.setBounds(77, 262, 147, 42);
		contentPane.add(sll);
		
		JButton dll = new JButton("DOUBLYLINKEDLIST");
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE DOUBLYLINKEDLIST  WINDOW OPENING CODE HERE
				new DoublyLinkedList().setVisible(true);
			}
		});
		dll.setForeground(new Color(0, 128, 0));
		dll.setFont(new Font("Constantia", Font.BOLD, 12));
		dll.setBounds(307, 353, 155, 42);
		contentPane.add(dll);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\DataStructure1.png"));
		lblNewLabel_1.setBounds(10, -126, 800, 913);
		contentPane.add(lblNewLabel_1);
	}
}
