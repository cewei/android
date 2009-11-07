package apress.book.example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class CanvasExample extends Activity {

	protected class CustomView extends View {
		
		Context ctx;
		Paint lPaint = new Paint();
		int x_l = 0, y_l = 0;
		MediaPlayer player = null;
		Bitmap ball = null;
		boolean running = true;
		
		CustomView(Context c) {
			super(c);
			player = MediaPlayer.create(c, R.raw.bounce);
			BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(R.drawable.theball);
			ball = d.getBitmap();
			ctx = c;
		}
		
		protected void drawSprint(int x, int y, Canvas canvas) {
			canvas.drawBitmap(ball, x, y, lPaint);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			/*
			Paint p = new Paint();
			p.setColor(Color.WHITE);
			canvas.drawText("Yo!", 0, 25, p);
			*/
			
			//Draw the white background
			Rect rct = new Rect();
			rct.set(0, 0, canvas.getWidth(), canvas.getHeight());
			Paint pnt = new Paint();
			pnt.setColor(Color.WHITE);
			pnt.setStyle(Style.FILL);
			canvas.drawRect(rct, pnt);
			
			//Increment the X and Y value for the sprites
			x_l += 2;
			y_l += 2;
			
			//Reset the loop when the balls drift offscreen.
			if (x_l >= canvas.getWidth()) {
				x_l = 0;
				y_l = 0;
			}
			
			//Draw ball 1
			drawSprint(x_l, y_l, canvas);
			//Draw ball 2
			drawSprint(canvas.getWidth()-x_l, y_l, canvas);
			
			
			
			if (running) {
				invalidate();
			}
		}
	}
	
	CustomView vw = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		vw = new CustomView(this);
		setTitle("Bounce or Pass, sounds changes everything");
		setContentView(vw);
	}
}