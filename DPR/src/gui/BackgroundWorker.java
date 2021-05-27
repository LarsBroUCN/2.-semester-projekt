package gui;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class BackgroundWorker extends SwingWorker<Void, Void> {

	private Homepage frame;
	private JProgressBar bar;

	public BackgroundWorker(JProgressBar bar, Homepage frame) {
		this.bar = bar;
		this.frame = frame;
	}

	@Override
	public Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		bar.setVisible(true);
		bar.setIndeterminate(true);
		frame.generateLists();
		return null;
	}

	@Override
	public void done() {
		bar.setIndeterminate(false);
		bar.setVisible(false);
	}
}
