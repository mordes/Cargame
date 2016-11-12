package com.mygdx.game.CarClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyScreen;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Kicsi on 2016. 11. 11..
 */

public class CarTunningScreen extends MyScreen{

    protected CarTunningStage carTunningStage;
    protected MyStage bgStage;


    public CarTunningScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.setProjectionMatrix(bgStage.getCamera().combined);
        bgStage.act(delta);
        bgStage.draw();

        spriteBatch.setProjectionMatrix(carTunningStage.getCamera().combined);
        carTunningStage.act(delta);
        carTunningStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        carTunningStage.resize(width, height);
        bgStage.resize(width, height);
    }

    @Override
    public void dispose() {
        carTunningStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        bgStage = new MyStage(new StretchViewport(90,160, new OrthographicCamera(90,160)), spriteBatch, game) {
            private OneSpriteStaticActor backGroudActor;
            @Override
            public void init() {
                addActor(backGroudActor = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_TEXTURE)));
            }

            @Override
            protected void resized() {

            }
        };
        carTunningStage  = new CarTunningStage(new ExtendViewport(270,480,new OrthographicCamera(270,480)), spriteBatch, game);
        Gdx.input.setInputProcessor(carTunningStage);
    }

}