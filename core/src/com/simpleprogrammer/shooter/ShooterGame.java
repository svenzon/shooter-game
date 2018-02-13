package com.simpleprogrammer.shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ShooterGame extends ApplicationAdapter {
    
        private OrthographicCamera camera;
	private SpriteBatch batch;
        private Texture background;
        private Sprite spaceshipSprite;
        private AnimatedSprite spaceshipAnimated;
	
	@Override
	public void create () {
                
            camera = new OrthographicCamera();
            camera.setToOrtho(false, 800, 480);
            
            batch = new SpriteBatch();
            
            background = new Texture(Gdx.files.internal("data/space-bg.jpg"));
            
            Texture spaceshipTexture = new Texture(Gdx.files.internal("data/spaceship.png"));
            spaceshipSprite = new Sprite(spaceshipTexture);
            spaceshipSprite.setPosition((800 / 2 - (spaceshipSprite.getWidth())), 0);
            
            spaceshipAnimated = new AnimatedSprite(spaceshipSprite);
            spaceshipAnimated.setPosition(800 / 2, 0);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                batch.draw(background, 0, 0);
                spaceshipSprite.draw(batch);
                //spaceshipAnimated.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
