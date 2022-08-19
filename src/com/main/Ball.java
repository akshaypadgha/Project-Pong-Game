package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public static final int Size = 16;
	private int x, y;
	private int xVel,yVel;//value 1 or -1
	private int speed =5;
	
	public Ball() {
		reset();
		
	}

	private void reset() {
		//initial position
		
		x =Game.WIDTH/2 - Size/2;
		y =Game.HEIGHT/2 - Size/2;
		
		//initial velocities
		
		xVel =Game.sign(Math.random()*2.0-1);
		yVel =Game.sign(Math.random()*2.0-1);
		
		
	}
	
     public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void changeYDir() {
    	 yVel *=-1;
     }
     public void changeXDir() {
    	 xVel *=-1;
}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, Size, Size);
		
		
	}

	public void update(Paddle p1, Paddle p2) {
		//update movement
     x += xVel *speed;
     y += yVel *speed;
     
     //collisions
     if (y + Size >=Game.HEIGHT || y<=0)
    	 changeYDir();
     
     //with walls
     
	if (x +Size >= Game.WIDTH) {
    	 p1.addPoint();
    	 reset();
	}
	if (x <=0) {
		p2.addPoint();
		reset();
	}
		
	}

}
