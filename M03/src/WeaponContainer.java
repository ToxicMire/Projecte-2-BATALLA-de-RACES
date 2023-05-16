
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
	
	@Override
	public String toString() {
		return "WeaponContainer [weaponId=" + weaponId + ", weaponPoints=" + weaponPoints + ", weaponStrength="
				+ weaponStrength + ", weaponSpeed=" + weaponSpeed + ", weaponName=" + weaponName + ", weaponImagePath="
				+ weaponImagePath + "]";
	}

	public int getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	public int getWeaponPoints() {
		return weaponPoints;
	}
	public void setWeaponPoints(int weaponPoints) {
		this.weaponPoints = weaponPoints;
	}
	public int getWeaponStrength() {
		return weaponStrength;
	}
	public void setWeaponStrength(int weaponStrength) {
		this.weaponStrength = weaponStrength;
	}
	public int getWeaponSpeed() {
		return weaponSpeed;
	}
	public void setWeaponSpeed(int weaponSpeed) {
		this.weaponSpeed = weaponSpeed;
	}
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	public String getWeaponImagePath() {
		return weaponImagePath;
	}
	public void setWeaponImagePath(String weaponImagePath) {
		this.weaponImagePath = weaponImagePath;
	}
	
	
	
	
}
