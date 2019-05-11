package com.mygdx.game.materials;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.screens.PlayScreen.PPM;

public class Harvestable {
	
	private int hp;
	private boolean harvested = false;
	private Vector2 pos;
	private Sprite sprite;
	
	public Harvestable(int hp, String assetPath) {
		this.hp = hp;
		pos = new Vector2();
		sprite = new Sprite(new Texture(assetPath));
	}
	
	public void harvest() {
		harvested = true;
		// to be implemented further
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(sprite, pos.x, pos.y, sprite.getWidth()/PPM, sprite.getHeight()/PPM);
	}
	
	public Vector2 getPos() { return pos; }
	
	public void setPos(float x, float y) { pos.set(x, y); } 

}
