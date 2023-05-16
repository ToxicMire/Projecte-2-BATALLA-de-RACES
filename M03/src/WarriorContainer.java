
public class WarriorContainer {
	private int warriorId,warriorHP,warriorStrength,warriorDefense,warriorAgility,warrioirSpeed,warriorPoints,maxHP;
	private String warriorName,warriorStringPathImage,warriorRace;
	
	public WarriorContainer(int warriorId, int warriorHP, int warriorStrength, int warriorDefense, int warriorAgility,
			int warrioirSpeed, int warriorPoints, String warriorName, String warriorStringPathImage,
			String warriorRace) {
		
		this.warriorId = warriorId;
		this.warriorHP = warriorHP;
		this.warriorStrength = warriorStrength;
		this.warriorDefense = warriorDefense;
		this.warriorAgility = warriorAgility;
		this.warrioirSpeed = warrioirSpeed;
		this.warriorPoints = warriorPoints;
		this.warriorName = warriorName;
		this.warriorStringPathImage = warriorStringPathImage;
		this.warriorRace = warriorRace;
		this.maxHP = warriorHP;
	}

	@Override
	public String toString() {
		return "WarriorContainer [warriorId=" + warriorId + ", warriorHP=" + warriorHP + ", warriorStrength="
				+ warriorStrength + ", warriorDefense=" + warriorDefense + ", warriorAgility=" + warriorAgility
				+ ", warrioirSpeed=" + warrioirSpeed + ", warriorPoints=" + warriorPoints + ", warriorName="
				+ warriorName + ", warriorStringPathImage=" + warriorStringPathImage + ", warriorRace=" + warriorRace
				+ "]";
	}

	public int getWarriorId() {
		return warriorId;
	}

	public void setWarriorId(int warriorId) {
		this.warriorId = warriorId;
	}

	public int getWarriorHP() {
		return warriorHP;
	}

	public void setWarriorHP(int warriorHP) {
		this.warriorHP = warriorHP;
	}

	public int getWarriorStrength() {
		return warriorStrength;
	}

	public void setWarriorStrength(int warriorStrength) {
		this.warriorStrength = warriorStrength;
	}

	public int getWarriorDefense() {
		return warriorDefense;
	}

	public void setWarriorDefense(int warriorDefense) {
		this.warriorDefense = warriorDefense;
	}

	public int getWarriorAgility() {
		return warriorAgility;
	}

	public void setWarriorAgility(int warriorAgility) {
		this.warriorAgility = warriorAgility;
	}

	public int getWarrioirSpeed() {
		return warrioirSpeed;
	}

	public void setWarrioirSpeed(int warrioirSpeed) {
		this.warrioirSpeed = warrioirSpeed;
	}

	public int getWarriorPoints() {
		return warriorPoints;
	}

	public void setWarriorPoints(int warriorPoints) {
		this.warriorPoints = warriorPoints;
	}

	public String getWarriorName() {
		return warriorName;
	}

	public void setWarriorName(String warriorName) {
		this.warriorName = warriorName;
	}

	public String getWarriorStringPathImage() {
		return warriorStringPathImage;
	}

	public void setWarriorStringPathImage(String warriorStringPathImage) {
		this.warriorStringPathImage = warriorStringPathImage;
	}

	public String getWarriorRace() {
		return warriorRace;
	}

	public void setWarriorRace(String warriorRace) {
		this.warriorRace = warriorRace;
	}
	
	public void subtractLife(int hp){
		this.warriorHP = this.warriorHP - hp;
	}

	public int getMaxHP(){
		return this.maxHP;
	}
	
	public void setMaxHP() {
		this.warriorHP = this.getMaxHP();
	}
	
}
