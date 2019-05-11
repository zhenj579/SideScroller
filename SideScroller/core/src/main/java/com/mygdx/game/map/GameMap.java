package com.mygdx.game.map;

import static com.mygdx.game.screens.PlayScreen.PPM;
import static com.mygdx.game.screens.PlayScreen.V_HEIGHT;
import static com.mygdx.game.screens.PlayScreen.V_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameMap {
	
	private int[] map;
	private Sprite sprite;
	private OrthographicCamera cam;
	private int leftBoundary = 0;
	private int rightBoundary = Math.round(V_WIDTH);
	
	public GameMap() {
		map = new int[Gdx.graphics.getWidth()*7];
		sprite = new Sprite(new Texture("grass.png"));
		cam = new OrthographicCamera(V_WIDTH, V_HEIGHT);
	}
	
	public void generateMap() {
//		for(int i = 0; i < map.length; i++) {
//			map[i] = 0;
//		}
	}
	
	public void drawMapAt(SpriteBatch batch, int y) {
		calculateBoundaries();
			for(float i = leftBoundary; i < rightBoundary; i++) {
				batch.draw(sprite, i , y, sprite.getWidth()/PPM, sprite.getHeight()/PPM);
		}
	}
	
	public void calculateBoundaries() {
		leftBoundary = Math.round(cam.position.x) - V_WIDTH/2;
		if(leftBoundary < 0) {
			leftBoundary = 0;
		}
		if(rightBoundary > map.length) {
			rightBoundary = map.length;
		}
		rightBoundary = Math.round(cam.position.x) + V_WIDTH/2;
		
		System.out.println("Left boundary: " + leftBoundary + "Right boundary: " + rightBoundary);
	}
	
	public void centerCam(float x, float y) { 
		cam.position.x = x;
		cam.position.y = y;
		cam.update();
	}
	
	public OrthographicCamera getCam() { return cam; }
}
