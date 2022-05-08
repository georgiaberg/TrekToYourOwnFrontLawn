package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Box {
	public int x;
	public int y;
	public Sprite spr;
	public Box(int xcoord, int ycoord, Sprite sprite) {
		x = xcoord;
		y = ycoord;
		spr = sprite;
	}
}
