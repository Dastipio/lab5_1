package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
	
	private PatriotBattery battery;
	private Executor exec;

	
	public Executor getExec() {
		return exec;
	}

	public void setExec(Executor exec) {
		this.exec = exec;
	}

	public BetterRadar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot( exec );
	}

	private void launchPatriot( Executor exec ) {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					battery.launchPatriot();
				}
			}
		};

		exec.execute( launchPatriotTask );
	}
}