package example.ejercicios;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class dos extends Activity implements OnTouchListener {

	TextView mensaje;
	int corx, cory;
	Lienzo fondo;
	String colorFondo;
	String dibujar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		/*Cosas de posicion*/
		corx = -10;
        cory = -10;
        Bundle m1=getIntent().getExtras();
        
        if (m1.getString("background").equals("Azul"))
			{colorFondo="Azul";}
	    else if (m1.getString("background").equals("Rojo"))
	        {colorFondo="Rojo";}
	    else if (m1.getString("background").equals("Amarillo"))
	    	{colorFondo="Amarillo";}
	    else if (m1.getString("background").equals("Verde"))
	    	{colorFondo="Verde";}
	    else
	    	colorFondo="White";
        
        if (m1.getBoolean("figCirculo"))
			{dibujar="Circulo";}
	    else if (m1.getBoolean("figRectangulo"))
	        {dibujar="Rectangulo";}
	    else if (m1.getBoolean("figPunto"))
	    	{dibujar="Punto";}
	    else if (m1.getBoolean("figImagen"))
	    	{dibujar="Imagen";}
	    else
	    	dibujar="White";
        
        RelativeLayout layout1=(RelativeLayout) findViewById(R.id.r1);
        fondo = new Lienzo(this);
        fondo.setOnTouchListener(this);
        layout1.addView(fondo);
        
		/*Cosas de texto*/
        /*mensaje=(TextView) findViewById(R.id.mensaje);*/

		/*mensaje.setText(m1.getString("background"));*/
		/*
		 * m1.getBoolean("figura")
		 * m1.getBoolean("texto")
		 * 
		 * m1.getString("textoEscrito");
		 * 
		 * m1.getString("background");
		 * m1.getString("color");
		 * 
		 * m1.getBoolean("figCirculo")
		 * m1.getBoolean("figRectangulo")
		 * m1.getBoolean("figImagen")
		 * m1.getBoolean("figPunto")
		 * 
		 * mensaje.setBackgroundColor(Color.BLUE);
		 * mensaje.setTextColor(Color.YELLOW);
		 * mensaje.setText(m1.getString("textoEscrito"));
		 * 
		 * 
		 * if(m1.getBoolean("figCirculo"))
			{
				canvas.drawARGB(255, 255, 0, 0);
			}
			else if(m1.getBoolean("figRectangulo"))
			{
				canvas.drawARGB(255, 255, 0, 0);
			}
			else if(m1.getBoolean("figPunto"))
			{
				canvas.drawARGB(255, 255, 0, 0);
			}
			else if(m1.getBoolean("figImagen"))
			{
				canvas.drawARGB(255, 255, 0, 0);
			}
		 */
		
	}
	
	public boolean onTouch(View v, MotionEvent event)
    {
    	corx = (int) event.getX();
    	cory = (int) event.getY();
    	Toast.makeText(this, corx+" "+cory, Toast.LENGTH_SHORT).show();
    	fondo.invalidate();
    	
		return false;
    }

    class Lienzo extends View{

		public Lienzo(Context context) {
			super(context);
		}
		
		protected void onDraw(Canvas canvas)
		{
			/*Bundle m1=getIntent().getExtras();*/
			/*String fondo=(String)m1.getString("background");*/
			
			/*mensaje.setText(colorFondo);*/
			
			/* Colores de fondo */
			if (colorFondo == "Azul")
				{canvas.drawARGB(255, 0, 0, 255);}
	        else if (colorFondo == "Rojo")
	            {canvas.drawARGB(255, 255, 0, 0);}
            else if (colorFondo == "Amarillo")
            	{canvas.drawARGB(255, 255, 255, 0);}
            else if (colorFondo == "Verde")
            	{canvas.drawARGB(255, 0, 255, 0);}
            else 
            	{canvas.drawARGB(255, 255, 255, 255);}		
			
			/* Figura a dibujar */
			if (dibujar == "Circulo")
			{
				Paint pincel = new Paint();
				pincel.setARGB(255, 255, 100, 20);
				pincel.setStrokeWidth(4);
				canvas.drawCircle(corx, cory, 15, pincel);
			}
	        else if (dibujar == "Rectangulo")
            {
	        	Paint pincel = new Paint();
				pincel.setARGB(255, 255, 100, 20);
				pincel.setStrokeWidth(4);
				canvas.drawCircle(corx, cory, 15, pincel);
            }
	        else if (dibujar == "Punto")
        	{
	        	Paint pincel = new Paint();
				pincel.setARGB(255, 255, 100, 20);
				pincel.setStrokeWidth(4);
				canvas.drawCircle(corx, cory, 15, pincel);
        	}
	        else if (dibujar == "Imagen")
        	{
	        	Paint pincel = new Paint();
				pincel.setARGB(255, 255, 100, 20);
				pincel.setStrokeWidth(4);
				canvas.drawCircle(corx, cory, 15, pincel);
        	}
	        else 
        	{
	        	Paint pincel = new Paint();
				pincel.setARGB(255, 255, 100, 20);
				pincel.setStrokeWidth(4);
				canvas.drawCircle(corx, cory, 15, pincel);
        	}
			

		}
    	
    }

}
