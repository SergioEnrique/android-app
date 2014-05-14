package example.ejercicios;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
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
	String colorPincel;
	String escribir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		/*Ubicación inicial del touch*/
		corx = -10;
        cory = -10;
        
        /* Cargar variables de la pantalla anterior */
        Bundle m1=getIntent().getExtras();
        
        /* Color de fondo */
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
        
        /* Color de la figura o texto */
        if (m1.getString("color").equals("Azul"))
			{colorPincel="Azul";}
	    else if (m1.getString("color").equals("Rojo"))
	        {colorPincel="Rojo";}
	    else if (m1.getString("color").equals("Amarillo"))
	    	{colorPincel="Amarillo";}
	    else if (m1.getString("color").equals("Verde"))
	    	{colorPincel="Verde";}
	    else
	    	colorPincel="White";
        
        /* Tipo de figura que se va a dibujar */
        if (m1.getBoolean("texto"))
        	{dibujar="Texto"; escribir=m1.getString("textoEscrito");}
        else if (m1.getBoolean("figCirculo"))
			{dibujar="Circulo";}
	    else if (m1.getBoolean("figRectangulo"))
	        {dibujar="Rectangulo";}
	    else if (m1.getBoolean("figPunto"))
	    	{dibujar="Punto";}
	    else if (m1.getBoolean("figImagen"))
	    	{dibujar="Imagen";}
	    else
	    	dibujar="Punto";
        
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
			int ancho=canvas.getWidth();
			int alto=canvas.getHeight();

			/* Pinceles */
			Paint pincel = new Paint();
			pincel.setStrokeWidth(4);
			pincel.setTextSize(30);
			pincel.setTypeface(Typeface.SERIF);

			/* Colores del pincel */
			if (colorPincel == "Azul")
				{pincel.setARGB(255, 0, 0, 255);}
	        else if (colorPincel == "Rojo")
	            {pincel.setARGB(255, 255, 0, 0);}
            else if (colorPincel == "Amarillo")
            	{pincel.setARGB(255, 255, 255, 0);}
            else if (colorPincel == "Verde")
            	{pincel.setARGB(255, 0, 255, 0);}
            else 
            	{pincel.setARGB(255, 255, 255, 255);}		
			
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
				{canvas.drawCircle(corx, cory, 25, pincel);}
	        else if (dibujar == "Rectangulo")
            	{canvas.drawRect(corx-20, cory-10, corx+20, cory+10, pincel);}
	        else if (dibujar == "Punto")
        		{canvas.drawPoint(corx, cory, pincel);}
	        else if (dibujar == "Texto")
        		{canvas.drawText(escribir, corx, cory, pincel);}
	        else if (dibujar == "Imagen")
    			{canvas.drawCircle(corx, cory, 15, pincel);}
	        else 
        		{canvas.drawPoint(corx, cory, pincel);}
		}
    	
    }

}
