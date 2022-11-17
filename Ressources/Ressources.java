public class Ressources {
	private int coin;
	private int attack;
	private int wisdom;

	public Ressources(int c, int a, int w) {
		this.attack = c;
		this.wisdom = a;
		this.coin = w;
	}

	int getCoin() {
		return this.coin;
	}

	int getAttack() {
		return this.attack;
	}

	int getWisdom() {
		return this.wisdom;
	}

	void setCoin(int coi) {
		this.coin += coi;
	}

	void setAttack(int att) {
		this.attack += att;
	}

	void setWisdom(int wis) {
		this.wisdom += wis;
	}
}
