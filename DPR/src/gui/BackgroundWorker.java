package gui;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class BackgroundWorker extends SwingWorker<Void, Void> {
	
	Homepage frame;
	JProgressBar bar;

	public BackgroundWorker(JProgressBar bar, Homepage frame) {
		this.bar = bar;
		this.frame = frame;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		bar.setVisible(true);
		bar.setIndeterminate(true);
		frame.generateLists();
		
		return null;
	}
	
	@Override
	protected void done() {
		bar.setIndeterminate(false);
		bar.setVisible(false);
		
	}
	

}
