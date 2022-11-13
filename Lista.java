
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
						gana = posicionGanadora(P);
					
					P = P.Derecha;
				}
				Q = Q.Abajo;

			}

		}
		
		return gana;
	}
	
	boolean posicionGanadora(Nodo P) {
		
		boolean gana=false;
		
		gana = conectaAbajo(P);
		if(gana != true) {
			gana = conectaDerecha(P);
			if(gana != true) {
				gana = conectaIzquierda(P);
				if(gana != true) {
					gana = conectaDiagonalIzquierda(P);
					if(gana != true) {
						gana = conectaDiagonalDerecha(P);
					}
				}
			}
		}
		
		return gana;
		
	}
	
	boolean conectaAbajo(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Abajo != null && P.dato != 0) {
			R = P.Abajo;
			if(R.dato == P.dato) {
				if(R.Abajo != null) {
					P = R.Abajo;
					if(P.dato == R.dato) {
						if(P.Abajo != null) {
							R = P.Abajo;
							if(R.dato == P.dato) {
								ganador = true;
							}
						}
					}
				}
			}
		}
		
		return ganador;
	}
	
	boolean conectaDerecha(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Derecha != null && P.dato != 0) {
			R = P.Derecha;
			if(R.dato == P.dato) {
				if(R.Derecha != null) {
					P = R.Derecha;
					if(P.dato == R.dato) {
						if(P.Derecha != null) {
							R = P.Derecha;
							if(R.dato == P.dato) {
							ganador = true;
							}
						}
					}
				}
			}
		}
		
		return ganador;
	}
	
	boolean conectaIzquierda(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Izquierda != null && P.dato != 0) {
			R = P.Izquierda;
			if(R.dato == P.dato) {
				if(R.Izquierda != null) {
					P = R.Izquierda;
					if(P.dato == R.dato) {
						if(P.Izquierda != null) {
							R = P.Izquierda;
							if(R.dato == P.dato) {
							ganador = true;
							}
						}
					}
				}
			}
		}
		
		return ganador;
	}
	
	boolean conectaDiagonalIzquierda(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Izquierda != null && P.Abajo != null && P.dato != 0) {
			R = P.Izquierda;
			Q = R.Abajo;
			if(Q.dato == P.dato) {
				if(Q.Izquierda != null && Q.Abajo != null) {
					P = Q.Izquierda;
					R = P.Abajo;
					if(R.dato == Q.dato) {
						if(R.Izquierda != null && R.Abajo != null) {
							P = R.Izquierda;
							Q = P.Abajo;
							if(Q.dato == R.dato) {
							ganador = true;
							}
						}
					}
				}
			}
		}
		
		return ganador;
	}
	
	boolean conectaDiagonalDerecha(Nodo P) {
		
		boolean ganador = false;
		
		if(P.Derecha != null && P.Abajo != null && P.dato != 0) {
			R = P.Derecha;
			Q = R.Abajo;
			if(Q.dato == P.dato) {
				if(Q.Derecha != null && Q.Abajo != null) {
					P = Q.Derecha;
					R = P.Abajo;
					if(R.dato == Q.dato) {
						if(R.Derecha != null && R.Abajo != null) {
							P = R.Derecha;
							Q = P.Abajo;
							if(Q.dato == R.dato) {
							ganador = true;
							}
						}
					}
				}
			}
		}
		
		return ganador;
	}
	
}


