package com.mygdx.game.player;

import static com.mygdx.game.screens.PlayScreen.PPM;
import static com.mygdx.game.screens.PlayScreen.V_HEIGHT;
import static com.mygdx.game.screens.PlayScreen.V_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;

public class Player {
	
	enum Direction {
		JUMPING,RIGHT,LEFT,IDLE;
	}
	
	public static final float velocity = 15f;
	
	private ObjectMap<Direction, Animation<TextureRegion>> animations;
	private Direction direction;
	private Vector2 pos;
	private Sprite sprite;
	private Texture spriteSheet;
	private float stateTime = 0;
	
	
	public Player() {
		animations = new ObjectMap<Direction, Animation<TextureRegion>>();
		spriteSheet = new Texture("spritesheet.png");
		direction = direction.RIGHT;
		generateAnimations();
		sprite = new Sprite(animations.get(direction).getKeyFrame(stateTime, true));
		pos = new Vector2(0,0);
		
	}
	
	public void draw(SpriteBatch batch) {
		sprite.setRegion(animations.get(direction).getKeyFrame(stateTime, true));
		batch.draw(sprite, pos.x, pos.y, sprite.getWidth()/PPM, sprite.getHeight()/PPM);
	}
	
	
	public Vector2 getPos() { return pos; }
	
	public void move(float dt) {
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			direction = direction.RIGHT;
			stateTime+=dt;
			pos.x+=velocity*dt;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			direction = direction.RIGHT;
			stateTime += dt;
			pos.x -= velocity * dt;
		}
		if(!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
			direction = direction.RIGHT;
		}
		
	}
	
	public void generateAnimations() {
		TextureRegion[] runRight = new TextureRegion[4];
		TextureRegion[][] buffer = TextureRegion.split(spriteSheet, spriteSheet.getWidth()/4, spriteSheet.getHeight());
		for(int i = 0; i < buffer[0].length; i++) {
			runRight[i] = buffer[0][i];
		}
		addAnimation(direction.RIGHT, runRight);
		
		
	}
	
	public void addAnimation(Direction direction, TextureRegion[] frames) {
		animations.put(direction, new Animation<TextureRegion>(1/8f,frames));
	}
	
	public Sprite getSprite() { return sprite; }
	
	
	

}
