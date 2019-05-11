package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.map.GameMap;
import com.mygdx.game.player.Player;

public class PlayScreen implements Screen{
	
	public static final int V_HEIGHT = 32;
	public static final int V_WIDTH = V_HEIGHT*(Gdx.graphics.getWidth()/Gdx.graphics.getHeight());
	public static final int PPM = 16;
	
	private boolean initialized = false;
	private GameMap map;
	private Player player;
	private SpriteBatch batch;
	
	@Override
	public void show() {
		
		if(!initialized) {
			initialize();
		}
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(map.getCam().combined);
		batch.begin();
		map.drawMapAt(batch, Math.round(player.getPos().y - player.getSprite().getHeight()/PPM + 0.1f));
		player.draw(batch);
		batch.end();
		player.move(delta);
		map.centerCam(player.getPos().x, player.getPos().y);
		if(Gdx.input.isKeyPressed(Input.Keys.V)) {
			map.getCam().zoom-=0.5f;
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public void initialize() {
		initialized = true;
		batch = new SpriteBatch();
		map = new GameMap();
		player = new Player();
	}

}
