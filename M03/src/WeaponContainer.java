// WEAPON CONTAINER —————————————————————————————————————————————————————————————————————————————————————————————————
// First we create the class "Weapon Container" to declare the variables "weaponId", "weaponPoints"...
public class WeaponContainer {
	private int weaponId,weaponPoints,weaponStrength,weaponSpeed;
	private String weaponName,weaponImagePath;
	public WeaponContainer(int weaponId, int weaponPoints, int weaponStrength, int weaponSpeed, String weaponName,
			String weaponImagePath) {
		this.weaponId = weaponId;
		this.weaponPoints = weaponPoints;
		this.weaponStrength = weaponStrength;
		this.weaponSpeed = weaponSpeed;
		this.weaponName = weaponName;
		this.weaponImagePath = weaponImagePath;
	}
	
	// TOSTRING() ———————————————————————————————————————————————————————————————————————————————————————————————————
	// Then we create "toString()", that returns a "String" that shows the names of the variables previously created,
	// and also shows the variables.
	@Override
	public String toString() {
		return "WeaponContainer [weaponId=" + weaponId + ", weaponPoints=" + weaponPoints + ", weaponStrength="
				+ weaponStrength + ", weaponSpeed=" + weaponSpeed + ", weaponName=" + weaponName + ", weaponImagePath="
				+ weaponImagePath + "]";
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// SETTERS AND GETTERS ——————————————————————————————————————————————————————————————————————————————————————————
	// First, we create the setter and getter of "weaponId".
	public int getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Secondly, we create the setter and getter of "weaponPoints".
	public int getWeaponPoints() {
		return weaponPoints;
	}
	public void setWeaponPoints(int weaponPoints) {
		this.weaponPoints = weaponPoints;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Then, we create the setter and getter of "weaponStrength".
	public int getWeaponStrength() {
		return weaponStrength;
	}
	public void setWeaponStrength(int weaponStrength) {
		this.weaponStrength = weaponStrength;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Now, we create the setter and getter of "weaponSpeed".
	public int getWeaponSpeed() {
		return weaponSpeed;
	}
	public void setWeaponSpeed(int weaponSpeed) {
		this.weaponSpeed = weaponSpeed;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Here we create the setter and getter of "weaponName".
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	// ——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	// Finally, we create the setter and getter of "weaponImagePath".
	public String getWeaponImagePath() {
		return weaponImagePath;
	}
	public void setWeaponImagePath(String weaponImagePath) {
		this.weaponImagePath = weaponImagePath;
	}
}