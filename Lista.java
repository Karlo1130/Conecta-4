
public class Lista {
	Nodo   Head, P, Q, R;
	private int renglones, columnas;
	
	public Lista(int renglones, int columnas)
	{
		this.renglones=renglones;
		this.columnas=columnas;
		Head = null;
	}
	
	public void CrearLista(){	
		for (int X = 1; X <= renglones; X++){
			for (int Y = 1; Y <= columnas; Y++){
				P = new Nodo();
				P.dato = 0;
				
				if (Y == 1){
					if (Head == null){
						Head = P;
					}
					Q = P;
				}else{
					P.Izquierda = Q;
					Q.Derecha= P;
					Q = P;
				}
				
				if (X == 1){
					Q = P;
				}else{
					P.Arriba = R;
					R.Abajo = P;
					R = R.Derecha;
				}
			}// for columnas
			R = Head;
			while (R.Abajo != null){
				R = R.Abajo;
			}
		}// for renglones
	}
			
	public void desplegarLista(){
		if (Head != null){
			Q = Head;
			while( Q != null)//renglon
			{
				P = Q;
				while(P != null)//columna
				{
					System.out.print(P.dato);
					P = P.Derecha;
				}
				Q = Q.Abajo;
				System.out.print("\n");
			}
			System.out.print("\n");
		}
	}
	
	public int moverficha(int datoFicha, int y) {
		P = Head;
		int cont = 0;
		int x = 0;
		while(cont != y) {
			P = P.Derecha;
			cont++;
		}
		while(P.dato == 0) {
			if(P.Abajo == null) {
				break;
			}
			P =  P.Abajo;
			x++;
			if(P.dato != 0) {
				x--;
				P = P.Arriba;
				break;
			}
		}
		if (P.dato==0) {
			P.dato=datoFicha;
			return x;
		}else {
			return -1;
		}
	}
	
	public boolean verificarLleno() {
		
		boolean lleno = false;
		int cont = 0;
		
		if (Head != null){
			Q = Head;
			while( Q != null)//renglon
			{
				P = Q;
				while(P != null)//columna
				{
					if(P.dato != 0)
						cont++;
					
					P = P.Derecha;
				}
				Q = Q.Abajo;
			}
		}
		
		if(cont ==  42)
			lleno = true;
		
		return lleno;
	}
	
	public boolean verificarGanador() {
		
		boolean gana=false;
		
		if (Head != null){
			Q = Head;
			while( Q != null)//renglon
			{
				P = Q;
				while(P != null)//columna
				{
					if(gana != true) 
					{
						gana = posicionGanadora(P);
					}
					
					P = P.Derecha;
				}
				Q = Q.Abajo;
			}
		}
		
		return gana;
	}
	
	boolean posicionGanadora(Nodo P) {
		
		boolean gana=false;
		
		if(conectaArriba(P)==true
				|| conectaDerecha(P)==true
				|| conectaDiagonalIzquierda(P)==true
				|| conectaDiagonalDerecha(P)==true) {
			gana = true;
		}
		
		return gana;
		
	}
	
	boolean conectaArriba(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Arriba != null && P.dato != 0
				&& P.dato == P.Arriba.dato
				&& P.Arriba.Arriba != null
				&& P.dato == P.Arriba.Arriba.dato
				&& P.Arriba.Arriba.Arriba != null
				&& P.dato == P.Arriba.Arriba.Arriba.dato) {
			
			ganador = true;
		}
		
		return ganador;
	}
	
	boolean conectaDerecha(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Derecha != null && P.dato != 0
				&& P.dato == P.Derecha.dato
				&& P.Derecha.Derecha != null
				&& P.dato == P.Derecha.Derecha.dato
				&& P.Derecha.Derecha.Derecha != null
				&& P.dato == P.Derecha.Derecha.Derecha.dato) {
			ganador = true;
		}
		
		return ganador;
	}
	
	boolean conectaDiagonalIzquierda(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Izquierda != null && P.Izquierda.Arriba != null && P.dato != 0
				&& P.dato == P.Izquierda.Arriba.dato
				&& P.Izquierda.Arriba.Izquierda != null && P.Izquierda.Arriba.Izquierda.Arriba != null 
				&& P.dato == P.Izquierda.Arriba.Izquierda.Arriba.dato
				&& P.Izquierda.Arriba.Izquierda.Arriba.Izquierda != null && P.Izquierda.Arriba.Izquierda.Arriba.Izquierda.Arriba != null
				&& P.dato == P.Izquierda.Arriba.Izquierda.Arriba.Izquierda.Arriba.dato) {
			
			ganador = true;
		}
		
		return ganador;
	}
	
	boolean conectaDiagonalDerecha(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Derecha != null && P.Derecha.Arriba != null && P.dato != 0
				&& P.dato == P.Derecha.Arriba.dato
				&& P.Derecha.Arriba.Derecha != null && P.Derecha.Arriba.Derecha.Arriba != null
				&& P.dato == P.Derecha.Arriba.Derecha.Arriba.dato
				&& P.Derecha.Arriba.Derecha.Arriba.Derecha != null && P.Derecha.Arriba.Derecha.Arriba.Derecha.Arriba != null
				&& P.dato == P.Derecha.Arriba.Derecha.Arriba.Derecha.Arriba.dato) {
			
			ganador = true;
		}
		
		return ganador;
	}
	
}


