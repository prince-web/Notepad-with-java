import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;

public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
	JScrollPane panel;
	String text = "";
    
    Notepad(){
		//This code will create the boundaries for our NotepadWindow.
		setBounds(0,0, 1950,1050);//first two coordinate will set for x and y and other two are used to set the size
		
		
		//this will create a menuBar for the notepad.
		JMenuBar menubar = new JMenuBar();
		
		//these are create the menu which are shown in the menu bar.
		JMenu file = new JMenu("File");
		
		
		//THESE code will create menu items for "file" menu the application.
		JMenuItem newdoc = new JMenuItem("New");
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newdoc.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		exit.addActionListener(this);
		
		
		JMenu edit = new JMenu("Edit");
		
		//THESE code will create menu items for "edit" menu the application.
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		
		JMenuItem selectall = new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);
		
		
		
		
		JMenu help = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About the Notepad");
		about.addActionListener(this);
		//This will add menu items for the help menu.
		help.add(about);
		
		
		//This will add menu items for the edit menu.
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectall);
		
		//This will add menu Items for the file menu.
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		//this code will add menu to the menu bar.
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		
		/*A bar is not show until we add that menu bar into the frame,so to do that we use add() or setJMenubar()*/
		
		setJMenuBar(menubar);
		
		
		area = new JTextArea();
		area.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		area.setLineWrap(true);//this Code will break the line.
		area.setWrapStyleWord(true);
		
		
		panel = new JScrollPane(area);
		panel.setBorder(BorderFactory.createEmptyBorder());
		add(panel,BorderLayout.CENTER);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New")) {
			area.setText("");
		}else if(ae.getActionCommand().equals("Open")) {
			JFileChooser chooser = new JFileChooser();
			//code to accept only the txt files. (Restrict a file chooser)
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");//javax.swing.filechooser
			chooser.addChoosableFileFilter(restrict);//to get know that it should restrict
			
			
			int action = chooser.showOpenDialog(this);
			if (action != JFileChooser.APPROVE_OPTION) {
				return;
			}
			
			
			File file = chooser.getSelectedFile();//this method will return the address.it will return file.
			try {
				BufferedReader  reader = new BufferedReader(new FileReader(file));
				area.read(reader, null);
			}catch(Exception e) {
				System.out.println("exception got");
			}
			
		}else if (ae.getActionCommand().equals("Save")) {//33.05
			JFileChooser saveas = new JFileChooser();
			saveas.setApproveButtonText("Save");
			int action = saveas.showOpenDialog(this);
			if (action != JFileChooser.APPROVE_OPTION) {
				return;
			}
			
			
			//write on a file
			File filename = new File(saveas.getSelectedFile() + ".txt");
			BufferedWriter outFile = null;
			try {
				outFile = new BufferedWriter(new FileWriter(filename));
				area.write(outFile);
			}catch (Exception e) {
				System.out.println("exception got");
			}
		}else if (ae.getActionCommand().equals("Print")) {
			try {
				area.print();//print()method will help to get the print functions automatically .
			}catch(Exception e) {}
		}else if (ae.getActionCommand().equals("Exit")) {
			System.exit(0);
		}else if (ae .getActionCommand().equals("Copy")) {
			text = area.getSelectedText();
		}else if (ae.getActionCommand().equals("Paste")) {
			area.insert(text, area.getCaretPosition());
		}else if (ae.getActionCommand().equals("Cut")) {
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd() );
		}else if (ae.getActionCommand().equals("selectall")) {
			area.selectAll();
		}else if (ae.getActionCommand().equals("About the Notepad")) {
			new About().setVisible(true);//this method call to the About class.	
		}
		
		
	}
    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
}
