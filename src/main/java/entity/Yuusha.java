package entity;

import java.io.Serializable;
import java.util.Random;

public class Yuusha implements Serializable{
	private String name;
	private int hp = 0;
	
	public Yuusha(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		// TODO 自動生成されたメソッド・スタブ
		return hp;
	}
	
	public void attack(Monster m) {
		int[] damage = {5,7,9};
		Random r = new Random();
		int randomV = damage[r.nextInt(3)];
		int thp = m.getHp();
		m.setHp(thp-randomV);
	}

	
	
}
