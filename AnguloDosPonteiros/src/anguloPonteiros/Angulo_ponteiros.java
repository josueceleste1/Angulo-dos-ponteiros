package anguloPonteiros;
import java.util.Calendar;
import java.util.GregorianCalendar;

class RetornaAnguloRelogio {
	private long hora;
	private long minuto;
	private long angH;
	private long angM;

	public long retornaAnguloRelogio(GregorianCalendar horario){
		this.setHora(horario.get(Calendar.HOUR_OF_DAY));
		this.setMinuto(horario.get(Calendar.MINUTE));
		
		if(this.getHora() > 12) {// Esse if garante que seja um angulo de um circulo, ou seja, de 360 graus.
			 this.setHora(this.getHora() - 12);
		}
		/*
		 * Como eu sei que um circulo tem 360 graus e um relogio tem 12 horas, e só fazer 360/12 = 30
		 * esse 30 eu multiplico pela quantidade de horas 30*hora que eu vou ter o ângulo do ponteiro das horas.
		 *  Para o ponteiro dos minutos, como eu sei que um minuto tem 60 segundos então 360/60 = 6, agora e só 
		 * multiplicar pela quantidade de minutos passado 6*minuto e o ângulo entre os ponteiros e dado pela diferença
		 * entre o ângulo das horas e dos minutos.
		 * */
		
		 this.angH = 30*this.getHora();  
		 this.angM = 6*this.getMinuto();
		 
		 if(this.angH > angM) {// Esse if e para garantir que não haverá ângulo negativo.
			return this.angH - this.angM; 
		 }else {
			return this.angM - this.angH; 
		 }
		
		 
	}

	public long getHora() {
		return hora;
	}

	public void setHora(long hora) {
		this.hora = hora;
	}

	public long getMinuto() {
		return minuto;
	}

	public void setMinuto(long minuto) {
		this.minuto = minuto;
	}
}

public class Angulo_ponteiros {
	/*
	 * Duvida:
	 *   	Minha duvida foi sobre o enunciado do problema, pois 00:15h nunca poderá dar 45 graus 
	 * mesmo se eu considerar o tempo que leva para o ponteiro das horas mudar de uma hora para outra.
	 * 		Então eu escolhi deixar parecido com o exemplo mostrado na premissa. Assim fica:
	 *  	- 00:00h possui um angulo de 0
	 *  	- 00:15h possui um angulo de 90
	 *  	- 00:30h possui um angulo de 180
	 * */

	public static void main(String[] args) {
		GregorianCalendar horario = new GregorianCalendar();// instancio um objeto chamado horario para passar como parametro para o metodo.
		RetornaAnguloRelogio ang = new RetornaAnguloRelogio();
		
		long angulo = ang.retornaAnguloRelogio(horario);
		
		System.out.println(ang.getHora()+":"+ang.getMinuto()+"h possiu um ângulo de "+angulo);
	}

}
