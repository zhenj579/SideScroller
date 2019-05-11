package com.mygdx.game.map.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.screens.PlayScreen.PPM;

public class Block {
	
	private int hp;
	private int id = 0;
	private Sprite sprite;
	
	public Block() {
		hp = 5;
		sprite = new Sprite(new Texture("grass.png"));
	}
	
	public void draw(SpriteBatch batch, float x) {
		batch.draw(sprite, x, 0, sprite.getWidth()/PPM, sprite.getHeight()/PPM);
	}
	
	

}
