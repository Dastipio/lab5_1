package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

public class BetterRadarTest {

	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		BetterRadar radar = new BetterRadar(batteryMock);
		radar.setExec(new Executor() {
			@Override
			public void execute(Runnable command) {
				command.run();
			}
		});
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}
}
