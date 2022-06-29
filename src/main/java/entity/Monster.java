package entity;

import java.io.Serializable;
import java.util.Random;

public class Monster implements Serializable{
	private String name;
	private int hp = 0;
	
	public Monster(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	public void attack(Yuusha y) {
		int[] damage = {1,3,5};
		Random r = new Random();
		int randomV = damage[r.nextInt(3)];
		int yhp = y.getHp();
		y.setHp(yhp - randomV);
	
	}
}
