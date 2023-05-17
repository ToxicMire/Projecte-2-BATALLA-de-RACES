// WARRIOR CONTAINER ————————————————————————————————————————————————————————————————————————————————————————————————
// First we create the class "Warrior Container" to declare the variables "warriorId", "warriorHP"...
public class WarriorContainer {
	private int warriorId,warriorHP,warriorStrength,warriorDefense,warriorAgility,warrioirSpeed,warriorPoints,maxHP;
	private String warriorName,warriorStringPathImage,warriorRace;
	
	// Then, we create a container, where we will pass the variables previously created. Then, we configure our
	// variables to match the names of our data base in "MySQL".
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

	// TOSTRING() ———————————————————————————————————————————————————————————————————————————————————————————————————
	// Then we create "toString()", that returns a "String" that shows the names of the variables previously created,
	// and also shows the variables.
	@Override
	public String toString() {
		return "WarriorContainer [warriorId=" + warriorId + ", warriorHP=" + warriorHP + ", warriorStrength="
				+ warriorStrength + ", warriorDefense=" + warriorDefense + ", warriorAgility=" + warriorAgility
				+ ", warrioirSpeed=" + warrioirSpeed + ", warriorPoints=" + warriorPoints + ", warriorName="
				+ warriorName + ", warriorStringPathImage=" + warriorStringPathImage + ", warriorRace=" + warriorRace
				+ "]";
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// SETTERS AND GETTERS ——————————————————————————————————————————————————————————————————————————————————————————
	// First, we create the setter and getter of "warriorId".
	public int getWarriorId() {
		return warriorId;
	}

	public void setWarriorId(int warriorId) {
		this.warriorId = warriorId;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Then, we create the setter and getter of "warriorHP".
	public int getWarriorHP() {
		return warriorHP;
	}

	public void setWarriorHP(int warriorHP) {
		this.warriorHP = warriorHP;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here we create the setter and getter of "warriorStrength".
	public int getWarriorStrength() {
		return warriorStrength;
	}

	public void setWarriorStrength(int warriorStrength) {
		this.warriorStrength = warriorStrength;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Now, we create the setter and getter of "warriorDefense".
	public int getWarriorDefense() {
		return warriorDefense;
	}

	public void setWarriorDefense(int warriorDefense) {
		this.warriorDefense = warriorDefense;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warriorAgility".
	public int getWarriorAgility() {
		return warriorAgility;
	}

	public void setWarriorAgility(int warriorAgility) {
		this.warriorAgility = warriorAgility;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warrioirSpeed".
	public int getWarrioirSpeed() {
		return warrioirSpeed;
	}

	public void setWarrioirSpeed(int warrioirSpeed) {
		this.warrioirSpeed = warrioirSpeed;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warriorPoints".
	public int getWarriorPoints() {
		return warriorPoints;
	}

	public void setWarriorPoints(int warriorPoints) {
		this.warriorPoints = warriorPoints;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warriorName".
	public String getWarriorName() {
		return warriorName;
	}

	public void setWarriorName(String warriorName) {
		this.warriorName = warriorName;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warriorStringPathImage".
	public String getWarriorStringPathImage() {
		return warriorStringPathImage;
	}

	public void setWarriorStringPathImage(String warriorStringPathImage) {
		this.warriorStringPathImage = warriorStringPathImage;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we create the setter and getter of "warriorRace".
	public String getWarriorRace() {
		return warriorRace;
	}

	public void setWarriorRace(String warriorRace) {
		this.warriorRace = warriorRace;
	}
	
	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here, we personalize "substractLife" to substract the points and % of life.
	public void subtractLife(int hp){
		this.warriorHP = this.warriorHP - hp;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Finally, we create the setter and getter of "MaxHP".
	public int getMaxHP(){
		return this.maxHP;
	}
	
	public void setMaxHP() {
		this.warriorHP = this.getMaxHP();
	}	
}