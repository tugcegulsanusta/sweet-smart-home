package model.enums;

import java.util.Random;

public enum ProgramType {

	PAMUKLULAR20, PAMUKLULAR40, PAMUKLULAR60, PAMUKLULAR90, SENTETIKLER40, MIX40, HASSAS_IPEK30, YUNLULER30, YOGUN70,
	NORMAL65, ECO50, HASSAS40, HIZLI45;

	public static ProgramType generateRandomProgram() {
		ProgramType[] values = ProgramType.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];
	}
}
