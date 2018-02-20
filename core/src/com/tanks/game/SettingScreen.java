package com.tanks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class SettingScreen implements Screen {

    private SpriteBatch batch;

    private BitmapFont font;

    private TextureRegion textureRegionBackground;

    private Stage stage;
    private Skin skin;

    public SettingScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void show() {
        textureRegionBackground = Assets.getInstance().getAtlas().findRegion("background");
        font = Assets.getInstance().getAssetManager().get("BandyCyr.ttf", BitmapFont.class);
//        font96 = Assets.getInstance().getAssetManager().get("BandyCyr.ttf", BitmapFont.class);
        createGUI();
    }

    public void createGUI() {
        stage = new Stage(ScreenManager.getInstance().getViewport(), batch);
        skin = new Skin(Assets.getInstance().getAtlas());
        Gdx.input.setInputProcessor(stage);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("btn2");
        textButtonStyle.font = font;
        skin.add("tbs", textButtonStyle);

        TextButton btnWeapon = new TextButton("WEAPON", skin, "tbs");
        TextButton btnMap = new TextButton("MAP", skin, "tbs");
        TextButton btnPlayer = new TextButton("PLAYER", skin, "tbs");
        btnWeapon.setPosition(520, 180);
        btnMap.setPosition(520, 20);
        btnPlayer.setPosition(520, 100);
        stage.addActor(btnWeapon);
        stage.addActor(btnMap);
        stage.addActor(btnPlayer);
        btnWeapon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
//                ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.GAME);
            }
        });
        btnMap.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
//                Gdx.app.exit();
            }
        });
        btnPlayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
//                ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.SETTING);
            }
        });
    }

    public void update(float dt) {
        stage.act(dt);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(textureRegionBackground, 0, 0);
//        font96.draw(batch, "Tanks Game", 0, 320, 1280, 1, false);
        batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
    }
}
