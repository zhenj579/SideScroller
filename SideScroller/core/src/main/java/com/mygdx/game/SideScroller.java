package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.PlayScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SideScroller extends Game {

	@Override
	public void create() {
		setScreen(new PlayScreen());
	}
}